package estudandoFILE;

import java.io.File;

public class main {

	public static void main(String[] args) {

		File dir = new File("batata/fejao/");
		File file = new File(dir, "myfile.txt");
		
		UsandoFILE usandoFILE = new UsandoFILE();
		usandoFILE.criarDiretorio(dir);
//		usandoFILE.criarArquivo(file);
		usandoFILE.setConteudo(file, "hello batata!");
		usandoFILE.lerArquivo(file);
//		usandoFILE.deleteArquivo(file);

	}
}
