package veilingActions.administrator;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import veilingDomain.Verkoper;
import veilingQuerys.IVeilingService;
import veilingService.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;
@SuppressWarnings("rawtypes")
public class EditUserVerkoper extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = -2453588735242395443L;
	private IVeilingService ivs = ServiceProvider.getveilingService();
	private Map session;
	private ArrayList<Verkoper> alleVerkopers = new ArrayList<Verkoper>();
	private String email, woonplaats, straat, postcode, huisnummer, telefoonnummer, bedrijfsnaam, kvknummer, rekeningnummer;
	
	
	public String execute() {
		ivs.adminUpdateVerkoper(new Verkoper(email, null, woonplaats, straat, huisnummer, postcode, telefoonnummer, bedrijfsnaam, kvknummer, rekeningnummer));
		addActionMessage("Verkoper is aangepast !");
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
	public void setEmail(String email) {
		this.email = email;
	}


	public ArrayList<Verkoper> getAlleVerkopers() {
		return alleVerkopers;
	}

	public void setAlleVerkopers(ArrayList<Verkoper> alleVerkopers) {
		this.alleVerkopers = alleVerkopers;
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

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getHuisnummer() {
		return huisnummer;
	}

	public void setHuisnummer(String huisnummer) {
		this.huisnummer = huisnummer;
	}

	public String getTelefoonnummer() {
		return telefoonnummer;
	}

	public void setTelefoonnummer(String telefoonnummer) {
		this.telefoonnummer = telefoonnummer;
	}

	public String getBedrijfsnaam() {
		return bedrijfsnaam;
	}

	public void setBedrijfsnaam(String bedrijfsnaam) {
		this.bedrijfsnaam = bedrijfsnaam;
	}

	public String getKvknummer() {
		return kvknummer;
	}

	public void setKvknummer(String kvknummer) {
		this.kvknummer = kvknummer;
	}

	public String getRekeningnummer() {
		return rekeningnummer;
	}

	public void setRekeningnummer(String rekeningnummer) {
		this.rekeningnummer = rekeningnummer;
	}

}
