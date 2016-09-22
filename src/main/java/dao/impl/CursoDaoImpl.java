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
	public List<Curso> buscarPorNome(String nome,Double precoMinimo,Double precoMaximo){
		String jqpl = "Select x from Curso x where x.nome like :p1 and x.preco>:p2 and x.preco<:p3";
		Query query = em.createQuery(jqpl);
		query.setParameter("p1", "%"+nome+"%");
		query.setParameter("p2", precoMinimo);
		query.setParameter("p3", precoMaximo);
		List<Curso> cursos = query.getResultList();
		return (cursos.size()>0)? cursos :null;
		
	}
}
