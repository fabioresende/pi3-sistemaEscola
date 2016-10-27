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

@WebServlet("/turma/cursos")
public class CursoTurmaListar extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private static String DESTINO = "/turma/cursos.jsp";
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		
		
		CursoServico cs= new CursoServico(); 
		
		List<Curso> itens = cs.buscarCursosOrderNome();
	    request.setAttribute("itens",itens);
	    request.getRequestDispatcher(DESTINO).forward(request,response);
	}
}