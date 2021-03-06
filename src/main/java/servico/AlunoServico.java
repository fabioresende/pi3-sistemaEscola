package servico;

import java.util.ArrayList;
import java.util.List;

import dao.AlunoDao;
import dao.DaoFactory;
import dao.Transaction;
import dao.impl.EM;
import dominio.Aluno;
import dominio.Curso;

public class AlunoServico {

	private AlunoDao dao;

	public AlunoServico() {
		dao = DaoFactory.criarAlunoDao();
	}
	
	public void validar(Aluno x) throws ValidacaoException{
		List<String> erros = new ArrayList<>();
		
		if(x.getNome()==null){
			erros.add("Favor preencher campo nome");
		}
		if(x.getCpf()==null){
			erros.add("Favor preencher campo cpf");
		}
		if(x.getEmail()==null){
			erros.add("Favor preencher campo email");
		}
		if(x.getTelefone()==null){
			erros.add("Favor preencher campo telefone");
		}
		if(x.getNascimento()==null){
			erros.add("Favor preencher campo data de nascimento");
		}
		if(x.getRenda()==null){
			erros.add("Favor preencher campo renda mensal");
		}
		
		if(!erros.isEmpty()){
			throw new ValidacaoException("Erros valida��o",erros);
		}
	}

	public void inserir(Aluno x) throws ServicoException {
		try {
			Aluno aluno = dao.buscarCpfExato(x.getCpf());
			if (aluno != null) {
				throw new ServicoException("Já existe um aluno com esse cpf!", 1);
			}
			Transaction.begin();
			dao.inserirAtualizar(x);
			Transaction.commit();
		} catch (RuntimeException e) {
			if (Transaction.isActive()) {
				Transaction.rollback();
			}
			System.out.println("Erro: " + e.getMessage());
		}

	}

	public void atualizar(Aluno x) throws ServicoException {

		try {
			Transaction.begin();
			dao.inserirAtualizar(x);
			Transaction.commit();
		} catch (RuntimeException e) {
			if (Transaction.isActive()) {
				Transaction.rollback();
			}
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void excluir(Aluno x) throws ServicoException{
		try {
			x = dao.buscar(x.getCodAluno());
			if (!x.getMatriculas().isEmpty()) {
				throw new ServicoException("Exclus�o n�o permitida: este aluno possui matriculas cadastradas!", 2);
			}
			Transaction.begin();
			dao.excluir(x);
			Transaction.commit();
		} catch (RuntimeException e) {
			if (Transaction.isActive()) {
				Transaction.rollback();
			}
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public Aluno buscar(int cod) {
		return dao.buscar(cod);
	}

	public List<Aluno> buscarTodos() {
		return dao.buscarTodos();
	}

	public List<Aluno> buscarAlunosOrderNome() {
		return dao.buscarAlunosOrderNome();
	}

	public List<Aluno> buscarPorTrecho(String trecho) {
		return dao.buscarPorTrecho(trecho);
	}
}
