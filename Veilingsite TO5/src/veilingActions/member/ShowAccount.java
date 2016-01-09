package veilingActions.member;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import veilingDomain.Gebruiker;
import veilingDomain.Koper;
import veilingDomain.Medewerker;
import veilingDomain.Recht.TYPE;
import veilingDomain.Verkoper;
import veilingQuerys.IVeilingService;
import veilingService.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ShowAccount extends ActionSupport implements SessionAware {
	private IVeilingService ivs = ServiceProvider.getveilingService();
	private Map session;

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	private String email;
	private String passwordcurrent;
	private String passwordnew;
	private String woonplaats;
	private String straat;
	private String huisnummer;
	private String postcode;
	private String telefoonnummer;
	private String voornaam;
	private String achternaam;
	private String geboortedatum;
	private Gebruiker gebruiker;

	public String execute() {
		
		// Cast gebruiker uit sessie naar juiste type
		gebruiker = (Gebruiker) session.get("loggedUser");
		email = gebruiker.getEmail();
		woonplaats = gebruiker.getWoonplaats();
		straat = gebruiker.getStraat();
		huisnummer = gebruiker.getHuisnummer();
		postcode = gebruiker.getPostcode();
		telefoonnummer = gebruiker.getTelefoonnummer();
		if (gebruiker.getRecht() == TYPE.koper) {
			gebruiker = (Koper) gebruiker;
			voornaam = ((Koper) gebruiker).getVoornaam();
			achternaam = ((Koper) gebruiker).getAchternaam();
			geboortedatum = ((Koper) gebruiker).getGeboortedatum();

			
		} else if (gebruiker.getRecht() == TYPE.verkoper) {
			gebruiker = (Verkoper) gebruiker;
		} else if (gebruiker.getRecht() == TYPE.medewerker) {
			gebruiker = (Medewerker) gebruiker;
		}
		// session.put("loggedUser", gebruiker);
		
		return ActionSupport.SUCCESS;
	}

	public Gebruiker getGebruiker() {
		return gebruiker;
	}

	public void setGebruiker(Gebruiker gebruiker) {
		this.gebruiker = gebruiker;
	}

	public void validate() {
	}

	public String getPasswordcurrent() {
		return passwordcurrent;
	}

	public void setPasswordcurrent(String passwordcurrent) {
		this.passwordcurrent = passwordcurrent;
	}

	public String getPasswordnew() {
		return passwordnew;
	}

	public void setPasswordnew(String passwordnew) {
		this.passwordnew = passwordnew;
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

}
