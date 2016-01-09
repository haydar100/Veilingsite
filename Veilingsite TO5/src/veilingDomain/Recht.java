package veilingDomain;

public class Recht {

	private String recht;

	public enum TYPE {
		admin, medewerker, verkoper, koper

	}
	
	public Recht(String recht) {
		this.recht = recht;
	}
	
	protected Recht(TYPE recht) {
		this.recht = recht.toString();
	}

	public TYPE getRechtByString(String recht) {
		if (recht.toLowerCase().equals("admin")){
			return TYPE.admin;
		}else if (recht.toLowerCase().equals("medewerker")) {
			return TYPE.medewerker;
		}else if (recht.toLowerCase().equals("verkoper")) {
			return TYPE.verkoper;
		} else if (recht.toLowerCase().equals("koper")){
			return TYPE.koper;
		}
		return null;
	}
	public synchronized String getRecht() {
		return recht;
	}
	
	public synchronized TYPE getRechtObj() {
		return getRechtByString(recht);
	}

	public synchronized void setRecht(String recht) {
		this.recht = recht;
	}

	@Override
	public String toString() {
		return "Recht [recht=" + recht + "]";
	}

}
