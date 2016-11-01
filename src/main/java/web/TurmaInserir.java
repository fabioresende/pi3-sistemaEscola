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

@WebServlet("/turma/novaTurma")
public class TurmaInserir extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private static String DESTINO = "/turma/formInserir.jsp";
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		CursoServico cs = new CursoServico();
		Turma t = new Turma();
		Integer cod = Integer.parseInt(request.getParameter("cod"));
		Curso c = cs.buscar(cod);
		t.setCurso(c);
	    request.setAttribute("item",t);
	    request.setAttribute("cod",cod);
	    request.getRequestDispatcher(DESTINO).forward(request,response);
	}
}