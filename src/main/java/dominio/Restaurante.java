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
@Table(name="tb_restaurantes")
public class Restaurante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codRestaurante;
	private String nome;
	private BigDecimal valorRefeicao;
	
	@ManyToOne
	@JoinColumn(name="cidade")
	private Cidade cidade;

	@OneToMany(mappedBy="restaurante")
	private List<Pacote> pacotes;
	
	public Restaurante() {
		pacotes = new ArrayList<>();
	}

	public Restaurante(Integer codRestaurante, String nome, BigDecimal valorRefeicao, Cidade cidade) {
		super();
		this.codRestaurante = codRestaurante;
		this.nome = nome;
		this.valorRefeicao = valorRefeicao;
		this.cidade = cidade;
		cidade.addRestaurante(this);
		pacotes = new ArrayList<>();
	}

	public Integer getCodRestaurante() {
		return codRestaurante;
	}

	public void setCodRestaurante(Integer codRestaurante) {
		this.codRestaurante = codRestaurante;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValorRefeicao() {
		return valorRefeicao;
	}

	public void setValorRefeicao(BigDecimal valorRefeicao) {
		this.valorRefeicao = valorRefeicao;
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
		x.setRestaurante(this);
	}

	public void removePacote(Pacote x) {
		pacotes.remove(x);
	}

	@Override
	public String toString() {
		return "Restaurante [codRestaurante=" + codRestaurante + ", nome=" + nome + ", valorRefeicao=" + valorRefeicao
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codRestaurante == null) ? 0 : codRestaurante.hashCode());
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
		Restaurante other = (Restaurante) obj;
		if (codRestaurante == null) {
			if (other.codRestaurante != null)
				return false;
		} else if (!codRestaurante.equals(other.codRestaurante))
			return false;
		return true;
	}

	public BigDecimal receita(Date dataMin, Date dataMax) {
		
		BigDecimal soma = new BigDecimal("0.00");
		for (Pacote p : pacotes) {
			if (p.getData().getTime()>=dataMin.getTime() && p.getData().getTime()<=dataMax.getTime()) {
				soma = soma.add(p.valorSomenteAlimentacao());
			}
		}
		return soma;
	}
	
}
