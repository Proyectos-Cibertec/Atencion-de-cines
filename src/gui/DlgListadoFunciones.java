package gui;

import java.awt.EventQueue;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import arreglos.ArregloCines;
import arreglos.ArregloFunciones;
import arreglos.ArregloPeliculas;
import arreglos.ArregloSalas;
import clases.Funcion;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.ImageIcon;

public class DlgListadoFunciones extends JDialog implements ActionListener, MouseListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelListado;
	private JLabel lblBuscar;
	private JTextField txtClaveBusqueda;
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
					DlgListadoFunciones dialog = new DlgListadoFunciones();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DlgListadoFunciones() {
		setModal(true);
		setTitle("Funciones");
		setBounds(100, 100, 882, 642);
		getContentPane().setLayout(null);
		
		panelListado = new JPanel();
		panelListado.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Listado de Funciones", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelListado.setBounds(10, 11, 847, 555);
		getContentPane().add(panelListado);
		panelListado.setLayout(null);
		
		lblBuscar = new JLabel("Buscar por c\u00F3digo");
		lblBuscar.setBounds(10, 29, 131, 14);
		panelListado.add(lblBuscar);
		
		txtClaveBusqueda = new JTextField();
		txtClaveBusqueda.addKeyListener(this);
		txtClaveBusqueda.setBounds(151, 26, 176, 20);
		panelListado.add(txtClaveBusqueda);
		txtClaveBusqueda.setColumns(10);
		
		btnBuscar = new JButton("");
		btnBuscar.setIcon(new ImageIcon(DlgListadoFunciones.class.getResource("/img/btnBuscar.png")));
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(546, 11, 89, 37);
		panelListado.add(btnBuscar);
		
		btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon(DlgListadoFunciones.class.getResource("/img/btnSalir2.png")));
		btnSalir.addActionListener(this);
		btnSalir.setBounds(645, 11, 89, 37);
		panelListado.add(btnSalir);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 66, 823, 478);
		panelListado.add(scrollPane);
		
		tblTabla = new JTable();
		tblTabla.addMouseListener(this);
		tblTabla.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblTabla);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Código");
		modelo.addColumn("Cine");
		modelo.addColumn("Sala");
		modelo.addColumn("Película");
		modelo.addColumn("Fecha de la función");
		modelo.addColumn("Hora de la función");
		
		tblTabla.setModel(modelo);
		
		lblTotalRegistros = new JLabel("Total registros: ");
		lblTotalRegistros.setBounds(599, 577, 150, 14);
		getContentPane().add(lblTotalRegistros);
		
		listar();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSalir) {
			actionPerformedBtnSalir(e);
		}
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
	}
	
	// Declaración Global
	ArregloFunciones arregloFunciones = new ArregloFunciones("funciones.txt");	
	int totalRegistros;
	private JLabel lblTotalRegistros;
	
	// Lista las funciones en la tabla
	void listar() {
		totalRegistros = 0;
		modelo.setRowCount(0);
		Funcion funcion = null;
		for (int i = 0; i < arregloFunciones.tamaño(); i++) {
			funcion = arregloFunciones.obtener(i);
			String nombreCine = (new ArregloCines("cines.txt")).buscar(funcion.getCodigoCine()).getNombre();
			int numeroSala = (new ArregloSalas("salas.txt")).buscar(funcion.getCodigoSala()).getNumeroSala();
			String nombrePelicula = (new ArregloPeliculas("peliculas.txt")).buscar(funcion.getCodigoPelicula()).getTituloDistribucion();
			Object[] fila = {
					funcion.getCodigo(),
					nombreCine,
					numeroSala,
					nombrePelicula,
					funcion.getFechaFuncion(),
					funcion.getHoraFuncion()
					};
			modelo.addRow(fila);
			totalRegistros++;
		}
		
		lblTotalRegistros.setText("Total registros: " + totalRegistros);
	}
	
	// Método sobrecargado listar que realiza la búsqueda de las funciones por código y la muestra en la tabla de resultados
	void listar(String claveBusqueda) {
		if (claveBusqueda == "") {
			listar();
			
		} else {
			// Se valida que lo ingresado sea entero
			try {
				int codigoFuncion = Integer.parseInt(claveBusqueda);
				if (codigoFuncion > 0) {
					
					totalRegistros = 0;
					modelo.setRowCount(0);
					Funcion funcion = null;
					for (int i = 0; i < arregloFunciones.tamaño(); i++) {
						funcion = arregloFunciones.obtener(i);
						if (funcion.getCodigo() == codigoFuncion) {
							String nombreCine = (new ArregloCines("cines.txt")).buscar(funcion.getCodigoCine()).getNombre();
							int numeroSala = (new ArregloSalas("salas.txt")).buscar(funcion.getCodigoSala()).getNumeroSala();
							String nombrePelicula = (new ArregloPeliculas("peliculas.txt")).buscar(funcion.getCodigoPelicula()).getTituloDistribucion();
							Object[] fila = {
									funcion.getCodigo(),
									nombreCine,
									numeroSala,
									nombrePelicula,
									funcion.getFechaFuncion(),
									funcion.getHoraFuncion()
									};
							modelo.addRow(fila);
							totalRegistros++;
						}
					}
					
					lblTotalRegistros.setText("Total registros: " + totalRegistros);					
				} else {
					mensaje("El código de la Función ingresada no puede ser negativo");
					txtClaveBusqueda.setText("");
					listar(); // Muestra todo y no un dato en específico
					txtClaveBusqueda.requestFocus();
				}
			} catch (Exception e) {
				// Se borra el texto no válido
				txtClaveBusqueda.setText("");
				listar(); // Muestra todo y no un dato en específico
				txtClaveBusqueda.requestFocus();
			}
		}
	}
	
	String leerClaveBusqueda() {
		return txtClaveBusqueda.getText();
	}

	
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		listar(leerClaveBusqueda());
	}
	
	protected void actionPerformedBtnSalir(ActionEvent e) {
		this.dispose();
	}
	
	public void mouseClicked(MouseEvent e) {
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
		// Cuando se hace doble clic
		if (e.getClickCount() == 2) {
			// Se obtiene la fila seleccionada
			int fila = tblTabla.getSelectedRow();
			
			// Se obtiene el código y nombre del funcion seleccionado
			String codigoFuncion = tblTabla.getValueAt(fila, 0).toString();
			String pelicula = tblTabla.getValueAt(fila, 3).toString();
			
			DlgReservaEntradas.txtCodigoFuncion.setText(codigoFuncion);
			DlgReservaEntradas.txtFuncion.setText(pelicula);
			
			this.dispose();
		}
	}
	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtClaveBusqueda) {
			keyReleasedTxtBuscar(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	
	protected void keyReleasedTxtBuscar(KeyEvent e) {
		listar(leerClaveBusqueda());
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
