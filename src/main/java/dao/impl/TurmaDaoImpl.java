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
		String jqpl = "Select x from Curso x where x.nome like :p1 and x.preco>:p2 and x.preco<:p3";
		Query query = em.createQuery(jqpl);
		return query.getResultList();
	}
}
