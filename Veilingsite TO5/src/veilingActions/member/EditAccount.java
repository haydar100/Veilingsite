package veilingActions.member;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.jasypt.util.password.BasicPasswordEncryptor;
import veilingDomain.Gebruiker;
import veilingDomain.Koper;
import veilingDomain.Medewerker;
import veilingDomain.Recht.TYPE;
import veilingDomain.Verkoper;
import veilingQuerys.IVeilingService;
import veilingService.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("rawtypes")
public class EditAccount extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = -7906957120781121825L;
	private IVeilingService ivs = ServiceProvider.getveilingService();
	BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
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
	private Map session;

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	@SuppressWarnings({ "unchecked" })
	public String execute() {
		System.out.println(gebruiker.getRecht());
		// To-do: De juiste query's uit de DAO aanroepen binnen deze if
		// statement
		if (gebruiker.getRecht() == TYPE.koper) {
			Gebruiker g = null;
			if(passwordnew.trim().length() > 0) {
				String encryptedPassword = passwordEncryptor.encryptPassword(passwordnew);
				g = new Koper(email, encryptedPassword, woonplaats, straat, huisnummer, postcode, telefoonnummer, voornaam, achternaam, geboortedatum);
			}
			else {
				String encryptedPassword = passwordEncryptor.encryptPassword(passwordcurrent);
				g = new Koper(email, encryptedPassword, woonplaats, straat, huisnummer, postcode, telefoonnummer, voornaam, achternaam, geboortedatum);
			}
			
			ivs.updateKoper((Koper) g);
			session.put("loggedUser", g);
			addActionMessage("Gebruikergegevens succesvol geupdated");

		} else if (gebruiker.getRecht() == TYPE.verkoper) {
			// UPDATE VERKOPER

		} else if (gebruiker.getRecht() == TYPE.medewerker) {
			// UPDATE MEDEWERKER

		}
		return ActionSupport.SUCCESS;
	}

	public void validate() {
		gebruiker = (Gebruiker) session.get("loggedUser");
		// Cast gebruiker uit sessie naar juiste type

		if (gebruiker.getRecht() == TYPE.koper) {
			gebruiker = (Koper) gebruiker;
		} else if (gebruiker.getRecht() == TYPE.verkoper) {
			gebruiker = (Verkoper) gebruiker;
		} else if (gebruiker.getRecht() == TYPE.medewerker) {
			gebruiker = (Medewerker) gebruiker;
		}
		if (!(passwordcurrent.trim().length() > 0)) {
			addFieldError("passwordcurrent", "Huidig wachtwoord mag niet leeg zijn");
		} else {
			if (passwordEncryptor.checkPassword(passwordcurrent, gebruiker.getPassword())) {
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
//				if (!(passwordnew.trim().length() > 0)) {
//					addFieldError("passwordnew", "Nieuw wachtwoord mag niet leeg zijn");
//				}

				if (!(email.trim().length() > 0)) {
					addFieldError("email", "Email mag niet leeg zijn");
				} else {
					if (ivs.userExists(email)) {
						addFieldError("email", "Email bestaat al");
					}
				}
			} else {
				addFieldError("passwordcurrent", "Huidig wachtwoord is onjuist");
			}
		}
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
