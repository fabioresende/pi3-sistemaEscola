package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Curso;
import servico.CursoServico;
import servico.ServicoException;
import servico.ValidacaoException;

@WebServlet("/curso/atualizar")
public class CursoAtualizar extends HttpServlet{
	private static final long serialVersionVID = 1l;
	
	private static String DESTINO = "/curso/listar.jsp";
	private static String FORM = "/curso/formEditar.jsp";
	private static String ERRO = "/publico/erro.jsp";
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
		CursoServico cs = new CursoServico();
		Curso x = Instanciar.curso(request);
		try {
			cs.validar(x);
			cs.atualizar(x);
			List<Curso> itens = cs.buscarCursosOrderNome();
			request.setAttribute("itens", itens);
			request.getRequestDispatcher(DESTINO).forward(request, response);
		} catch (ServicoException e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher(ERRO).forward(request, response);
		} catch (ValidacaoException e) {
			request.setAttribute("erros", e.getErro());
			request.setAttribute("item", x);
			request.getRequestDispatcher(FORM).forward(request, response);
		}
	}
}
