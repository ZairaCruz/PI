package com.poo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Buscas {
	Scanner dado = new Scanner(System.in);
	boolean encontrou = false;  
    String nomeArquivo = "d://relatorio.txt";  
    String linha = "";  
    String usuarioBuscado = null;
    String dataBuscada = null;
    int opcao = 0, b = 0, u = 0;
    int totalAcessso;
    
    
	public boolean buscaUsuario() {  
	    System.out.print("Nome do usuário:");
	    usuarioBuscado = dado.nextLine();
	    try {  
	        BufferedReader in = new BufferedReader(new FileReader(nomeArquivo));  
	        while ((linha = in.readLine()) != null) {
	        	if (linha.contains(usuarioBuscado)) {  
	            	System.out.println(linha);  
	                encontrou = true; 
	                u++;
	            }  
	        } 
	        
	        if(u == 0){
	        	System.out.println("Usuário não acessou o servidor neste período");
	        }else{
	        	System.out.println("Total de acessos do usuário " + usuarioBuscado + " = " + u);
	        }
	    } catch (Exception e) {  
	        System.err.println("Erro na abertura do arquivo " + nomeArquivo);  
	        return encontrou;  
	    }  
	    return encontrou;  
	}
	
	public void buscaData() {
	    System.out.println("**Opções de data**");
	    System.out.println("Digite <1> para 23/Nov/2015");
	    System.out.println("Digite <2> para 24/Nov/2015");
	    System.out.println("Digite <3> para 25/Nov/2015");
	    System.out.print("Escolha uma data para verificar total de acessos:");
	    opcao = dado.nextInt();
	    switch(opcao){
	    case 1:
	    	dataBuscada = "23/Nov/2015";
	    	break;
	    case 2:
	    	dataBuscada = "24/Nov/2015";
	    	break;
	    case 3:
	    	dataBuscada = "25/Nov/2015";
	    	break;
	    default:
	    }
	   
	    try {  
	        BufferedReader scanner = new BufferedReader(new FileReader(nomeArquivo));  
	        while ((linha = scanner.readLine()) != null) {  
	            if (linha.contains(dataBuscada)) {  
	            	System.out.println(linha);
	                b++;
	            }  
	        } 

	        System.out.println("Total de acessos na data " + dataBuscada + " = " + b);
	    }catch (Exception e) {  
	        System.err.println("Escolha de data inválida!");
	    }    
	}

	public void buscaData(int i) {
		// TODO Auto-generated method stub
		
	}
}
