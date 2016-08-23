package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.RestauranteDao;
import dominio.Restaurante;

public class RestauranteDaoImpl implements RestauranteDao {

	private EntityManager em;

	public RestauranteDaoImpl() {
		this.em = EM.getLocalEm();
	}
	
	@Override
	public void inserirAtualizar(Restaurante x) {
		if (x.getCodRestaurante() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(Restaurante x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Restaurante buscar(int cod) {
		return em.find(Restaurante.class, cod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Restaurante> buscarTodos() {
		String jpql = "SELECT x FROM Restaurante x";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}
}
