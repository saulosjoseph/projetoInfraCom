package gui;

import usuario.Usuario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SUcliente extends JFrame {

	private JPanel contentPane;
	private JTextField campoIP;
	private JTextField campoPorta;
	private JTextField campoCaminho;
	
	private Usuario user;
	private String ip;
	private int porta;
	private String caminho;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SUcliente frame = new SUcliente();
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
	public SUcliente() {
		this.user = new Usuario(); //cria um usuario assim que o frame abre.
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBaixandoUmArquivo = new JLabel("Baixando um arquivo");
		lblBaixandoUmArquivo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblBaixandoUmArquivo.setBounds(10, 11, 414, 29);
		contentPane.add(lblBaixandoUmArquivo);
		
		JLabel lblIpDoServidor = new JLabel("IP do Servidor:");
		lblIpDoServidor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIpDoServidor.setBounds(10, 52, 130, 14);
		contentPane.add(lblIpDoServidor);
		
		JLabel lblCaminhoondeO = new JLabel("Caminho (onde o arquivo ser\u00E1 salvo):");
		lblCaminhoondeO.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCaminhoondeO.setBounds(10, 110, 414, 14);
		contentPane.add(lblCaminhoondeO);
		
		campoIP = new JTextField();
		campoIP.setBounds(109, 51, 225, 20);
		contentPane.add(campoIP);
		campoIP.setColumns(10);
		
		campoCaminho = new JTextField();
		campoCaminho.setColumns(10);
		campoCaminho.setBounds(10, 125, 414, 20);
		contentPane.add(campoCaminho);
		
		JButton btnNewButton = new JButton("Baixar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ip = campoIP.getText();
				porta = Integer.parseInt(campoPorta.getText());
				caminho = campoCaminho.getText();
				
				user.conectar(ip, porta, caminho);
				user.enviarMsg("baixar");
			}
		});
		btnNewButton.setBounds(150, 190, 120, 35);
		contentPane.add(btnNewButton);
		
		JLabel lblPortaDoServidor = new JLabel("Porta do Servidor:");
		lblPortaDoServidor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPortaDoServidor.setBounds(10, 77, 130, 14);
		contentPane.add(lblPortaDoServidor);
		
		campoPorta = new JTextField();
		campoPorta.setColumns(10);
		campoPorta.setBounds(137, 76, 120, 20);
		contentPane.add(campoPorta);
	}

}
