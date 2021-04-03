package gui;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.ImageIcon;

public class DialogoAcercaDe extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	// Declaraci�n de variables
	private final JPanel contentPanel = new JPanel();
	private JLabel lblAutores;
	private JLabel lblGuisadoMenaLuis;
	private JButton btnCerrar;
	private JLabel lblViteMayauteEduardo;
	private JLabel lblIconoPrincipal;
	private JLabel lblFondoBlanco;
	private JLabel lblPrograma;
	private JLabel lblDesarrolladoEnEl;
	private JSeparator separator;
	private JLabel lblConWindowsbuilder;
	private JLabel lblRodriguezCruzBriant;
	private JLabel lblHuillcaRamirezMiguel;

	// Lanza la aplicaci�n
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			DialogoAcercaDe dialog = new DialogoAcercaDe();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Crea la GUI
	public DialogoAcercaDe() {
		setModal(true);
		setResizable(false);
		setTitle("Acerca de Sistema de Atenci\u00F3n de Cine");
		setBounds(100, 100, 588, 330);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(237, 197, 115));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblAutores = new JLabel("Autores:");
		lblAutores.setForeground(Color.DARK_GRAY);
		lblAutores.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAutores.setHorizontalAlignment(SwingConstants.LEFT);
		lblAutores.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblAutores.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAutores.setBounds(162, 98, 72, 23);
		contentPanel.add(lblAutores);
		
		lblGuisadoMenaLuis = new JLabel("Guisado Mena Luis Alberto");
		lblGuisadoMenaLuis.setForeground(Color.DARK_GRAY);
		lblGuisadoMenaLuis.setHorizontalAlignment(SwingConstants.LEFT);
		lblGuisadoMenaLuis.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblGuisadoMenaLuis.setBounds(239, 122, 197, 23);
		contentPanel.add(lblGuisadoMenaLuis);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setIcon(new ImageIcon(DialogoAcercaDe.class.getResource("/img/btnCerrar.png")));
		btnCerrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCerrar.addActionListener(this);
		
		lblRodriguezCruzBriant = new JLabel("Rodriguez Cruz Briant");
		lblRodriguezCruzBriant.setHorizontalAlignment(SwingConstants.LEFT);
		lblRodriguezCruzBriant.setForeground(Color.DARK_GRAY);
		lblRodriguezCruzBriant.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRodriguezCruzBriant.setBounds(239, 173, 197, 23);
		contentPanel.add(lblRodriguezCruzBriant);
		
		lblHuillcaRamirezMiguel = new JLabel("Huillca Ramirez Miguel Angel");
		lblHuillcaRamirezMiguel.setHorizontalAlignment(SwingConstants.LEFT);
		lblHuillcaRamirezMiguel.setForeground(Color.DARK_GRAY);
		lblHuillcaRamirezMiguel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHuillcaRamirezMiguel.setBounds(239, 198, 197, 23);
		contentPanel.add(lblHuillcaRamirezMiguel);
		btnCerrar.setBounds(474, 257, 98, 33);
		contentPanel.add(btnCerrar);
		
		lblViteMayauteEduardo = new JLabel("Vite Mayaute Eduardo");
		lblViteMayauteEduardo.setForeground(Color.DARK_GRAY);
		lblViteMayauteEduardo.setHorizontalAlignment(SwingConstants.LEFT);
		lblViteMayauteEduardo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblViteMayauteEduardo.setBounds(239, 145, 197, 23);
		contentPanel.add(lblViteMayauteEduardo);
		
		lblPrograma = new JLabel("Sistema de Atenci\u00F3n de Cine");
		lblPrograma.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrograma.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPrograma.setBounds(162, 11, 353, 27);
		contentPanel.add(lblPrograma);
		
		lblDesarrolladoEnEl = new JLabel("Desarrollado en el IDE Eclipse Mars 2.0 con WindowBuilder");
		lblDesarrolladoEnEl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDesarrolladoEnEl.setBounds(162, 49, 353, 14);
		contentPanel.add(lblDesarrolladoEnEl);
		
		lblConWindowsbuilder = new JLabel("para un sistema de atenci\u00F3n de cines.");
		lblConWindowsbuilder.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblConWindowsbuilder.setBounds(162, 73, 410, 14);
		contentPanel.add(lblConWindowsbuilder);
		
		separator = new JSeparator();
		separator.setBounds(10, 244, 556, 2);
		contentPanel.add(separator);
		
		lblIconoPrincipal = new JLabel("");
		lblIconoPrincipal.setBounds(16, 11, 136, 135);
		contentPanel.add(lblIconoPrincipal);
		lblIconoPrincipal.setBackground(Color.WHITE);
		lblIconoPrincipal.setIcon(new ImageIcon(DialogoAcercaDe.class.getResource("/img/cinelogo.jpg")));
		
		lblFondoBlanco = new JLabel("New label");
		lblFondoBlanco.setIcon(new ImageIcon(DialogoAcercaDe.class.getResource("/img/fondoBlanco.png")));
		lblFondoBlanco.setBounds(0, 0, 582, 337);
		contentPanel.add(lblFondoBlanco);
		agregarContenido();
	}
	
	// Direcciona eventos de tipo ActionEvent
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	
	// Procesa la pulsaci�n del bot�n Cerrar
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose(); // Cierra el cuadro de di�logo
	}
	
	void agregarContenido() {
	}
}
