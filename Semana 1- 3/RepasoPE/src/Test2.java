import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

import cibertec.edu.pe.Linea;
import cibertec.edu.pe.Marca;
import cibertec.edu.pe.Producto;

public class Test2 {

	public static EntityManagerFactory emf = null;
	public static EntityManager em = null;

	public static void Open() {
		emf = Persistence.createEntityManagerFactory("Repaso");
		em = emf.createEntityManager();
	}

	public static void Close() {
		em.close();
		emf.close();
	}

	public static void ListaProducto() {
		try {
			Open();
			List<Producto> productos = null;
			TypedQuery<Producto> query = em.createQuery("select p from Producto p where p.productoId=:param1",
					Producto.class);
			query.setParameter("param1", Integer.parseInt(JOptionPane.showInputDialog("Código")));
			productos = query.getResultList();
			for (Producto obj : productos) {
				System.out.println(obj.getMarca().getMarcaDescri());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Close();
		}
	}

	public static void ListaLinea() {
		try {
			Open();
			List<Linea> lineas = null;
			TypedQuery<Linea> query = em.createQuery("select a from Linea a", Linea.class);
			lineas = query.getResultList();
			for (Linea obj : lineas) {
				System.out.println("\n" + obj.getIdlinea() + " ," + obj.getDeslinea());
				for (Producto p : obj.getProductos()) {
					System.out.println("\n\t" + p.getProductoId() + "," + p.getProductodescri());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Close();
		}
	}

	public static void ListarMarca() {
		try {
			Open();

			List<Marca> marcas = null;

			TypedQuery<Marca> query = em.createQuery("select a from Marca a ", Marca.class);
			marcas = query.getResultList();

			for (Marca obj : marcas) {
				System.out.println("\n" + obj.getMarcaID() + ", " + obj.getMarcaDescri());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Close();
		}
	}

	public static void CantidadRegistros() {
		try {
			Open();

			TypedQuery<Long> query = em.createQuery(
					"select count(p.productoId) from Producto p where p.marca.MarcaDescri like :param1 ", Long.class);

			query.setParameter("param1", "%A%");
			int cant = (int) (long) query.getSingleResult();

			System.out.println("Cantidad de productos que tienen la A son:" + cant);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Close();
		}
	}

	public static void Buscar() {
		try {
			Open();
			TypedQuery<Producto> query = em.createQuery("select p from Producto p where p.productoId = 1",
					Producto.class);

			Producto obj = query.getSingleResult();
			System.out.println(obj.getProductodescri());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Close();
		}
	}

	public static void ListarUno() {
		try {
			Open();
			TypedQuery<Producto> query = em.createQuery("select p from Producto p order by p.productoId desc",
					Producto.class);
			// el paràmetro recibe la cantidad de registros que deseas mostrar
			query.setMaxResults(1);
			// ya que tenemos 1 solo registro, podemos usar ahora sì el
			// getSingleResult()
			Producto obj = query.getSingleResult();

			// query.setMaxResults(1);
			// List <Producto> obj = query.getResultList();

			System.out.println(obj.getProductodescri());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Close();
		}
	}

	public static void ListarProc() {
		try {
			Open();
			TypedQuery<Producto> query = em.createNamedQuery("ProductosXLinea", Producto.class);
			query.setParameter("param1", 1);
			Producto obj = query.getSingleResult();
			System.out.println(obj.getProductodescri());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Close();
		}
	}

	public static void ListarProc2() {
		try {
			Open();

			List<Producto> productos = null;

			TypedQuery<Producto> query = em.createNamedQuery("ProductosXLineaMarca", Producto.class);
			query.setParameter("param1", "%a%");
			query.setParameter("param2", "%a%");

			// Producto obj = query.getSingleResult();
			productos = query.getResultList();
			for (Producto obj : productos) {
				System.out.println(
						"\n" + obj.getProductoId() + ", " + obj.getProductodescri() + "," + obj.getProductoprecio()
								+ ", " + obj.getLinea().getDeslinea() + ", " + obj.getMarca().getMarcaDescri());
			}

			// System.out.println(obj.getProductodescri());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Close();
		}
	}

	public static void main(String[] args) {
		// ListaProducto();
		// ListaLinea();
		// ListarMarca();
		// CantidadRegistros();
		// Buscar();
		// ListarUno();
		//ListarProc();
		ListarProc2();
	}

}
