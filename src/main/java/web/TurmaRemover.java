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

@WebServlet("/turma/remover")
public class TurmaRemover extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private static String DESTINO = "/turma/confirmarExclusao.jsp";
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		TurmaServico ts= new TurmaServico(); 
		
		int cod = Integer.parseInt(request.getParameter("cod"));
		Turma item = ts.buscar(cod);
		int codCurso = item.getCurso().getCodCurso();
	    request.setAttribute("item",item);
	    request.setAttribute("codCurso",codCurso);
	    request.getRequestDispatcher(DESTINO).forward(request,response);
	}
}