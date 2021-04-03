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
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import com.toedter.calendar.JDateChooser;

import arreglos.ArregloDetalleReservas;
import arreglos.ArregloFunciones;
import arreglos.ArregloPeliculas;
import arreglos.ArregloReservas;
import clases.DetalleReserva;
import clases.Funcion;
import clases.Pelicula;
import clases.Reserva;
import libreria.LibreriaFechas;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.Font;
import javax.swing.UIManager;

public class Reporte4 extends JDialog implements ActionListener, PropertyChangeListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnSalir;
	private final JPanel panelFecha = new JPanel();
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JDateChooser txtFechaInicio;
	private JDateChooser txtFechaFin;
	private JButton btnActualizar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
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
	public Reporte4() {
		setModal(true);
		setTitle("Reporte - Pel\u00EDcula menos taquillera entre dos fechas");
		setBounds(100, 100, 714, 577);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			panelFecha.setBorder(new TitledBorder(null, "Rango de fechas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelFecha.setBounds(10, 11, 678, 88);
			contentPanel.add(panelFecha);
		}
		panelFecha.setLayout(null);
		
		txtFechaInicio = new JDateChooser();
		txtFechaInicio.setDateFormatString("dd/MM/yyyy");
		txtFechaInicio.setBounds(26, 33, 95, 20);
		panelFecha.add(txtFechaInicio);
		
		txtFechaFin = new JDateChooser();
		txtFechaFin.addPropertyChangeListener(this);
		txtFechaFin.setDateFormatString("dd/MM/yyyy");
		txtFechaFin.setBounds(209, 33, 95, 20);
		panelFecha.add(txtFechaFin);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(375, 33, 125, 23);
		panelFecha.add(btnActualizar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 110, 678, 385);
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
		
		String fechaInicio = leerFechaInicio();
		String fechaFin = leerFechaFin();
		
		imprimir("REPORTE DE # DE ESPECTADORES POR PEL�CULA");
		imprimir("---------------------------------------------------------");
		imprimir();
		if (fechaInicio.length() > 0 && fechaFin.length() > 0) {
			
			// Para cada pel�cula se va a contar la cantidad de espectadores
			for (int i = 0; i < ap.tama�o(); i++) {
				Pelicula pelicula = ap.obtener(i);
				
				// Los espectadores est�n en detalle Reserva
				for (int j = 0; j < adr.tama�o(); j++) {
					DetalleReserva dr = adr.obtener(j);
					Reserva reserva = ar.buscar(dr.getCodigoReserva());
					Funcion funcion = af.buscar(reserva.getCodigoFuncion());
					
					// Si la funci�n se encuentra en el rango de fechas establecido
					if (LibreriaFechas.diasEntreDosFechas(fechaInicio, funcion.getFechaFuncion()) >= 0 && 
						LibreriaFechas.diasEntreDosFechas(funcion.getFechaFuncion(), fechaFin) >= 0) {
						if (funcion.getCodigoPelicula() == pelicula.getCodigo()) {
							espectadoresPorPelicula[i]++;
						}
					}
				}
				imprimir("PEL�CULA: " + pelicula.getTituloDistribucion());
				imprimir("# de espectadores totales: " + espectadoresPorPelicula[i]);
				imprimir();
			}
			
			
			// Pel�cula m�s taquillera:
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
			
			
		} else {
			mensaje("Debe ingresar la fecha de inicio y la fecha de fin");
		}
	}
	
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getSource() == txtFechaFin) {
			propertyChangeFechaFin(evt);
		}
	}
	
	protected void propertyChangeFechaFin(PropertyChangeEvent evt) {
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
	
	String leerFechaInicio() {
		String strFechaInicio = LibreriaFechas.dateToString(txtFechaInicio.getDate());
		return (strFechaInicio == null) ? "" : strFechaInicio;
	}
	
	String leerFechaFin() {
		String strFechaFin = LibreriaFechas.dateToString(txtFechaFin.getDate());
		return (strFechaFin == null) ? "" : strFechaFin;
	}
}

