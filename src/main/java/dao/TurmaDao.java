package dao;

import java.util.List;

import dominio.Curso;
import dominio.Turma;

public interface TurmaDao {

	public void inserirAtualizar(Turma x);
	public void excluir(Turma x);
	public Turma buscar(int cod);
	public List<Turma> buscarTodos();
	public List<Turma> buscarTurmasNaoFinalizadas(Curso curso);
} 
