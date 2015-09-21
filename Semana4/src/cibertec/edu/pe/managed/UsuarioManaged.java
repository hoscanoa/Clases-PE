package cibertec.edu.pe.managed;

import javax.faces.bean.ManagedBean;

import cibertec.edu.pe.beans.UsuarioBean;

@ManagedBean(name = "usuarioManaged")
public class UsuarioManaged {
	private UsuarioBean usuario = new UsuarioBean();

	public String validar() {
		String ir = "/ui/denegado.jsf";
		if (usuario.getLogin().equalsIgnoreCase("CIBERTEC") && usuario.getPassword().equals("123")) {
			usuario.setNombre("Hernán");
			ir = "/ui/bienvenido.jsf";
		}
		return ir;
	}

	public UsuarioBean getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioBean usuario) {
		this.usuario = usuario;
	}
	
}
