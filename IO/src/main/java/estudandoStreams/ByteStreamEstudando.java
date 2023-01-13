package estudandoStreams;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

public class ByteStreamEstudando {
	

	public void byteTypeRead() {
		try {
			File file = new File("batata.txt");
			// nao tem path?
			FileInputStream fileInputStream = new FileInputStream(file);
//			FileOutputStream fileOutputStream = new FileOutputStream(file);

			// le em formato de bytes
//			byte[] readAllBytes = fileInputStream.readAllBytes();

			BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
//			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

			while (fileInputStream.available() > 0) {
				int read = fileInputStream.read();
				System.out.print((char) read);
			}
			
//			while (bufferedInputStream.available() > 0) {
//				int read = bufferedInputStream.read();
//				System.out.print((char) read);
//			}

			// funciona com os 2
//			ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);
//			ObjectInputStream objectInputStream2 = new ObjectInputStream(fileInputStream);
//			ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);
//			ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(fileOutputStream);
//			
//			Object readObject = objectInputStream.readObject();
//			Object readObject2 = objectInputStream2.readObject();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void otro() {
		File file = new File("batata.txt");		
		try {
			PrintWriter printWriter = new PrintWriter(file);
			PrintStream printStream = new PrintStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void charType() {
		try {
			File file = new File("batata.txt");
			FileReader fileReader = new FileReader(file);
			FileWriter fileWriter = new FileWriter(file);

			BufferedReader bufferedReader = new BufferedReader(fileReader);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			// ?
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
