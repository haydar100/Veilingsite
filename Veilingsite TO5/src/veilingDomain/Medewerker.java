package veilingDomain;

import java.util.Date;

import veilingDomain.Recht.TYPE;

public class Medewerker extends Gebruiker {
	private String voornaam;
	private String achternaam;
	private String functie;
	private Date geboortedatum;

	public Medewerker(String email, String password, String woonplaats, String straat, String huisnummer, String postcode,
			String telefoonnummer, String voornaam, String achternaam, String functie, Date geboortedatum) {
		super(email, password, TYPE.medewerker, woonplaats, straat, huisnummer, postcode, telefoonnummer);
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		this.functie = functie;
		this.geboortedatum = geboortedatum;
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

	public synchronized String getFunctie() {
		return functie;
	}

	public synchronized void setFunctie(String functie) {
		this.functie = functie;
	}

	public synchronized Date getGeboortedatum() {
		return geboortedatum;
	}

	public synchronized void setGeboortedatum(Date geboortedatum) {
		this.geboortedatum = geboortedatum;
	}

	@Override
	public String toString() {
		return "Medewerker [voornaam=" + voornaam + ", achternaam="
				+ achternaam + ", functie=" + functie + ", geboortedatum="
				+ geboortedatum + "]";
	}

}
