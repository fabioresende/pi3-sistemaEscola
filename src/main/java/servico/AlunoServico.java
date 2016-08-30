package servico;

import java.util.List;

import dao.AlunoDao;
import dao.DaoFactory;
import dao.impl.EM;
import dominio.Aluno;

public class AlunoServico {

	private AlunoDao dao;
	
	public AlunoServico() {
		dao = DaoFactory.criarAlunoDao();
	}
	
	public void inserirAtualizar(Aluno x) {
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public void excluir(Aluno x) {
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public Aluno buscar(int cod) {
		return dao.buscar(cod);
	}
	
	public List<Aluno> buscarTodos() {
		return dao.buscarTodos();
	}
}
