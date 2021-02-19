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
public class Cancion implements Serializable {

	@Id
	@Column(name="cod")
	private int cod_cancion;
	private String titulo;
	private double duracion;
	
	@OneToMany (cascade=CascadeType.ALL, fetch=FetchType.LAZY,	mappedBy="cancion_disco")
	private	List<Esta> discos = new ArrayList<Esta>();

	public Cancion() {
		super();
	}

	public int getCod_cancion() {
		return cod_cancion;
	}

	public void setCod_cancion(int cod_cancion) {
		this.cod_cancion = cod_cancion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

	public List<Esta> getDiscos() {
		return discos;
	}

	public void setDiscos(List<Esta> discos) {
		this.discos = discos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cod_cancion;
		result = prime * result + ((discos == null) ? 0 : discos.hashCode());
		long temp;
		temp = Double.doubleToLongBits(duracion);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
		Cancion other = (Cancion) obj;
		if (cod_cancion != other.cod_cancion)
			return false;
		if (discos == null) {
			if (other.discos != null)
				return false;
		} else if (!discos.equals(other.discos))
			return false;
		if (Double.doubleToLongBits(duracion) != Double.doubleToLongBits(other.duracion))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cancion [cod_cancion=" + cod_cancion + ", titulo=" + titulo + ", duracion=" + duracion + "]";
	}
	
	
}
