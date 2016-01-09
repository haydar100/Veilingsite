package veilingDomain;

import veilingDomain.Recht.TYPE;

public class Verkoper extends Gebruiker {
	private String bedrijfsnaam;
	private String kvkNummer;
	private String rekeningnummer;

	public Verkoper(String email, String password, String woonplaats, String straat, String huisnummer, String postcode,
			String telefoonnummer, String bedrijfsnaam, String kvkNummer, String rekeningnummer) {
		super(email, password, TYPE.verkoper, woonplaats, straat, huisnummer, postcode, telefoonnummer);
		this.bedrijfsnaam = bedrijfsnaam;
		this.kvkNummer = kvkNummer;
		this.rekeningnummer = rekeningnummer;
	}

	public synchronized String getBedrijfsnaam() {
		return bedrijfsnaam;
	}

	public synchronized void setBedrijfsnaam(String bedrijfsnaam) {
		this.bedrijfsnaam = bedrijfsnaam;
	}

	public synchronized String getKvkNummer() {
		return kvkNummer;
	}

	public synchronized void setKvkNummer(String kvkNummer) {
		this.kvkNummer = kvkNummer;
	}

	public synchronized String getRekeningnummer() {
		return rekeningnummer;
	}

	public synchronized void setRekeningnummer(String rekeningnummer) {
		this.rekeningnummer = rekeningnummer;
	}

	@Override
	public String toString() {
		return "Verkoper [bedrijfsnaam=" + bedrijfsnaam + ", kvkNummer="
				+ kvkNummer + ", rekeningnummer=" + rekeningnummer + "]";
	}

}
