package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class Andamento extends JFrame {

	private JPanel contentPane;
	private int tamanho_arquivo;
	
	public int getTamanho() {
		return this.tamanho_arquivo;
	}
	
	public void setTamanho(int tamanho) {
		this.tamanho_arquivo = tamanho;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Andamento frame = new Andamento();
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
	public Andamento() {
		setTamanho(SUcliente.getTamanho());
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JProgressBar progressBar = new JProgressBar(0, getTamanho()); 
		progressBar.setBounds(10, 51, 400, 24);
		contentPane.add(progressBar);
		
		JLabel lblArquivoEmTransferncia = new JLabel("Arquivo em transfer\u00EAncia...");
		lblArquivoEmTransferncia.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblArquivoEmTransferncia.setBounds(10, 11, 330, 29);
		contentPane.add(lblArquivoEmTransferncia);
		
		JButton btnPausar = new JButton("Pausar");
		btnPausar.setBounds(10, 86, 100, 35);
		contentPane.add(btnPausar);
		
		JButton btnParar = new JButton("Parar");
		btnParar.setBounds(10, 132, 100, 35);
		contentPane.add(btnParar);
		
		JButton btnRecomear = new JButton("Recome\u00E7ar");
		btnRecomear.setBounds(225, 86, 100, 35);
		contentPane.add(btnRecomear);
	}
}
