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
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Curso> buscarCursosOrderNome(){
		String jpql = "SELECT x FROM Curso x ORDER BY x.nome";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Curso buscarCpfExato(String cpf){
		String jpql = "SELECT x FROM Curso x WHERE x.cpf = :p1";
		Query query = em.createQuery(jpql);
		query.setParameter("p1", cpf);
		List<Curso> aux = query.getResultList();
		return (aux.size() > 0) ? aux.get(0) : null;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Curso> buscarPorTrecho(String trecho){
		String jpql = "SELECT x FROM Curso x LIKE :p1";
		Query query = em.createQuery(jpql);
		query.setParameter("p1", "%"+trecho+"%");
		return query.getResultList();
	}
}
