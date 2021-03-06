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
public class Esta implements Serializable {

	@Id
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="can")
	private Disco cod_disco;
	
	@Id
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="cod")
	private Cancion cancion_disco;

	public Esta() {
		super();
	}

	public Disco getCod_disco() {
		return cod_disco;
	}

	public void setCod_disco(Disco cod_disco) {
		this.cod_disco = cod_disco;
	}

	public Cancion getCancion_disco() {
		return cancion_disco;
	}

	public void setCancion_disco(Cancion cancion_disco) {
		this.cancion_disco = cancion_disco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cancion_disco == null) ? 0 : cancion_disco.hashCode());
		result = prime * result + ((cod_disco == null) ? 0 : cod_disco.hashCode());
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
		Esta other = (Esta) obj;
		if (cancion_disco == null) {
			if (other.cancion_disco != null)
				return false;
		} else if (!cancion_disco.equals(other.cancion_disco))
			return false;
		if (cod_disco == null) {
			if (other.cod_disco != null)
				return false;
		} else if (!cod_disco.equals(other.cod_disco))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Esta [cod_disco=" + cod_disco + ", cancion_disco=" + cancion_disco + "]";
	}
	
	
}
