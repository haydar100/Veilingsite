package veilingDomain;

import java.math.BigDecimal;

import veilingDomain.Recht.TYPE;
 
public class Koper extends Gebruiker {
	private String voornaam;
	private String achternaam;
	private String geboortedatum;
	private BigDecimal credits;
	private String rekeningnummer;

	public Koper(String email, String password, String woonplaats, String straat, String huisnummer,
			String postcode, String telefoonnummer, String voornaam,
			String achternaam, String geboortedatum) {
		super(email, password, TYPE.koper, woonplaats, straat, huisnummer, postcode,
				telefoonnummer);
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		this.geboortedatum = geboortedatum;
		this.credits = new BigDecimal(0.0);
		this.rekeningnummer = null;
	}
	

	public synchronized String getVoornaam() {
		return voornaam;
	}

	public synchronized void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}

	public synchronized String getAchternaam() {
		return achternaam;
	}

	public synchronized void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}

	public synchronized String getGeboortedatum() {
		return geboortedatum;
	}

	public synchronized void setGeboortedatum(String geboortedatum) {
		this.geboortedatum = geboortedatum;
	}

	public synchronized BigDecimal getCredits() {
		return credits;
	}

	public synchronized void setCredits(BigDecimal credits) {
		this.credits = credits;
	}
	
	public synchronized void addCredits(BigDecimal credits) {
		this.credits = this.credits.add(credits);
	}
	
	public synchronized void removeCredits(BigDecimal credits) {
		this.credits = this.credits.subtract(credits);
	}

	public synchronized String getRekeningnummer() {
		return rekeningnummer;
	}

	public synchronized void setRekeningnummer(String rekeningnummer) {
		this.rekeningnummer = rekeningnummer;
	}

	@Override
	public String toString() {
		return "Koper [voornaam=" + voornaam + ", achternaam=" + achternaam
				+ ", geboortedatum=" + geboortedatum + ", credits=" + credits
				+ ", rekeningnummer=" + rekeningnummer + "]";
	}



}
