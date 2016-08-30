package dao;

import dao.impl.AlunoDaoImpl;
import dao.impl.AvaliacaoDaoImpl;
import dao.impl.CursoDaoImpl;
import dao.impl.MatriculaDaoImpl;
import dao.impl.ResultadoDaoImpl;
import dao.impl.TurmaDaoImpl;

public class DaoFactory {

	public static AlunoDao criarAlunoDao() {
		return new AlunoDaoImpl();
	}

	public static AvaliacaoDao criarAvaliacaoDao() {
		return new AvaliacaoDaoImpl();
	}

	public static CursoDao criarCursoDao() {
		return new CursoDaoImpl();
	}

	public static MatriculaDao criarMatriculaDao() {
		return new MatriculaDaoImpl();
	}
	public static ResultadoDao criarResultadoDao() {
		return new ResultadoDaoImpl();
	}
	public static TurmaDao criarTurmaDao() {
		return new TurmaDaoImpl();
	}
}
