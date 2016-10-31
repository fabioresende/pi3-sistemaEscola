package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Curso;
import dominio.Turma;
import servico.CursoServico;
import servico.TurmaServico;

@WebServlet("/turma/editar")
public class TurmaEditar extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private static String DESTINO = "/turma/listar.jsp";
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		TurmaServico ts= new TurmaServico(); 
		CursoServico cs= new CursoServico();
		
		int cod = Integer.parseInt(request.getParameter("cod"));

		Curso curso = cs.buscar(cod);
		List<Turma> itens = ts.buscarTurmasNaoFinalizadas(curso);
	    request.setAttribute("itens",itens);
	    request.setAttribute("curso",curso);
	    request.getRequestDispatcher(DESTINO).forward(request,response);
	}
}