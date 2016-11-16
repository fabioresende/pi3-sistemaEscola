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

@WebServlet("/curso/editar")
public class CursoEditar extends HttpServlet{
	private static final long serialVersionVID = 1l;
	
	private static String DESTINO = "/curso/formEditar.jsp";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
		CursoServico cs = new CursoServico();
		int cod = Integer.parseInt(request.getParameter("cod"));
		Curso curso = cs.buscar(cod);
		request.setAttribute("item", curso);
		request.getRequestDispatcher(DESTINO).forward(request, response);
	}
}
