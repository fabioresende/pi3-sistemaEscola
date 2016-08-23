package dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_cidades")
public class Cidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codCidade;
	private String nome;
	private String website;
	private String estado;
	
	@OneToMany(mappedBy="cidade")
	private List<Restaurante> restaurantes;
	
	@OneToMany(mappedBy="cidade")
	private List<Pacote> pacotes;

	@OneToMany(mappedBy="cidade")
	private List<Hotel> hoteis;
	
	public Cidade() {
		restaurantes = new ArrayList<>();
		pacotes = new ArrayList<>();
		hoteis = new ArrayList<>();
	}

	public Cidade(Integer codCidade, String nome, String website, String estado) {
		super();
		this.codCidade = codCidade;
		this.nome = nome;
		this.website = website;
		this.estado = estado;
		restaurantes = new ArrayList<>();
		pacotes = new ArrayList<>();
		hoteis = new ArrayList<>();
	}

	public Integer getCodCidade() {
		return codCidade;
	}

	public void setCodCidade(Integer codCidade) {
		this.codCidade = codCidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<Restaurante> getRestaurantes() {
		return restaurantes;
	}

	public void setRestaurantes(List<Restaurante> restaurantes) {
		this.restaurantes = restaurantes;
	}

	public List<Pacote> getPacotes() {
		return pacotes;
	}

	public void setPacotes(List<Pacote> pacotes) {
		this.pacotes = pacotes;
	}

	public List<Hotel> getHoteis() {
		return hoteis;
	}

	public void setHoteis(List<Hotel> hoteis) {
		this.hoteis = hoteis;
	}
	
	public void addRestaurante(Restaurante x) {
		restaurantes.add(x);
		x.setCidade(this);
	}

	public void removeRestaurante(Restaurante x) {
		restaurantes.remove(x);
	}
	
	public void addPacote(Pacote x) {
		pacotes.add(x);
		x.setCidade(this);
	}

	public void removePacote(Pacote x) {
		pacotes.remove(x);
	}
	
	public void addHotel(Hotel x) {
		hoteis.add(x);
		x.setCidade(this);
	}

	public void removeHotel(Hotel x) {
		hoteis.remove(x);
	}

	@Override
	public String toString() {
		return "Cidade [codCidade=" + codCidade + ", nome=" + nome + ", website=" + website + ", estado=" + estado
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codCidade == null) ? 0 : codCidade.hashCode());
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
		Cidade other = (Cidade) obj;
		if (codCidade == null) {
			if (other.codCidade != null)
				return false;
		} else if (!codCidade.equals(other.codCidade))
			return false;
		return true;
	}
	
	public List<Hotel> hoteisJaVendidos() {
		
		List<Hotel> aux = new ArrayList<>();
		for (Pacote p : pacotes) {
			if (!aux.contains(p.getHotel())) {
				aux.add(p.getHotel());
			}
		}
		return aux;
	}
	
}
