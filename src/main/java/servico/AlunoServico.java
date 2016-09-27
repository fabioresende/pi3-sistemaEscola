package servico;

import java.util.List;

import dao.AlunoDao;
import dao.DaoFactory;
import dao.Transaction;
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
	
	public void inserir(Aluno x) throws ServicoException{
		try{
			Aluno aluno = dao.buscarNomeExato(x.getNome());
			if(aluno != null){
				throw new ServicoException("Já existe um aluno com esse nome!", 1);
			}
			Transaction.begin();
			dao.inserirAtualizar(x);
			Transaction.commit();
		}
		catch (RuntimeException e) {
			if (Transaction.isActive()) {
				Transaction.rollback();
			}
			System.out.println("Erro: " + e.getMessage());
		}
		
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
	
	public List<Aluno> buscarAlunosOrderNome(){
		return dao.buscarAlunosOrderNome();
	}
	public List<Aluno> buscarPorTrecho(String trecho){
		return dao.buscarPorTrecho(trecho);
	}
}
