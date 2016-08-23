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

import dominio.Cidade;
import dominio.Hotel;
import dominio.Pacote;
import dominio.Restaurante;
import servico.CidadeServico;
import servico.HotelServico;
import servico.PacoteServico;
import servico.RestauranteServico;

@WebServlet("/Instanciacao")
public class Instanciacao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			Cidade c1 = new Cidade(null, "Udi", "udi.com.br", "MG");
			Cidade c2 = new Cidade(null, "Uberaba", "uberaba.com.br", "MG");

			Hotel h1 = new Hotel(null, "San Diego", new BigDecimal("200.00"), c1);
			Hotel h2 = new Hotel(null, "Ibis", new BigDecimal("150.00"), c1);

			Hotel h3 = new Hotel(null, "Grande Hotel", new BigDecimal("300.00"), c2);
			Hotel h4 = new Hotel(null, "Dona Chica", new BigDecimal("100.00"), c2);

			Restaurante r1 = new Restaurante(null, "Bom Sabor", new BigDecimal("40.00"), c1);
			Restaurante r2 = new Restaurante(null, "Grill Bom", new BigDecimal("30.00"), c1);

			Restaurante r3 = new Restaurante(null, "Saborzinho", new BigDecimal("20.00"), c2);
			Restaurante r4 = new Restaurante(null, "Uberabão", new BigDecimal("50.00"), c2);

			Pacote p1 = new Pacote(null, sdf.parse("20/10/2015"), 4, 2, r1, c1, h2);

			Pacote p2 = new Pacote(null, sdf.parse("30/09/2015"), 3, 0, null, c1, h2);

			Pacote p3 = new Pacote(null, sdf.parse("15/10/2015"), 5, 1, r3, c2, h4);

			CidadeServico cs = new CidadeServico();
			HotelServico hs = new HotelServico();
			PacoteServico ps = new PacoteServico();
			RestauranteServico rs = new RestauranteServico();

			cs.inserirAtualizar(c1);
			cs.inserirAtualizar(c2);
			hs.inserirAtualizar(h1);
			hs.inserirAtualizar(h2);
			hs.inserirAtualizar(h3);
			hs.inserirAtualizar(h4);
			rs.inserirAtualizar(r1);
			rs.inserirAtualizar(r2);
			rs.inserirAtualizar(r3);
			rs.inserirAtualizar(r4);
			ps.inserirAtualizar(p1);
			ps.inserirAtualizar(p2);
			ps.inserirAtualizar(p3);

			response.getWriter().append("Fim da instanciação");

		} catch (ParseException e) {
			response.getWriter().append(e.getMessage());
		}
	}
}
