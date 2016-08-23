package servico;

import java.util.List;

import dao.CidadeDao;
import dao.DaoFactory;
import dao.impl.EM;
import dominio.Cidade;

public class CidadeServico {

	private CidadeDao dao;
	
	public CidadeServico() {
		dao = DaoFactory.criarCidadeDao();
	}
	
	public void inserirAtualizar(Cidade x) {
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public void excluir(Cidade x) {
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public Cidade buscar(int cod) {
		return dao.buscar(cod);
	}
	
	public List<Cidade> buscarTodos() {
		return dao.buscarTodos();
	}
}
