package servico;

import java.util.List;

import dao.RestauranteDao;
import dao.DaoFactory;
import dao.impl.EM;
import dominio.Restaurante;

public class RestauranteServico {

	private RestauranteDao dao;
	
	public RestauranteServico() {
		dao = DaoFactory.criarRestauranteDao();
	}
	
	public void inserirAtualizar(Restaurante x) {
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public void excluir(Restaurante x) {
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public Restaurante buscar(int cod) {
		return dao.buscar(cod);
	}
	
	public List<Restaurante> buscarTodos() {
		return dao.buscarTodos();
	}
}
