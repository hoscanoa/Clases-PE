package cibertec.edu.pe;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
@NamedQueries({ @NamedQuery(name = "ProductosXCodigo", query = "select p from Producto p where p.productoId=:param1"),
		@NamedQuery(name = "ProductosXLinea", query = "select p from Producto p where p.linea.idlinea=:param1"),
		@NamedQuery(name = "ProductosXLineaMarca", query = "select p from Producto p where p.marca.MarcaDescri like :param1 and p.linea.deslinea like :param2") })
public class Producto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column
	private int productoId;

	@Column
	private String productodescri;

	@Column
	private int productoprecio;

	@ManyToOne
	@JoinColumn(name = "MarcaId")
	private Marca marca;

	@ManyToOne
	@JoinColumn(name = "idlinea")
	private Linea linea;

	public int getProductoId() {
		return productoId;
	}

	public void setProductoId(int productoId) {
		this.productoId = productoId;
	}

	public String getProductodescri() {
		return productodescri;
	}

	public void setProductodescri(String productodescri) {
		this.productodescri = productodescri;
	}

	public int getProductoprecio() {
		return productoprecio;
	}

	public void setProductoprecio(int productoprecio) {
		this.productoprecio = productoprecio;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Linea getLinea() {
		return linea;
	}

	public void setLinea(Linea linea) {
		this.linea = linea;
	}

}
