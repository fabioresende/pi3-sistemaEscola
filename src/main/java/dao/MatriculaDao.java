package dao;

import java.util.List;

import dominio.Matricula;

public interface MatriculaDao {

	public void inserirAtualizar(Matricula x);
	public void excluir(Matricula x);
	public Matricula buscar(int cod);
	public List<Matricula> buscarTodos();
} 
