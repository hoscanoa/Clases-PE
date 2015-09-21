import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import cibertec.edu.pe.Marca;

public class Test1 {

	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Repaso");
	public static EntityManager em = emf.createEntityManager();

	public static void Grabar() {
		try {
			em.getTransaction().begin();
			Marca obj = new Marca();
			obj.setMarcaID(Integer.parseInt(JOptionPane.showInputDialog("Código")));
			obj.setMarcaDescri(JOptionPane.showInputDialog("Descripción"));
			em.persist(obj);
			em.getTransaction().commit();
			System.out.println("Registro Grabado");
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	public static void Consultar() {
		try {
			int id = Integer.parseInt(JOptionPane.showInputDialog("Código"));
			Marca obj = em.find(Marca.class, id);
			if (obj != null) {
				System.out.println("Descripcion: " + obj.getMarcaDescri());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void Editar() {
		try {
			int id = Integer.parseInt(JOptionPane.showInputDialog("Còdigo"));
			Marca obj = em.find(Marca.class, id);
			if (obj == null) {
				System.out.println("No existe");
			} else {
				em.getTransaction().begin();
				obj.setMarcaDescri(JOptionPane.showInputDialog("Nueva Descripción"));
				em.merge(obj);
				em.getTransaction().commit();
			}
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	public static void Eliminar() {
		try {
			int id = Integer.parseInt(JOptionPane.showInputDialog("Código"));
			Marca obj = em.find(Marca.class, id);
			if (obj == null) {
				System.out.println("No existe");
			} else {
				em.getTransaction().begin();
				em.remove(obj);
				em.getTransaction().commit();
			}
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		int op;
		do {
			op = Integer.parseInt(JOptionPane.showInputDialog("1.-Graba 2.-Consulta 3.-Elimina 4.-Modifica 5.-Salir"));
			switch (op) {
			case 1:
				Grabar();
				break;
			case 2:
				Consultar();
				break;
			case 3:
				Eliminar();
				break;
			case 4:
				Editar();
				break;
			}
		} while (op != 5);
	}

}
