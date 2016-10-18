package servico;

import java.util.List;



import dao.MatriculaDao;
import dao.DaoFactory;
import dao.impl.EM;
import dominio.Matricula;
import dao.Transaction;

public class MatriculaServico {

	private MatriculaDao dao;
	
	public MatriculaServico() {
		dao = DaoFactory.criarMatriculaDao();
	}
	
	public void inserir(Matricula x) throws ServicoException{
		try{
			Matricula aux = dao.buscarCodigoExato(x.getCodMatricula());
			if(aux != null){
				throw new ServicoException("Já existe matricula com esse código!",1);
			}
			Transaction.begin();
			dao.inserirAtualizar(x);
			Transaction.commit();
		}
		catch(RuntimeException e){
			if(Transaction.isActive()){
				Transaction.rollback();
			}
		}
	}
	public void excluir(Matricula x) {
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public Matricula buscar(int cod) {
		return dao.buscar(cod);
	}
	
	public List<Matricula> buscarTodos() {
		return dao.buscarTodos();
	}
}
