package kort;


public abstract class Kort {
	private String forNavn;
	private String etterNavn;
	private int PIN;
	private int kortnummer;
	private boolean sperret;;
	private static int antKort;
	
	public Kort(String forNavn, String etterNavn, int PIN, boolean sperret){
		this.forNavn = forNavn;
		this.etterNavn = etterNavn;
		this.PIN = PIN;
		this.sperret = sperret;
		kortnummer = antKort++;
	}
	
	public String toString(){
		return String.format("%1$-8s %2$-20s %3$-5s %4$-8s", kortnummer,
				forNavn + " " + etterNavn, PIN, sperret);
	}
	
	public abstract boolean sjekkPIN(int PIN);
	
	public String getNavn() {
		return forNavn + " " + etterNavn;
	}

	public boolean isSperret() {
		return sperret;
	}
	
	protected int getPIN(){
		return PIN;
	}
	
	protected void settSperret(boolean b){
		this.sperret = b;
	}
}
