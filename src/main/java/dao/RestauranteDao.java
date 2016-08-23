package dao;

import java.util.List;

import dominio.Restaurante;

public interface RestauranteDao {

	public void inserirAtualizar(Restaurante x);
	public void excluir(Restaurante x);
	public Restaurante buscar(int cod);
	public List<Restaurante> buscarTodos();
} 
