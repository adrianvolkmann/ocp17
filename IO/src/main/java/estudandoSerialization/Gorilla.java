package estudandoSerialization;

import java.io.Serializable;

public class Gorilla implements Serializable {

	private static final long serialVersionUID = 2L;

	public static String apelido;
	public static String otroCampo = "banana";

	public String nome;
	public int idade;
	public transient String comidaFavorita;
	
	@Override
	public String toString() {
		return "Gorilla [nome=" + nome + ", idade=" + idade + ", comidaFavorita=" + comidaFavorita + "]";
	}

	
	
}
