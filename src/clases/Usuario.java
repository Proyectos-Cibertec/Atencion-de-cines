package clases;

public class Usuario extends Persona {
	// Atributos privados
	private String usuario;
	private String contraseña;
	
	// Constructor
	public Usuario(int codigo, String nombres, String apellidoPaterno, String apellidoMaterno, String direccion,
			String distrito, String fechaNacimiento, int estadoCivil, String telefono, String dni, String usuario,
			String contraseña) {
		super(codigo, nombres, apellidoPaterno, apellidoMaterno, direccion, distrito, fechaNacimiento, estadoCivil,
				telefono, dni);
		this.usuario = usuario;
		this.contraseña = contraseña;
	}

	// Métodos de acceso público get y set
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
}
