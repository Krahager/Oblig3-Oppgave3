package kort;


public abstract class Kort {
	private String navn;
	private int PIN;
	private int kortnummer;
	private boolean sperret;;
	private static int antKort;
	
	public Kort(String forNavn, int PIN, boolean sperret){
		this.navn = forNavn;
		this.PIN = PIN;
		this.sperret = sperret;
		kortnummer = antKort++;
	}
	
	public String toString(){
		return String.format("%1$-8s %2$-20s %3$-4s %4$-20s %5$-5s", kortnummer, navn, PIN, sperret);
	}
	
	public abstract boolean sjekkPIN(int PIN);
	
	public String getNavn() {
		return navn;
	}

	public boolean isSperret() {
		return sperret;
	}
	
}
