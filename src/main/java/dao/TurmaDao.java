package dao;

import java.util.Date;
import java.util.List;

import dominio.Curso;
import dominio.Turma;

public interface TurmaDao {

	public void inserirAtualizar(Turma x);
	public void excluir(Turma x);
	public Turma buscar(int cod);
	public List<Turma> buscarTodos();
	public List<Turma> buscarTurmasNaoFinalizadas(Curso curso);
	public List<Turma> buscarTurmasCurso(Curso curso);
	public List<Turma> buscarTurmaPorVagas(int vagas);
} 
