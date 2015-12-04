package com.poo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.lang.IllegalStateException;
import java.util.Formatter;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class LendoDados {
	private Scanner scan;
	private Formatter output;
	EmpacotandoDados registros = new EmpacotandoDados();
	private static String arquivoLog = "";
	Scanner dado = new Scanner(System.in);
	
	public void abrirArquivo() throws FileNotFoundException{
		try{
			arquivoLog = JOptionPane.showInputDialog("Digite nome do arquivo log a ser analisado: ");
			//arquivoLog = dado.nextLine();
			scan = new Scanner(new File(arquivoLog));
		}catch(FileNotFoundException fileNotFoundException){
			System.err.println("Erro ao abrir o arquivo");
			System.exit(1);
		}
		
		output = new Formatter("d://relatorioDois.txt");
		System.setOut(new PrintStream("d://relatorioDois.txt"));//grava tudo no relatório 
		System.out.printf("%-18s%-10s%-10s%14s\n", 
				"N.IP", "Usuário", "Data", "Horário\n");//formatação dos campos
		System.out.println(" ");
		try{
			while(scan.hasNext()){
				registros.setIp(scan.next());
				registros.setUsuario(scan.next());
				registros.setData(scan.next());
				registros.setHora(scan.next());
				System.out.printf("%-18s%-10s%-10s%14s\n", 
						registros.getIp(), registros.getUsuario(), 
						registros.getData(), registros.getHora());
				System.out.print(" | ");
			}
		}catch(NoSuchElementException elementException){
			System.err.println("Arquivo com formato diferente");
			System.exit(1);
		}catch(IllegalStateException stateException){
			System.err.println("Erro ao ler do arquivo");
			System.exit(1);
		}
		closeFile();
		System.out.println("Arquivo log " + arquivoLog + " editado e copiado.");
		JOptionPane.showMessageDialog(null,"Arquivo log " + arquivoLog + " editado e copiado.\n" + 
		" Salvo em d://relatorioDois.txt");

	}
	public void closeFile(){
		if(scan != null)
			scan.close();
		if(output != null)
			output.close();
	}
	public String getArquivoLog() {
		return arquivoLog;
	}
	public void setArquivoLog(String arquivoLog) {
		this.arquivoLog = arquivoLog;
	}
	public static void main(String[] args) throws FileNotFoundException{
		Scanner dado = new Scanner(System.in);
		LendoDados logDeAcesso = new LendoDados();
		logDeAcesso.abrirArquivo();//abre arquivo de log e empacota dados e cria um novo arquivo txt
		
		
	}
	
}
