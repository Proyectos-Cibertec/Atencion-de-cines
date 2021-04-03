package gui;


import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

import arreglos.ArregloButacas;
import arreglos.ArregloCines;
import arreglos.ArregloClientes;
import arreglos.ArregloDetalleReservas;
import arreglos.ArregloEmpleados;
import arreglos.ArregloFunciones;
import arreglos.ArregloPeliculas;
import arreglos.ArregloReservas;
import arreglos.ArregloSalas;
import clases.Butaca;
import clases.Cine;
import clases.Cliente;
import clases.DetalleReserva;
import clases.Funcion;
import clases.Pelicula;
import clases.Reserva;
import libreria.Asiento;
import libreria.LibreriaFechas;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.ImageIcon;

public class DlgPagoReservas extends JInternalFrame implements ActionListener, MouseListener, KeyListener, ItemListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelRegistro;
	private JPanel panelListado;
	private JLabel lblCdigo;
	public static JTextField txtCodigoReserva;
	private JLabel lblEmpleado;
	public static JTextField txtEmpleado;
	private JLabel lblCliente;
	public static JTextField txtCliente;
	private JButton btnSeleccionarCliente;
	private JLabel lblFuncion;
	public static JTextField txtFuncion;
	private JButton btnSeleccionarFuncion;
	private JLabel lblCantidadDeEntradas;
	public static JTextField txtEntradas;
	private JLabel lblFecha;
	private JDateChooser txtFechaReserva;
	private JLabel lblHora;
	private JTextField txtHoraReserva;
	private JLabel lblEstado;
	private JComboBox<String> cboEstadoReserva;
	private JButton btnSeleccionarButacas;
	private JButton btnPagar;
	private JButton btnCancelar;
	private JLabel lblBuscar;
	private JTextField txtClaveBusquedaCodigoReserva;
	private JButton btnBuscar;
	private JButton btnEliminar;
	private JButton btnSalir;
	private JScrollPane scrollPane;
	private JTable tblTabla;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	private int accionPrincipal; 
	public DlgPagoReservas(int accionPrincipal) {
		this.accionPrincipal = accionPrincipal; 
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Reserva");
		setBounds(100, 100, 1275, 556);
		getContentPane().setLayout(null);
		
		panelRegistro = new JPanel();
		panelRegistro.setBorder(new TitledBorder(null, "Registro de Reservas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelRegistro.setBounds(10, 36, 513, 475);
		getContentPane().add(panelRegistro);
		panelRegistro.setLayout(null);
		
		lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCdigo.setBounds(10, 26, 68, 14);
		panelRegistro.add(lblCdigo);
		
		txtCodigoReserva = new JTextField();
		txtCodigoReserva.setEditable(false);
		txtCodigoReserva.setBounds(104, 23, 150, 20);
		panelRegistro.add(txtCodigoReserva);
		txtCodigoReserva.setColumns(10);
		
		lblEmpleado = new JLabel("Empleado");
		lblEmpleado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmpleado.setBounds(10, 62, 68, 14);
		panelRegistro.add(lblEmpleado);
		
		txtEmpleado = new JTextField();
		txtEmpleado.setEditable(false);
		txtEmpleado.setBounds(104, 59, 206, 20);
		panelRegistro.add(txtEmpleado);
		txtEmpleado.setColumns(10);
		
		lblCliente = new JLabel("Cliente");
		lblCliente.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCliente.setBounds(10, 97, 68, 14);
		panelRegistro.add(lblCliente);
		
		txtCliente = new JTextField();
		txtCliente.setEditable(false);
		txtCliente.setBounds(103, 94, 207, 20);
		panelRegistro.add(txtCliente);
		txtCliente.setColumns(10);
		
		btnSeleccionarCliente = new JButton("...");
		btnSeleccionarCliente.setVisible(false);
		btnSeleccionarCliente.setEnabled(false);
		btnSeleccionarCliente.addActionListener(this);
		btnSeleccionarCliente.setBounds(414, 93, 89, 23);
		panelRegistro.add(btnSeleccionarCliente);
		
		lblFuncion = new JLabel("Funci\u00F3n");
		lblFuncion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFuncion.setBounds(10, 135, 68, 14);
		panelRegistro.add(lblFuncion);
		
		txtFuncion = new JTextField();
		txtFuncion.setEditable(false);
		txtFuncion.setBounds(104, 132, 206, 20);
		panelRegistro.add(txtFuncion);
		txtFuncion.setColumns(10);
		
		btnSeleccionarFuncion = new JButton("...");
		btnSeleccionarFuncion.setVisible(false);
		btnSeleccionarFuncion.setEnabled(false);
		btnSeleccionarFuncion.addActionListener(this);
		btnSeleccionarFuncion.setBounds(414, 131, 89, 23);
		panelRegistro.add(btnSeleccionarFuncion);
		
		lblCantidadDeEntradas = new JLabel("N\u00BA entradas");
		lblCantidadDeEntradas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCantidadDeEntradas.setBounds(10, 182, 68, 14);
		panelRegistro.add(lblCantidadDeEntradas);
		
		txtEntradas = new JTextField();
		txtEntradas.setText("0");
		txtEntradas.setEditable(false);
		txtEntradas.setBounds(104, 179, 128, 20);
		panelRegistro.add(txtEntradas);
		txtEntradas.setColumns(10);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFecha.setBounds(10, 261, 68, 14);
		panelRegistro.add(lblFecha);
		
		txtFechaReserva = new JDateChooser();
		txtFechaReserva.setEnabled(false);
		txtFechaReserva.setDateFormatString("dd/MM/yyyy");
		txtFechaReserva.setBounds(104, 255, 128, 20);
		panelRegistro.add(txtFechaReserva);
		
		lblHora = new JLabel("Hora");
		lblHora.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHora.setBounds(10, 301, 68, 14);
		panelRegistro.add(lblHora);
		
		txtHoraReserva = new JTextField();
		txtHoraReserva.setEditable(false);
		txtHoraReserva.setBounds(104, 298, 128, 20);
		panelRegistro.add(txtHoraReserva);
		txtHoraReserva.setColumns(10);
		
		btnSeleccionarButacas = new JButton("Seleccionar butacas");
		btnSeleccionarButacas.setVisible(false);
		btnSeleccionarButacas.setEnabled(false);
		btnSeleccionarButacas.addActionListener(this);
		btnSeleccionarButacas.setBounds(242, 178, 167, 23);
		panelRegistro.add(btnSeleccionarButacas);
		
		txtCodigoCliente = new JTextField();
		txtCodigoCliente.setEditable(false);
		txtCodigoCliente.setBounds(318, 94, 86, 20);
		panelRegistro.add(txtCodigoCliente);
		txtCodigoCliente.setColumns(10);
		
		txtCodigoFuncion = new JTextField();
		txtCodigoFuncion.setEditable(false);
		txtCodigoFuncion.setBounds(318, 132, 86, 20);
		panelRegistro.add(txtCodigoFuncion);
		txtCodigoFuncion.setColumns(10);
		
		txtCodigoEmpleado = new JTextField();
		txtCodigoEmpleado.setEditable(false);
		txtCodigoEmpleado.setBounds(320, 59, 86, 20);
		panelRegistro.add(txtCodigoEmpleado);
		txtCodigoEmpleado.setColumns(10);
		
		lblCosto = new JLabel("Costo");
		lblCosto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCosto.setBounds(10, 215, 68, 14);
		panelRegistro.add(lblCosto);
		
		txtCostoTotal = new JTextField();
		txtCostoTotal.setEditable(false);
		txtCostoTotal.setBounds(104, 212, 128, 20);
		panelRegistro.add(txtCostoTotal);
		txtCostoTotal.setColumns(10);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Seleccione una acci\u00F3n para la reserva", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(20, 333, 463, 131);
		panelRegistro.add(panel);
		panel.setLayout(null);
		
		lblEstado = new JLabel("ACCI\u00D3N:");
		lblEstado.setBounds(47, 28, 44, 14);
		panel.add(lblEstado);
		lblEstado.setHorizontalAlignment(SwingConstants.RIGHT);
		
		cboEstadoReserva = new JComboBox<String>();
		cboEstadoReserva.addItemListener(this);
		cboEstadoReserva.setBounds(119, 25, 128, 20);
		panel.add(cboEstadoReserva);
		cboEstadoReserva.setEnabled(false);
		cboEstadoReserva.setModel(new DefaultComboBoxModel<String>(new String[] {"Reservada", "Reserva usada", "Reserva cancelada", "Reserva caducada"}));
		
		btnPagar = new JButton("Pagar");
		btnPagar.setIcon(new ImageIcon(DlgPagoReservas.class.getResource("/img/btnPagar.png")));
		btnPagar.setBounds(31, 65, 120, 41);
		panel.add(btnPagar);
		btnPagar.setEnabled(false);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(DlgPagoReservas.class.getResource("/img/btnCancelar.png")));
		btnCancelar.setBounds(210, 65, 120, 41);
		panel.add(btnCancelar);
		btnCancelar.setEnabled(false);
		btnCancelar.addActionListener(this);
		btnPagar.addActionListener(this);
		
		panelListado = new JPanel();
		panelListado.setBorder(new TitledBorder(null, "Listado de Reservas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelListado.setBounds(533, 36, 716, 423);
		getContentPane().add(panelListado);
		panelListado.setLayout(null);
		
		lblBuscar = new JLabel("Buscar por c\u00F3digo");
		lblBuscar.setBounds(10, 29, 85, 14);
		panelListado.add(lblBuscar);
		
		txtClaveBusquedaCodigoReserva = new JTextField();
		txtClaveBusquedaCodigoReserva.addKeyListener(this);
		txtClaveBusquedaCodigoReserva.setBounds(105, 26, 176, 20);
		panelListado.add(txtClaveBusquedaCodigoReserva);
		txtClaveBusquedaCodigoReserva.setColumns(10);
		
		btnBuscar = new JButton("");
		btnBuscar.setIcon(new ImageIcon(DlgPagoReservas.class.getResource("/img/btnBuscar.png")));
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(314, 11, 95, 44);
		panelListado.add(btnBuscar);
		
		btnEliminar = new JButton("");
		btnEliminar.setIcon(new ImageIcon(DlgPagoReservas.class.getResource("/img/btnEliminar.png")));
		btnEliminar.setEnabled(false);
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(419, 11, 89, 44);
		panelListado.add(btnEliminar);
		
		btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon(DlgPagoReservas.class.getResource("/img/btnSalir.png")));
		btnSalir.addActionListener(this);
		btnSalir.setBounds(617, 11, 89, 44);
		panelListado.add(btnSalir);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 66, 696, 350);
		panelListado.add(scrollPane);
		
		tblTabla = new JTable();
		tblTabla.addMouseListener(this);
		tblTabla.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblTabla);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("C�digo de Reserva");
		modelo.addColumn("Empleado");
		modelo.addColumn("Cliente");
		modelo.addColumn("C�digo de Funci�n");
		modelo.addColumn("Entradas"); // Nro de Entradas
		modelo.addColumn("Fecha"); // Fecha de la funci�n
		modelo.addColumn("Hora"); // Hora de la funci�n
		modelo.addColumn("Estado");
		
		tblTabla.setModel(modelo);
		
		btnGrabar = new JButton("");
		btnSalir.setIcon(new ImageIcon(DlgPagoReservas.class.getResource("/img/btnSalir.png")));
		btnGrabar.setBounds(518, 11, 89, 44);
		panelListado.add(btnGrabar);
		btnGrabar.addActionListener(this);
		
		lblTotalRegistros = new JLabel("Total registros: ");
		lblTotalRegistros.setBounds(881, 470, 150, 14);
		getContentPane().add(lblTotalRegistros);
		
		lblPagoDeEntradas = new JLabel("PAGO DE ENTRADAS");
		lblPagoDeEntradas.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPagoDeEntradas.setBounds(10, 11, 239, 20);
		getContentPane().add(lblPagoDeEntradas);
		listar();
		
		switch (accionPrincipal) {
			case 1:
				lblPagoDeEntradas.setText("USAR RESERVAS");
				btnPagar.setText("Usar");
				break;
				
			case 2:
				lblPagoDeEntradas.setText("PAGO DE RESERVAS");
				btnPagar.setText("Pagar");
				break;
			
			case 3:
				lblPagoDeEntradas.setText("CADUCAR RESERVAS");
				btnPagar.setText("Caducar");
				break;
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGrabar) {
			actionPerformedBtnGuardar(e);
		}
		if (e.getSource() == btnSalir) {
			actionPerformedBtnSalir(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnPagar) {
			actionPerformedBtnIngresar(e);
		}
		if (e.getSource() == btnSeleccionarButacas) {
			actionPerformedBtnSeleccionarButacas(e);
		}
		if (e.getSource() == btnSeleccionarFuncion) {
			actionPerformedBtnSeleccionarFuncion(e);
		}
		if (e.getSource() == btnSeleccionarCliente) {
			actionPerformedBtnSeleccionarCliente(e);
		}
	}
	
	// Declaraci�n Global
	ArregloReservas arregloReservas = new ArregloReservas("reservas.txt");
	ArregloEmpleados arregloEmpleados = new ArregloEmpleados("empleados.txt");
	ArregloDetalleReservas adr = new ArregloDetalleReservas("detalle_reservas.txt");
	ArregloButacas arregloButacas = new ArregloButacas("butacas.txt");
	ArregloClientes arregloClientes = new ArregloClientes("clientes.txt");
	ArregloPeliculas arregloPeliculas = new ArregloPeliculas("peliculas.txt");
	ArregloFunciones arregloFunciones = new ArregloFunciones("funciones.txt");
	ArregloCines arregloCines = new ArregloCines("cines.txt");
	ArregloSalas arregloSalas = new ArregloSalas("salas.txt");
	
	
	int accion = INGRESAR;
	boolean cambios = false; // Permite saber si se hicieron cambios que necesitan guardarse
	
	int totalRegistros;
	private JLabel lblTotalRegistros;
	
	//  Constantes
	public final static int INGRESAR = 0;
	public final static int PAGAR = 1;
	
	public final static int USAR_RESERVA = 1;
	public final static int PAGAR_RESERVA = 2;
	public final static int CADUCAR_RESERVA = 3;
	private JButton btnGrabar;
	public static JTextField txtCodigoCliente;
	public static JTextField txtCodigoFuncion;
	public static JTextField txtCodigoEmpleado;
	private JLabel lblCosto;
	public static JTextField txtCostoTotal;
	private JLabel lblPagoDeEntradas;
	private JPanel panel;
	
	// Lista las reservas en la tabla
	void listar() {
		totalRegistros = 0;
		modelo.setRowCount(0);
		Reserva reserva = null;
		for (int i = 0; i < arregloReservas.tama�o(); i++) {
			reserva = arregloReservas.obtener(i);
			Object[] fila = {
					reserva.getCodigo(),
					reserva.getCodigoEmpleado(),
					reserva.getCodigoCliente(),
					reserva.getCodigoFuncion(),
					reserva.getNumeroEntradas(),
					reserva.getFechaReserva(),
					reserva.getHoraReserva(),
					reserva.getEstadoDescripcion(),
					};
			modelo.addRow(fila);
			totalRegistros++;
		}
		
		lblTotalRegistros.setText("Total registros: " + totalRegistros);
	}
	
	// M�todo sobrecargado listar que realiza la b�squeda de las reservas por c�digo y la muestra en la tabla de resultados
	void listar(String claveBusqueda) {
		if (claveBusqueda == "") {
			listar();
			
		} else {
			// Se valida que lo ingresado sea entero
			try {
				int codigoReserva = Integer.parseInt(claveBusqueda);
				if (codigoReserva > 0) {
					
					totalRegistros = 0;
					modelo.setRowCount(0);
					Reserva reserva = null;
					for (int i = 0; i < arregloReservas.tama�o(); i++) {
						reserva = arregloReservas.obtener(i);
						if (reserva.getCodigo() == codigoReserva) {
							Object[] fila = {
									reserva.getCodigo(),
									reserva.getCodigoEmpleado(),
									reserva.getCodigoCliente(),
									reserva.getCodigoFuncion(),
									reserva.getNumeroEntradas(),
									reserva.getFechaReserva(),
									reserva.getHoraReserva(),
									reserva.getEstadoDescripcion()
									};
							modelo.addRow(fila);
							totalRegistros++;
						}
					}
					
					lblTotalRegistros.setText("Total registros: " + totalRegistros);
					
				} else {
					mensaje("El c�digo de Reserva ingresado no puede ser negativo");
					txtClaveBusquedaCodigoReserva.setText("");
					listar(); // Muestra todo y no un dato en espec�fico
					txtClaveBusquedaCodigoReserva.requestFocus();
				}
			} catch (Exception e) {
				mensaje("Ingrese un c�digo de Reserva v�lido a buscar");
				txtClaveBusquedaCodigoReserva.setText("");
				listar(); // Muestra todo y no un dato en espec�fico
				txtClaveBusquedaCodigoReserva.requestFocus();
			}
		}
	}
	
	void habilitar(boolean valor) {
        btnSeleccionarCliente.setEnabled(valor);
        btnSeleccionarFuncion.setEnabled(valor);
        btnSeleccionarButacas.setEnabled(valor);
        txtFechaReserva.setEnabled(valor);
        txtHoraReserva.setEditable(valor);
        cboEstadoReserva.setEnabled(valor);
        
        btnPagar.setEnabled(valor);
        btnCancelar.setEnabled(valor);
        //btnEliminar.setEnabled(valor);
	}
	
	// Limpia los cuadros de texto
	void limpiarEntradas() {
		txtCodigoReserva.setText("");
		txtCliente.setText("");
		txtFuncion.setText("");
		txtCostoTotal.setText("");
		txtEntradas.setText("");
		txtCodigoCliente.setText("");
		txtCodigoFuncion.setText("");
		txtFechaReserva.setDate(LibreriaFechas.fechaActual()); // Por defecto es la fecha actual);
		txtHoraReserva.setText("");
		cboEstadoReserva.setSelectedIndex(0);
	}
	
	int leerCodigoReserva() {
		return Integer.parseInt(txtCodigoReserva.getText());
	}
	
	int leerCodigoEmpleado() {
		return Integer.parseInt(txtCodigoEmpleado.getText());
	}
	
	int leerCodigoCliente() {
		return Integer.parseInt(txtCodigoCliente.getText());
	}
	
	int leerCodigoFuncion() {
		return Integer.parseInt(txtCodigoFuncion.getText());
	}
	
	int leerNumeroEntradas() {
		return Integer.parseInt(txtEntradas.getText());
	}
	
	String leerFechaReserva() {
		String fechaReserva = LibreriaFechas.dateToString(txtFechaReserva.getDate());
		return (fechaReserva == null) ? "" : fechaReserva;
	}
	
	String leerHoraReserva() {
		return txtHoraReserva.getText();
	}
	
	int leerEstadoReserva() {
		return cboEstadoReserva.getSelectedIndex();
	}
	
	String leerClaveBusqueda() {
		return txtClaveBusquedaCodigoReserva.getText();
	}
	
	void ingresarReserva(Reserva reserva) {
		arregloReservas.adicionar(reserva);
		
		// Se crea todos los detallesReservas asociado a esa reserva (Cada detalle reserva se corresponde con una entrada)
		// Y se marcan las butacas seleccionadas como Ocupadas
		generarDetalleReservasYOcuparButacas();
		
		listar();
		
		habilitar(false);
		btnSeleccionarCliente.requestFocus();
		mensaje("Registro exitoso");
		cambios = true; // Variable que permite saber si se realizaron cambios en el array list
		
		grabarTodosLosCambiosEnLosArchivos(); // Se graba autom�ticamente
		
		mostrarInformacionDelPagoOUsoDeLaReserva(reserva.getCodigo());
		
		limpiarEntradas();
	}
	
	// Muestra informaci�n acerca de la reserva cuyo c�digo se le pasa como argumento
	void mostrarInformacionDelPagoOUsoDeLaReserva(int codigoReserva) {		
		Reserva reserva = arregloReservas.buscar(codigoReserva);
		Cliente cliente = arregloClientes.buscar(reserva.getCodigoCliente());
		Funcion funcion = arregloFunciones.buscar(reserva.getCodigoFuncion());
		Pelicula pelicula = arregloPeliculas.buscar(funcion.getCodigoPelicula());
		Cine cine = arregloCines.buscar(funcion.getCodigoPelicula());
		
		imprimir("C�digo de la reserva: " + codigoReserva);
		imprimir("Fecha de la reserva: " + reserva.getFechaReserva());
		imprimir("---------------------------------------------------");
		
		imprimir("C�digo del cliente: " + cliente.getCodigo());
		imprimir("CLIENTE: " + cliente.getApellidoPaterno() + " " + cliente.getApellidoMaterno() + ", " + cliente.getNombres());
		imprimir("---------------------------------------------------");
		
		imprimir("C�digo de cine: " + cine.getCodigo());
		imprimir("CINE: " + cine.getNombre());
		imprimir("LUGAR: " + cine.getDistrito() + ", " + cine.getProvincia() + ", " + cine.getDepartamento());
		imprimir("---------------------------------------------------");
		
		imprimir("C�digo de pel�cula: " + pelicula.getCodigo());
		imprimir("Pel�cula: " + pelicula.getTituloDistribucion());
		imprimir("Proyecci�n: " + pelicula.getTipoProyeccionDescripcion());
		imprimir("G�nero: " + pelicula.getGenero());
		imprimir("---------------------------------------------------");
		
		imprimir("C�digo de Funci�n: " + funcion.getCodigo());
		imprimir("HORA y FECHA: " + funcion.getFechaFuncion() + " " + funcion.getHoraFuncion());
		imprimir("---------------------------------------------------");
		
		imprimir("# de entradas: " + DlgPagoReservas.txtEntradas.getText());
		imprimir("Costo total: " + DlgPagoReservas.txtCostoTotal.getText());
		
		// Declara y crea el cuadro de di�logo
		DlgReservaInfo dri = new DlgReservaInfo();
				
		// Centra el cuadro de di�logo
		dri.setLocationRelativeTo(this);
				
		// Hace visible el cuadro de di�logo
		dri.setVisible(true);
	}
	
	void imprimir(String cadena) {
		DlgReservaInfo.txtS.append(cadena + "\n");
	}
	
	void imprimir() {
		imprimir("");
	}
	
	// Genera un detalleReserva para cada asiento elegido en la venta de Selecci�n de butacas
	void generarDetalleReservasYOcuparButacas() {
		ArrayList<Asiento> asientosSeleccionados = DlgSeleccionButacas.asientosTMP;
		for (Asiento asiento : asientosSeleccionados) {
			// Se genera un detalleReserva
			DetalleReserva detalleReserva = new DetalleReserva(adr.codigoCorrelativo(), asiento.getCodigo(), 
					leerCodigoReserva(), asiento.getTipoEntradaCodigo(), asiento.getPrecio());
			adr.adicionar(detalleReserva);
			
			// Se ocupa la butaca
			arregloButacas.reservarButaca(asiento.getCodigo()); // Se ocupan todas las butacas seleccionadas
		}
	}
	
	void modificarReserva(Reserva nuevaReserva) {
		Reserva reserva = arregloReservas.buscar(nuevaReserva.getCodigo());
		if (reserva != null) {
			
			reserva.setCodigoEmpleado(nuevaReserva.getCodigoEmpleado());
			reserva.setCodigoCliente(nuevaReserva.getCodigoCliente());
			reserva.setCodigoFuncion(nuevaReserva.getCodigoFuncion());
			reserva.setNumeroEntradas(nuevaReserva.getNumeroEntradas());
			reserva.setFechaReserva(nuevaReserva.getFechaReserva());
			reserva.setHoraReserva(nuevaReserva.getHoraReserva());
			reserva.setEstado(nuevaReserva.getEstado());
			
			listar();
			habilitar(false);
			mensaje("Se pag� la reserva de manera exitosa");
			
			// Cuando se caduca una reserva se deben liberar las butacas de dicha reserva
			if (accionPrincipal == CADUCAR_RESERVA) {
				liberarButacasDeReserva(nuevaReserva.getCodigo());
			}
			
			/*public final static int USAR_RESERVA = 1;
			public final static int PAGAR_RESERVA = 2;
			public final static int CADUCAR_RESERVA = 3;*/
			
			grabarTodosLosCambiosEnLosArchivos(); // Se graba autom�ticamente
			
			mostrarInformacionDelPagoOUsoDeLaReserva(reserva.getCodigo());
			
			limpiarEntradas();
			
		} else {
			mensaje("C�digo de la reserva a pagar no existe");
		}
	}
	
	void liberarButacasDeReserva(int codigoReserva) {
		for (int i = 0; i < adr.tama�o(); i++) {
			DetalleReserva detalle = adr.obtener(i);
			
			Butaca butaca = arregloButacas.buscar(detalle.getCodigoButaca());
			butaca.setEstado(1); // Se libera la butaca
		}
	}
	
	void eliminarReserva() {
		try {
			int codigoReserva = leerCodigoReserva();
			Reserva reserva = arregloReservas.buscar(codigoReserva);
			
			if (reserva != null) {
				int respuesta = confirmar("�Seguro que desea eliminar al cliente seleccionado?",
						"Seleccionar una opci�n");
						
				if (respuesta == JOptionPane.YES_OPTION) {
					arregloReservas.eliminar(reserva);
					mensaje("Eliminaci�n exitosa");
					listar();
					limpiarEntradas();
					habilitar(false);
					cambios = true; // Variable que permite saber si se realizaron cambios en el array list
				}
			} else {
				mensaje("Error. La reserva no existe");
			}
		} catch (Exception e) {
			mensaje("Error. Debe seleccionar una reserva de la tabla para eliminar");
		}
	}
	
	protected void actionPerformedBtnSeleccionarCliente(ActionEvent e) {
		// Declara y crea el cuadro de di�logo
		DlgListadoClientes dlc = new DlgListadoClientes();
		
		// Centra el cuadro de di�logo
		dlc.setLocationRelativeTo(this);
		
		// Hace visible el cuadro de di�logo
		dlc.setVisible(true);
	}
	
	protected void actionPerformedBtnSeleccionarFuncion(ActionEvent e) {
		
		// Se resetean las variables est�ticas de DlgSeleccionButacas
		DlgSeleccionButacas.asientosTMP.clear();
		DlgSeleccionButacas.costoTotal = 0.0;
		DlgPagoReservas.txtEntradas.setText("0");
		
		// Declara y crea el cuadro de di�logo
		DlgListadoFunciones dlf = new DlgListadoFunciones();
		
		// Centra el cuadro de di�logo
		dlf.setLocationRelativeTo(this);
		
		// Hace visible el cuadro de di�logo
		dlf.setVisible(true);
	}
	
	protected void actionPerformedBtnSeleccionarButacas(ActionEvent e) {
		try {
			// Declara y crea el cuadro de di�logo
			//mensaje("C�digo de funci�n: " + leerCodigoFuncion());
			int codigoFuncion = leerCodigoFuncion();
			DlgSeleccionButacas.codigoReservaActual = leerCodigoReserva();
			
			DlgSeleccionButacas dsb = new DlgSeleccionButacas(codigoFuncion);
			
			// Centra el cuadro de di�logo
			dsb.setLocationRelativeTo(this);
			
			// Hace visible el cuadro de di�logo
			dsb.setVisible(true);
		} catch (Exception e2) {
			e2.printStackTrace();
			mensaje("Para elegir las butacas primero debe elegir una funci�n");
			btnSeleccionarFuncion.requestFocus();
		}
	}
	
	protected void actionPerformedBtnIngresar(ActionEvent e) {		
		int codigoReserva;
		int codigoCliente;
		int codigoEmpleado;
		int codigoFuncion;
		try {
			codigoReserva = leerCodigoReserva();
			codigoCliente = leerCodigoCliente();
			codigoEmpleado = leerCodigoEmpleado();
			codigoFuncion = leerCodigoFuncion();
			
		} catch (Exception e2) {
			mensaje("Hay un error con el c�digo de Reserva | c�digo de Cliente | c�digo de Empleado | c�digo de Funci�n");
			return;
		}
		
		// N�mero de entradas
		int numeroEntradas;
		try {
			numeroEntradas = leerNumeroEntradas();
			if (numeroEntradas <= 0) {
				mensaje("Error. A�n no ha seleccionado por lo menos una entrada (butaca)");
				txtEntradas.setText("");
				btnSeleccionarButacas.requestFocus();
				return;
			}
		} catch (Exception e2) {
			mensaje("Error en el n�mero de entradas");
			txtEntradas.setText("");
			btnSeleccionarButacas.requestFocus();
			return;
		}
		
		// Fecha de la reserva
		String fechaReserva = leerFechaReserva();
		if (fechaReserva.length() == 0) {
			mensaje("Error. Debe ingresar una fecha para la Reserva.");
			txtFechaReserva.setDate(null);
			txtFechaReserva.requestFocus();
			return;
		}
		
		// Hora de la reserva
		String horaReserva = leerHoraReserva();
		if (horaReserva.length() == 0) {
			mensaje("Error. Debe ingresar una hora para la Reserva");
			txtHoraReserva.setText("");
			txtHoraReserva.requestFocus();
			return;
		}
		
		// Estado de la reserva
		int estadoReserva = leerEstadoReserva();
		
		Reserva reserva = new Reserva(codigoReserva, codigoCliente, codigoEmpleado, codigoFuncion, numeroEntradas, fechaReserva, 
				horaReserva, estadoReserva);
		
		// Ingresar
		if (this.accion == INGRESAR) {
			ingresarReserva(reserva);
		
		// Pagar
		} else if (this.accion == PAGAR) {
			//mensaje("Validar que solo sepuede pagar la reserva hasta hasta 30 minutos antes del inicio de la funci�n");
			// VALIDAR
			//if (hora - horaFuncion == 30) {
				int respuesta = confirmar("�Seguro que desea pagar la reserva?");
				if (respuesta == JOptionPane.YES_OPTION) {
					modificarReserva(reserva);
				}
			//} else {
				// mensaje("No se puede pagar la reserva");
				// LAS BUTACAS SON LIBREADAS
			//}
		}
	}
	
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		limpiarEntradas();
		habilitar(false);
	}
	
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		listar(leerClaveBusqueda());
	}
	
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		eliminarReserva();
	}
	
	protected void actionPerformedBtnSalir(ActionEvent e) {
		this.dispose();
	}
	
	public void mouseClicked(MouseEvent e) {
		// Cuando se hace clic en la tabla, se activa la opci�n para modificar
		this.accion = PAGAR;
		
		if (cboEstadoReserva.getSelectedIndex() == 0) {
			cboEstadoReserva.setSelectedIndex(PAGAR_RESERVA);
		}
				
		habilitar(true);
		
		// Se obtiene la fila seleccionada en la tabla
		int fila = tblTabla.getSelectedRow();
		
		// Se obtienen los datos de la tabla en la fila seleccionada
		txtCodigoReserva.setText(tblTabla.getValueAt(fila, 0).toString());
		//int codigoEmpleado = Integer.parseInt(tblTabla.getValueAt(fila, 1).toString());
		int codigoCliente = Integer.parseInt(tblTabla.getValueAt(fila, 2).toString());
		int codigoFuncion = Integer.parseInt(tblTabla.getValueAt(fila, 3).toString());
		
		Cliente cliente = arregloClientes.buscar(codigoCliente);
		txtCliente.setText(cliente.getNombres() + " " + cliente.getApellidoPaterno() + " " + cliente.getApellidoMaterno());
		txtCodigoCliente.setText("" + codigoCliente);
		
		Funcion funcion = arregloFunciones.buscar(codigoFuncion);
		Pelicula pelicula = arregloPeliculas.buscar(funcion.getCodigoPelicula());
		txtFuncion.setText(pelicula.getTituloDistribucion());
		txtCodigoFuncion.setText("" + codigoFuncion);
		
		txtEntradas.setText(tblTabla.getValueAt(fila, 4).toString());
		txtFechaReserva.setDate(LibreriaFechas.stringToDate(tblTabla.getValueAt(fila, 5).toString()));
		txtHoraReserva.setText(tblTabla.getValueAt(fila, 6).toString());
		
		// cboEstadoReserva.setSelectedItem("Reserva cancelada");
		
		// Se deshabilitan los botones que permiten cambiar de Cliente, elegir algunas otros botones seg�n sea el caso
		btnSeleccionarCliente.setEnabled(false);
		
		double costoTotal = obtenerCostoTotalPorReserva(leerCodigoReserva());
		txtCostoTotal.setText("" + costoTotal);
	}
	
	double obtenerCostoTotalPorReserva(int codigoReserva) {
		double costoTotal = 0.0;
		// Se recorre el arreglo de DetalleReservas cuya reserva sea codigoReserva
		for (int i = 0; i < adr.tama�o(); i++) {
			DetalleReserva dr = adr.obtener(i);
			if (dr.getCodigoReserva() == codigoReserva) {
				costoTotal += dr.getPrecioEntrada();
			}
		}
		
		return costoTotal;
	}
	
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == tblTabla) {
			mousePressedTblTabla(e);
		}
	}
	public void mouseReleased(MouseEvent e) {
	}
	
	protected void mousePressedTblTabla(MouseEvent e) {
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtClaveBusquedaCodigoReserva) {
			keyReleasedTxtBuscar(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTxtBuscar(KeyEvent e) {
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
	
	// Actualiza el archivo
	protected void actionPerformedBtnGuardar(ActionEvent e) {
		int respuesta = confirmar("�Seguro que desea actualizar \"" + arregloReservas.getArchivo() + "\"?");
		if (respuesta == JOptionPane.YES_OPTION) {
			grabarTodosLosCambiosEnLosArchivos();
			
		} else {
			mensaje("No se actualiz� \"" + arregloReservas.getArchivo() + "\"");
		}
	}
	
	void grabarTodosLosCambiosEnLosArchivos() {
		arregloReservas.grabarReservas();
		adr.grabarDetalleReservas();
		arregloButacas.grabarButacas();
		//mensaje("Los cambios han sido guardados en los archivos");
	}
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cboEstadoReserva) {
			itemStateChangedCboEstadoReserva(e);
		}
	}

	protected void itemStateChangedCboEstadoReserva(ItemEvent e) {
		
		accionPrincipal = cboEstadoReserva.getSelectedIndex();
		
		switch (cboEstadoReserva.getSelectedIndex()) {
		
			case 0: // Reservada
				cboEstadoReserva.setSelectedIndex(2);
				break;
				
			case 1: // Reserva usada
				lblPagoDeEntradas.setText("USAR RESERVAS");
				btnPagar.setText("Usar");
				break;
				
			case 2: // Reserva cancelada
				lblPagoDeEntradas.setText("PAGO DE RESERVAS");
				btnPagar.setText("Pagar");
				break;
				
			default:	// Reserva caducada
				lblPagoDeEntradas.setText("CADUCAR RESERVAS");
				btnPagar.setText("Caducar");
		}
	}
}
