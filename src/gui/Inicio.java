package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inicio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
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
	public Inicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblComoDesejaAtuar = new JLabel("Como deseja atuar?");
		lblComoDesejaAtuar.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblComoDesejaAtuar.setBounds(70, 11, 290, 34);
		contentPane.add(lblComoDesejaAtuar);
		
		JButton btnNewButton = new JButton("Servidor");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new SUservidor().setVisible(true);
				
			}
		});
		btnNewButton.setBounds(80, 56, 122, 34);
		contentPane.add(btnNewButton);
		
		JButton btnCliente = new JButton("Cliente");
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SUcliente().setVisible(true);
			}
		});
		btnCliente.setBounds(80, 116, 122, 34);
		contentPane.add(btnCliente);
		
		JLabel lblenviarArquivos = new JLabel("(Enviar arquivos)");
		lblenviarArquivos.setBounds(212, 66, 130, 14);
		contentPane.add(lblenviarArquivos);
		
		JLabel lblreceberArquivos = new JLabel("(Receber arquivos)");
		lblreceberArquivos.setBounds(212, 126, 130, 14);
		contentPane.add(lblreceberArquivos);
	}
}
