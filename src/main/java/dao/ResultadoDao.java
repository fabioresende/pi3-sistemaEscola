package dao;

import java.util.List;

import dominio.Resultado;

public interface ResultadoDao {

	public void inserirAtualizar(Resultado x);
	public void excluir(Resultado x);
	public Resultado buscar(int cod);
	public List<Resultado> buscarTodos();
} 
