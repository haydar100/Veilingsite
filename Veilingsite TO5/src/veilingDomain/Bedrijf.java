package veilingDomain;

import java.util.ArrayList;

public class Bedrijf {
	private String naam;
	private String plaats;
	private String straat;
	private String postcode;
	private String telefoonnummer;
	private String kvkNummer;
	private String rekeningnummer;
	private ArrayList<Gebruiker> alleGebruikers;
	private ArrayList<Veiling> alleVeilingen;

	protected Bedrijf(String naam, String plaats, String straat,
			String postcode, String telefoonnummer, String kvkNummer,
			String rekeningnummer) {

		this.naam = naam;
		this.plaats = plaats;
		this.straat = straat;
		this.postcode = postcode;
		this.telefoonnummer = telefoonnummer;
		this.kvkNummer = kvkNummer;
		this.rekeningnummer = rekeningnummer;
		alleGebruikers = new ArrayList<Gebruiker>();
		alleVeilingen = new ArrayList<Veiling>();
	}

	public synchronized ArrayList<Veiling> getAlleVeilingen() {
		return alleVeilingen;
	}

	public synchronized void setAlleVeilingen(ArrayList<Veiling> alleVeilingen) {
		this.alleVeilingen = alleVeilingen;
	}

	public synchronized String getNaam() {
		return naam;
	}

	public synchronized void setNaam(String naam) {
		this.naam = naam;
	}

	public synchronized String getPlaats() {
		return plaats;
	}

	public synchronized void setPlaats(String plaats) {
		this.plaats = plaats;
	}

	public synchronized String getStraat() {
		return straat;
	}

	public synchronized void setStraat(String straat) {
		this.straat = straat;
	}

	public synchronized String getPostcode() {
		return postcode;
	}

	public synchronized void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public synchronized String getTelefoonnummer() {
		return telefoonnummer;
	}

	public synchronized void setTelefoonnummer(String telefoonnummer) {
		this.telefoonnummer = telefoonnummer;
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

	public synchronized ArrayList<Gebruiker> getAlleGebruikers() {
		return alleGebruikers;
	}

	public synchronized void setAlleGebruikers(
			ArrayList<Gebruiker> alleGebruikers) {
		this.alleGebruikers = alleGebruikers;
	}

	@Override
	public String toString() {
		return "Bedrijf [naam=" + naam + ", plaats=" + plaats + ", straat="
				+ straat + ", postcode=" + postcode + ", telefoonnummer="
				+ telefoonnummer + ", kvkNummer=" + kvkNummer
				+ ", rekeningnummer=" + rekeningnummer + ", alleGebruikers="
				+ alleGebruikers + ", alleVeilingen=" + alleVeilingen + "]";
	}

}
