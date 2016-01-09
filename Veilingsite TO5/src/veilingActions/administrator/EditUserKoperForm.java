package veilingActions.administrator;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import veilingDomain.Koper;
import veilingQuerys.IVeilingService;
import veilingService.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("rawtypes")
public class EditUserKoperForm extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 3588752356428817065L;
	private IVeilingService ivs = ServiceProvider.getveilingService();
	private ArrayList<Koper> alleKopers = new ArrayList<Koper>();
	private Map session;
	private String email;
	private String woonplaats;
	private String straat;
	private String huisnummer;
	private String postcode;
	private String telefoonnummer;
	private String voornaam;
	private String achternaam;
	private String geboortedatum;
	private Koper gezocht;
	
	public String execute() {
		alleKopers = ivs.alleKopers();
		for (Koper k : alleKopers) {
			if (k.getEmail().equals(email)) {
				setGezocht(k);
				break;
			}
		}
		
		email = gezocht.getEmail();
		woonplaats = gezocht.getWoonplaats();
		straat = gezocht.getStraat();
		huisnummer = gezocht.getHuisnummer();
		postcode = gezocht.getPostcode();
		telefoonnummer = gezocht.getTelefoonnummer();
		voornaam = gezocht.getVoornaam();
		achternaam = gezocht.getAchternaam();
		geboortedatum = gezocht.getGeboortedatum();
	
		return ActionSupport.SUCCESS;
	}
	
	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
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

	public ArrayList<Koper> getAlleKopers() {
		return alleKopers;
	}

	public void setAlleKopers(ArrayList<Koper> alleKopers) {
		this.alleKopers = alleKopers;
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

	public Koper getGezocht() {
		return gezocht;
	}

	public void setGezocht(Koper gezocht) {
		this.gezocht = gezocht;
	}

}
