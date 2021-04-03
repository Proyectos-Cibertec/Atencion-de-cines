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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTextField;

public class ReservasxFechayEmpleado_Reporte3 extends JDialog implements ActionListener, PropertyChangeListener, ItemListener {

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
	public ReservasxFechayEmpleado_Reporte3() {
		setModal(true);
		setTitle("Reporte - Reservas por fecha y por empleado");
		setBounds(100, 100, 714, 693);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			panelFecha.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Elija la fecha para consultar las reservas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelFecha.setBounds(10, 11, 678, 272);
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
		txtFechaFin.setBounds(186, 33, 104, 20);
		panelFecha.add(txtFechaFin);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(512, 33, 125, 23);
		panelFecha.add(btnActualizar);
		
		cboEmpleado = new JComboBox<String>();
		cboEmpleado.addItemListener(this);
		cboEmpleado.setBounds(186, 70, 182, 20);
		panelFecha.add(cboEmpleado);
		
		lblCdigoDeEmpleado = new JLabel("C\u00F3digo de Empleado");
		lblCdigoDeEmpleado.setBounds(26, 73, 145, 14);
		panelFecha.add(lblCdigoDeEmpleado);
		
		lblNombresCompletos = new JLabel("Nombres completos");
		lblNombresCompletos.setBounds(26, 115, 108, 14);
		panelFecha.add(lblNombresCompletos);
		
		lblNewLabel = new JLabel("Distrito");
		lblNewLabel.setBounds(26, 208, 108, 14);
		panelFecha.add(lblNewLabel);
		
		txtNombres = new JTextField();
		txtNombres.setFont(new Font("Dialog", Font.BOLD, 13));
		txtNombres.setEditable(false);
		txtNombres.setBounds(144, 111, 215, 20);
		panelFecha.add(txtNombres);
		txtNombres.setColumns(10);
		
		txtDistrito = new JTextField();
		txtDistrito.setFont(new Font("Dialog", Font.BOLD, 13));
		txtDistrito.setEditable(false);
		txtDistrito.setBounds(144, 204, 215, 20);
		panelFecha.add(txtDistrito);
		txtDistrito.setColumns(10);
		
		lblDni = new JLabel("DNI:");
		lblDni.setBounds(26, 145, 108, 14);
		panelFecha.add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setFont(new Font("Dialog", Font.BOLD, 13));
		txtDni.setEditable(false);
		txtDni.setBounds(144, 142, 146, 20);
		panelFecha.add(txtDni);
		txtDni.setColumns(10);
		
		lblDireccin = new JLabel("Direcci\u00F3n");
		lblDireccin.setBounds(26, 176, 108, 14);
		panelFecha.add(lblDireccin);
		
		txtDirección = new JTextField();
		txtDirección.setFont(new Font("Dialog", Font.BOLD, 13));
		txtDirección.setEditable(false);
		txtDirección.setBounds(144, 173, 215, 20);
		panelFecha.add(txtDirección);
		txtDirección.setColumns(10);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(26, 237, 108, 14);
		panelFecha.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Dialog", Font.BOLD, 13));
		txtTelefono.setEditable(false);
		txtTelefono.setBounds(144, 235, 146, 20);
		panelFecha.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(400, 237, 57, 14);
		panelFecha.add(lblTipo);
		
		txtTipo = new JTextField();
		txtTipo.setFont(new Font("Dialog", Font.BOLD, 13));
		txtTipo.setEditable(false);
		txtTipo.setBounds(481, 234, 145, 20);
		panelFecha.add(txtTipo);
		txtTipo.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 294, 678, 317);
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
		
		if (ap.tamaño() == 0 || 
				adr.tamaño() == 0 ||
				ar.tamaño() == 0 ||
				af.tamaño() == 0 ||
				ac.tamaño() == 0 ||
				ae.tamaño() == 0
				) {
			mensaje("ERROR. Para ver los reportes primero debe haber ingresado datos en el" + 
				"archivo de películas, reservas, detalleReservas, funciones, clientes y empleados");
			dispose();
		}
		
		llenarEmpleados();
	}

	// Llena los combobox con los datos de los empleados
	void llenarEmpleados() {
		for (int i = 0; i < ae.tamaño(); i++) {
			cboEmpleado.addItem(ae.obtener(i).getCodigo() + "");
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
	
	// Se crea un arreglo en donde se almacena el # de espectadores para cada película
	int[] espectadoresPorPelicula;
	private JComboBox<String> cboEmpleado;
	private JLabel lblCdigoDeEmpleado;
	private JLabel lblNombresCompletos;
	private JLabel lblNewLabel;
	private JTextField txtNombres;
	private JTextField txtDistrito;
	private JLabel lblDni;
	private JTextField txtDni;
	private JLabel lblDireccin;
	private JTextField txtDirección;
	private JLabel lblTelefono;
	private JTextField txtTelefono;
	private JLabel lblTipo;
	private JTextField txtTipo;
	
	int leerCodigoEmpleado() {
		return Integer.parseInt(cboEmpleado.getSelectedItem().toString());
	}
	
	void metodo() {
		espectadoresPorPelicula = new int[ap.tamaño()]; // Se reinicia el arreglo
		
		String fechaInicio = leerFechaInicio();
		String fechaFin = leerFechaFin();
		
		imprimir("REPORTE DE # DE RESERVAS ENTRE LAS FECHAS: " + fechaInicio + " y " + fechaFin);
		imprimir("-------------------------------------------------------------------");
		Empleado e = ae.buscar(leerCodigoEmpleado());
		imprimir("EMPLEADO: " + e.getCodigo() + " " + e.getApellidoMaterno() + " " + e.getApellidoPaterno() + ", " + 
				e.getNombres());
		
		if (fechaInicio.length() > 0 && fechaFin.length() > 0) {
			int contador = 0;
			int sumaCantidadEntradas = 0;
			
			// Se recorre la lista de reservas
			for (int i = 0; i < ar.tamaño(); i++) {
				Reserva reserva = ar.obtener(i);
				
				// Se valida que las reservas se encuentren entre las fechas dadas
				if (LibreriaFechas.estaEntreFechas(reserva.getFechaReserva(), fechaInicio, fechaFin)) {
					
					// Se obtiene el cliente y empleado
					Cliente cliente = ac.buscar(reserva.getCodigoCliente());
					Empleado empleado = ae.buscar(reserva.getCodigoEmpleado());
					
					if (empleado.getCodigo() == leerCodigoEmpleado()) {
						
						
						// Se contabiliza la reserva entre las fechas dadas para el empleado elegido
						contador++;
						
						int cantidadEntradas = 0; // Se obtiene la cantidad de entradas en esta reserva
						for (int j = 0; j < adr.tamaño(); j++) {
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
						/*imprimir("EMPLEADO: " + empleado.getCodigo() + " " + 
								empleado.getApellidoPaterno() + " " +
								empleado.getApellidoMaterno() + ", " +
								empleado.getNombres());*/
						imprimir("# de entradas compradas: " + cantidadEntradas);
						sumaCantidadEntradas += cantidadEntradas;
						imprimir("FECHA Y HORA DE RESERVA: " + reserva.getFechaReserva() + " " + reserva.getHoraReserva());
						imprimir();
					}
				}
			} // fin de for
			
			
			if (contador == 0) {
				imprimir("NO SE REGISTRAN RESERVAS ENTRE LAS FECHAS DADAS PARA EL EMPLEADO");
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
	
	String leerFechaInicio() {
		String strFechaInicio = LibreriaFechas.dateToString(txtFechaInicio.getDate());
		return (strFechaInicio == null) ? "" : strFechaInicio;
	}
	
	String leerFechaFin() {
		String strFechaFin = LibreriaFechas.dateToString(txtFechaFin.getDate());
		return (strFechaFin == null) ? "" : strFechaFin;
	}
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cboEmpleado) {
			itemStateChangedCboEmpleado(e);
		}
	}
	
	protected void itemStateChangedCboEmpleado(ItemEvent e) {
		int codigoEmpleado = leerCodigoEmpleado();
		Empleado empleado = ae.buscar(codigoEmpleado);
		txtNombres.setText(empleado.getApellidoPaterno() + " " + empleado.getApellidoMaterno() + ", " + empleado.getNombres());
		txtDni.setText(empleado.getDni());
		txtDirección.setText(empleado.getDireccion());
		txtDistrito.setText(empleado.getDistrito());
		txtTelefono.setText(empleado.getTelefono());
		txtTipo.setText(empleado.getTipoDescripcion());
	}
}

