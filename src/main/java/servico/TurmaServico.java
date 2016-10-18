package servico;

import java.util.Date;
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
	
	public void inserirAtualizar(Turma x) {
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getLocalEm().getTransaction().commit();
	}
	public void atualizar(Turma x) throws ServicoException {
		Turma turma = dao.buscar(x.getCodTurma());
		if (turma != null) {
			throw new ServicoException("Ja existe uma turma com esse c�digo!", 1);
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
	public List<Turma> buscarTurmaPorDataIn(Date data) {
		return dao.buscarTurmaPorDataIn(data);
	}
}
