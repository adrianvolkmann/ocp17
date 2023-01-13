package estudandoSerialization;

import java.io.File;

public class Principal {

	public static void main(String[] args) {

		Gorilla gorilla = new Gorilla();
		Gorilla.apelido = "magila";
		gorilla.nome = "Gorrila";
		gorilla.idade = 20;
		gorilla.comidaFavorita = "banana sem casaca";

		File file = new File("gorilla.txt");
		OperacoesObjeto.gravarObjeto(gorilla, file);

		Gorilla.apelido = "mudou apelido";
		Gorilla.otroCampo = "mudou campo";

		OperacoesObjeto.lerObjeto(file);
	}

}
