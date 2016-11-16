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

@WebServlet("/aluno/listar")
public class AlunoListar extends HttpServlet{
	private static final long serialVersionVID = 1l;
	
	private static String DESTINO = "/aluno/listar.jsp";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
		AlunoServico al = new AlunoServico();
		List<Aluno> itens = al.buscarAlunosOrderNome();
		request.setAttribute("itens", itens);
		request.getRequestDispatcher(DESTINO).forward(request, response);
	}
}
