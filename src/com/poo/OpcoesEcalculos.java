package com.poo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.Scanner;

public class OpcoesEcalculos {
	Scanner dado = new Scanner(System.in);
	double totalAcessos = 0;
	int totalDeDatas = 3, acessosPorData = 0;
	int opcao = 0, contaData = 0, contaUsuario = 0;
	double media, aux = 0.0, sigma = 0.0, somatorio = 0.0;
	double[] porDatas = new double[totalDeDatas];
	String nomeArquivo = "d://relatorioDois.txt";  
    String linha = "", data = ""; 
    String usuarioBuscado = null, dataBuscada = null;
	boolean encontrou = false;  
	private static final DecimalFormat formatadorNumero = new DecimalFormat("##.##");
    
    
	public void calcularMedia(){
    	try {  
	        BufferedReader scanner = new BufferedReader(new FileReader(nomeArquivo));  
	        //while ((linha = scanner.readLine()) != null) {  
	          //  if (linha.contains("|" )) {  
	            //	totoalAcessos++;
	            //}  
	        //}  
	        for(int i = 0; i < 3; i++){
	        	acessosPorData = 0;
	        	if(i == 0){
	        		data = "23/Nov/2015";
	        	}
	        	if(i == 1){
		        	data = "24/Nov/2015";
		        }
		        if(i == 2){
		        	data = "25/Nov/2015";
		        }
	        	BufferedReader scanner2 = new BufferedReader(new FileReader("d://relatorio.txt"));  
		        while ((linha = scanner2.readLine()) != null) {  
		            if (linha.contains(data)) {  
		            	acessosPorData++;
		            }  
		        }
		        porDatas[i] = acessosPorData;
		        System.out.println("Total de acesso no dia " + data + " foram de " + porDatas[i] );
	        } 	
	        for(int i = 0; i < porDatas.length; i++){
	        	totalAcessos = porDatas[i] + totalAcessos;
	        }
	        media = totalAcessos / porDatas.length;
	        for(int i = 0; i < porDatas.length; i++){
	        	if(porDatas[i] < media){
	        		aux = media - porDatas[i];
	        		somatorio = aux * aux + somatorio;
	        	}else{
	        		aux = porDatas[i] - media;
	        		somatorio = aux * aux + somatorio;
	        	}
	        }
	        double raiz = 0.0;
	        raiz = Math.sqrt(1 / totalAcessos);
	        sigma = raiz * somatorio /100;
	        System.out.println("Total de " + totalAcessos + " acessos.");
	        System.out.println("A média de acessos nos 3 dias foi de " + formatadorNumero.format(media));
	        System.out.println("Desvio Padrão " + sigma);
	        System.out.println("raiz " + somatorio);
	    }catch (Exception e) {  
	        System.err.println("Erro!");
	    }   
    }
	public boolean buscarUsuario(){
		System.out.println("****Usuários****");
	    System.out.println("Digite <1> para Antonio");
	    System.out.println("Digite <2> para Juliane");
	    System.out.println("Digite <3> para Levi");
	    System.out.println("Digite <3> para Zaira");
	    System.out.print("Escolha um usuário para verificar o total de acessos:");
	    opcao = dado.nextInt();
	    if(opcao == 1){
	    	usuarioBuscado = "Antonio";
	    }else{
	    	if(opcao == 2){
	    		usuarioBuscado = "Juliane";
	    	}else{
	    		if(opcao == 3){
	    			usuarioBuscado = "Levi";
	    		}else{
	    			if(opcao == 4){
	    				usuarioBuscado = "Zaira";
	    			}
	    		}
	    	}
	    }
	    System.out.println("");
	    try {  
	        BufferedReader in = new BufferedReader(new FileReader(nomeArquivo));  
	        while ((linha = in.readLine()) != null) {
	        	if (linha.contains(usuarioBuscado)) {  
	            	System.out.println(linha);  
	                encontrou = true; 
	                contaUsuario++;
	            }  
	        } 
	        
	        if(contaUsuario == 0){
	        	System.out.println("Usuário não acessou o servidor neste período");
	        }else{
	        	System.out.println("Total de acessos do usuário " + usuarioBuscado + " = " + contaUsuario);
	        }
	    } catch (Exception e) {  
	        System.err.println("Erro na abertura do arquivo " + nomeArquivo);  
	    }
		return encontrou; 
	}
	public void buscarData(){
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
	                contaData++;
	            }  
	        } 

	        System.out.println("Total de acessos na data " + dataBuscada + " = " + contaData);
	    }catch (Exception e) {  
	        System.err.println("Escolha de data inválida!");
	    }
	}
	public void moda(){
		System.out.println("Valor Modal");
		for(int i = 1; i < 5; i++){
			if(i == 1){
		    	usuarioBuscado = "Antonio";
		    }else{
		    	if(i == 2){
		    		usuarioBuscado = "Juliane";
		    	}else{
		    		if(i == 3){
		    			usuarioBuscado = "Levi";
		    		}else{
		    			if(i == 4){
		    				usuarioBuscado = "Zaira";
		    			}
		    		}
		    	}
		    }
		    try {  
		        BufferedReader in = new BufferedReader(new FileReader(nomeArquivo));  
		        while ((linha = in.readLine()) != null) {
		        	if (linha.contains(usuarioBuscado)) {  
		            	System.out.println(linha);  
		                encontrou = true; 
		                contaUsuario++;
		            }  
		        } 
		        System.out.println(usuarioBuscado + " teve " + contaUsuario + " acessos");
		    }catch (Exception e) {  
		        System.err.println("Erro na abertura do arquivo " + nomeArquivo);  
		    }
		}
	}
	
	public void menuUm(){
		Scanner dado = new Scanner(System.in);
		System.out.println("**Menu de opções**");
		System.out.println("Digite <1> Média");
		System.out.println("Digite <2> Acessos por usuário");
		System.out.println("Digite <3> Acessos por data");
		System.out.println("Digite <4> Moda");
		System.out.println("Digite <5> para sair");
		System.out.println("Escolha a opção:");
		opcao = dado.nextInt();
		switch(opcao){
	    case 1:
	    	calcularMedia();
	    break;
	    case 2:
	    	buscarUsuario();
		break;
	    case 3:
	    	buscarData();
	    break;
	    case 4:
	    	moda();
	    break;
	    case 5:
	    	System.out.println("Fim");
	    default:
	    }
   }

}
    
	

	

