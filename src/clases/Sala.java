package clases;

public class Sala {
	// Atributos privados
	private int codigo;
	private int codigoCine;
	private int numeroSala;
	private int filas;
	private int butacas;

	// Constructor con 5 argumentos
	public Sala(int codigo, int codigoCine, int numeroSala, int filas, int butacas) {
		this.codigo = codigo;
		this.codigoCine = codigoCine;
		this.numeroSala = numeroSala;
		this.filas = filas;
		this.butacas = butacas;
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

	public int getNumeroSala() {
		return numeroSala;
	}

	public void setNumeroSala(int numeroSala) {
		this.numeroSala = numeroSala;
	}

	public int getFilas() {
		return filas;
	}

	public void setFilas(int filas) {
		this.filas = filas;
	}

	public int getButacas() {
		return butacas;
	}

	public void setButacas(int butacas) {
		this.butacas = butacas;
	}
}
