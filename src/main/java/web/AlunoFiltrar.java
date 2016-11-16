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

@WebServlet("/aluno/filtrar")
public class AlunoFiltrar extends HttpServlet{
	private static final long serialVersionVID = 1l;
	
	private static String DESTINO = "/aluno/listar.jsp";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
		AlunoServico al = new AlunoServico();
		String nome = request.getParameter("busca");
		List<Aluno> itens = al.buscarPorTrecho(nome);
		request.setAttribute("itens", itens);
		request.getRequestDispatcher(DESTINO).forward(request, response);
	}
}
