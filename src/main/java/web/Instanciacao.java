package web;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Aluno;
import dominio.Avaliacao;
import dominio.Curso;
import dominio.Matricula;
import dominio.Resultado;
import dominio.Turma;
import servico.AlunoServico;
import servico.AvaliacaoServico;
import servico.CursoServico;
import servico.MatriculaServico;
import servico.ResultadoServico;
import servico.ServicoException;
import servico.TurmaServico;

@WebServlet("/Instanciacao")
public class Instanciacao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			Curso c1 = new Curso(null, "Sistemmas para Internet",2800,new BigDecimal("0.00"),5.0);
			Curso c2 = new Curso(null, "Ciência da commputacao",4200,new BigDecimal("1000.00"),3.0);
			
			Turma t1 = new Turma(null, sdf.parse("20/10/2015"),30,true,c1);
			Turma t2 = new Turma(null, sdf.parse("01/02/2014"),40,false,c2);
			Turma t3 = new Turma(null, sdf.parse("25/10/2015"),30,true,c1);
			Turma t4 = new Turma(null, sdf.parse("05/02/2014"),40,false,c2);
			
		    Aluno a1 = new Aluno(null,"Aluno1","12345678900","(34)0000-0000",sdf.parse("20/02/2015"),"email@.com",new BigDecimal("700.00"));
		    Aluno a2 = new Aluno(null,"Aluno2","12345678902","(34)0000-0002",sdf.parse("23/03/2015"),"email2@.com",new BigDecimal("800.00"));
		    Aluno a3 = new Aluno(null,"Aluno3","12345678903","(34)0000-0003",sdf.parse("20/04/2015"),"email3@.com",new BigDecimal("900.00"));
		    Aluno a4 = new Aluno(null,"Aluno4","12345678904","(34)0000-0004",sdf.parse("20/05/2015"),"email4@.com",new BigDecimal("1000.00"));
		    Aluno a5 = new Aluno(null,"Aluno5","12345678905","(34)0000-0005",sdf.parse("20/07/2015"),"email5@.com",new BigDecimal("600.00"));
		    Aluno a6 = new Aluno(null,"Aluno6","12345678906","(34)0000-0006",sdf.parse("20/08/2015"),"email6@.com",new BigDecimal("1500.00"));
		    Aluno a7 = new Aluno(null,"Aluno7","12345678907","(34)0000-0007",sdf.parse("20/10/2015"),"email7@.com",new BigDecimal("700.00"));
		    Aluno a8 = new Aluno(null,"Aluno8","12345678908","(34)0000-0008",sdf.parse("20/12/2015"),"email8@.com",new BigDecimal("1200.00"));
		    Aluno a9 = new Aluno(null,"Aluno9","12345678909","(34)0000-0009",sdf.parse("20/04/2015"),"email9@.com",new BigDecimal("1300.00"));
		    Aluno a10 = new Aluno(null,"Aluno10","12345678910","(34)0000-0010",sdf.parse("20/01/2015"),"email10@.com",new BigDecimal("500.00"));
		    
		    Matricula m1 = new Matricula(null,sdf.parse("20/02/2015"),6,a1,t1);
		    Matricula m2 = new Matricula(null,sdf.parse("21/02/2015"),7,a2,t1);
		    Matricula m3 = new Matricula(null,sdf.parse("22/02/2015"),8,a3,t1);
		    Matricula m4 = new Matricula(null,sdf.parse("23/02/2015"),9,a4,t1);
		    
		    Matricula m5 = new Matricula(null,sdf.parse("20/02/2015"),10,a5,t2);
		    Matricula m6 = new Matricula(null,sdf.parse("21/02/2015"),9,a6,t2);
		    Matricula m7 = new Matricula(null,sdf.parse("22/02/2015"),8,a7,t2);
		    Matricula m8 = new Matricula(null,sdf.parse("23/02/2015"),7,a8,t2);
	
		    
		    Matricula m9 = new Matricula(null,sdf.parse("20/02/2015"),6,a1,t3);
		    Matricula m10 = new Matricula(null,sdf.parse("21/02/2015"),7,a2,t3);
		    Matricula m11 = new Matricula(null,sdf.parse("22/02/2015"),8,a3,t3);
		    Matricula m12 = new Matricula(null,sdf.parse("23/02/2015"),9,a4,t3);
		    
		    Matricula m13 = new Matricula(null,sdf.parse("20/02/2015"),10,a5,t4);
		    Matricula m14 = new Matricula(null,sdf.parse("21/02/2015"),9,a6,t4);
		    Matricula m15 = new Matricula(null,sdf.parse("22/02/2015"),8,a7,t4);
		    Matricula m16 = new Matricula(null,sdf.parse("23/02/2015"),7,a8,t4);
		    
		    
		    
		    Avaliacao av1 = new Avaliacao(null,10.0,sdf.parse("20/03/2015"),t1);
		    Avaliacao av2 = new Avaliacao(null,20.0,sdf.parse("20/04/2015"),t2);
		    
		    Resultado r1 = new Resultado(null, 0.0, m1, av1);
		    Resultado r2 = new Resultado(null, 7.0, m2, av1);
		    Resultado r3 = new Resultado(null, 10.0,m3, av1);
		    Resultado r4 = new Resultado(null, 3.0, m4, av1);
		    
		    Resultado r5 = new Resultado(null, 20.0, m5, av2);
		    Resultado r6 = new Resultado(null, 19.0, m6, av2);
		    Resultado r7 = new Resultado(null, 8.0, m7, av2);
		    Resultado r8 = new Resultado(null, 9.0, m8, av2);
		    
		    
		    AlunoServico as = new AlunoServico();
			AvaliacaoServico avs = new AvaliacaoServico();
			CursoServico cs = new CursoServico();
			TurmaServico ts = new TurmaServico();
			MatriculaServico ms = new MatriculaServico();
			ResultadoServico rs = new ResultadoServico();
			
			cs.inserir(c1);
			cs.inserir(c2);
			
			ts.inserirAtualizar(t1);
			ts.inserirAtualizar(t2);
			
			
			as.inserir(a1);
			as.inserir(a2);
			as.inserir(a3);
			as.inserir(a4);
			as.inserir(a5);
			as.inserir(a6);
			as.inserir(a7);
			as.inserir(a8);			
			as.inserir(a9);
			as.inserir(a10);
			
			
			ms.inserir(m1);
			ms.inserir(m2);
			ms.inserir(m3);
			ms.inserir(m4);
			ms.inserir(m5);
			ms.inserir(m6);
			ms.inserir(m7);
			ms.inserir(m8);
			
			avs.inserirAtualizar(av1);
			avs.inserirAtualizar(av2);
			
			rs.inserirAtualizar(r1);
			rs.inserirAtualizar(r2);
			rs.inserirAtualizar(r3);
			rs.inserirAtualizar(r4);
			rs.inserirAtualizar(r5);
			rs.inserirAtualizar(r6);
			rs.inserirAtualizar(r7);
			rs.inserirAtualizar(r8);

			response.getWriter().append("Fim da instanciação");

		} catch (ParseException e) {
			response.getWriter().append(e.getMessage());
		} catch (ServicoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
