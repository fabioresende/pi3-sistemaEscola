package web;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import antlr.ParserSharedInputState;
import dominio.Curso;

public class Instanciar {

	public static Curso curso(HttpServletRequest request) {
		Curso aux = new Curso();
		String c;

		c = request.getParameter("codCurso");
		if (c != null && !c.isEmpty()) {
			try {
				aux.setCodCurso(Integer.parseInt(c));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}

		c = request.getParameter("nome");
		if (c != null && !c.isEmpty()) {
			aux.setNome(c);
		}

		c = request.getParameter("preco");
		if (c != null && !c.isEmpty()) {
			try {
				aux.setPreco(new BigDecimal(c));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}

		c = request.getParameter("pontuacao");
		if (c != null && !c.isEmpty()) {
			try {
				aux.setPontuacao(Double.parseDouble(c));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		
		c = request.getParameter("cargaHoraria");
		if (c != null && !c.isEmpty()) {
			try {
				aux.setCargaHoraria(Integer.parseInt(c));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		
		
		return aux;
	}

}
