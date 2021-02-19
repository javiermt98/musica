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

@Entity(name="Companyia")
public class Company implements Serializable{
	@Id
	@Column(name="cod")
	private int cod_company;
	private String nombre;
	private String dir;
	private String fax;
	private String tfno;
	
	@OneToMany (cascade=CascadeType.ALL, fetch=FetchType.LAZY,	mappedBy="company_disco")
	private	List<Disco> discos = new ArrayList<Disco>();

	public Company() {
		super();
	}

	public int getCod_company() {
		return cod_company;
	}

	public void setCod_company(int cod_company) {
		this.cod_company = cod_company;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getTfno() {
		return tfno;
	}

	public void setTfno(String tfno) {
		this.tfno = tfno;
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
		result = prime * result + cod_company;
		result = prime * result + ((dir == null) ? 0 : dir.hashCode());
		result = prime * result + ((discos == null) ? 0 : discos.hashCode());
		result = prime * result + ((fax == null) ? 0 : fax.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((tfno == null) ? 0 : tfno.hashCode());
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
		Company other = (Company) obj;
		if (cod_company != other.cod_company)
			return false;
		if (dir == null) {
			if (other.dir != null)
				return false;
		} else if (!dir.equals(other.dir))
			return false;
		if (discos == null) {
			if (other.discos != null)
				return false;
		} else if (!discos.equals(other.discos))
			return false;
		if (fax == null) {
			if (other.fax != null)
				return false;
		} else if (!fax.equals(other.fax))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (tfno == null) {
			if (other.tfno != null)
				return false;
		} else if (!tfno.equals(other.tfno))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Company [cod_company=" + cod_company + ", nombre=" + nombre + ", dir=" + dir + ", fax=" + fax
				+ ", tfno=" + tfno + "]";
	}
	
	
	
}
