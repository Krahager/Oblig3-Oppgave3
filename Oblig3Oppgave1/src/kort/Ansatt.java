package kort;

import java.util.Calendar;
import java.util.GregorianCalendar;

@SuppressWarnings("unused")
public class Ansatt extends Kort{
	
	public Ansatt(String forNavn, String etterNavn, int PIN, boolean sperret){
		super(forNavn, etterNavn, PIN, sperret);
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
}
