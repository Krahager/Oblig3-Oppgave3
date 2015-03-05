package kort;

import java.util.ArrayList;
import java.util.Collections;

//Testklasse for Kort og relevante subklasser
public class TestKort {
	public static void main(String[] args) {
		ArrayList<Kort> arr = new ArrayList<Kort>();
		
		Ansatt a = new Ansatt("Kari", "Nordmann", 1234, false, 300);
		Ansatt b = new Ansatt("En", "Ansatt", 1111, false, 200);
		Ansatt c = (Ansatt) b.clone();
		Gjest d = new Gjest("Ukjent", "Bruker", true);
		Gjest e = new Gjest("Ola", "Nordmann", false);
		
		arr.add(a);
		arr.add(b);
		arr.add(c);
		arr.add(d);
		arr.add(e);
		Collections.sort(arr);
		
		System.out.println(arr.get(0));
		System.out.println(arr.get(1));
		System.out.println(arr.get(2));
		System.out.println(arr.get(3));
		System.out.println(arr.get(4));
		
		for (int i = 0; i < arr.size(); i++){
		System.out.println("Attempting code 9999 for " + i + ": " + arr.get(i).sjekkPIN(9999));
		System.out.println("Attempting code 1234 for " + i + ": " + arr.get(i).sjekkPIN(1234));
		}
	}
}
