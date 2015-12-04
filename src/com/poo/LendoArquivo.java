package com.poo;
import java.io.File;
import java.util.Scanner;

public class LendoArquivo {
	public static void main(String[] args){
		Scanner dado = new Scanner(System.in);
		System.out.print("Nome do arquivo: ");
		analyzePath(dado.nextLine());
	}
	public static void analyzePath(String path){
		File nomeArquivo = new File(path);
		if(nomeArquivo.exists()){
			System.out.printf("%s%s\n%s\n",
					nomeArquivo.getName(), " encontrado",
					(nomeArquivo.isFile()? "É um arquivo válido" : "Não é um arquivo"));
		}else{
			System.out.printf("%s %s", path, "Não existe" );;
		}
	}
}
