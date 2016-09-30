package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.TurmaDao;
import dominio.Curso;
import dominio.Turma;

public class TurmaDaoImpl implements TurmaDao {

	private EntityManager em;

	public TurmaDaoImpl() {
		this.em = EM.getLocalEm();
	}
	
	@Override
	public void inserirAtualizar(Turma x) {
		if (x.getCodTurma() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(Turma x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Turma buscar(int cod) {
		return em.find(Turma.class, cod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Turma> buscarTodos() {
		String jpql = "SELECT x FROM Turma x";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Turma> buscarTurmasNaoFinalizadas(Curso curso){
		String jqpl = "Select x from Turma x where x.curso = :p1";
		Query query = em.createQuery(jqpl);
		query.setParameter("p1",curso);
		return query.getResultList();
	}
}
