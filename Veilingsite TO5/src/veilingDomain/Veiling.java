package veilingDomain;

import java.util.Date;

public class Veiling {
	private Date startdatum, sluitdatum;
	private String categorie, artikelnummer, omschrijving;
	private int id, aantal;
	private double minimumbedrag;
	private double maxbedrag;
	
	
	public Veiling(int id, Date startdatum, Date sluitdatum, String categorie,
			String artikelnummer, String omschrijving,double minimumbedrag , int aantal, double maxbedrag) {
		super();
		this.startdatum = startdatum;
		this.sluitdatum = sluitdatum;
		this.categorie = categorie;
		this.artikelnummer = artikelnummer;
		this.omschrijving = omschrijving;
		this.id = id;
		this.aantal = aantal;
		this.minimumbedrag = minimumbedrag;
		this.maxbedrag = maxbedrag;
	}


	public Veiling(int id, Date startdatum, Date sluitdatum, String categorie,
			String artikelnummer, String omschrijving,double minimumbedrag , int aantal) {
		super();
		this.startdatum = startdatum;
		this.sluitdatum = sluitdatum;
		this.categorie = categorie;
		this.artikelnummer = artikelnummer;
		this.omschrijving = omschrijving;
		this.id = id;
		this.aantal = aantal;
		this.minimumbedrag = minimumbedrag;
	}
	

	public Veiling(Date startdatum, Date sluitdatum, String categorie,
			String artikelnummer, String omschrijving, int aantal,
			double minimumbedrag) {
		super();
		this.startdatum = startdatum;
		this.sluitdatum = sluitdatum;
		this.categorie = categorie;
		this.artikelnummer = artikelnummer;
		this.omschrijving = omschrijving;
		this.aantal = aantal;
		this.minimumbedrag = minimumbedrag;
	}
	
	

	public Veiling(String artikelnummer, String omschrijving, double minimumbedrag, int aantal) {
		this.artikelnummer = artikelnummer;
		this.omschrijving = omschrijving;
		this.minimumbedrag = minimumbedrag;
		this.aantal = aantal;
		
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getStartdatum() {
		return startdatum;
	}

	public void setStartdatum(Date startdatum) {
		this.startdatum = startdatum;
	}

	public Date getSluitdatum() {
		return sluitdatum;
	}

	public void setSluitdatum(Date sluitdatum) {
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

	

	public int getAantal() {
		return aantal;
	}

	public void setAantal(int aantal) {
		this.aantal = aantal;
	}

	public double getMinimumbedrag() {
		return minimumbedrag;
	}

	public void setMinimumbedrag(double minimumbedrag) {
		this.minimumbedrag = minimumbedrag;
	}


	@Override
	public String toString() {
		return "Veiling [startdatum=" + startdatum + ", sluitdatum="
				+ sluitdatum + ", categorie=" + categorie + ", artikelnummer="
				+ artikelnummer + ", omschrijving=" + omschrijving + ", id="
				+ id + ", aantal=" + aantal + ", minimumbedrag="
				+ minimumbedrag + "]";
	}

	



}
