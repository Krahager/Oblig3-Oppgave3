package kort;

public interface Fast {
	public final double TIMELONNFAKTOR = 1.5;
	
	public void settFornavn(String fornavn);
	
	public void settEtternavn(String etternavn);
	
	public void setFulltNavn(String navn);
	
	public String hentFornavn();
	
	public String hentEtternavn();
	
	public String hentFulltNavn();
	
	public double beregnKreditt();
	
	public double beregnBonus();
}
