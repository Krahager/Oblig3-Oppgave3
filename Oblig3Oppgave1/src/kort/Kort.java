package kort;


public abstract class Kort implements Comparable<Kort>, Cloneable {
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
	
	public int compareTo(Kort k){
		int result = this.etterNavn.compareTo(k.hentEtternavn());
		if (result != 0)
			return result;
		result = this.forNavn.compareTo(k.hentFornavn());
		if (result != 0)
			return result;
		else
			return 0;
	}
	
	public Object clone(){
		Kort clone = null;
		try {
			clone = (Kort) super.clone();
			clone.etterNavn = new String(etterNavn);
			clone.forNavn = new String(forNavn);
			return clone;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
			return clone;
	}
	
	public abstract boolean sjekkPIN(int PIN);
	
	public String getNavn() {
		return forNavn + " " + etterNavn;
	}
	
	public String hentFornavn(){
		return this.forNavn;
	}
	
	public String hentEtternavn(){
		return this.etterNavn;
	}

	public boolean isSperret() {
		return sperret;
	}
	
	protected int getPIN(){
		return PIN;
	}
	
	protected void settFornavn(String fornavn){
		this.forNavn = fornavn;
	}
	
	protected void settEtternavn(String etternavn){
		this.etterNavn = etternavn;
	}
	
	protected void settSperret(boolean b){
		this.sperret = b;
	}
}
