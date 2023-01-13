package estudandoJava;

import java.util.Scanner;

public class ScannerTestes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
 
        String s = in.nextLine();
        System.out.println("You entered string " + s);
 
        int a = in.nextInt();
        System.out.println("You entered integer " + a);
 
        float b = in.nextFloat();
        System.out.println("You entered float " + b);
	}

}
