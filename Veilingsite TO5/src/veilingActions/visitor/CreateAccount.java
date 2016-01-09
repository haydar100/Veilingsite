package veilingActions.visitor;

import java.util.Date;
import org.jasypt.util.password.BasicPasswordEncryptor;
import veilingDomain.Koper;
import veilingQuerys.IVeilingService;
import veilingService.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class CreateAccount extends ActionSupport {

	private IVeilingService ivs = ServiceProvider.getveilingService();
	private String email;
	private String password;
	private String woonplaats;
	BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
	private String straat;
	private String huisnummer;
	private String postcode;
	private String telefoonnummer;
	private String voornaam;
	private String achternaam;
	private String geboortedatum;
	private Date gebdatum;

	// GEBOORTEDATUM null MOET WORDEN VERVANGEN DOOR VARIABELE
	public String execute() {
		String encryptedPassword = passwordEncryptor.encryptPassword(password);
		ivs.addKoper(new Koper(email, encryptedPassword, woonplaats, straat, huisnummer,
				postcode, telefoonnummer, voornaam, achternaam, geboortedatum));
		System.out.println("hallo");
		// test.insert(new Gebruiker(email, password, TYPE.verkoper, woonplaats,
		// straat,
		// huisnummer, postcode, telefoonnummer));
		// // verschil verkoper ? gebruiker hoe de fuck voeg je dat toe en
		// nullpointer want null velden ..
		return ActionSupport.SUCCESS;
	}

	public String getVoornaam() {
		return voornaam;
	}

	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}

	public String getAchternaam() {
		return achternaam;
	}

	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}

	public String getGeboortedatum() {
		return geboortedatum;
	}

	public void setGeboortedatum(String geboortedatum) {
		this.geboortedatum = geboortedatum;
	}

	public Date getGebdatum() {
		return gebdatum;
	}

	public void setGebdatum(Date gebdatum) {
		this.gebdatum = gebdatum;
	}

	public void validate() {
		System.out.println("validate bereikt");
		email = email.trim();
		password = password.trim();

		if (email.length() == 0) {
			addFieldError("username", "naam is verplicht");
		} else if (ivs.userExists(email)) {
			addFieldError("username", "gebruiker bestaat al");
		}

		if (password.length() == 0) {
			addFieldError("password", "wachtwoord is verplicht");
		}
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public IVeilingService getIvs() {
		return ivs;
	}

	public void setIvs(IVeilingService ivs) {
		this.ivs = ivs;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWoonplaats() {
		return woonplaats;
	}

	public void setWoonplaats(String woonplaats) {
		this.woonplaats = woonplaats;
	}

	public String getStraat() {
		return straat;
	}

	public void setStraat(String straat) {
		this.straat = straat;
	}

	public String getHuisnummer() {
		return huisnummer;
	}

	public void setHuisnummer(String huisnummer) {
		this.huisnummer = huisnummer;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getTelefoonnummer() {
		return telefoonnummer;
	}

	public void setTelefoonnummer(String telefoonnummer) {
		this.telefoonnummer = telefoonnummer;
	}

}
