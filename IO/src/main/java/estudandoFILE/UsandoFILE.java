package estudandoFILE;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class UsandoFILE {

	public void criarArquivo(File file) {
		try {
			if (file.createNewFile()) {
				System.out.println("File created: " + file.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void lerArquivo(File file) {
		try (Scanner Reader = new Scanner(file)) {
			if (file.exists()) {
				System.out.println("existe");
			} else {
				System.out.println("NON existe");
			}
			while (Reader.hasNextLine()) {
				String data = Reader.nextLine();
				System.out.println(data);
			}
		} catch (FileNotFoundException e) {
			System.out.println("An error has occurred.");
			e.printStackTrace();
		}
	}

	public void deleteArquivo(File file) {
		if (file.delete()) {
			System.out.println("The deleted file is : " + file.getName());
		} else {
			System.out.println("Failed in deleting the file.");
		}
	}

	public void criarDiretorio(File file) {
//		cria arvore dos diretorios
		file.mkdirs();
		
//		cria apenas um diretorio
//		file.mkdirs();

		if (file.exists()) {
			System.out.println(file.getAbsolutePath() + " criado");
		} else {
			System.out.println("nao foi criado");
		}
	}
	
	public void setConteudo(File file, String conteudo) {
		//se nao existe, grava o arquivo
		//grava direto no arquivo
		try (PrintWriter pw = new PrintWriter(file)){
			pw.write(conteudo);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
