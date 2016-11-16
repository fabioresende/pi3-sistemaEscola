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
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Aluno> buscarAlunosOrderNome(){
		String jpql = "SELECT x FROM Aluno x ORDER BY x.nome";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Aluno buscarCpfExato(String cpf){
		String jpql = "SELECT x FROM Aluno x WHERE x.cpf = :p1";
		Query query = em.createQuery(jpql);
		query.setParameter("p1", cpf);
		List<Aluno> aux = query.getResultList();
		return (aux.size() > 0) ? aux.get(0) : null;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Aluno> buscarPorTrecho(String trecho){
		String jpql = "SELECT x FROM Aluno x WHERE x.nome LIKE :p1";
		Query query = em.createQuery(jpql);
		query.setParameter("p1", "%"+trecho+"%");
		return query.getResultList();
	}
}
