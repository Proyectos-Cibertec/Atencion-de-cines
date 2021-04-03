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

import arreglos.ArregloClientes;
import arreglos.ArregloDetalleReservas;
import arreglos.ArregloEmpleados;
import arreglos.ArregloFunciones;
import arreglos.ArregloPeliculas;
import arreglos.ArregloReservas;
import clases.Cliente;
import clases.DetalleReserva;
import clases.Empleado;
import clases.Reserva;
import libreria.LibreriaFechas;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.ImageIcon;

public class ReservasxFecha_Reporte2 extends JDialog implements ActionListener, PropertyChangeListener {

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
	public ReservasxFecha_Reporte2() {
		setModal(true);
		setTitle("Reporte - Reservas por fecha");
		setBounds(100, 100, 714, 577);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			panelFecha.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Elija la fecha para consultar las reservas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
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
		btnActualizar.setIcon(new ImageIcon(ReservasxFecha_Reporte2.class.getResource("/img/btnActualizar.png")));
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(400, 33, 125, 44);
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
				btnSalir.setIcon(new ImageIcon(ReservasxFecha_Reporte2.class.getResource("/img/btnSalir2.png")));
				btnSalir.addActionListener(this);
				btnSalir.setActionCommand("OK");
				buttonPane.add(btnSalir);
				getRootPane().setDefaultButton(btnSalir);
			}
		}
		
		if (ap.tama�o() == 0 || 
				adr.tama�o() == 0 ||
				ar.tama�o() == 0 ||
				af.tama�o() == 0 ||
				ac.tama�o() == 0 ||
				ae.tama�o() == 0
				) {
			mensaje("ERROR. Para ver los reportes primero debe haber ingresado datos en el" + 
				"archivo de pel�culas, reservas, detalleReservas, funciones, clientes y empleados");
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
	ArregloClientes ac = new ArregloClientes("clientes.txt");
	ArregloEmpleados ae = new ArregloEmpleados("empleados.txt");
	
	// Se crea un arreglo en donde se almacena el # de espectadores para cada pel�cula
	int[] espectadoresPorPelicula;
	
	void metodo() {
		espectadoresPorPelicula = new int[ap.tama�o()]; // Se reinicia el arreglo
		
		String fechaInicio = leerFechaInicio();
		String fechaFin = leerFechaFin();
		
		imprimir("REPORTE DE # DE RESERVAS ENTRE LAS FECHAS: " + fechaInicio + " y " + fechaFin);
		imprimir("-------------------------------------------------------------------");
		
		if (fechaInicio.length() > 0 && fechaFin.length() > 0) {
			int contador = 0;
			int sumaCantidadEntradas = 0;
			
			// Se recorre la lista de reservas totales
			for (int i = 0; i < ar.tama�o(); i++) {
				Reserva reserva = ar.obtener(i);
				
				// Se valida que las reservas se encuentren entre las fechas dadas
				if (LibreriaFechas.estaEntreFechas(reserva.getFechaReserva(), fechaInicio, fechaFin)) {
					
					// Se contabiliza la reserva entre las fechas dadas
					contador++;
					
					// Se obtiene el cliente y empleado
					Cliente cliente = ac.buscar(reserva.getCodigoCliente());
					Empleado empleado = ae.buscar(reserva.getCodigoEmpleado());
					
					// Se obtiene la cantidad de entradas en esta reserva
					int cantidadEntradas = 0;
					for (int j = 0; j < adr.tama�o(); j++) {
						DetalleReserva dr = adr.obtener(j);
						if (dr.getCodigoReserva() == reserva.getCodigo()) {
							cantidadEntradas++;
						}
					}
					
					// Se muestran los datos pedidos
					imprimir();
					imprimir("RESERVA: " + reserva.getCodigo());
					imprimir("CLIENTE: " + cliente.getCodigo() + " " + 
							cliente.getApellidoPaterno() + " " +
							cliente.getApellidoMaterno() + ", " +
							cliente.getNombres());
					imprimir("EMPLEADO: " + empleado.getCodigo() + " " + 
							empleado.getApellidoPaterno() + " " +
							empleado.getApellidoMaterno() + ", " +
							empleado.getNombres());
					imprimir("# de entradas compradas: " + cantidadEntradas);
					sumaCantidadEntradas += cantidadEntradas;
					imprimir("FECHA Y HORA DE RESERVA: " + reserva.getFechaReserva() + " " + reserva.getHoraReserva());
					imprimir();
				}
			} // fin de for
			
			
			if (contador == 0) {
				imprimir("NO SE REGISTRAN RESERVAS ENTRE LAS FECHAS DADAS");
			} else {
				imprimir("# de reservas registradas en total : " + contador);
				imprimir("# de entradas vendidas en total    : " + sumaCantidadEntradas);
			}

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

