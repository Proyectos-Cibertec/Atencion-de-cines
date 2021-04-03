package clases;

public class Cine {
	// Atributos privados
	private int codigo;
	private String nombre;
	private String departamento;
	private String provincia;
	private String distrito;
	private String fechaInicio;
	private int tipo; // 0 = Estándar | 1 = Prime
	
	// Constructor con 7 argumentos
	public Cine(int codigo, String nombre, String departamento, String provincia, String distrito, String fechaInicio,
			int tipo) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.departamento = departamento;
		this.provincia = provincia;
		this.distrito = distrito;
		this.fechaInicio = fechaInicio;
		this.tipo = tipo;
	}
	
	// Métodos de acceso público get y set
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public String descripcionTipoCine() {
		return (getTipo() == 0) ? "Estándar" : "Prime";
	}
}
