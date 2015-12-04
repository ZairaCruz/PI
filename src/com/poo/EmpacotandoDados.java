package com.poo;
/*
/@autora: Zaira Cruz
/*
public class EmpacotandoDados {
	private String ip;
	private String usuario;
	private String data;
	private String hora;
	
	public EmpacotandoDados(){
		this("", "", "", "");
	}
	public EmpacotandoDados(String ip, String usuario, String data, String hora){
		setIp(ip);
		setUsuario(usuario);
		setData(data);
		setHora(hora);
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	
}
