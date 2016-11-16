package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Curso;
import servico.CursoServico;

@WebServlet("/curso/listar")
public class CursoListar extends HttpServlet{
	private static final long serialVersionVID = 1l;
	
	private static String DESTINO = "/curso/listar.jsp";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
		CursoServico cs = new CursoServico();
		List<Curso> itens = cs.buscarCursosOrderNome();
		request.setAttribute("itens", itens);
		request.getRequestDispatcher(DESTINO).forward(request, response);
	}
}
