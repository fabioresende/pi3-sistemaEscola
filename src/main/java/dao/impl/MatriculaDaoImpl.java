package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.MatriculaDao;
import dominio.Matricula;

public class MatriculaDaoImpl implements MatriculaDao {

	private EntityManager em;

	public MatriculaDaoImpl() {
		this.em = EM.getLocalEm();
	}
	
	@Override
	public void inserirAtualizar(Matricula x) {
		if (x.getCodMatricula() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}
	public Matricula buscarCodigoExato(int cod){
		String jpql = "Select x from Matricula x where x.codMatricula = :p1";
		Query query = em.createNamedQuery(jpql);
		query.setParameter("p1",cod);
		List<Matricula> aux = query.getResultList();
		return (aux.size() > 0)?aux.get(0):null;
	}
	@Override
	public void excluir(Matricula x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Matricula buscar(int cod) {
		return em.find(Matricula.class, cod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Matricula> buscarTodos() {
		String jpql = "SELECT x FROM Matricula x";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}
}
