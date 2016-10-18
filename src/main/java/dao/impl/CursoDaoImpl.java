package dao.impl;

import java.math.BigDecimal;
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

	public List<Curso> buscarPorNome(String nome,BigDecimal precoMinimo,BigDecimal precoMaximo){
		String jqpl = "Select x from Curso x where x.nome like :p1 and x.preco>:p2 and x.preco<:p3";
		Query query = em.createQuery(jqpl);
		query.setParameter("p1", "%"+nome+"%");
		query.setParameter("p2", precoMinimo);
		query.setParameter("p3", precoMaximo);
		List<Curso> cursos = query.getResultList();
		return (cursos.size()>0)? cursos :null;
	}

	public List<Curso> buscarCursosOrderNome(){
		String jpql = "SELECT x FROM Curso x ORDER BY x.nome";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Curso buscarNomeExato(String nome){
		String jpql = "SELECT x FROM Curso x WHERE x.nome = :p1";
		Query query = em.createQuery(jpql);
		query.setParameter("p1", nome);
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
