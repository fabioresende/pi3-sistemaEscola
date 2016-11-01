package servico;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.ValidationException;

import dao.CursoDao;
import dao.DaoFactory;
import dao.Transaction;
import dao.impl.EM;
import dominio.Curso;
import dominio.Curso;

public class CursoServico {

	private CursoDao dao;
	
	public CursoServico() {
		dao = DaoFactory.criarCursoDao();
	}
	
	public void validar(Curso x) throws ValidacaoException{
		List<String> erros = new ArrayList<>();
		
		if(x.getNome()==null){
			erros.add("Favor preencher campo nome");
		}
		if(x.getCargaHoraria()==null){
			erros.add("Favor preencher campo carga horária");
		}
		if(x.getPontuacao()==null){
			erros.add("Favor preencher campo pontuação");
		}
		if(x.getPreco()==null){
			erros.add("Favor preencher campo preço");
		}
		if(!erros.isEmpty()){
			throw new ValidacaoException("Erros validação",erros);
		}
	}
	public void inserir(Curso x) throws ServicoException {
		try {
			Curso aluno = dao.buscarNomeExato(x.getNome());
			if (aluno != null) {
				throw new ServicoException("Já existe um curso com esse nome!", 1);
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

	public void atualizar(Curso x) throws ServicoException {
		Curso aluno = dao.buscarNomeExato(x.getNome());
		if (aluno != null) {
			throw new ServicoException("Já existe um curso com esse nome!", 1);
		}

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
	
	
	
	public void excluir(Curso x) {
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public Curso buscar(int cod) {
		return dao.buscar(cod);
	}
	
	public List<Curso> buscarTodos() {
		return dao.buscarTodos();
	}

	public List<Curso> buscarPorNome(String nome,Double precoMinimo,Double precoMaximo){
		return dao.buscarPorNome(nome,precoMinimo,precoMaximo);
	}

	public List<Curso> buscarCursosOrderNome() {
		return dao.buscarCursosOrderNome();
	}

	public List<Curso> buscarPorTrecho(String trecho) {
		return dao.buscarPorTrecho(trecho);
	}
}
