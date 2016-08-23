package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.CidadeDao;
import dominio.Cidade;

public class CidadeDaoImpl implements CidadeDao {

	private EntityManager em;

	public CidadeDaoImpl() {
		this.em = EM.getLocalEm();
	}
	
	@Override
	public void inserirAtualizar(Cidade x) {
		if (x.getCodCidade() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(Cidade x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Cidade buscar(int cod) {
		return em.find(Cidade.class, cod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cidade> buscarTodos() {
		String jpql = "SELECT x FROM Cidade x";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}
}
