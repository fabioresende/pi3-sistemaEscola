package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Aluno;
import dominio.Curso;
import dominio.Turma;
import servico.AlunoServico;
import servico.CursoServico;
import servico.TurmaServico;

@WebServlet("/matricula/alunoListar")
public class MatriculaAlunoListar extends HttpServlet{
	private static final long serialVersionVID = 1l;
	
	private static String DESTINO = "/matricula/alunosListar.jsp";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	    request.setAttribute("codTurma", request.getParameter("cod"));
	    AlunoServico as = new AlunoServico();
	    List<Aluno> alunos = as.buscarAlunosOrderNome();
		request.setAttribute("itens", alunos);
		request.getRequestDispatcher(DESTINO).forward(request, response);
	}
}
