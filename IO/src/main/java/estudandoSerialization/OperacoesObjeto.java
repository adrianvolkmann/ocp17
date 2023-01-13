package estudandoSerialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class OperacoesObjeto {

	public static void gravarObjeto(Gorilla gorilla, File path) {
		try (var fileOut = new FileOutputStream(path); var objOut = new ObjectOutputStream(fileOut)) {
			objOut.writeObject(gorilla);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void lerObjeto(File path) {
		try (var fileIn = new FileInputStream(path); var objIn = new ObjectInputStream(fileIn)) {
			Gorilla gorilla = (Gorilla) objIn.readObject();
			System.out.println(gorilla.toString());
			System.out.println("Apelido: " + Gorilla.apelido); // imprime valor static
			System.out.println("OtroCampo: " + gorilla.otroCampo); // imprime valor static
		} catch (InvalidClassException e) {
			e.printStackTrace(); //alterar o serialID ocorre erro
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
