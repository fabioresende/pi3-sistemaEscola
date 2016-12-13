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
			
			Curso c1 = new Curso(null, "Sistemas para Internet",2800,new BigDecimal("900.00"),5.0);
			Curso c2 = new Curso(null, "Ciência da computacao",4200,new BigDecimal("1000.00"),3.0);
			
			Turma t1 = new Turma(null, sdf.parse("20/10/2015"),30,false,c1);
			Turma t2 = new Turma(null, sdf.parse("01/02/2014"),40,false,c2);
			Turma t3 = new Turma(null, sdf.parse("25/10/2015"),30,false,c1);
			Turma t4 = new Turma(null, sdf.parse("05/02/2014"),40,false,c2);
			
		    Aluno a1 = new Aluno(null,"Fernanda","43191169334","(34)99780215",sdf.parse("20/02/2002"),"fernanda@gmail.com",new BigDecimal("700.00"));
		    Aluno a2 = new Aluno(null,"Bruno","66041570753","(34)99913320",sdf.parse("23/03/1996"),"bruno@gmail.com",new BigDecimal("800.00"));
		    Aluno a3 = new Aluno(null,"Pedro","13837488616","(34)99916044",sdf.parse("20/04/1998"),"pedro@gmail.com",new BigDecimal("900.00"));
		    Aluno a4 = new Aluno(null,"Jessica","16223745419","(34)99913901",sdf.parse("20/05/2000"),"jessica@gmail.com",new BigDecimal("1000.00"));
		    Aluno a5 = new Aluno(null,"Igor","75147389750","(34)99780013",sdf.parse("20/07/1997"),"igor@gmail.com",new BigDecimal("600.00"));
		    Aluno a6 = new Aluno(null,"Bianca","15652104252","(34)99362568",sdf.parse("20/08/1995"),"bianca@gmail.com",new BigDecimal("1500.00"));
		    Aluno a7 = new Aluno(null,"Guilherme","65034562634","(34)99780013",sdf.parse("20/10/2003"),"guilherme@gmail.com",new BigDecimal("700.00"));
		    Aluno a8 = new Aluno(null,"Aline","42879666279","(34)99988672",sdf.parse("20/12/1996"),"aline@gmail.com",new BigDecimal("1200.00"));
		    Aluno a9 = new Aluno(null,"Caroline","06778031760","(34)99787611",sdf.parse("20/04/2002"),"caroline@gmail.com",new BigDecimal("1300.00"));
		    Aluno a10 = new Aluno(null,"Gilberto","66686532789","(34)99787731",sdf.parse("20/01/2000"),"gilberto@gmail.com",new BigDecimal("500.00"));
		    
		    Matricula m1 = new Matricula(null,sdf.parse("20/02/2015"),6,a1,t1);
		    Matricula m2 = new Matricula(null,sdf.parse("21/02/2015"),7,a2,t1);
		    Matricula m3 = new Matricula(null,sdf.parse("22/02/2015"),8,a3,t1);
		    Matricula m4 = new Matricula(null,sdf.parse("23/02/2015"),9,a4,t1);
		    
		    Matricula m5 = new Matricula(null,sdf.parse("20/06/2015"),10,a5,t2);
		    Matricula m6 = new Matricula(null,sdf.parse("21/06/2015"),9,a6,t2);
		    Matricula m7 = new Matricula(null,sdf.parse("22/06/2015"),8,a7,t2);
		    Matricula m8 = new Matricula(null,sdf.parse("22/02/2015"),7,a8,t2);
	
		    
		    Matricula m9 = new Matricula(null,sdf.parse("20/12/2015"),6,a7,t3);
		    Matricula m10 = new Matricula(null,sdf.parse("20/12/2015"),7,a8,t3);
		    Matricula m11 = new Matricula(null,sdf.parse("22/12/2015"),8,a9,t3);
		    Matricula m12 = new Matricula(null,sdf.parse("23/12/2015"),9,a10,t3);
		    
		    Matricula m13 = new Matricula(null,sdf.parse("20/01/2016"),10,a3,t4);
		    Matricula m14 = new Matricula(null,sdf.parse("21/02/2016"),9,a4,t4);
		    Matricula m15 = new Matricula(null,sdf.parse("22/02/2016"),8,a5,t4);
		    Matricula m16 = new Matricula(null,sdf.parse("23/02/2016"),7,a6,t4);
		    
		    
		    
		    Avaliacao av1 = new Avaliacao(null,10.0,sdf.parse("20/03/2015"),t1);
		    Avaliacao av2 = new Avaliacao(null,20.0,sdf.parse("21/03/2015"),t2);
		    Avaliacao av3 = new Avaliacao(null,10.0,sdf.parse("22/03/2015"),t3);
		    Avaliacao av4 = new Avaliacao(null,20.0,sdf.parse("23/03/2016"),t4);
		    Avaliacao av5 = new Avaliacao(null,10.0,sdf.parse("20/06/2015"),t1);
		    Avaliacao av6 = new Avaliacao(null,20.0,sdf.parse("21/06/2015"),t2);
		    Avaliacao av7 = new Avaliacao(null,10.0,sdf.parse("22/06/2015"),t3);
		    Avaliacao av8 = new Avaliacao(null,20.0,sdf.parse("23/06/2016"),t4);
		    
		    Resultado r1 = new Resultado(null, 0.0, m1, av1);
		    Resultado r2 = new Resultado(null, 7.0, m2, av1);
		    Resultado r3 = new Resultado(null, 10.0,m3, av1);
		    Resultado r4 = new Resultado(null, 3.0, m4, av1);		    
		    Resultado r5 = new Resultado(null, 20.0, m5, av1);
		    Resultado r6 = new Resultado(null, 19.0, m6, av1);
		    Resultado r7 = new Resultado(null, 8.0, m7, av1);
		    Resultado r8 = new Resultado(null, 9.0, m8, av1);
		    Resultado r9 = new Resultado(null, 8.0, m7, av1);
		    Resultado r10 = new Resultado(null, 9.0, m8, av1);
		    

		    Resultado r11 = new Resultado(null, 0.0, m1, av2);
		    Resultado r12 = new Resultado(null, 7.0, m2, av2);
		    Resultado r13 = new Resultado(null, 10.0,m3, av2);
		    Resultado r14 = new Resultado(null, 3.0, m4, av2);		    
		    Resultado r15 = new Resultado(null, 20.0, m5, av2);
		    Resultado r16 = new Resultado(null, 19.0, m6, av2);
		    Resultado r17 = new Resultado(null, 8.0, m7, av2);
		    Resultado r18 = new Resultado(null, 9.0, m8, av2);
		    Resultado r19 = new Resultado(null, 8.0, m7, av2);
		    Resultado r20 = new Resultado(null, 9.0, m8, av2);
		    
		    
		    AlunoServico as = new AlunoServico();
			AvaliacaoServico avs = new AvaliacaoServico();
			CursoServico cs = new CursoServico();
			TurmaServico ts = new TurmaServico();
			MatriculaServico ms = new MatriculaServico();
			ResultadoServico rs = new ResultadoServico();
			
			cs.inserir(c1);
			cs.inserir(c2);
			
			ts.inserir(t1);
			ts.inserir(t2);
			ts.inserir(t3);
			ts.inserir(t4);
			
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
			ms.inserir(m9);
			ms.inserir(m10);
			ms.inserir(m11);
			ms.inserir(m12);
			ms.inserir(m13);
			ms.inserir(m14);
			ms.inserir(m15);
			ms.inserir(m16);
			
			avs.inserirAtualizar(av1);
			avs.inserirAtualizar(av2);
			avs.inserirAtualizar(av3);
			avs.inserirAtualizar(av4);
			avs.inserirAtualizar(av5);
			avs.inserirAtualizar(av6);
			avs.inserirAtualizar(av7);
			avs.inserirAtualizar(av8);
			
			rs.inserirAtualizar(r1);
			rs.inserirAtualizar(r2);
			rs.inserirAtualizar(r3);
			rs.inserirAtualizar(r4);
			rs.inserirAtualizar(r5);
			rs.inserirAtualizar(r6);
			rs.inserirAtualizar(r7);
			rs.inserirAtualizar(r8);
			rs.inserirAtualizar(r9);
			rs.inserirAtualizar(r10);

			response.getWriter().append("Fim da instanciação");

		} catch (ParseException e) {
			response.getWriter().append(e.getMessage());
		} catch (ServicoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
