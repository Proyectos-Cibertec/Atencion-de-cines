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

public class Reporte2 extends JDialog implements ActionListener, PropertyChangeListener {

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
			Reporte2 dialog = new Reporte2();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Reporte2() {
		setModal(true);
		setTitle("Reporte - Pel\u00EDcula menos taquillera");
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
				btnSalir.addActionListener(this);
				
				btnActualizar = new JButton("Actualizar");
				buttonPane.add(btnActualizar);
				btnActualizar.addActionListener(this);
				btnSalir.setActionCommand("OK");
				buttonPane.add(btnSalir);
				getRootPane().setDefaultButton(btnSalir);
			}
		}
		
		if (ap.tama�o() == 0 || 
				adr.tama�o() == 0 ||
				ar.tama�o() == 0 ||
				af.tama�o() == 0
				) {
			mensaje("ERROR. Para ver los reportes primero debe haber ingresado datos en el" + 
				"archivo de pel�culas, reservas, detalleReservas yfunciones");
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
	
	// Se crea un arreglo en donde se almacena el # de espectadores para cada pel�cula
	int[] espectadoresPorPelicula;
	
	void metodo() {
		espectadoresPorPelicula = new int[ap.tama�o()]; // Se reinicia el arreglo
		
		imprimir("REPORTE DE # DE ESPECTADORES POR PEL�CULA");
		imprimir("---------------------------------------------------------");
		imprimir();
		
			
		// Para cada pel�cula se va a contar la cantidad de espectadores
		for (int i = 0; i < ap.tama�o(); i++) {
			Pelicula pelicula = ap.obtener(i);
			
			// Los espectadores est�n en detalle Reserva
			for (int j = 0; j < adr.tama�o(); j++) {
				DetalleReserva dr = adr.obtener(j);
				Reserva reserva = ar.buscar(dr.getCodigoReserva());
				Funcion funcion = af.buscar(reserva.getCodigoFuncion());
				if (funcion.getCodigoPelicula() == pelicula.getCodigo()) {
					espectadoresPorPelicula[i]++;
				}
			}
			imprimir("PEL�CULA: " + pelicula.getTituloDistribucion());
			imprimir("# de espectadores totales: " + espectadoresPorPelicula[i]);
			imprimir();
		}
		
		
		// Pel�cula menos taquillera:
		int indice = 0, minimo = espectadoresPorPelicula[0];
		for (int i = 1; i < espectadoresPorPelicula.length; ++i) {
			if (minimo > espectadoresPorPelicula[i]) {
				minimo = espectadoresPorPelicula[i];
				indice = i;
			}
		}
		
		imprimir("---------------------------------------------------------");
		imprimir("PEL�CULA MENOS TAQUILLERA : " + ap.obtener(indice).getTituloDistribucion());
		imprimir("# de espectadores       : " + espectadoresPorPelicula[indice]);
		imprimir("Fecha de estreno        : " + ap.obtener(indice).getFechaEstreno());
		imprimir("G�nero                  : " + ap.obtener(indice).getGenero());
		imprimir("Tipo de censura         : " + ap.obtener(indice).getTipoCensuraDescripcion());
	}
	
	public void propertyChange(PropertyChangeEvent evt) {
	}
	
	// M�todo que muestra un mensaje
	void mensaje(String cadena) {
		JOptionPane.showMessageDialog(this, cadena);
	}
	
	// M�todo sobrecargado que pide una confirmaci�n
	int confirmar(String mensaje, String tituloMensaje) {
		return JOptionPane.showConfirmDialog(this, mensaje,
				tituloMensaje, JOptionPane.YES_NO_OPTION);
	}
	
	// M�todo sobrecargado que pide una confirmaci�n
	int confirmar(String mensaje) {
		return JOptionPane.showConfirmDialog(this, mensaje,
				"Seleccionar una opci�n", JOptionPane.YES_NO_OPTION);
	}

}

