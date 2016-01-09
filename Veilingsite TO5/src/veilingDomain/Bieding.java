package veilingDomain;

import java.sql.Date;

public class Bieding {
	private int id, veiling_id;
	private double bedrag;
	private Date datum;
	private String gebruikermail;
	private int aantal;
	
	
	
	
	public Bieding(int id, String gebruikermail, int veiling_id, double bedrag,
			Date datum) {
		this.id = id;
		this.gebruikermail = gebruikermail;
		this.veiling_id = veiling_id;
		this.bedrag = bedrag;
		this.datum = datum;
	}
	
	public Bieding(int veiling_id, int aantal) {
		this.veiling_id = veiling_id;
		this.aantal = aantal;
	}



	public int getId() {
		return id;
	}
	
	
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getVeiling_id() {
		return veiling_id;
	}
	public void setVeiling_id(int veiling_id) {
		this.veiling_id = veiling_id;
	}
	public double getBedrag() {
		return bedrag;
	}
	public void setBedrag(double bedrag) {
		this.bedrag = bedrag;
	}
	public Date getDatum() {
		return datum;
	}
	public String getGebruikermail() {
		return gebruikermail;
	}



	public void setGebruikermail(String gebruikermail) {
		this.gebruikermail = gebruikermail;
	}



	public void setDatum(Date datum) {
		this.datum = datum;
	}



	public int getAantal() {
		return aantal;
	}



	public void setAantal(int aantal) {
		this.aantal = aantal;
	}
	
	
}
