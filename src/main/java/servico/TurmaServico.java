package servico;

import java.util.List;

import dao.TurmaDao;
import dao.DaoFactory;
import dao.impl.EM;
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
	
	public void excluir(Turma x) {
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public Turma buscar(int cod) {
		return dao.buscar(cod);
	}
	
	public List<Turma> buscarTodos() {
		return dao.buscarTodos();
	}
}
