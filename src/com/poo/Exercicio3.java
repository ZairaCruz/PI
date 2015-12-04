package com.poo;
import java.io.*;
import java.util.Scanner;

public class Exercicio3 {
	public static void main(String[] args) throws FileNotFoundException, IOException {

		try(FileInputStream arq1 = new FileInputStream("d://access.log")){
			
				Scanner scanner = new Scanner(new FileReader("d://access.log"))
		                  .useDelimiter(" ");
				OutputStream os = new FileOutputStream("d://relatorio1.txt");
				OutputStreamWriter osw = new OutputStreamWriter(os);
				BufferedWriter bw = new BufferedWriter(osw);

				while (scanner.hasNext()) {
					String ip = scanner.next();
					String usuario = scanner.next();
					String data = scanner.next();
					String horario = scanner.next();
					bw.write(ip + "|");
					bw.write(usuario + "|");
					bw.write(data + "|");
					bw.write(horario + "\n");
				}
					
				bw.close();
				    
			
				
		}catch(IOException exc){
			System.err.println("ERRO: " + exc);
		}
	}
}
