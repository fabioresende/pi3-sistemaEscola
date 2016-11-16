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
import servico.AlunoServico;
import servico.CursoServico;

@WebServlet("/aluno/remover")
public class AlunoRemover extends HttpServlet{
	private static final long serialVersionVID = 1l;
	
	private static String DESTINO = "/aluno/confirmarExclusao.jsp";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
		AlunoServico al = new AlunoServico();
		int cod = Integer.parseInt(request.getParameter("cod"));
		Aluno aluno = al.buscar(cod);
		request.setAttribute("item", aluno);
		request.getRequestDispatcher(DESTINO).forward(request, response);
	}
}
