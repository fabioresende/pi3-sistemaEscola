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
import dominio.Matricula;
import dominio.Turma;
import servico.AlunoServico;
import servico.CursoServico;
import servico.MatriculaServico;
import servico.ServicoException;
import servico.TurmaServico;
import servico.ValidacaoException;

@WebServlet("/matricula/inserir")
public class MatriculaInserir extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private static String DESTINO = "/matricula/matriculasListar.jsp";
	private static String FORM = "/matricula/formIserir.jsp";
	private static String ERRO = "/publico/erro.jsp";
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		TurmaServico ts = new TurmaServico();
		AlunoServico as = new AlunoServico();
		MatriculaServico ms = new MatriculaServico();
		Integer codTurma = Integer.parseInt(request.getParameter("codTurma"));
		Integer codAluno = Integer.parseInt(request.getParameter("codAluno"));
		Matricula m = Instanciar.matricula(request);
		Turma t = ts.buscar(codTurma);
		Aluno a = as.buscar(codAluno);
		try {
			m.setTurma(t);
			m.setAluno(a);
			ms.validar(m);
			ms.inserir(m);
			List<Matricula> itens = ms.buscarTodos();
			
		    request.setAttribute("itens",itens);
		    request.setAttribute("codTurma",codTurma);
		    request.getRequestDispatcher(DESTINO).forward(request,response);
		} catch (ServicoException e) {
			request.setAttribute("msg",e.getMessage());
			request.getRequestDispatcher(ERRO).forward(request,response);
		} catch (ValidacaoException e){
			request.setAttribute("erros",e.getErro());
			request.setAttribute("item",m);
			request.getRequestDispatcher(FORM).forward(request,response);
		}
	}
}