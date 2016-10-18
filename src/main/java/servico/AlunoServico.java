package servico;

import java.util.List;

import dao.AlunoDao;
import dao.DaoFactory;
import dao.Transaction;
import dao.impl.EM;
import dominio.Aluno;

public class AlunoServico {

	private AlunoDao dao;

	public AlunoServico() {
		dao = DaoFactory.criarAlunoDao();
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
		Aluno aluno = dao.buscarCpfExato(x.getCpf());
		if (aluno != null) {
			throw new ServicoException("Já existe um aluno com esse cpf!", 1);
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

	public void excluir(Aluno x) {
		try {
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
