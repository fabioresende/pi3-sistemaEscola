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

@WebServlet("/turma/filtrar")
public class TurmaFiltrar extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private static String DESTINO = "/turma/consultar.jsp";
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		TurmaServico ts= new TurmaServico(); 
		int vagas = Integer.parseInt(request.getParameter("busca"));

		List<Turma> itens = ts.buscarTurmaPorVagas(vagas);

	    request.setAttribute("itens",itens);
	    request.getRequestDispatcher(DESTINO).forward(request,response);
	}
}