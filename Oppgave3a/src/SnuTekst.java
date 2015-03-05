import java.util.Scanner;


public class SnuTekst {
	private static int count;
	private static Scanner s = new Scanner(System.in);
	public static void main(String[] args){
		System.out.println("Skriv inn en Streng og trykk enter: ");
		String input = s.nextLine();
		System.out.print("Baklengs Streng: ");
		baklengs(input);
		System.out.println("Antall tegn som ble skrevet ut: " + count);
	}
	
	public static void baklengs(String tekst){
		System.out.print(tekst.charAt(tekst.length()-1));
		count++;
		if (tekst.length() > 1)
			baklengs(tekst.substring(0, tekst.length()-1));
		else
			System.out.println();
	}
}
