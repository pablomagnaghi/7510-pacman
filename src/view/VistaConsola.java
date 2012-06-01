package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import main.config.Constantes;
import Controller.ControladorConsola;

public class VistaConsola {

	private static VistaConsola instance = null;
	
	private ControladorConsola controlador;
	
	private JFrame frame;
	
	private static JTextArea textArea;

	private VistaConsola() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 792, 337);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnComer = new JButton("Comer");
		btnComer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getControlador().manejarBtnComer();
			}
		});
		btnComer.setBounds(52, 69, 166, 25);
		frame.getContentPane().add(btnComer);
		
		JButton btnConvertirPresa = new JButton("Convertir en presa");
		btnConvertirPresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getControlador().manejarBtnConvertirPresa();
			}
		});
		btnConvertirPresa.setBounds(52, 106, 166, 25);
		frame.getContentPane().add(btnConvertirPresa);
		
		JButton btnMover = new JButton("Mover");
		btnMover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getControlador().manejarBtnMover();
			}
		});
		btnMover.setBounds(52, 143, 166, 25);
		frame.getContentPane().add(btnMover);
		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getControlador().manejarBtnMostrar();
			}
		});
		btnMostrar.setBounds(52, 180, 166, 25);
		frame.getContentPane().add(btnMostrar);
		
		JButton btnIncrementarIra = new JButton("IncrementarIra");
		btnIncrementarIra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getControlador().manejarBtnIncrementarIra();
			}
		});
		btnIncrementarIra.setBounds(52, 217, 166, 25);
		frame.getContentPane().add(btnIncrementarIra);
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getControlador().manejarBtnIniciar();
			}
		});
		btnIniciar.setBounds(52, 32, 166, 25);
		frame.getContentPane().add(btnIniciar);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setBounds(282, 32, 465, 245);
		frame.getContentPane().add(textArea);
		
	}
	
	public static VistaConsola getInstance(){
		if (instance == null){
			instance = new VistaConsola();
		}
		return instance;
	}

	public ControladorConsola getControlador() {
		return controlador;
	}

	public void setControlador(ControladorConsola controller) {
		this.controlador = controller;
	}
	
	public void mostrar() {
		getInstance().frame.setVisible(true);
	}
	
	public static void redirect(){
		try {
			System.setOut(new PrintStream(new FileOutputStream("out.log"), true){
				public synchronized void println(String s){
					if((s != null)&&(s.length() > 0)){
						if (textArea.getText().split("\n").length==Constantes.LINEAS_MAXIMA){
							textArea.setText("");
						}
						if (!textArea.getText().isEmpty()){
							textArea.setText(textArea.getText() + "\n" + s);
						} else {
							textArea.setText(textArea.getText() + "" + s);
						}
					}
				}
			});
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}
}
