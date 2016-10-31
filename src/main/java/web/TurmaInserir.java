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

@WebServlet("/turma/inserir")
public class TurmaInserir extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private static String DESTINO = "/turma/formInserir.jsp";
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{

	    request.setAttribute("itens",new Turma());
	    request.getRequestDispatcher(DESTINO).forward(request,response);
	}
}