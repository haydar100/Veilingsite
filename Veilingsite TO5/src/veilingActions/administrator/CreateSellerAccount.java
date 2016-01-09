package veilingActions.administrator;

import org.jasypt.util.password.BasicPasswordEncryptor;

import veilingDomain.Recht.TYPE;
import veilingDomain.Verkoper;
import veilingQuerys.IVeilingService;
import veilingService.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class CreateSellerAccount extends ActionSupport {

	private IVeilingService ivs = ServiceProvider.getveilingService();
	private String bedrijfsnaam;
	private String kvkNummer;
	private String rekeningnummer;
	BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
	private String email;
	private String password;
	private String woonplaats;
	private String straat;
	private String huisnummer;
	private String postcode;
	private String telefoonnummer;
	
	// GEBOORTEDATUM null MOET WORDEN VERVANGEN DOOR VARIABELE
	public String execute() {
		String encryptedPassword = passwordEncryptor.encryptPassword(password);
		System.out.println("execute bereikt");
		System.out.println(email);
		System.out.println(woonplaats);
		System.out.println(password);
		System.out.println(straat);
		System.out.println(huisnummer);
		System.out.println(postcode);
		System.out.println(email);
		System.out.println(telefoonnummer);
		System.out.println();
		
		ivs.addVerkoper(new Verkoper(email, encryptedPassword, woonplaats, straat, huisnummer, postcode, telefoonnummer, bedrijfsnaam, kvkNummer, rekeningnummer));
		System.out.println("hallo");
		// test.insert(new Gebruiker(email, password, TYPE.verkoper, woonplaats,
		// straat,
		// huisnummer, postcode, telefoonnummer));
		// // verschil verkoper ? gebruiker hoe de fuck voeg je dat toe en
		// nullpointer want null velden ..
		addActionMessage("verkoper aangemaakt");
		return ActionSupport.SUCCESS;
	}

	
	public void validate() {
		System.out.println("validate bereikt");
		email = email.trim();
		password = password.trim();

		if (email.length() == 0) {
			addActionError("email klopt niet");
		} else if (ivs.userExists(email)) {
			addActionError("username bestaat al");
		}

		if (password.length() == 0) {
			addActionError("wachtwoord klopt niet");
		}
	}

	
	public String getBedrijfsnaam() {
		return bedrijfsnaam;
	}


	public void setBedrijfsnaam(String bedrijfsnaam) {
		this.bedrijfsnaam = bedrijfsnaam;
	}


	public String getKvkNummer() {
		return kvkNummer;
	}


	public void setKvkNummer(String kvkNummer) {
		this.kvkNummer = kvkNummer;
	}


	public String getRekeningnummer() {
		return rekeningnummer;
	}


	public void setRekeningnummer(String rekeningnummer) {
		this.rekeningnummer = rekeningnummer;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
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


	public IVeilingService getIvs() {
		return ivs;
	}

	public void setIvs(IVeilingService ivs) {
		this.ivs = ivs;
	}



}
