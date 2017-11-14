package usuario;

import funções.EnviarMsg;
//import funções.ReceberMsg;

public class Usuario {
	private Servidor servidor;
	private Cliente cliente;
	private EnviarMsg enviar;
	
	
	public Usuario(){
		this.servidor = new Servidor();
		this.cliente = new Cliente();
	}
	
	public void conectar(String ip){
		this.cliente.conectar(ip);
		enviar = new EnviarMsg(this.cliente.pegarSoquete());
	}
	
	public void iniciarServidor(){
		this.servidor.iniciar();
	}
	
	public void baixar(){
		this.cliente.baixar();
	}
	
	public void enviarMsg(String msg){
		this.enviar.enviar(msg);
		if(msg.equals("baixar")){
			this.baixar();
		}
	}
}
