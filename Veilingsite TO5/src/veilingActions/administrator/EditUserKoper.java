package veilingActions.administrator;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import veilingDomain.Gebruiker;
import veilingDomain.Koper;
import veilingQuerys.IVeilingService;
import veilingService.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings({"serial", "rawtypes"})
public class EditUserKoper extends ActionSupport implements SessionAware {
	private IVeilingService ivs = ServiceProvider.getveilingService();
	private String email;
	private String woonplaats;
	private String straat;
	private String huisnummer;
	private String postcode;
	private String telefoonnummer;
	private String voornaam;
	private String achternaam;
	private String geboortedatum;
	private Gebruiker gebruiker;
	private Map session;

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}


	public String execute() { // password veld leeg omdat we die niet willen meesturen
		ivs.adminUpdateKoper(new Koper(email, "", woonplaats, straat, huisnummer, postcode, telefoonnummer, voornaam, achternaam, geboortedatum));
		addActionMessage("Gebruiker is aangepast !");
		return ActionSupport.SUCCESS;
	}

	public void validate() {

		if (!(geboortedatum.trim().length() > 0)) {
			addFieldError("geboortedatum", "Geboortedatum mag niet leeg zijn");
		}
		if (!(achternaam.trim().length() > 0)) {
			addFieldError("achternaam", "Achternaam mag niet leeg zijn");
		}
		if (!(voornaam.trim().length() > 0)) {
			addFieldError("voornaam", "Voornaam mag niet leeg zijn");
		}
		if (!(telefoonnummer.trim().length() > 0)) {
			addFieldError("telefoonnummer", "Telefoonnummer mag niet leeg zijn");
		}
		if (!(postcode.trim().length() > 0)) {
			addFieldError("postcode", "Postcode mag niet leeg zijn");
		}
		if (!(huisnummer.trim().length() > 0)) {
			addFieldError("huisnummer", "Huisnummer mag niet leeg zijn");
		}
		if (!(straat.trim().length() > 0)) {
			addFieldError("straat", "Straat mag niet leeg zijn");
		}
		if (!(woonplaats.trim().length() > 0)) {
			addFieldError("woonplaats", "Woonplaats mag niet leeg zijn");
		}

		if (!(email.trim().length() > 0)) {
			addFieldError("email", "Email mag niet leeg zijn");
		} else {
			if (ivs.userExists(email)) {
				addFieldError("email", "Email bestaat al");
			}
		}

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

	public Gebruiker getGebruiker() {
		return gebruiker;
	}

	public void setGebruiker(Gebruiker gebruiker) {
		this.gebruiker = gebruiker;
	}

}
