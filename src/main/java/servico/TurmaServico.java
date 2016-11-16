package servico;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import dao.TurmaDao;
import dao.DaoFactory;
import dao.Transaction;
import dao.impl.EM;
import dominio.Curso;
import dominio.Turma;

public class TurmaServico {

	private TurmaDao dao;
	
	public TurmaServico() {
		dao = DaoFactory.criarTurmaDao();
	}
	public void validar(Turma x) throws ValidacaoException{
		List<String> erros = new ArrayList<>();
		
		if(x.getDatainicio() == null){
			erros.add("Favor preencher o campo de Data de Início");
		}
		if(x.getNumeroDeVagas() == null){
			erros.add("Favor preencher o campo de Número de Vagas");
		}
		
		if(!erros.isEmpty()){
			throw new ValidacaoException("Erro de validação",erros);
		}
	}
	public void inserir(Turma x) throws ServicoException{
		System.out.println("aa");
		try {
			Transaction.begin();
			dao.inserirAtualizar(x);
			Transaction.commit();
		} catch (RuntimeException e) {
			if (Transaction.isActive()) {
				Transaction.rollback();
			}
			System.out.println("Erro: " + e.getMessage());
		}
	}	
	public void atualizar(Turma x) throws ServicoException {
		try {
			Transaction.begin();
			dao.inserirAtualizar(x);
			Transaction.commit();
		} catch (RuntimeException e) {
			if (Transaction.isActive()) {
				Transaction.rollback();
			}
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void excluir(Turma x) throws ServicoException{
		try {
			Transaction.begin();
			dao.excluir(x);
			Transaction.commit();
		} catch (RuntimeException e) {
			if (Transaction.isActive()) {
				Transaction.rollback();
			}
			System.out.println("Erro: " + e.getMessage());
		}
	}

	
	public Turma buscar(int cod) {
		return dao.buscar(cod);
	}
	
	public List<Turma> buscarTodos() {
		return dao.buscarTodos();
	}
	public List<Turma> buscarTurmasNaoFinalizadas(Curso curso){
		return dao.buscarTurmasNaoFinalizadas(curso);
	}
	public List<Turma> buscarTurmasCurso(Curso curso){
		return dao.buscarTurmasCurso(curso);
	}
	public List<Turma> buscarTurmaPorVagas(int vagas) {
		return dao.buscarTurmaPorVagas(vagas);
	}
}
