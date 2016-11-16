package web;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import antlr.ParserSharedInputState;
import dominio.Aluno;
import dominio.Curso;
import dominio.Matricula;
import dominio.Turma;


public class Instanciar {
	public static Turma turma(HttpServletRequest request) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Turma aux = new Turma();
		String s;

		s = request.getParameter("codTurma");
		if (s != null && !s.isEmpty()) {
			try{
				aux.setCodTurma(Integer.parseInt(s));
			}
			catch(NumberFormatException e){
				e.printStackTrace();
			}
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
			try{
				aux.setNumeroDeVagas(Integer.parseInt(s));
			}
			catch(NumberFormatException e){
				e.printStackTrace();
			}
		}
		
		
		aux.setFinalizada(false);

		return aux;
	}
	public static Matricula matricula(HttpServletRequest request) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Matricula aux = new Matricula();
		String s;

		s = request.getParameter("codMatricula");
		if (s != null && !s.isEmpty()) {
			try{
				aux.setCodMatricula(Integer.parseInt(s));
			}
			catch(NumberFormatException e){
				e.printStackTrace();
			}
		}

		s = request.getParameter("numParcelas");
		if (s != null && !s.isEmpty()) {
			try{
				aux.setNumParcelas(Integer.parseInt(s));
			}
			catch(NumberFormatException e){
				e.printStackTrace();
			}
		}
		
		aux.setDataMatricula(new Date());
	

		return aux;
	}
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

	public static Aluno aluno(HttpServletRequest request) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Aluno aux = new Aluno();
		String c;

		c = request.getParameter("codAluno");
		if (c != null && !c.isEmpty()) {
			try {
				aux.setCodAluno(Integer.parseInt(c));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}

		c = request.getParameter("nome");
		if (c != null && !c.isEmpty()) {
			aux.setNome(c);
		}

		c = request.getParameter("cpf");
		if (c != null && !c.isEmpty()) {
				aux.setCpf(c);
		}

		c = request.getParameter("telefone");
		if (c != null && !c.isEmpty()) {
				aux.setTelefone(c);
		}
		
		c = request.getParameter("email");
		if (c != null && !c.isEmpty()) {
				aux.setEmail(c);
		}
		
		c = request.getParameter("nascimento");
		if (c != null && !c.isEmpty()) {
			try{
				aux.setNascimento(sdf.parse(c));
			}
			catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		
		c = request.getParameter("renda");
		if (c != null && !c.isEmpty()) {
			try {
				aux.setRenda(new BigDecimal(c));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		
		return aux;
	}

}
