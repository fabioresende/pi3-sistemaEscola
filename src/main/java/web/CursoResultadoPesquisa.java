package web;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Curso;
import servico.CursoServico;

@WebServlet("/curso/resultadoPesquisa")
public class CursoResultadoPesquisa extends HttpServlet{
	private static final long serialVersionVID = 1l;
	
	private static String DESTINO = "/curso/listar.jsp";
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
		CursoServico cs = new CursoServico();
		String trechoNome = request.getParameter("trechoNome");
		String aux = request.getParameter("precoMinimo");
		BigDecimal precoMinimo = new BigDecimal(aux); 
		aux = request.getParameter("precoMaximo");
		BigDecimal precoMaximo = new BigDecimal(aux);
		List<Curso> itens = cs.buscarPorNome(trechoNome, precoMinimo, precoMaximo);
		request.setAttribute("itens", itens);
		request.getRequestDispatcher(DESTINO).forward(request, response);
	}
}
