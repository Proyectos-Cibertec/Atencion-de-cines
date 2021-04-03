package gui;

import java.awt.EventQueue;

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
import arreglos.ArregloFunciones;
import arreglos.ArregloPeliculas;
import arreglos.ArregloReservas;
import arreglos.ArregloSalas;
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
import javax.swing.ImageIcon;
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

public class DlgReservaEntradas extends JInternalFrame implements ActionListener, MouseListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelRegistro;
	private JPanel panelListado;
	private JLabel lblReservas;
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
	private JButton btnNuevo;
	private JButton btnIngresar;
	private JButton btnCancelar;
	private JLabel lblBuscar;
	private JTextField txtClaveBusquedaCodigoReserva;
	private JButton btnBuscar;
	private JButton btnSalir;
	private JScrollPane scrollPane;
	private JTable tblTabla;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgReservaEntradas frame = new DlgReservaEntradas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DlgReservaEntradas() {
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
		
		lblEstado = new JLabel("Estado");
		lblEstado.setVisible(false);
		lblEstado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEstado.setBounds(10, 346, 68, 14);
		panelRegistro.add(lblEstado);
		
		cboEstadoReserva = new JComboBox<String>();
		cboEstadoReserva.setVisible(false);
		cboEstadoReserva.setEnabled(false);
		cboEstadoReserva.setModel(new DefaultComboBoxModel<String>(new String[] {"Reservada", "Reserva usada", "Reserva cancelada", "Reserva caducada"}));
		cboEstadoReserva.setBounds(104, 343, 128, 20);
		panelRegistro.add(cboEstadoReserva);
		
		btnSeleccionarButacas = new JButton("Seleccionar butacas");
		btnSeleccionarButacas.setEnabled(false);
		btnSeleccionarButacas.addActionListener(this);
		btnSeleccionarButacas.setBounds(242, 178, 167, 23);
		panelRegistro.add(btnSeleccionarButacas);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setIcon(new ImageIcon(DlgReservaEntradas.class.getResource("/img/btnNuevo.png")));
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(84, 392, 117, 41);
		panelRegistro.add(btnNuevo);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setIcon(new ImageIcon(DlgReservaEntradas.class.getResource("/img/btnIngresar.png")));
		btnIngresar.setEnabled(false);
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(224, 392, 111, 41);
		panelRegistro.add(btnIngresar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setEnabled(false);
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(359, 392, 111, 41);
		panelRegistro.add(btnCancelar);
		
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
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(310, 11, 89, 37);
		panelListado.add(btnBuscar);
		
		btnSalir = new JButton("");
		btnSalir.addActionListener(this);
		btnSalir.setBounds(548, 11, 103, 37);
		panelListado.add(btnSalir);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 66, 696, 350);
		panelListado.add(scrollPane);
		
		tblTabla = new JTable();
		tblTabla.addMouseListener(this);
		tblTabla.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblTabla);
		
		lblReservas = new JLabel("RESERVA DE ENTRADAS");
		lblReservas.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblReservas.setBounds(10, 5, 239, 20);
		getContentPane().add(lblReservas);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Código de Reserva");
		modelo.addColumn("Empleado");
		modelo.addColumn("Cliente");
		modelo.addColumn("Código de Función");
		modelo.addColumn("Entradas"); // Nro de Entradas
		modelo.addColumn("Fecha"); // Fecha de la función
		modelo.addColumn("Hora"); // Hora de la función
		modelo.addColumn("Estado");
		
		tblTabla.setModel(modelo);
		
		btnGrabar = new JButton("");
		btnGrabar.setIcon(new ImageIcon(DlgReservaEntradas.class.getResource("/img/btnGrabar.png")));
		btnGrabar.setBounds(419, 11, 103, 37);
		panelListado.add(btnGrabar);
		btnGrabar.addActionListener(this);
		
		//btnPagar.setIcon(new ImageIcon(DlgPagoReservas.class.getResource("/img/btnPagar.png")));
		btnCancelar.setIcon(new ImageIcon(DlgPagoReservas.class.getResource("/img/btnCancelar.png")));
		btnBuscar.setIcon(new ImageIcon(DlgPagoReservas.class.getResource("/img/btnBuscar.png")));
		//btnEliminar.setIcon(new ImageIcon(DlgPagoReservas.class.getResource("/img/btnEliminar.png")));

		btnSalir.setIcon(new ImageIcon(DlgPagoReservas.class.getResource("/img/btnSalir.png")));
		btnSalir.setIcon(new ImageIcon(DlgPagoReservas.class.getResource("/img/btnSalir.png")));
		
		lblTotalRegistros = new JLabel("Total registros: ");
		lblTotalRegistros.setBounds(881, 470, 150, 14);
		getContentPane().add(lblTotalRegistros);
		listar();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGrabar) {
			actionPerformedBtnGuardar(e);
		}
		if (e.getSource() == btnSalir) {
			actionPerformedBtnSalir(e);
		}
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(e);
		}
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
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
	
	// Declaración Global
	ArregloReservas arregloReservas = new ArregloReservas("reservas.txt");
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
	private JButton btnGrabar;
	public static JTextField txtCodigoCliente;
	public static JTextField txtCodigoFuncion;
	public static JTextField txtCodigoEmpleado;
	private JLabel lblCosto;
	public static JTextField txtCostoTotal;
	
	// Lista las reservas en la tabla
	void listar() {
		totalRegistros = 0;
		modelo.setRowCount(0);
		Reserva reserva = null;
		for (int i = 0; i < arregloReservas.tamaño(); i++) {
			reserva = arregloReservas.obtener(i);
			Object[] fila = {
					reserva.getCodigo(),
					reserva.getCodigoCliente(),
					reserva.getCodigoEmpleado(),
					reserva.getCodigoFuncion(),
					reserva.getNumeroEntradas(),
					reserva.getFechaReserva(),
					reserva.getHoraReserva(),
					reserva.getEstadoDescripcion()
					};
			modelo.addRow(fila);
			totalRegistros++;
		}
		
		lblTotalRegistros.setText("Total registros: " + totalRegistros);
	}
	
	// Método sobrecargado listar que realiza la búsqueda de las reservas por código y la muestra en la tabla de resultados
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
					for (int i = 0; i < arregloReservas.tamaño(); i++) {
						reserva = arregloReservas.obtener(i);
						if (reserva.getCodigo() == codigoReserva) {
							Object[] fila = {
									reserva.getCodigo(),
									reserva.getCodigoCliente(),
									reserva.getCodigoEmpleado(),
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
					mensaje("El código de Reserva ingresado no puede ser negativo");
					txtClaveBusquedaCodigoReserva.setText("");
					listar(); // Muestra todo y no un dato en específico
					txtClaveBusquedaCodigoReserva.requestFocus();
				}
			} catch (Exception e) {
				mensaje("Ingrese un código de Reserva válido a buscar");
				txtClaveBusquedaCodigoReserva.setText("");
				listar(); // Muestra todo y no un dato en específico
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
        
        btnIngresar.setEnabled(valor);
        btnCancelar.setEnabled(valor);
	}
	
	// Limpia los cuadros de texto
	void limpiarEntradas() {
		txtCliente.setText("");
		txtFuncion.setText("");
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
		
		grabarTodosLosCambiosEnLosArchivos(); // Se graba automáticamente
		
		mostrarInformacionCompletaDeLaReservaEfectuada(reserva.getCodigo());
		
		limpiarEntradas();
	}
	
	// Muestra información acerca de la reserva cuyo código se le pasa como argumento
	void mostrarInformacionCompletaDeLaReservaEfectuada(int codigoReserva) {
		DlgReservaInfo.txtS.setText("");
		Reserva reserva = arregloReservas.buscar(codigoReserva);
		Cliente cliente = arregloClientes.buscar(reserva.getCodigoCliente());
		Funcion funcion = arregloFunciones.buscar(reserva.getCodigoFuncion());
		Pelicula pelicula = arregloPeliculas.buscar(funcion.getCodigoPelicula());
		Cine cine = arregloCines.buscar(funcion.getCodigoPelicula());
		//Sala sala = arregloSalas.buscar(funcion.getCodigoSala());
		
		imprimir("Código de la reserva: " + codigoReserva);
		imprimir("Fecha de la reserva: " + reserva.getFechaReserva());
		imprimir("Hora de la reserva: " + reserva.getHoraReserva());
		imprimir("---------------------------------------------------");
		
		imprimir("Código del cliente: " + cliente.getCodigo());
		imprimir("CLIENTE: " + cliente.getApellidoPaterno() + " " + cliente.getApellidoMaterno() + ", " + cliente.getNombres());
		imprimir("---------------------------------------------------");
		
		imprimir("Código de cine: " + cine.getCodigo());
		imprimir("CINE: " + cine.getNombre());
		imprimir("LUGAR: " + cine.getDistrito() + ", " + cine.getProvincia() + ", " + cine.getDepartamento());
		imprimir("---------------------------------------------------");
		
		imprimir("Código de película: " + pelicula.getCodigo());
		imprimir("Película: " + pelicula.getTituloDistribucion());
		imprimir("Proyección: " + pelicula.getTipoProyeccionDescripcion());
		imprimir("Género: " + pelicula.getGenero());
		imprimir("---------------------------------------------------");
		
		imprimir("Código de Función: " + funcion.getCodigo());
		imprimir("HORA y FECHA: " + funcion.getFechaFuncion() + " " + funcion.getHoraFuncion());
		imprimir("---------------------------------------------------");
		
		imprimir("# de entradas: " + DlgReservaEntradas.txtEntradas.getText());
		imprimir("Costo total: " + DlgReservaEntradas.txtCostoTotal.getText());
		
		// Declara y crea el cuadro de diálogo
		DlgReservaInfo dri = new DlgReservaInfo();
				
		// Centra el cuadro de diálogo
		dri.setLocationRelativeTo(this);
				
		// Hace visible el cuadro de diálogo
		dri.setVisible(true);
	}
	
	void imprimir(String cadena) {
		DlgReservaInfo.txtS.append(cadena + "\n");
	}
	
	void imprimir() {
		imprimir("");
	}
	
	// Genera un detalleReserva para cada asiento elegido en la venta de Selección de butacas
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
			limpiarEntradas();
			habilitar(false);
			btnSeleccionarCliente.requestFocus();
			mensaje("Modificación exitosa");
			cambios = true; // Variable que permite saber si se realizaron cambios en el array list
			
		} else {
			mensaje("Código de la reserva a editar no existe");
		}
	}
	
	void eliminarReserva() {
		try {
			int codigoReserva = leerCodigoReserva();
			Reserva reserva = arregloReservas.buscar(codigoReserva);
			
			if (reserva != null) {
				int respuesta = confirmar("¿Seguro que desea eliminar al cliente seleccionado?",
						"Seleccionar una opción");
						
				if (respuesta == JOptionPane.YES_OPTION) {
					arregloReservas.eliminar(reserva);
					mensaje("Eliminación exitosa");
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
		// Declara y crea el cuadro de diálogo
		DlgListadoClientes dlc = new DlgListadoClientes();
		
		// Centra el cuadro de diálogo
		dlc.setLocationRelativeTo(this);
		
		// Hace visible el cuadro de diálogo
		dlc.setVisible(true);
	}
	
	protected void actionPerformedBtnSeleccionarFuncion(ActionEvent e) {
		
		// Se resetean las variables estáticas de DlgSeleccionButacas
		DlgSeleccionButacas.asientosTMP.clear();
		DlgSeleccionButacas.costoTotal = 0.0;
		DlgReservaEntradas.txtEntradas.setText("0");
		
		// Declara y crea el cuadro de diálogo
		DlgListadoFunciones dlf = new DlgListadoFunciones();
		
		// Centra el cuadro de diálogo
		dlf.setLocationRelativeTo(this);
		
		// Hace visible el cuadro de diálogo
		dlf.setVisible(true);
	}
	
	protected void actionPerformedBtnSeleccionarButacas(ActionEvent e) {
		try {
			// Declara y crea el cuadro de diálogo
			//mensaje("Código de función: " + leerCodigoFuncion());
			int codigoFuncion = leerCodigoFuncion();
			DlgSeleccionButacas.codigoReservaActual = leerCodigoReserva();
			
			DlgSeleccionButacas dsb = new DlgSeleccionButacas(codigoFuncion);
			
			// Centra el cuadro de diálogo
			dsb.setLocationRelativeTo(this);
			
			// Hace visible el cuadro de diálogo
			dsb.setVisible(true);
		} catch (Exception e2) {
			e2.printStackTrace();
			mensaje("Para elegir las butacas primero debe elegir una función");
			btnSeleccionarFuncion.requestFocus();
		}
	}
	
	protected void actionPerformedBtnNuevo(ActionEvent e) {
		this.limpiarEntradas();
		txtCodigoReserva.setText("" + arregloReservas.codigoCorrelativo());
		this.habilitar(true);
		this.btnIngresar.setText("Ingresar");
		this.accion = INGRESAR;
		
		limpiarEntradas();
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
			mensaje("Hay un error con el código de Reserva | código de Cliente | código de Empleado | código de Función");
			return;
		}
		
		// Número de entradas
		int numeroEntradas;
		try {
			numeroEntradas = leerNumeroEntradas();
			if (numeroEntradas <= 0) {
				mensaje("Error. Aún no ha seleccionado por lo menos una entrada (butaca)");
				txtEntradas.setText("");
				btnSeleccionarButacas.requestFocus();
				return;
			}
		} catch (Exception e2) {
			mensaje("Error en el número de entradas");
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
		}
	}
	
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		limpiarEntradas();
		habilitar(false);
	}
	
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		listar(leerClaveBusqueda());
	}
	
	protected void actionPerformedBtnSalir(ActionEvent e) {
		this.dispose();
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
	
	// Actualiza el archivo
	protected void actionPerformedBtnGuardar(ActionEvent e) {
		int respuesta = confirmar("¿Seguro que desea actualizar \"" + arregloReservas.getArchivo() + "\"?");
		if (respuesta == JOptionPane.YES_OPTION) {
			grabarTodosLosCambiosEnLosArchivos();
			
		} else {
			mensaje("No se actualizó \"" + arregloReservas.getArchivo() + "\"");
		}
	}
	
	void grabarTodosLosCambiosEnLosArchivos() {
		arregloReservas.grabarReservas();
		adr.grabarDetalleReservas();
		arregloButacas.grabarButacas();
		//mensaje("Los cambios han sido guardados en los archivos");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
