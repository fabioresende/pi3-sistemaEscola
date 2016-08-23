package dao;

import java.util.List;

import dominio.Cidade;

public interface CidadeDao {

	public void inserirAtualizar(Cidade x);
	public void excluir(Cidade x);
	public Cidade buscar(int cod);
	public List<Cidade> buscarTodos();
} 
