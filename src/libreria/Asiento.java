package libreria;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
/* Los asientos tienen tres estados: Reservado, Ocupado y Desocupado
 * RESERVADO: Significa que ya ha sido reservado por otro cliente en otra fecha, por lo tanto
 * 			  no se podrá elegir en otras reservas. Ya está como ocupado en el archivo
 * OCUPADO:	  Significa que el asiento está disponible pero que se está eligiendo en el momento actual. Aún no se guarda en el archivo
 * DESOCUPADO: Significa que el asiento está disponible y que se puede elegir en el momento actual. Aún no se guarda en el archivo.
 * */
public class Asiento extends Canvas {
	
	private static final long serialVersionUID = 1L;
	//  Atributos privados
	private int codigo;
	private int codigoReserva;
	private String tipoEntrada;
	private double precio;
	private Image img;
	private int numAsiento;
	// private boolean libre;
	private Color color;
	private int estado;	/* Reservado : 0 , Ocupado: 1 , Desocupado: 2 */
	
	//  Constructor
	public Asiento(int codigo, int codigoReserva, int numAsiento, int reservado) {
		this.codigo = codigo;
		this.codigoReserva = codigoReserva;
		setTipoEntrada("General");
		setPrecio(15.0);
		img = Toolkit.getDefaultToolkit().getImage("src/img/asiento2.png");
		this.numAsiento = numAsiento;
		
		if (reservado == 0) { // Significa que el asiento no se puede ocupar o desocupar ya que ha sido reservado por otra persona
			setEstado(reservado);
			color = Color.gray;
		} else {
			setEstado(2); // Significa que como el asiento no ha sido reservado anteriormente, se podrá ocupar o desocupar en el momento de la elección
			color = Color.green;
		}
	}
	
	//  Zona de dibujo
	public void paint(Graphics g) {
		super.paint(g);
		Rectangle r = getBounds();
		g.drawImage(img, 0, 0, r.width, r.height, this);
		g.setColor(color);
		g.setFont(new Font("monospaced", 1, 16));
		g.drawString(String.format("%02d",  numAsiento), r.width/2 - 10, r.height/2 - 3);
	}
	
	//  Operaciones públicas
	// Solamente permite ocupar o desocupar un asiento que no haya sido reservado anteriormente (esté disponible)
	public void ocupar() {
		if (getEstado() != 0) {
			if (estado == 2) {	// Si está desocupado
				setEstado(1);	//	Se ocupa
				color = Color.red;
				
			} else {		// Si está ocupado
				setEstado(2);	// Se desocupa
				color = Color.green;
			}
			repaint();
		}
	}

	public boolean estaOcupado() {
		return (getEstado() == 1);
	}

	public int getCodigo() {
		return codigo;
	}

	public int getCodigoReserva() {
		return codigoReserva;
	}

	public void setCodigoReserva(int codigoReserva) {
		this.codigoReserva = codigoReserva;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	public String informacion() {
		String info = "";
		switch (getEstado()) {
			case 0:
				info = "Reservado";
				break;
			case 1:
				info = "Ocupado";
				break;
			case 2:
				info = "Desocupado";
				break;
		}
		return info;
	}

	public String getTipoEntrada() {
		return tipoEntrada;
	}
	
	public int getTipoEntradaCodigo() {
		switch (tipoEntrada) {		
			case "General":
				return 0;
				
			case "Menores de 11 años":
				return 1;
			
			default:
				return 2;
		}
	}

	public void setTipoEntrada(String tipoEntrada) {
		this.tipoEntrada = tipoEntrada;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
}
