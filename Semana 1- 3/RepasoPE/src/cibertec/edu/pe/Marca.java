package cibertec.edu.pe;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="marca")
public class Marca implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column
	private int MarcaID;
	
	@Column
	private String MarcaDescri;

	@OneToMany(mappedBy="marca")
	private List<Producto> productos;	
	
	public int getMarcaID() {
		return MarcaID;
	}

	public void setMarcaID(int marcaID) {
		MarcaID = marcaID;
	}

	public String getMarcaDescri() {
		return MarcaDescri;
	}

	public void setMarcaDescri(String marcaDescri) {
		MarcaDescri = marcaDescri;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
}
