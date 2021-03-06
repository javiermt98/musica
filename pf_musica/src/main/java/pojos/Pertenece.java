package pojos;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pertenece implements Serializable {
	@Id
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="dni")
	private Artista artista;
	
	@Id
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="cod")
	private Grupo grupo_pertenece;
	
	private String funcion;

	public Pertenece() {
		super();
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}



	public Grupo getGrupo_pertenece() {
		return grupo_pertenece;
	}

	public void setGrupo_pertenece(Grupo grupo_pertenece) {
		this.grupo_pertenece = grupo_pertenece;
	}

	public String getFuncion() {
		return funcion;
	}

	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((grupo_pertenece == null) ? 0 : grupo_pertenece.hashCode());
		result = prime * result + ((artista == null) ? 0 : artista.hashCode());
		result = prime * result + ((funcion == null) ? 0 : funcion.hashCode());
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
		Pertenece other = (Pertenece) obj;
		if (grupo_pertenece == null) {
			if (other.grupo_pertenece != null)
				return false;
		} else if (!grupo_pertenece.equals(other.grupo_pertenece))
			return false;
		if (artista == null) {
			if (other.artista != null)
				return false;
		} else if (!artista.equals(other.artista))
			return false;
		if (funcion == null) {
			if (other.funcion != null)
				return false;
		} else if (!funcion.equals(other.funcion))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pertenece [dni=" + artista + ", cod_grupo=" + grupo_pertenece + ", funcion=" + funcion + "]";
	}
	
	
	
	
}
