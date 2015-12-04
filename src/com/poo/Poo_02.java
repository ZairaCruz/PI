package com.poo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


	public class Poo_02 {

		public int i, j;
		public int total;
		public char ch;

		public int letras;
		public int vogais;
		public int consoantes;
		public int espacos;
		public int palavras;
		public int linhas;

		public String[] pedacos;
		public String pedaco;
		public BufferedReader reader;
		public BufferedWriter writer;
		public FileReader fileReader;

		public Poo_02() throws IOException {
			File saida = new File("dados/saida.txt");
			writer = new BufferedWriter(new FileWriter(saida));

			File entrada = new File("dados/entrada.txt");
			fileReader = new FileReader(entrada);
			reader = new BufferedReader(fileReader);

			letras = 0; // quantidade total de letras
			vogais = 0; // quantidade de vogais
			consoantes = 0; // quandidade de consoantes
			espacos = 0; // quantidade de espacos
			palavras = 0; // quantidade de palavras
			linhas = 0; // quantidade de linhas
		}

		public void Estatistica() throws FileNotFoundException, IOException {

			// Leitura e processamento do arquivo
			// ------------------------------------
			String linha = null;
			while ((linha = reader.readLine()) != null) {
				pedacos = linha.split(" ");
				espacos = espacos + pedacos.length - 1; // contagem dos espaços
				for (i = 0; i < pedacos.length; i++) {
					pedaco = pedacos[i].toLowerCase(); // passa para minusculo
					palavras++;
					total = pedaco.length(); // comprimento de cada palavra em
												// letras
					j = 0;
					while (j < total) {
						ch = pedaco.charAt(j); // acessa letra por letra
						if ((ch == 'a') || (ch == 'e') || (ch == 'i') || (ch == 'o') || (ch == 'u')) {
							vogais++;
						} else {
							if (((byte) ch >= 97) && ((byte) ch <= 122)) { // somente
																			// as
																			// minusculas
								consoantes++;
							}
						}
						j++;
					}
					letras = consoantes + vogais;
				}
				linhas++;
			}
		}

		// Fechamento---------------------------------------
		public void libera() throws IOException {
			writer.flush(); // Cria o conteúdo do arquivo.
			writer.close(); // Fechando conexão e escrita do arquivo.
			fileReader.close(); // Fecha o file reader
			reader.close(); // Fecha a conexão
		}

		// Impressão de resultatos ----------------------------------------------
		public void mostraResultados() throws IOException {

			writer.write("Estatisticas do texto --------------------------" + "\n");
			writer.write("Total de letras ...........................: " + Integer.toString(letras) + "\n");
			writer.write("Total de vogais ...........................: " + Integer.toString(vogais) + "\n");
			writer.write("Total de consoantes........................: " + Integer.toString(consoantes) + "\n");
			writer.write("Total de espacos ..........................: " + Integer.toString(espacos) + "\n");
			writer.write("Total de palavras .........................: " + Integer.toString(palavras) + "\n");
			writer.write("Total de linhas ...........................: " + Integer.toString(linhas) + "\n");
			writer.write("------------------------------------------------" + "\n");
			writer.write("\n");
		}

		public static void main(String[] args) throws FileNotFoundException, IOException {
			Poo_02 poo_02 = new Poo_02();
			poo_02.Estatistica();
			poo_02.mostraResultados();
			poo_02.libera();
		}

	}

