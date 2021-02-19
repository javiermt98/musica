package pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Disco implements Serializable {
	@Id
	@Column(name="cod")
	private int cod_disco;
	private String nombre;
	private String fecha;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="cod_comp")
	private Company company_disco;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="cod_gru")
	private Grupo grupodisco;
	
	@OneToMany (cascade=CascadeType.ALL, fetch=FetchType.LAZY,	mappedBy="cod_disco")
	private	List<Esta> canciones = new ArrayList<Esta>();

	public Disco() {
		super();
	}

	public int getCod_disco() {
		return cod_disco;
	}

	public void setCod_disco(int cod_disco) {
		this.cod_disco = cod_disco;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Company getCompany_disco() {
		return company_disco;
	}

	public void setCompany_disco(Company company_disco) {
		this.company_disco = company_disco;
	}

	public Grupo getGrupodisco() {
		return grupodisco;
	}

	public void setGrupodisco(Grupo grupodisco) {
		this.grupodisco = grupodisco;
	}

	public List<Esta> getCanciones() {
		return canciones;
	}

	public void setCanciones(List<Esta> canciones) {
		this.canciones = canciones;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((canciones == null) ? 0 : canciones.hashCode());
		result = prime * result + cod_disco;
		result = prime * result + ((company_disco == null) ? 0 : company_disco.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((grupodisco == null) ? 0 : grupodisco.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Disco other = (Disco) obj;
		if (canciones == null) {
			if (other.canciones != null)
				return false;
		} else if (!canciones.equals(other.canciones))
			return false;
		if (cod_disco != other.cod_disco)
			return false;
		if (company_disco == null) {
			if (other.company_disco != null)
				return false;
		} else if (!company_disco.equals(other.company_disco))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (grupodisco == null) {
			if (other.grupodisco != null)
				return false;
		} else if (!grupodisco.equals(other.grupodisco))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Disco [cod_disco=" + cod_disco + ", nombre=" + nombre + ", fecha=" + fecha + ", company_disco="
				+ company_disco + ", grupodisco=" + grupodisco + "]";
	}

	
	
}
