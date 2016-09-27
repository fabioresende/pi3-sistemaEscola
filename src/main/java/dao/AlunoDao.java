package dao;

import java.util.List;

import dominio.Aluno;

public interface AlunoDao {

	public void inserirAtualizar(Aluno x);
	public void excluir(Aluno x);
	public Aluno buscar(int cod);
	public List<Aluno> buscarTodos();
	public List<Aluno> buscarAlunosOrderNome();
	public Aluno buscarNomeExato(String nome);
	public List<Aluno> buscarPorTrecho(String trecho);
} 
