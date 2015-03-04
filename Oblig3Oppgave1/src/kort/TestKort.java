package kort;

//Testklasse for Kort og relevante subklasser
public class TestKort {
	public static void main(String[] args) {
		Ansatt a = new Ansatt("Kari", "Nordmann", 1234, false);
		Gjest b = new Gjest("Ola", "Nordmann", false);
		Gjest c = new Gjest("Ukjent", "Bruker", true);
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println("Attempting code 9999 for a: " + a.sjekkPIN(9999));
		System.out.println("Attempting code 1234 for a: " + a.sjekkPIN(1234));
		System.out.println("Attempting code 9999 for b: " + b.sjekkPIN(9999));
		System.out.println("Attempting code 1234 for b: " + b.sjekkPIN(1234));
		System.out.println("Attempting code 9999 for c: " + c.sjekkPIN(9999));
		System.out.println("Attempting code 1234 for c: " + c.sjekkPIN(1234));
	}
}
