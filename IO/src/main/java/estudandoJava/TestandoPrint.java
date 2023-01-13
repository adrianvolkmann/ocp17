package estudandoJava;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestandoPrint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		System.out.println("Hallow");
//		
//		try (var in = new FileInputStream("zoo.txt")) {
//			System.out.println("Found file!");
//		} catch (IOException e) {
//			System.err.println("File not found!");
//		}

		
		var reader = new BufferedReader(new InputStreamReader(System.in));
		String userInput;
		try {
			userInput = reader.readLine();
			System.out.println("You entered: " + userInput);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
