package dao;

import java.util.List;

import dominio.Curso;

public interface CursoDao {

	public void inserirAtualizar(Curso x);
	public void excluir(Curso x);
	public Curso buscar(int cod);
	public List<Curso> buscarTodos();
} 
