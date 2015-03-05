package kort;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Ansatt extends Kort implements Fast{
	private double timelonn;
	private GregorianCalendar ansiennitet;
	
	public Ansatt(String forNavn, String etterNavn, int PIN, boolean sperret, double timelonn){
		super(forNavn, etterNavn, PIN, sperret);
		this.timelonn = timelonn;
		ansiennitet = new GregorianCalendar();
	}
	
	public Ansatt(String forNavn, String etterNavn, int PIN, boolean sperret, double timelonn,
			GregorianCalendar ansiennitet){
		super(forNavn, etterNavn, PIN, sperret);
		this.timelonn = timelonn;
		ansiennitet = new GregorianCalendar();
	}
	
	public boolean sjekkPIN(int PIN){
		GregorianCalendar calendar = new GregorianCalendar();
		int hour = calendar.get(GregorianCalendar.HOUR_OF_DAY);
		if (hour < 17 && hour >= 7 && calendar.get(GregorianCalendar.DAY_OF_WEEK) != GregorianCalendar.SATURDAY 
				&& calendar.get(GregorianCalendar.DAY_OF_WEEK) != GregorianCalendar.SUNDAY){
			return true;
		}
		else
			return PIN == super.getPIN();
	}
	
	@Override
	public String toString(){
		String label = String.format("%1$-8s %2$-20s %3$-5s %4$-8s \n", "Kortnmr", "Navn",
				"PIN", "Sperret");
		return label + super.toString();
	}

	@Override
	public void settFornavn(String fornavn) {
		super.settFornavn(fornavn);
		
	}

	@Override
	public void settEtternavn(String etternavn) {
		super.settEtternavn(etternavn);
		
	}

	@Override
	public void setFulltNavn(String navn) {
		String[] fulltnavn = navn.split(" ");
		switch(fulltnavn.length){
			case 1:
				super.settFornavn(fulltnavn[0]);
				super.settEtternavn("");
				break;
			case 2:		
				super.settFornavn(fulltnavn[0]);
				super.settEtternavn(fulltnavn[1]);
				break;
			case 3:
				super.settFornavn(fulltnavn[0]);
				super.settEtternavn(fulltnavn[1] + " " + fulltnavn[2]);
				break;
			default:
				System.out.println("Recieved an unexpected amount of spaces. Name has not been overwritten");
		}
	}
	
	public void settTimelonn(double timelonn){
		this.timelonn = timelonn;
	}

	@Override
	public String hentFornavn() {
		return super.hentFornavn();
	}

	@Override
	public String hentEtternavn() {
		return super.hentEtternavn();
	}

	@Override
	public String hentFulltNavn() {
		return super.getNavn();
	}
	
	public double hentTimelonn(){
		return this.timelonn;
	}

	@Override
	public double beregnKreditt() {
		return timelonn*Fast.TIMELONNFAKTOR;
	}

	@Override
	public double beregnBonus() {
		return (new GregorianCalendar().get(Calendar.YEAR) 
				- ansiennitet.get(Calendar.YEAR)) * Fast.TIMELONNFAKTOR;
	}
}
