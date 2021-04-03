package clases;

public class Funcion {
	// Atributos privados
	private int codigo;
	private int codigoCine;
	private int codigoSala;
	private String fechaFuncion;
	private String horaFuncion;
	
	// Constructor con 5 argumentos
	public Funcion(int codigo, int codigoCine, int codigoSala, String fechaFuncion, String horaFuncion) {
		this.codigo = codigo;
		this.codigoCine = codigoCine;
		this.codigoSala = codigoSala;
		this.fechaFuncion = fechaFuncion;
		this.horaFuncion = horaFuncion;
	}

	// Métodos de acceso público get y set
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigoCine() {
		return codigoCine;
	}

	public void setCodigoCine(int codigoCine) {
		this.codigoCine = codigoCine;
	}

	public int getCodigoSala() {
		return codigoSala;
	}

	public void setCodigoSala(int codigoSala) {
		this.codigoSala = codigoSala;
	}

	public String getFechaFuncion() {
		return fechaFuncion;
	}

	public void setFechaFuncion(String fechaFuncion) {
		this.fechaFuncion = fechaFuncion;
	}

	public String getHoraFuncion() {
		return horaFuncion;
	}

	public void setHoraFuncion(String horaFuncion) {
		this.horaFuncion = horaFuncion;
	}
}
