package veilingDomain;

import veilingDomain.Recht.TYPE;

public class Gebruiker {
	private String email;
	private String password;
	private TYPE recht;
	private String woonplaats;
	private String straat;
	private String huisnummer;
	private String postcode;
	private String telefoonnummer;

	public Gebruiker(String email, String password, TYPE recht,
			String woonplaats, String straat, String huisnummer,
			String postcode, String telefoonnummer) {
		this.email = email;
		this.password = password;
		this.recht = recht;
		this.woonplaats = woonplaats;
		this.straat = straat;
		this.huisnummer = huisnummer;
		this.postcode = postcode;
		this.telefoonnummer = telefoonnummer;
	}

	public synchronized String getEmail() {
		return email;
	}

	public synchronized void setEmail(String email) {
		this.email = email;
	}

	public synchronized String getPassword() {
		return password;
	}

	public synchronized void setPassword(String password) {
		this.password = password;
	}

	public synchronized String getWoonplaats() {
		return woonplaats;
	}

	public synchronized void setWoonplaats(String woonplaats) {
		this.woonplaats = woonplaats;
	}

	public synchronized String getStraat() {
		return straat;
	}

	public synchronized void setStraat(String straat) {
		this.straat = straat;
	}

	public synchronized String getHuisnummer() {
		return huisnummer;
	}

	public synchronized void setHuisnummer(String huisnummer) {
		this.huisnummer = huisnummer;
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

	public synchronized TYPE getRecht() {
		return recht;
	}

	public synchronized void setRecht(TYPE recht) {
		this.recht = recht;
	}

	public synchronized void setRecht(Recht recht) {
		this.recht = recht.getRechtObj();
	}

	@Override
	public String toString() {
		return "Gebruiker [email=" + email + ", password=" + password
				+ ", recht=" + recht + ", woonplaats=" + woonplaats
				+ ", straat=" + straat + ", huisnummer=" + huisnummer
				+ ", postcode=" + postcode + ", telefoonnummer="
				+ telefoonnummer + "]";
	}

}
