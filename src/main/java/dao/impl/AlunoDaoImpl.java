package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.AlunoDao;
import dominio.Aluno;

public class AlunoDaoImpl implements AlunoDao {

	private EntityManager em;

	public AlunoDaoImpl() {
		this.em = EM.getLocalEm();
	}
	
	@Override
	public void inserirAtualizar(Aluno x) {
		if (x.getCodAluno() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(Aluno x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Aluno buscar(int cod) {
		return em.find(Aluno.class, cod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Aluno> buscarTodos() {
		String jpql = "SELECT x FROM Aluno x";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}
}
