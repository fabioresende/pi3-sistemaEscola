package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.ResultadoDao;
import dominio.Resultado;

public class ResultadoDaoImpl implements ResultadoDao {

	private EntityManager em;

	public ResultadoDaoImpl() {
		this.em = EM.getLocalEm();
	}
	
	@Override
	public void inserirAtualizar(Resultado x) {
		if (x.getCodResultado() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(Resultado x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Resultado buscar(int cod) {
		return em.find(Resultado.class, cod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Resultado> buscarTodos() {
		String jpql = "SELECT x FROM Resultado x";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}
}
