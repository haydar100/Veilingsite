package veilingActions.member;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import veilingDomain.Bieding;
import veilingDomain.Koper;
import veilingDomain.Veiling;
import veilingQuerys.IVeilingService;
import veilingService.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings({ "rawtypes", "unused" })
public class ChosenAuction extends ActionSupport implements SessionAware {
	private Veiling auction;
	private int id;
	private double huidigBod;
	private String huidigeBieder = "NOTHING";

	public synchronized IVeilingService getIvs() {
		return ivs;
	}

	public synchronized void setIvs(IVeilingService ivs) {
		this.ivs = ivs;
	}

	private static final long serialVersionUID = 1831482785400902055L;
	private IVeilingService ivs = ServiceProvider.getveilingService();
	private Map session;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public String execute() {
		List<Veiling> veilingen = ivs.collectAlleVeilingen();
		for (Veiling v : veilingen) {
			if (v.getId() == this.id) {
				auction = v;
				break;
			}
		}
		List<Bieding> biedingen = ivs.collectAlleBiedingen(id);

		for (Bieding b : biedingen) {
	
			if (huidigBod < b.getBedrag()) {
				huidigBod = b.getBedrag();
				huidigeBieder = ((Koper) ivs.getGebruikerDoorEmail(b.getGebruikermail())).getVoornaam();
		
			}
		}
		return ActionSupport.SUCCESS;
	}

	public String getHuidigeBieder() {
		return huidigeBieder;
	}

	public void setHuidigeBieder(String huidigeBieder) {
		this.huidigeBieder = huidigeBieder;
	}

	public double getHuidigBod() {
		return huidigBod;
	}

	public void setHuidigBod(double huidigBod) {
		this.huidigBod = huidigBod;
	}

	public Veiling getAuction() {
		return auction;
	}

	public void setAuction(Veiling auction) {
		this.auction = auction;
	}

}
