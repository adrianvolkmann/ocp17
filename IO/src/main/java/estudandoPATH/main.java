package estudandoPATH;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class main {

	public static void main(String[] args) {
		try {

			Path path = Paths.get("tutorial.txt");
			Files.createFile(path);
			if(Files.exists(path)) {
				System.out.println("existe");
			}else {
				System.out.println("non exicste");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
