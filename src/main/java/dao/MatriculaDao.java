package dao;

import java.util.List;

import dominio.Aluno;
import dominio.Curso;
import dominio.Matricula;
import dominio.Turma;

public interface MatriculaDao {

	public void inserirAtualizar(Matricula x);
	public void excluir(Matricula x);
	public Matricula buscar(int cod);
	public List<Matricula> buscarTodos();
	public Matricula buscarRegistroMatricula(Turma turma,Aluno aluno);
} 
