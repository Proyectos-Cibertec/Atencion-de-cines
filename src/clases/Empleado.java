package clases;

public class Empleado extends Usuario {
	// Atributos privados
	private int tipo;		// Administrador = 0 | Supervisor = 1 | Cajero = 2
	private String fechaInicio;
	
	// Constructor
	public Empleado(int codigo, String nombres, String apellidoPaterno, String apellidoMaterno, String direccion,
			String distrito, String fechaNacimiento, int estadoCivil, String telefono, String dni, String usuario,
			String contrase�a, int tipo, String fechaInicio) {
		super(codigo, nombres, apellidoPaterno, apellidoMaterno, direccion, distrito, fechaNacimiento, estadoCivil,
				telefono, dni, usuario, contrase�a);
		this.tipo = tipo;
		this.fechaInicio = fechaInicio;
	}

	// M�todos de acceso p�blico get y set
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	// Operaciones complementarias
	public String getTipoDescripcion() {
		String tipoEmpleado;
		
		switch (this.getTipo()) {
			case 0:
				tipoEmpleado = "Administrador"; 
				break;
				
			case 1:
				tipoEmpleado = "Supervisor";
				break;
				
			default:
				tipoEmpleado = "Cajero";
				break;
		}
		
		return tipoEmpleado;
	}
}
/*package clases;

public class Empleado {
	
	// Atributos privados
	private int codigo;
	private String nombres;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private int tipo;
	private String usuario;
	private String contrase�a;
	
	// Constructor con 7 par�metros	
	public Empleado(int codigo, String nombres, String apellidoPaterno, String apellidoMaterno, int tipo,
			String usuario, String contrase�a) {
		this.codigo = codigo;
		this.nombres = nombres;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.tipo = tipo;
		this.usuario = usuario;
		this.contrase�a = contrase�a;
	}

	// M�todos de acceso p�blico get y set
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

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

	public String nombreTipoEmpleado() {
		String tipoEmpleado;
		switch (getTipo()) {
			case 0:
				tipoEmpleado = "Administrador";
				break;
			
			case 1:
				tipoEmpleado = "Supervisor";
				break;
				
			default:
				tipoEmpleado = "Cajero";
		}
		return tipoEmpleado;
	}
}*/