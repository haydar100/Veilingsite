package veilingActions.visitor;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.jasypt.util.password.BasicPasswordEncryptor;
import veilingDomain.Gebruiker;
import veilingDomain.Koper;
import veilingDomain.Recht.TYPE;
import veilingQuerys.IVeilingService;
import veilingService.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class Login extends ActionSupport implements SessionAware {

	private IVeilingService ivs = ServiceProvider.getveilingService();
	BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
	private Koper koper;
	@SuppressWarnings("rawtypes")
	private Map session;
	private String email;
	private String password;
	private String woonplaats;
	private String straat;
	private String huisnummer;
	private String postcode;
	private String telefoonnummer;
	private String voornaam;
	private String achternaam;
	private Gebruiker gebruiker;
	private String geboortedatum;

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

	@SuppressWarnings({ "unchecked", "unused" })
	public String execute() {
		session.put("loggedUser", gebruiker);
		System.out.println("gebruiker in sessie");
				return SUCCESS;
	}

	public void validate() {
		password = password.trim();
		email = email.trim();

		if (email.length() == 0) {
			addFieldError("username", "naam is verplicht");
		}
		if (password.length() == 0) {
			addFieldError("password", "wachtwoord is verplicht");
		}

		gebruiker = ivs.getGebruiker(email, password);
		
		if (gebruiker != null) {
		
			email = gebruiker.getEmail();
			woonplaats = gebruiker.getWoonplaats();
			straat = gebruiker.getStraat();
			huisnummer = gebruiker.getHuisnummer();
			postcode = gebruiker.getPostcode();
			telefoonnummer = gebruiker.getTelefoonnummer();
			if (!ivs.isBlocked(email)) {
				if (gebruiker.getRecht() == TYPE.koper) {
					gebruiker = (Koper) gebruiker;
					voornaam = ((Koper) gebruiker).getVoornaam();
					achternaam = ((Koper) gebruiker).getAchternaam();
					geboortedatum = ((Koper) gebruiker).getGeboortedatum();
				}

				else if (gebruiker.getRecht() == TYPE.verkoper) {

				} else if (gebruiker.getRecht() == TYPE.medewerker) {
				}
			} else {
				addActionError("Gebruiker geblokkeerd !! inloggen niet toegestaan");
			}
			
		} else {
			addActionError("gebruiker / password combinatie klopt niet");
		}
		
	}

	// if (ivs.login(email, password)) {
	//
	// String foundEmail = ivs.findKoperByEmail(email);
	// System.out.println(foundEmail);
	// if(session.containsKey("usedLogger")) {
	// System.out.println("userlogger bestaat al");
	// }
	// else {
	// session.put("usedLogger", foundEmail);
	// System.out.println("user in sessie geset");
	// }
	//
	// // session.put("gebruiker", koper); // er wordt niks erin geput. we
	// moeten de gebruiker object uit de DB halen
	// System.out.println("Gebruiker ingelogd!");
	// System.out.println(session.toString()); // dit bewijst dat het leeg
	// is. --> MVC MODEL --> we moeten de gebruiker uit de database casten
	// naar een koper object en deze ophalen !
	// } else {
	// addFieldError("password", "combinatie ongeldig");
	// System.out.println("Login ongeldig");
	// }

	public String getVoornaam() {
		return voornaam;
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

	public Gebruiker getGebruiker() {
		return gebruiker;
	}

	public void setGebruiker(Gebruiker gebruiker) {
		this.gebruiker = gebruiker;
	}

	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}

	// public String getPassword() {
	// return password;
	// }

	public IVeilingService getIvs() {
		return ivs;
	}

	public void setIvs(IVeilingService ivs) {
		this.ivs = ivs;
	}

	@SuppressWarnings("rawtypes")
	public Map getSession() {
		return session;
	}

	public void setKoper(Koper koper) {
		this.koper = koper;
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

	@SuppressWarnings("rawtypes")
	public void setSession(Map session) {
		this.session = session;

	}

	public Koper getKoper() {
		return koper;

	}

}
