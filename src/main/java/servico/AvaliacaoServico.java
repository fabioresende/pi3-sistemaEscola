package servico;

import java.util.List;

import dao.AvaliacaoDao;
import dao.DaoFactory;
import dao.impl.EM;
import dominio.Avaliacao;

public class AvaliacaoServico {

	private AvaliacaoDao dao;
	
	public AvaliacaoServico() {
		dao = DaoFactory.criarAvaliacaoDao();
	}
	
	public void inserirAtualizar(Avaliacao x) {
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public void excluir(Avaliacao x) {
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public Avaliacao buscar(int cod) {
		return dao.buscar(cod);
	}
	
	public List<Avaliacao> buscarTodos() {
		return dao.buscarTodos();
	}
}
