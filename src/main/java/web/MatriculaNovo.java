package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Curso;
import dominio.Matricula;
import servico.CursoServico;

@WebServlet("/matricula/novo")
public class MatriculaNovo extends HttpServlet{
	private static final long serialVersionVID = 1l;
	
	private static String DESTINO = "/matricula/formInserir.jsp";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setAttribute("codAluno", request.getParameter("codAluno"));
		request.setAttribute("codTurma", request.getParameter("codTurma"));
		request.setAttribute("iten", new Matricula());
		request.getRequestDispatcher(DESTINO).forward(request, response);
	}
}
