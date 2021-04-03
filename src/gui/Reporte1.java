package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import arreglos.ArregloDetalleReservas;
import arreglos.ArregloFunciones;
import arreglos.ArregloPeliculas;
import arreglos.ArregloReservas;
import clases.DetalleReserva;
import clases.Funcion;
import clases.Pelicula;
import clases.Reserva;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Reporte1 extends JDialog implements ActionListener, PropertyChangeListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnSalir;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JButton btnActualizar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Reporte1 dialog = new Reporte1();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Reporte1() {
		setModal(true);
		setTitle("Reporte - Pel\u00EDcula m\u00E1s taquillera");
		setBounds(100, 100, 714, 577);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 678, 484);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 13));
		scrollPane.setViewportView(txtS);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnSalir = new JButton("Salir");
				btnSalir.setIcon(new ImageIcon(Reporte1.class.getResource("/img/btnSalir2.png")));
				btnSalir.addActionListener(this);
				
				btnActualizar = new JButton("Actualizar");
				btnActualizar.setIcon(new ImageIcon(Reporte1.class.getResource("/img/btnActualizar.png")));
				buttonPane.add(btnActualizar);
				btnActualizar.addActionListener(this);
				btnSalir.setActionCommand("OK");
				buttonPane.add(btnSalir);
				getRootPane().setDefaultButton(btnSalir);
			}
		}
		
		if (ap.tamaño() == 0 || 
				adr.tamaño() == 0 ||
				ar.tamaño() == 0 ||
				af.tamaño() == 0
				) {
			mensaje("ERROR. Para ver los reportes primero debe haber ingresado datos en el" + 
				"archivo de películas, reservas, detalleReservas yfunciones");
			dispose();
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnActualizar) {
			actionPerformedBtnActualizar(e);
		}
		if (e.getSource() == btnSalir) {
			actionPerformedOkButton(e);
		}
	}
	
	protected void actionPerformedOkButton(ActionEvent e) {
		this.dispose();
	}
	
	void imprimir(String cadena) {
		txtS.append(cadena + "\n");
	}
	
	void imprimir() {
		imprimir("");
	}
	
	protected void actionPerformedBtnActualizar(ActionEvent e) {
		txtS.setText("");
		metodo();
	}
	
	ArregloPeliculas ap = new ArregloPeliculas("peliculas.txt");
	ArregloDetalleReservas adr = new ArregloDetalleReservas("detalle_reservas.txt");
	ArregloReservas ar = new ArregloReservas("reservas.txt");
	ArregloFunciones af = new ArregloFunciones("funciones.txt");
	
	// Se crea un arreglo en donde se almacena el # de espectadores para cada película
	int[] espectadoresPorPelicula;
	
	void metodo() {
		espectadoresPorPelicula = new int[ap.tamaño()]; // Se reinicia el arreglo
		
		imprimir("REPORTE DE # DE ESPECTADORES POR PELÍCULA");
		imprimir("---------------------------------------------------------");
		imprimir();
		
			
		// Para cada película se va a contar la cantidad de espectadores
		for (int i = 0; i < ap.tamaño(); i++) {
			Pelicula pelicula = ap.obtener(i);
			
			// Los espectadores están en detalle Reserva
			for (int j = 0; j < adr.tamaño(); j++) {
				DetalleReserva dr = adr.obtener(j);
				Reserva reserva = ar.buscar(dr.getCodigoReserva());
				Funcion funcion = af.buscar(reserva.getCodigoFuncion());
				if (funcion.getCodigoPelicula() == pelicula.getCodigo()) {
					espectadoresPorPelicula[i]++;
				}
			}
			imprimir("PELÍCULA: " + pelicula.getTituloDistribucion());
			imprimir("# de espectadores totales: " + espectadoresPorPelicula[i]);
			imprimir();
		}
		
		
		// Película más taquillera:
		int indice = 0, maximo = espectadoresPorPelicula[0];
		for (int i = 1; i < espectadoresPorPelicula.length; ++i) {
			if (maximo < espectadoresPorPelicula[i]) {
				maximo = espectadoresPorPelicula[i];
				indice = i;
			}
		}
		
		imprimir("---------------------------------------------------------");
		imprimir("PELÍCULA MÁS TAQUILLERA : " + ap.obtener(indice).getTituloDistribucion());
		imprimir("# de espectadores       : " + espectadoresPorPelicula[indice]);
		imprimir("Fecha de estreno        : " + ap.obtener(indice).getFechaEstreno());
		imprimir("Género                  : " + ap.obtener(indice).getGenero());
		imprimir("Tipo de censura         : " + ap.obtener(indice).getTipoCensuraDescripcion());
	}
	
	public void propertyChange(PropertyChangeEvent evt) {
	}
	
	// Método que muestra un mensaje
	void mensaje(String cadena) {
		JOptionPane.showMessageDialog(this, cadena);
	}
	
	// Método sobrecargado que pide una confirmación
	int confirmar(String mensaje, String tituloMensaje) {
		return JOptionPane.showConfirmDialog(this, mensaje,
				tituloMensaje, JOptionPane.YES_NO_OPTION);
	}
	
	// Método sobrecargado que pide una confirmación
	int confirmar(String mensaje) {
		return JOptionPane.showConfirmDialog(this, mensaje,
				"Seleccionar una opción", JOptionPane.YES_NO_OPTION);
	}

}

