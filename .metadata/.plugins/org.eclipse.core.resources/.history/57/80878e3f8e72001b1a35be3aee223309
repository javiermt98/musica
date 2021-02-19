package pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Grupo implements Serializable {
	@Id
	@Column(name="cod")
	private int cod_grupo;
	private String nombre;
	private String fecha;
	private String pais;
	
	@OneToMany (cascade=CascadeType.ALL, fetch=FetchType.LAZY,	mappedBy="grupo_club")
	private	List<Club> clubsTocado = new ArrayList<Club>();
	
	@OneToMany (cascade=CascadeType.ALL, fetch=FetchType.LAZY,	mappedBy="grupo_pertenece")
	private	List<Pertenece> artistas = new ArrayList<Pertenece>();
	
	@OneToMany (cascade=CascadeType.ALL, fetch=FetchType.LAZY,	mappedBy="grupodisco")
	private	List<Disco> discos = new ArrayList<Disco>();

	public Grupo() {
		super();
	}

	public int getCod_grupo() {
		return cod_grupo;
	}

	public void setCod_grupo(int cod_grupo) {
		this.cod_grupo = cod_grupo;
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

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public List<Club> getClubsTocado() {
		return clubsTocado;
	}

	public void setClubsTocado(List<Club> clubsTocado) {
		this.clubsTocado = clubsTocado;
	}

	public List<Pertenece> getArtistas() {
		return artistas;
	}

	public void setArtistas(List<Pertenece> artistas) {
		this.artistas = artistas;
	}

	public List<Disco> getDiscos() {
		return discos;
	}

	public void setDiscos(List<Disco> discos) {
		this.discos = discos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artistas == null) ? 0 : artistas.hashCode());
		result = prime * result + ((clubsTocado == null) ? 0 : clubsTocado.hashCode());
		result = prime * result + cod_grupo;
		result = prime * result + ((discos == null) ? 0 : discos.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((pais == null) ? 0 : pais.hashCode());
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
		Grupo other = (Grupo) obj;
		if (artistas == null) {
			if (other.artistas != null)
				return false;
		} else if (!artistas.equals(other.artistas))
			return false;
		if (clubsTocado == null) {
			if (other.clubsTocado != null)
				return false;
		} else if (!clubsTocado.equals(other.clubsTocado))
			return false;
		if (cod_grupo != other.cod_grupo)
			return false;
		if (discos == null) {
			if (other.discos != null)
				return false;
		} else if (!discos.equals(other.discos))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (pais == null) {
			if (other.pais != null)
				return false;
		} else if (!pais.equals(other.pais))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Grupo [cod_grupo=" + cod_grupo + ", nombre=" + nombre + ", fecha=" + fecha + ", pais=" + pais + "]";
	}
	
	
	

}
