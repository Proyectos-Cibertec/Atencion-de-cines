package clases;

public class Usuario extends Persona {
	// Atributos privados
	private String usuario;
	private String contrase�a;
	
	// Constructor
	public Usuario(int codigo, String nombres, String apellidoPaterno, String apellidoMaterno, String direccion,
			String distrito, String fechaNacimiento, int estadoCivil, String telefono, String dni, String usuario,
			String contrase�a) {
		super(codigo, nombres, apellidoPaterno, apellidoMaterno, direccion, distrito, fechaNacimiento, estadoCivil,
				telefono, dni);
		this.usuario = usuario;
		this.contrase�a = contrase�a;
	}

	// M�todos de acceso p�blico get y set
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
}
