package kort;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Gjest extends Kort{
	private GregorianCalendar opprettet = new GregorianCalendar();
	private GregorianCalendar utgaar;
	
	public Gjest(String forNavn, String etterNavn, boolean sperret){
		super(forNavn, etterNavn, 9999, sperret);
		utgaar = new GregorianCalendar();
		utgaar.add(GregorianCalendar.DAY_OF_WEEK, 7);
	}
	
	public boolean sjekkPIN(int PIN){
		if (utgaar.before(opprettet))
			super.settSperret(true);
		if (isSperret())
			return false;
		else
			return (super.getPIN() == PIN);
	}
	
	public Object clone(){
		Gjest clone = (Gjest)super.clone();
		clone.opprettet = opprettet;
		clone.utgaar = utgaar;
		return clone;
	}
	
	@Override
	public String toString(){
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String label = String.format("%1$-8s %2$-20s %3$-5s %4$-8s %5$-1s \n", "Kortnmr", "Navn",
				"PIN", "Sperret", "Utgår");
		return String.format("%-1s%-1s %-1s", label, super.toString(), form.format(utgaar.getTime()));
	}
}
