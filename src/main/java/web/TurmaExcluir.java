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
import servico.ServicoException;
import servico.TurmaServico;

@WebServlet("/turma/excluir")
public class TurmaExcluir extends HttpServlet{
	private static final long serialVersionVID = 1l;
	
	private static String DESTINO = "/turma/listar.jsp";
	private static String ERRO = "/publico/erro.jsp";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		CursoServico cs = new CursoServico();
		TurmaServico ts = new TurmaServico();
		int cod = Integer.parseInt(request.getParameter("cod"));
		Turma turma = ts.buscar(cod);
		int codCurso = turma.getCurso().getCodCurso();
		Curso curso = cs.buscar(codCurso);
		try {
			ts.excluir(turma);
			List<Turma> itens = ts.buscarTurmasCurso(curso);
			request.setAttribute("itens", itens);
			request.getRequestDispatcher(DESTINO).forward(request, response);
		} catch (ServicoException e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher(ERRO).forward(request, response);
		}
	}
}
