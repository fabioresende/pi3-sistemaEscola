package servico;

import java.util.List;

import dao.TurmaDao;
import dao.DaoFactory;
import dao.Transaction;
import dao.impl.EM;
import dominio.Curso;
import dominio.Turma;

public class TurmaServico {

	private TurmaDao dao;
	
	public TurmaServico() {
		dao = DaoFactory.criarTurmaDao();
	}
	
	public void inserir(Turma x) throws ServicoException{
		try {
			Turma turma = dao.buscar(x.getCodTurma());
			if (turma != null) {
				throw new ServicoException("Ja existe uma turma com esse código!", 1);
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
	public void atualizar(Turma x) throws ServicoException {
		Turma turma = dao.buscar(x.getCodTurma());
		if (turma != null) {
			throw new ServicoException("Ja existe uma turma com esse código!", 1);
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

	public void excluir(Turma x) {
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

	
	public Turma buscar(int cod) {
		return dao.buscar(cod);
	}
	
	public List<Turma> buscarTodos() {
		return dao.buscarTodos();
	}
	public List<Turma> buscarTurmasNaoFinalizadas(Curso curso){
		return dao.buscarTurmasNaoFinalizadas(curso);
	}
	public List<Turma> buscarTurmasCurso(Curso curso){
		return dao.buscarTurmasCurso(curso);
	}
	public List<Turma> buscarTurmaPorVagas(int vagas) {
		return dao.buscarTurmaPorVagas(vagas);
	}
}
