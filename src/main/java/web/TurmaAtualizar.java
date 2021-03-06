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
import servico.ValidacaoException;

@WebServlet("/turma/atualizar")
public class TurmaAtualizar extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private static String DESTINO = "/turma/listar.jsp";
	private static String FORM = "/turma/formEditar.jsp";
	private static String ERRO = "/publico/erro.jsp";
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		CursoServico cs = new CursoServico();
		TurmaServico ts = new TurmaServico();
		Turma t = Instanciar.turma(request);
		Integer cod  = Integer.parseInt(request.getParameter("codCurso"));
		Curso c = cs.buscar(cod);
		try {
			ts.validar(t);
			t.setCurso(c);
			ts.atualizar(t);
			List<Turma> itens = ts.buscarTurmasNaoFinalizadas(c);
			
		    request.setAttribute("itens",itens);
		    request.setAttribute("cod",cod);
		    
		    request.getRequestDispatcher(DESTINO).forward(request,response);
		} catch (ServicoException e) {
			request.setAttribute("msg",e.getMessage());
			request.getRequestDispatcher(ERRO).forward(request,response);
		} catch (ValidacaoException e){
			request.setAttribute("erros",e.getErro());
			request.setAttribute("item",t);
			request.getRequestDispatcher(FORM).forward(request,response);
		}
	}
}