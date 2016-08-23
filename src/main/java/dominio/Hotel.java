package dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_hoteis")
public class Hotel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codHotel;
	private String nome;
	private BigDecimal valorDiaria;
	
	@ManyToOne
	@JoinColumn(name="cidade")
	private Cidade cidade;
	
	@OneToMany(mappedBy="hotel")
	private List<Pacote> pacotes;
	
	public Hotel() {
		pacotes = new ArrayList<>();
	}

	public Hotel(Integer codHotel, String nome, BigDecimal valorDiaria, Cidade cidade) {
		super();
		this.codHotel = codHotel;
		this.nome = nome;
		this.valorDiaria = valorDiaria;
		this.cidade = cidade;
		cidade.addHotel(this);
		pacotes = new ArrayList<>();
	}

	public Integer getCodHotel() {
		return codHotel;
	}

	public void setCodHotel(Integer codHotel) {
		this.codHotel = codHotel;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(BigDecimal valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Pacote> getPacotes() {
		return pacotes;
	}

	public void setPacotes(List<Pacote> pacotes) {
		this.pacotes = pacotes;
	}
	
	public void addPacote(Pacote x) {
		pacotes.add(x);
		x.setHotel(this);
	}

	public void removePacote(Pacote x) {
		pacotes.remove(x);
	}

	@Override
	public String toString() {
		return "Hotel [codHotel=" + codHotel + ", nome=" + nome + ", valorDiaria=" + valorDiaria + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codHotel == null) ? 0 : codHotel.hashCode());
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
		Hotel other = (Hotel) obj;
		if (codHotel == null) {
			if (other.codHotel != null)
				return false;
		} else if (!codHotel.equals(other.codHotel))
			return false;
		return true;
	}

	public Integer qteDiariasJaVendidas() {
		int soma = 0;
		for (Pacote p : pacotes) {
			soma = soma + p.getDias();
		}
		return soma;
	}
	
	public BigDecimal receita(Date dataMin, Date dataMax) {
		
		BigDecimal soma = new BigDecimal("0.00");
		for (Pacote p : pacotes) {
			if (p.getData().getTime()>=dataMin.getTime() && p.getData().getTime()<=dataMax.getTime()) {
				soma = soma.add(p.valorSomenteHospedagem());
			}
		}
		return soma;
	}
	
}
