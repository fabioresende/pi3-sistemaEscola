package servico;

import java.util.List;

import dao.ResultadoDao;
import dao.DaoFactory;
import dao.impl.EM;
import dominio.Resultado;

public class ResultadoServico {

	private ResultadoDao dao;
	
	public ResultadoServico() {
		dao = DaoFactory.criarResultadoDao();
	}
	
	public void inserirAtualizar(Resultado x) {
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public void excluir(Resultado x) {
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public Resultado buscar(int cod) {
		return dao.buscar(cod);
	}
	
	public List<Resultado> buscarTodos() {
		return dao.buscarTodos();
	}
}
