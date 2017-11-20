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

public class SUservidor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	
	
	private Usuario user;
	private int porta;
	private String caminho;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SUservidor frame = new SUservidor();
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
	public SUservidor() {
		this.user = new Usuario(); //cria um usuário assim que o frame abrir.
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCriandoUmServidor = new JLabel("Criando um servidor");
		lblCriandoUmServidor.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblCriandoUmServidor.setBounds(10, 11, 270, 29);
		contentPane.add(lblCriandoUmServidor);
		
		JLabel lblPorta = new JLabel("Porta:");
		lblPorta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPorta.setBounds(10, 51, 60, 22);
		contentPane.add(lblPorta);
		
		textField = new JTextField(); //campo de onde será extraído a porta a ser usado pelo servidor.
		textField.setBounds(65, 51, 140, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCaminhoParaO = new JLabel("Caminho para o arquivo:");
		lblCaminhoParaO.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCaminhoParaO.setBounds(10, 91, 270, 22);
		contentPane.add(lblCaminhoParaO);
		
		textField_1 = new JTextField(); //campo de onde será extraído o caminho para o arquivo a ser enviado.
		textField_1.setColumns(10);
		textField_1.setBounds(10, 118, 360, 22);
		contentPane.add(textField_1);
		
		JButton btnCriarServidor = new JButton("Criar Servidor");
		btnCriarServidor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				porta = Integer.parseInt(textField.getText());
				caminho = textField_1.getText();
				user.iniciarServidor(porta, caminho);
				
				
			}
		});
		btnCriarServidor.setBounds(129, 185, 151, 23);
		contentPane.add(btnCriarServidor);
	}
}
