package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JDesktopPane;
import java.awt.CardLayout;
import java.awt.Frame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;

public class MenuPrincipal extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenuItem mntmSalir;
	private JMenu mnMantenimiento;
	private JMenu mnReserva;
	private JMenu mnPago;
	private JMenu mnReportes;
	private JMenu mnAyuda;
	private JMenuItem mntmManualDelUsuario;
	private JMenuItem mntmAcercaDeAtencin;
	private JMenuItem mntmEmpleado;
	private JMenuItem mntmClientes;
	private JMenuItem mntmCines;
	private JMenuItem mntmSalas;
	private JMenuItem mntmPelculas;
	private JMenuItem mntmFunciones;
	private JMenuItem mntmReservaDeButaca;
	private JMenuItem mntmReporte1;
	private JMenuItem mntmReporte2;
	private JMenuItem mntmReporte3;
	private JMenuItem mntmReporte4;
	private JMenuItem mntmPagoDeReservas;
	private JDesktopPane escritorio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setTitle("Sistema de Atenci\u00F3n de Cines");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 869, 626);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		mnArchivo.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/itemArchivo.png")));
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/itemSalir.png")));
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/itemMantenimiento2.png")));
		mnMantenimiento.setHorizontalAlignment(SwingConstants.LEFT);
		menuBar.add(mnMantenimiento);
		
		mntmEmpleado = new JMenuItem("Empleados");
		mntmEmpleado.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/itemEmpleado.png")));
		mntmEmpleado.addActionListener(this);
		mnMantenimiento.add(mntmEmpleado);
		
		mntmClientes = new JMenuItem("Clientes");
		mntmClientes.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/itemCliente.png")));
		mntmClientes.addActionListener(this);
		mnMantenimiento.add(mntmClientes);
		
		mntmCines = new JMenuItem("Cines");
		mntmCines.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/itemCine.png")));
		mntmCines.addActionListener(this);
		mnMantenimiento.add(mntmCines);
		
		mntmSalas = new JMenuItem("Salas");
		mntmSalas.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/itemSala.png")));
		mntmSalas.addActionListener(this);
		mnMantenimiento.add(mntmSalas);
		
		mntmPelculas = new JMenuItem("Pel\u00EDculas");
		mntmPelculas.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/itemPelicula.png")));
		mntmPelculas.addActionListener(this);
		mnMantenimiento.add(mntmPelculas);
		
		mntmFunciones = new JMenuItem("Funciones");
		mntmFunciones.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/itemFuncion.png")));
		mntmFunciones.addActionListener(this);
		mnMantenimiento.add(mntmFunciones);
		
		mnReserva = new JMenu("Reservas");
		mnReserva.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/itemTicket.png")));
		menuBar.add(mnReserva);
		
		mntmReservaDeButaca = new JMenuItem("Reserva de butacas");
		mntmReservaDeButaca.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/itemButaca.png")));
		mntmReservaDeButaca.addActionListener(this);
		mnReserva.add(mntmReservaDeButaca);
		
		mnPago = new JMenu("Pagos");
		mnPago.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/itemVender.png")));
		menuBar.add(mnPago);
		
		mntmPagoDeReservas = new JMenuItem("Pago de Reservas");
		mntmPagoDeReservas.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/itemPago.png")));
		mntmPagoDeReservas.addActionListener(this);
		mnPago.add(mntmPagoDeReservas);
		
		mnReportes = new JMenu("Reportes");
		mnReportes.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/itemGenerarReporte.png")));
		menuBar.add(mnReportes);
		
		mntmReporte1 = new JMenuItem("Reporte 1");
		mntmReporte1.addActionListener(this);
		mnReportes.add(mntmReporte1);
		
		mntmReporte2 = new JMenuItem("Reporte 2");
		mntmReporte2.addActionListener(this);
		mnReportes.add(mntmReporte2);
		
		mntmReporte3 = new JMenuItem("Reporte  3");
		mntmReporte3.addActionListener(this);
		mnReportes.add(mntmReporte3);
		
		mntmReporte4 = new JMenuItem("Reporte 4");
		mntmReporte4.addActionListener(this);
		mnReportes.add(mntmReporte4);
		
		mntmReporte5 = new JMenuItem("Reporte 5");
		mntmReporte5.addActionListener(this);
		mnReportes.add(mntmReporte5);
		
		mntmReporte6 = new JMenuItem("Reporte 6");
		mntmReporte6.addActionListener(this);
		mnReportes.add(mntmReporte6);
		
		mntmReporte7 = new JMenuItem("Reporte 7");
		mntmReporte7.addActionListener(this);
		mnReportes.add(mntmReporte7);
		
		mnAyuda = new JMenu("Ayuda");
		mnAyuda.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/itemAyuda.png")));
		menuBar.add(mnAyuda);
		
		mntmManualDelUsuario = new JMenuItem("Manual del usuario");
		mntmManualDelUsuario.addActionListener(this);
		mntmManualDelUsuario.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/itemManualUsuario.png")));
		mnAyuda.add(mntmManualDelUsuario);
		
		mntmAcercaDeAtencin = new JMenuItem("Acerca de Atenci\u00F3n de Cines");
		mntmAcercaDeAtencin.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/itemAbout.png")));
		mntmAcercaDeAtencin.addActionListener(this);
		mnAyuda.add(mntmAcercaDeAtencin);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		escritorio = new JDesktopPane();
		contentPane.add(escritorio, "name_58280710821134");
		
		lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCodigo.setForeground(Color.BLACK);
		lblCodigo.setBounds(779, 0, 225, 37);
		escritorio.add(lblCodigo);
		
		lblNombres = new JLabel("Nombres");
		lblNombres.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNombres.setForeground(Color.BLACK);
		lblNombres.setBounds(779, 33, 225, 38);
		escritorio.add(lblNombres);
		
		lblApellidos = new JLabel("Apelidos");
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblApellidos.setForeground(Color.BLACK);
		lblApellidos.setBounds(779, 70, 225, 39);
		escritorio.add(lblApellidos);
		
		lblTipoEmpleado = new JLabel("Tipo de empleado");
		lblTipoEmpleado.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTipoEmpleado.setForeground(Color.BLACK);
		lblTipoEmpleado.setBounds(779, 119, 225, 38);
		escritorio.add(lblTipoEmpleado);
		
		lblCodigo_2 = new JLabel("C\u00F3digo");
		lblCodigo_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCodigo_2.setForeground(Color.RED);
		lblCodigo_2.setBounds(546, 5, 83, 26);
		escritorio.add(lblCodigo_2);
		
		lblNombres_1 = new JLabel("Nombres");
		lblNombres_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNombres_1.setForeground(Color.RED);
		lblNombres_1.setBounds(546, 45, 83, 14);
		escritorio.add(lblNombres_1);
		
		lblApellidos_1 = new JLabel("Apellidos");
		lblApellidos_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblApellidos_1.setForeground(Color.RED);
		lblApellidos_1.setBounds(546, 82, 83, 14);
		escritorio.add(lblApellidos_1);
		
		lblTipo_2 = new JLabel("Privilegio");
		lblTipo_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTipo_2.setForeground(Color.RED);
		lblTipo_2.setBounds(546, 125, 83, 26);
		escritorio.add(lblTipo_2);
		
		lblFondoCine = new JLabel("New label");
		lblFondoCine.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/fondoCinema.png")));
		lblFondoCine.setBounds(0, 0, 1348, 684);
		escritorio.add(lblFondoCine);
		
		configurarPrivilegios();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmManualDelUsuario) {
			actionPerformedMntmManualDelUsuario(e);
		}
		if (e.getSource() == mntmAcercaDeAtencin) {
			actionPerformedMntmAcercaDeAtencin(e);
		}
		if (e.getSource() == mntmReporte7) {
			actionPerformedMntmReporte7(e);
		}
		if (e.getSource() == mntmReporte6) {
			actionPerformedMntmReporte6(e);
		}
		if (e.getSource() == mntmReporte5) {
			actionPerformedMntmReporte5(e);
		}
		if (e.getSource() == mntmPagoDeReservas) {
			actionPerformedMntmPagoDeReservas(e);
		}
		if (e.getSource() == mntmReporte4) {
			actionPerformedMntmReporte_3(e);
		}
		if (e.getSource() == mntmReporte3) {
			actionPerformedMntmReporte_2(e);
		}
		if (e.getSource() == mntmReporte2) {
			actionPerformedMntmReporte_1(e);
		}
		if (e.getSource() == mntmReporte1) {
			actionPerformedMntmReporte(e);
		}
		if (e.getSource() == mntmReservaDeButaca) {
			actionPerformedMntmReservaDeButaca(e);
		}
		if (e.getSource() == mntmFunciones) {
			actionPerformedMntmFunciones(e);
		}
		if (e.getSource() == mntmPelculas) {
			actionPerformedMntmPelculas(e);
		}
		if (e.getSource() == mntmSalas) {
			actionPerformedMntmSalas(e);
		}
		if (e.getSource() == mntmCines) {
			actionPerformedMntmCines(e);
		}
		if (e.getSource() == mntmClientes) {
			actionPerformedMntmClientes(e);
		}
		if (e.getSource() == mntmEmpleado) {
			actionPerformedMntmEmpleados(e);
		}
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
		}
	}
	
	/**************** VARIABLES GLOBALES *****************/
	// Tipos de usuarios y sus privilegios
	public static final int ADMINISTRADOR = 0;
	public static final int SUPERVISOR = 1;
	public static final int CAJERO = 2;
	
	// Variable que almacena el tipo de privilegio del empleado que está haciendo uso del sistema
	public static int tipoPrivilegio;
	public static JLabel lblCodigo;
	public static JLabel lblNombres;
	public static JLabel lblApellidos;
	public static JLabel lblTipoEmpleado;
	private JLabel lblCodigo_2;
	private JLabel lblNombres_1;
	private JLabel lblApellidos_1;
	private JLabel lblTipo_2;
	private JMenuItem mntmReporte5;
	private JMenuItem mntmReporte6;
	private JMenuItem mntmReporte7;
	private JLabel lblFondoCine;
		
	// Procesa la pulsación del menú item Salir
	protected void actionPerformedMntmSalir(ActionEvent e) {
		// Pide la confirmación al usuario para cerrar el programa
		int respuesta = JOptionPane.showConfirmDialog(this, "¿Seguro que desea salir del programa?",
				"Seleccionar una opción", JOptionPane.YES_NO_OPTION);
				
		if (respuesta == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	protected void actionPerformedMntmEmpleados(ActionEvent e) {
		DlgMantenimientoEmpleado dme = new DlgMantenimientoEmpleado();
		this.escritorio.add(dme);
		dme.toFront();
		centrarInternalFrame(dme);
		dme.setVisible(true);
	}
	
	protected void actionPerformedMntmClientes(ActionEvent e) {
		DlgMantenimientoCliente dmc = new DlgMantenimientoCliente();
		this.escritorio.add(dmc);
		dmc.toFront();
		centrarInternalFrame(dmc);
		dmc.setVisible(true);
	}
	
	protected void actionPerformedMntmCines(ActionEvent e) {
		DlgMantenimientoCine dmc = new DlgMantenimientoCine();
		this.escritorio.add(dmc);
		dmc.toFront();
		centrarInternalFrame(dmc);
		dmc.setVisible(true);
	}
	
	protected void actionPerformedMntmSalas(ActionEvent e) {
		DlgMantenimientoSala dms = new DlgMantenimientoSala();
		this.escritorio.add(dms);
		dms.toFront();
		centrarInternalFrame(dms);
		dms.setVisible(true);
	}
	
	protected void actionPerformedMntmPelculas(ActionEvent e) {
		DlgMantenimientoPelicula dmp = new DlgMantenimientoPelicula();
		this.escritorio.add(dmp);
		dmp.toFront();
		centrarInternalFrame(dmp);
		dmp.setVisible(true);
	}
	
	protected void actionPerformedMntmFunciones(ActionEvent e) {
		DlgMantenimientoFuncion dmf = new DlgMantenimientoFuncion();
		this.escritorio.add(dmf);
		dmf.toFront();
		centrarInternalFrame(dmf);
		dmf.setVisible(true);
	}
	
	protected void actionPerformedMntmReservaDeButaca(ActionEvent e) {
		// Se asignan los datos del empleado actual en la ventana de Reservas
		DlgReservaEntradas dr = new DlgReservaEntradas();
		DlgReservaEntradas.txtCodigoEmpleado.setText(lblCodigo.getText());
		DlgReservaEntradas.txtEmpleado.setText(String.format("%s %s", lblNombres.getText(), lblApellidos.getText()));
		this.escritorio.add(dr);
		dr.toFront();
		centrarInternalFrame(dr);
		dr.setVisible(true);
	}
	
	protected void actionPerformedMntmReporte(ActionEvent e) {
		// Declara y crea el cuadro de diálogo
		Reporte1 reporte1 = new Reporte1();
		
		// Centra el cuadro de diálogo
		reporte1.setLocationRelativeTo(this);
		
		// Hace visible el cuadro de diálogo
		reporte1.setVisible(true);
	}
	
	protected void actionPerformedMntmReporte_1(ActionEvent e) {
		// Declara y crea el cuadro de diálogo
		Reporte2 reporte2 = new Reporte2();
		
		// Centra el cuadro de diálogo
		reporte2.setLocationRelativeTo(this);
		
		// Hace visible el cuadro de diálogo
		reporte2.setVisible(true);
	}
	
	protected void actionPerformedMntmReporte_2(ActionEvent e) {
		// Declara y crea el cuadro de diálogo
		Reporte3 reporte3 = new Reporte3();
		
		// Centra el cuadro de diálogo
		reporte3.setLocationRelativeTo(this);
		
		// Hace visible el cuadro de diálogo
		reporte3.setVisible(true);
	}
	protected void actionPerformedMntmReporte_3(ActionEvent e) {
		// Declara y crea el cuadro de diálogo
		Reporte4 reporte4 = new Reporte4();
		
		// Centra el cuadro de diálogo
		reporte4.setLocationRelativeTo(this);
		
		// Hace visible el cuadro de diálogo
		reporte4.setVisible(true);
	}
	
	protected void actionPerformedMntmPagoDeReservas(ActionEvent e) {
		// Se asignan los datos del empleado actual en la ventana de Reservas
		DlgPagoReservas dr = new DlgPagoReservas(2); // 2 = Accion Principal: pagar
		DlgPagoReservas.txtCodigoEmpleado.setText(lblCodigo.getText());
		DlgPagoReservas.txtEmpleado.setText(String.format("%s %s", lblNombres.getText(), lblApellidos.getText()));
		this.escritorio.add(dr);
		dr.toFront();
		centrarInternalFrame(dr);
		dr.setVisible(true);
	}
	
	// Deshabilita ciertos menús o menú items, de acuerdo al privilegio del usuario que inicia sesión
	void configurarPrivilegios() {
		switch (MenuPrincipal.tipoPrivilegio) {
			case MenuPrincipal.ADMINISTRADOR:
				// Acceso a todo
				break;
				
			case MenuPrincipal.SUPERVISOR:				
				// Se desactiva todo el módulo de mantenimiento excepto el de Clientes para poder registrar en caso que se realice una reserva
				mntmEmpleado.setEnabled(false);
				mntmCines.setEnabled(false);
				mntmSalas.setEnabled(false);
				mntmFunciones.setEnabled(false);
				mntmPelculas.setEnabled(false);
				break;
				
			case MenuPrincipal.CAJERO:
				// Se desactivan los reportes
				mnReportes.setEnabled(false);
				
				// Se desactiva todo el módulo de mantenimiento excepto el de Clientes para poder registrar en caso que se realice una reserva
				mntmEmpleado.setEnabled(false);
				mntmCines.setEnabled(false);
				mntmSalas.setEnabled(false);
				mntmFunciones.setEnabled(false);
				mntmPelculas.setEnabled(false);
				
				
				break;
		}
	}
	
	// Centra el internal frame
	void centrarInternalFrame(JInternalFrame frame) {
		/*Dimension desktopSize = this.escritorio.getSize();
		Dimension frameSize = frame.getSize();
		frame.setLocation((desktopSize.width - frameSize.width)/2, (desktopSize.height- frameSize.height)/2);*/
	}
	
	protected void actionPerformedMntmReporte5(ActionEvent e) {
		// Declara y crea el cuadro de diálogo
		ReservasxFecha_Reporte2 reporte = new ReservasxFecha_Reporte2();
				
		// Centra el cuadro de diálogo
		reporte.setLocationRelativeTo(this);
				
		// Hace visible el cuadro de diálogo
		reporte.setVisible(true);
	}
	
	protected void actionPerformedMntmReporte6(ActionEvent e) {
		// Declara y crea el cuadro de diálogo
		ReservasxFechayEmpleado_Reporte3 reporte = new ReservasxFechayEmpleado_Reporte3();
				
		// Centra el cuadro de diálogo
		reporte.setLocationRelativeTo(this);
				
		// Hace visible el cuadro de diálogo
		reporte.setVisible(true);
	}
	
	protected void actionPerformedMntmReporte7(ActionEvent e) {
		// Declara y crea el cuadro de diálogo
		ReservasxFechayCliente_Reporte4 reporte = new ReservasxFechayCliente_Reporte4();
				
		// Centra el cuadro de diálogo
		reporte.setLocationRelativeTo(this);
				
		// Hace visible el cuadro de diálogo
		reporte.setVisible(true);
	}
	
	protected void actionPerformedMntmAcercaDeAtencin(ActionEvent e) {
		// Declara y crea el cuadro de diálogo
		DialogoAcercaDe reporte = new DialogoAcercaDe();
		
						
		// Centra el cuadro de diálogo
		reporte.setLocationRelativeTo(this);
				
		// Hace visible el cuadro de diálogo
		reporte.setVisible(true);
	}
	
	protected void actionPerformedMntmManualDelUsuario(ActionEvent e) {
		try {
		    Desktop.getDesktop().browse(new URL("https://drive.google.com/file/d/0B5PJu2VRH1WzcHlIRVJqa21sY2s/view?usp=sharing").toURI());
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
}
