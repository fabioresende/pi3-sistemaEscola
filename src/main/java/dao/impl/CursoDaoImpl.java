package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.CursoDao;
import dominio.Curso;

public class CursoDaoImpl implements CursoDao {

	private EntityManager em;

	public CursoDaoImpl() {
		this.em = EM.getLocalEm();
	}
	
	@Override
	public void inserirAtualizar(Curso x) {
		if (x.getCodCurso() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(Curso x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Curso buscar(int cod) {
		return em.find(Curso.class, cod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Curso> buscarTodos() {
		String jpql = "SELECT x FROM Curso x";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}
}
