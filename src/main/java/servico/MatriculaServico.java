package servico;

import java.util.List;

import dao.MatriculaDao;
import dao.DaoFactory;
import dao.impl.EM;
import dominio.Matricula;

public class MatriculaServico {

	private MatriculaDao dao;
	
	public MatriculaServico() {
		dao = DaoFactory.criarMatriculaDao();
	}
	
	public void inserirAtualizar(Matricula x) {
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public void excluir(Matricula x) {
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public Matricula buscar(int cod) {
		return dao.buscar(cod);
	}
	
	public List<Matricula> buscarTodos() {
		return dao.buscarTodos();
	}
}
