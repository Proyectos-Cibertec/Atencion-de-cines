package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
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
		setTitle("Sistema de Atenci\u00F3n de Cines");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		mntmEmpleado = new JMenuItem("Empleados");
		mntmEmpleado.addActionListener(this);
		mnMantenimiento.add(mntmEmpleado);
		
		mntmClientes = new JMenuItem("Clientes");
		mntmClientes.addActionListener(this);
		mnMantenimiento.add(mntmClientes);
		
		mntmCines = new JMenuItem("Cines");
		mntmCines.addActionListener(this);
		mnMantenimiento.add(mntmCines);
		
		mntmSalas = new JMenuItem("Salas");
		mntmSalas.addActionListener(this);
		mnMantenimiento.add(mntmSalas);
		
		mntmPelculas = new JMenuItem("Pel\u00EDculas");
		mntmPelculas.addActionListener(this);
		mnMantenimiento.add(mntmPelculas);
		
		mntmFunciones = new JMenuItem("Funciones");
		mntmFunciones.addActionListener(this);
		mnMantenimiento.add(mntmFunciones);
		
		mnReserva = new JMenu("Reserva");
		menuBar.add(mnReserva);
		
		mnPago = new JMenu("Pago");
		menuBar.add(mnPago);
		
		mnReportes = new JMenu("Reportes");
		menuBar.add(mnReportes);
		
		mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		mntmManualDelUsuario = new JMenuItem("Manual del usuario");
		mnAyuda.add(mntmManualDelUsuario);
		
		mntmAcercaDeAtencin = new JMenuItem("Acerca de Atenci\u00F3n de Cines");
		mnAyuda.add(mntmAcercaDeAtencin);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	public void actionPerformed(ActionEvent e) {
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
		dme.setLocationRelativeTo(this);
		dme.setVisible(true);
	}
	
	protected void actionPerformedMntmClientes(ActionEvent e) {
		DlgMantenimientoCliente dmc = new DlgMantenimientoCliente();
		dmc.setLocationRelativeTo(this);
		dmc.setVisible(true);
	}
	
	protected void actionPerformedMntmCines(ActionEvent e) {
		DlgMantenimientoCine dmc = new DlgMantenimientoCine();
		dmc.setLocationRelativeTo(this);
		dmc.setVisible(true);
	}
	
	protected void actionPerformedMntmSalas(ActionEvent e) {
		DlgMantenimientoSala dms = new DlgMantenimientoSala();
		dms.setLocationRelativeTo(this);
		dms.setVisible(true);
	}
	
	protected void actionPerformedMntmPelculas(ActionEvent e) {
		DlgMantenimientoPelicula dmp = new DlgMantenimientoPelicula();
		dmp.setLocationRelativeTo(this);
		dmp.setVisible(true);
	}
	
	protected void actionPerformedMntmFunciones(ActionEvent e) {
		DlgMantenimientoFuncion dmf = new DlgMantenimientoFuncion();
		dmf.setLocationRelativeTo(this);
		dmf.setVisible(true);
	}
}
