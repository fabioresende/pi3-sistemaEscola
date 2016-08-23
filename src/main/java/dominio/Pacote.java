package dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_pacotes")
public class Pacote implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codPacote;
	private Date data;
	private Integer dias;
	private Integer refeicoesPorDia;
	
	@ManyToOne
	@JoinColumn(name="restaurante")
	private Restaurante restaurante;
	
	@ManyToOne
	@JoinColumn(name="cidade")
	private Cidade cidade;

	@ManyToOne
	@JoinColumn(name="hotel")
	private Hotel hotel;
	
	public Pacote() {
	}

	public Pacote(Integer codPacote, Date data, Integer dias, Integer refeicoesPorDia, Restaurante restaurante,
			Cidade cidade, Hotel hotel) {
		super();
		this.codPacote = codPacote;
		this.data = data;
		this.dias = dias;
		this.refeicoesPorDia = refeicoesPorDia;
		this.restaurante = restaurante;
		if (restaurante!=null) {
			restaurante.addPacote(this);
		}
		this.cidade = cidade;
		cidade.addPacote(this);
		this.hotel = hotel;
		hotel.addPacote(this);
	}

	public Integer getCodPacote() {
		return codPacote;
	}

	public void setCodPacote(Integer codPacote) {
		this.codPacote = codPacote;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getDias() {
		return dias;
	}

	public void setDias(Integer dias) {
		this.dias = dias;
	}

	public Integer getRefeicoesPorDia() {
		return refeicoesPorDia;
	}

	public void setRefeicoesPorDia(Integer refeicoesPorDia) {
		this.refeicoesPorDia = refeicoesPorDia;
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	@Override
	public String toString() {
		return "Pacote [codPacote=" + codPacote + ", data=" + data + ", dias=" + dias + ", refeicoesPorDia="
				+ refeicoesPorDia + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codPacote == null) ? 0 : codPacote.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pacote other = (Pacote) obj;
		if (codPacote == null) {
			if (other.codPacote != null)
				return false;
		} else if (!codPacote.equals(other.codPacote))
			return false;
		return true;
	}

	public BigDecimal valorSomenteHospedagem() {
		return hotel.getValorDiaria().multiply(new BigDecimal(dias));
	}
	
	public BigDecimal valorSomenteAlimentacao() {
		if (restaurante==null) {
			return new BigDecimal("0.00");
		}
		return restaurante.getValorRefeicao().multiply(new BigDecimal(dias * refeicoesPorDia));
	}
	
	public BigDecimal valorTotal() {
		return valorSomenteAlimentacao().add(valorSomenteHospedagem());
	}
}
