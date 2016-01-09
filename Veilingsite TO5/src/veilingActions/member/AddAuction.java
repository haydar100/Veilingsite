package veilingActions.member;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import veilingDomain.Gebruiker;
import veilingDomain.Veiling;
import veilingQuerys.IVeilingService;
import veilingService.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("rawtypes")
public class AddAuction extends ActionSupport implements SessionAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2532579433983617764L;
	private IVeilingService ivs = ServiceProvider.getveilingService();

	private int aantald;
	private double minimumbedragd;
	private Date startdatumd, sluitdatumd;
	private String startdatum, sluitdatum, categorie, artikelnummer,
			omschrijving, minimumbedrag, aantal;
	private Map session;
	private Gebruiker gebruiker;

	public String execute() {
		setGebruiker((Gebruiker) session.get("loggedUser"));
		System.out.println(gebruiker);
		aantald = Integer.parseInt(aantal);
		minimumbedragd = Double.parseDouble(minimumbedrag);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try { 
			startdatumd = sdf.parse(startdatum);
			sluitdatumd = sdf.parse(sluitdatum);
		} catch (ParseException e) {
			System.out.println("Parse error");
			e.printStackTrace();
		}

		Veiling v = new Veiling(startdatumd, sluitdatumd, categorie,
				artikelnummer, omschrijving, aantald, minimumbedragd);

		ivs.addVeiling(v, gebruiker.getEmail());
		addActionMessage("De veiling is succesvol aangemaakt !");
		return ActionSupport.SUCCESS;

	}

	public void validate() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			startdatumd = sdf.parse(startdatum);
			sluitdatumd = sdf.parse(sluitdatum);

		} catch (ParseException e) {
			System.out.println("Parse error");
			e.printStackTrace();
		}

		Calendar cal1 = Calendar.getInstance();
		// dit is om te kijken of de datum niet eerder is dan vandaag... maar
		// dit gaat wel mis want als de datum vandaag is dan loopt dit mis...
		// dit komt omdat we een date parsen die zo binnen komt xx-xx-xxxx > getTime() vraagt een heel ander formaat op
		// en dit kunnen we niet parsen het kan wel maar dan moeten we het hele project om gaan zetten (kost veel tijd)
		
		if (startdatumd.after(cal1.getTime())) {
			if (startdatum.length() > 0 && artikelnummer.length() > 0
					&& omschrijving.length() > 0 && aantal.length() > 0
					&& minimumbedrag.length() > 0) {
				try {
					Integer.parseInt(aantal);
					Double.parseDouble(minimumbedrag);
				} catch (NumberFormatException nfe) {
					System.out.println("Geen double");
				}	

			} else {
				addActionError("1 van de velden is een null" + "" + startdatum
						+ "" + categorie + "" + "" + artikelnummer + ""
						+ omschrijving + "" + aantal);
			}
		} else {
			addActionError("datum is eerder dan vandaag !");
		}
	}

	public IVeilingService getIvs() {
		return ivs;
	}

	public void setIvs(IVeilingService ivs) {
		this.ivs = ivs;
	}

	public int getAantald() {
		return aantald;
	}

	public void setAantald(int aantald) {
		this.aantald = aantald;
	}

	public double getMinimumbedragd() {
		return minimumbedragd;
	}

	public void setMinimumbedragd(double minimumbedragd) {
		this.minimumbedragd = minimumbedragd;
	}

	public Date getStartdatumd() {
		return startdatumd;
	}

	public void setStartdatumd(Date startdatumd) {
		this.startdatumd = startdatumd;
	}

	public Date getSluitdatumd() {
		return sluitdatumd;
	}

	public void setSluitdatumd(Date sluitdatumd) {
		this.sluitdatumd = sluitdatumd;
	}

	public String getStartdatum() {
		return startdatum;
	}

	public void setStartdatum(String startdatum) {
		this.startdatum = startdatum;
	}

	public String getSluitdatum() {
		return sluitdatum;
	}

	public void setSluitdatum(String sluitdatum) {
		this.sluitdatum = sluitdatum;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getArtikelnummer() {
		return artikelnummer;
	}

	public void setArtikelnummer(String artikelnummer) {
		this.artikelnummer = artikelnummer;
	}

	public String getOmschrijving() {
		return omschrijving;
	}

	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}

	public String getMinimumbedrag() {
		return minimumbedrag;
	}

	public void setMinimumbedrag(String minimumbedrag) {
		this.minimumbedrag = minimumbedrag;
	}

	public String getAantal() {
		return aantal;
	}

	public void setAantal(String aantal) {
		this.aantal = aantal;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public Gebruiker getGebruiker() {
		return gebruiker;
	}

	public void setGebruiker(Gebruiker gebruiker) {
		this.gebruiker = gebruiker;
	}

}
