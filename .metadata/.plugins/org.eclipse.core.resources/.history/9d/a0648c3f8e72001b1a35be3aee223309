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
public class Club implements Serializable{
	@Id
	@Column(name="cod")
	private int cod_club;
	private String nombre;
	private String sede;
	private int num;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="cod_gru")
	private Grupo grupo_club;

	public Club() {
		super();
	}

	public int getCod_club() {
		return cod_club;
	}

	public void setCod_club(int cod_club) {
		this.cod_club = cod_club;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Grupo getGrupo_club() {
		return grupo_club;
	}

	public void setGrupo_club(Grupo grupo_club) {
		this.grupo_club = grupo_club;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cod_club;
		result = prime * result + ((grupo_club == null) ? 0 : grupo_club.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + num;
		result = prime * result + ((sede == null) ? 0 : sede.hashCode());
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
		Club other = (Club) obj;
		if (cod_club != other.cod_club)
			return false;
		if (grupo_club == null) {
			if (other.grupo_club != null)
				return false;
		} else if (!grupo_club.equals(other.grupo_club))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (num != other.num)
			return false;
		if (sede == null) {
			if (other.sede != null)
				return false;
		} else if (!sede.equals(other.sede))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Club [cod_club=" + cod_club + ", nombre=" + nombre + ", sede=" + sede + ", num=" + num + ", grupo_club="
				+ grupo_club + "]";
	}
	
	
	

}
