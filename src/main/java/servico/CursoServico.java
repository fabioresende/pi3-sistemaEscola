package servico;

import java.util.List;

import dao.CursoDao;
import dao.DaoFactory;
import dao.impl.EM;
import dominio.Curso;

public class CursoServico {

	private CursoDao dao;
	
	public CursoServico() {
		dao = DaoFactory.criarCursoDao();
	}
	
	public void inserirAtualizar(Curso x) {
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getLocalEm().getTransaction().commit();
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

}
