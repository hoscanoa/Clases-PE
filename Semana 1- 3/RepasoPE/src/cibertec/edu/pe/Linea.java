package cibertec.edu.pe;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "linea")
public class Linea implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column
	private int idlinea;

	@Column
	private String deslinea;

	@OneToMany(mappedBy = "linea")
	private List<Producto> productos;

	public int getIdlinea() {
		return idlinea;
	}

	public void setIdlinea(int idlinea) {
		this.idlinea = idlinea;
	}

	public String getDeslinea() {
		return deslinea;
	}

	public void setDeslinea(String deslinea) {
		this.deslinea = deslinea;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

}
