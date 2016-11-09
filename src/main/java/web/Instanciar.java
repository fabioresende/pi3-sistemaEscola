package web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import dominio.Turma;

public class Instanciar {
	public static Turma turma(HttpServletRequest request) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Turma aux = new Turma();
		String s;

		s = request.getParameter("codTurma");
		if (s != null && !s.isEmpty()) {
			aux.setNumeroDeVagas(Integer.parseInt(s));
		}

		s = request.getParameter("datainicio");
		if (s != null && !s.isEmpty()) {
			try {
				aux.setDatainicio(sdf.parse(s));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		s = request.getParameter("numeroDeVagas");
		if (s != null && !s.isEmpty()) {
			aux.setNumeroDeVagas(Integer.parseInt(s));
		}

		aux.setFinalizada(false);

		return aux;
	}
}
