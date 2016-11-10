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
import servico.ServicoException;

@WebServlet("/aluno/inserir")
public class AlunoInserir extends HttpServlet{
	private static final long serialVersionVID = 1l;
	
	private static String DESTINO = "/aluno/listar.jsp";
	private static String ERRO = "/publico/erro.jsp";
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
		AlunoServico al = new AlunoServico();
		Aluno x = Instanciar.aluno(request);
		try {
			al.inserir(x);
			List<Aluno> itens = al.buscarAlunosOrderNome();
			request.setAttribute("itens", itens);
			request.getRequestDispatcher(DESTINO).forward(request, response);
		} catch (ServicoException e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher(ERRO).forward(request, response);
		}
	}
}
