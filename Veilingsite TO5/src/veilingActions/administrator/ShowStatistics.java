package veilingActions.administrator;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import veilingDomain.Bieding;
import veilingQuerys.IVeilingService;
import veilingService.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;
@SuppressWarnings("rawtypes")
public class ShowStatistics extends ActionSupport implements SessionAware {
	private Bieding hoogsteBiedingDag, hoogsteBiedingMaand, hoogsteBiedingJaar, veilingMeesteBiedingen;
	
	public synchronized IVeilingService getIvs() {
		return ivs;
	}

	public synchronized void setIvs(IVeilingService ivs) {
		this.ivs = ivs;
	}

	private static final long serialVersionUID = 1831482785400902055L;
	private IVeilingService ivs = ServiceProvider.getveilingService();
	private Map session;
	
	
	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}
	
	public String execute() {
		
		hoogsteBiedingDag = ivs.collectHoogsteBiedingDag();
		if(hoogsteBiedingDag == null) {
			System.out.println("Hoogstebieding dag is null");
		}
		hoogsteBiedingMaand = ivs.collectHoogsteBiedingMaand();
		if(hoogsteBiedingMaand == null) {
			System.out.println("Hoogstebieding maand is null");
		}
		hoogsteBiedingJaar = ivs.collectHoogsteBiedingJaar();
		if(hoogsteBiedingJaar == null) {
			System.out.println("Hoogstebieding jaar is null");
		}
		veilingMeesteBiedingen = ivs.collectVeilingMeesteBieding();
		return ActionSupport.SUCCESS;
	}

	

	public Bieding getHoogsteBiedingDag() {
		return hoogsteBiedingDag;
	}

	public void setHoogsteBiedingDag(Bieding hoogsteBiedingDag) {
		this.hoogsteBiedingDag = hoogsteBiedingDag;
	}

	public Bieding getHoogsteBiedingMaand() {
		return hoogsteBiedingMaand;
	}

	public void setHoogsteBiedingMaand(Bieding hoogsteBiedingMaand) {
		this.hoogsteBiedingMaand = hoogsteBiedingMaand;
	}

	public Bieding getHoogsteBiedingJaar() {
		return hoogsteBiedingJaar;
	}

	public void setHoogsteBiedingJaar(Bieding hoogsteBiedingJaar) {
		this.hoogsteBiedingJaar = hoogsteBiedingJaar;
	}

	public Bieding getVeilingMeesteBiedingen() {
		return veilingMeesteBiedingen;
	}

	public void setVeilingMeesteBiedingen(Bieding veilingMeesteBiedingen) {
		this.veilingMeesteBiedingen = veilingMeesteBiedingen;
	}
	
	

}
