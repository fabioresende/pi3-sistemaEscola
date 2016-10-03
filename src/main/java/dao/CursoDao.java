package dao;

import java.util.List;

import dominio.Curso;

public interface CursoDao {

	public void inserirAtualizar(Curso x);
	public void excluir(Curso x);
	public Curso buscar(int cod);
	public List<Curso> buscarTodos();
	public List<Curso> buscarPorNome(String nome,Double precoMinimo,Double precoMaximo);
	public List<Curso> buscarCursosOrderNome();
	public Curso buscarNomeExato(String nome);
	public List<Curso> buscarPorTrecho(String trecho);
} 
