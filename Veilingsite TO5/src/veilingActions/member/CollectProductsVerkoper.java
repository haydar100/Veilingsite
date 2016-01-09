package veilingActions.member;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import veilingDomain.Gebruiker;
import veilingDomain.Veiling;
import veilingDomain.Verkoper;
import veilingQuerys.IVeilingService;
import veilingService.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("rawtypes")
public class CollectProductsVerkoper extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = -5451616020339801939L;
	private IVeilingService ivs = ServiceProvider.getveilingService();
	private ArrayList<Veiling> alleProducten = new ArrayList<Veiling>();
	private Map session;
	private Gebruiker gebruiker;

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}
	
	public String execute() {
		alleProducten = ivs.alleProductenVerkoper((Verkoper) gebruiker);
		return ActionSupport.SUCCESS;
	}
	
	public void validate() {
		gebruiker = (Gebruiker) session.get("loggedUser");
		if(gebruiker instanceof Verkoper) {
		
		}
		addActionError("Gebruiker is geen verkoper, dus er kunnen geen producten worden opgehaald");
	}
	
	public IVeilingService getIvs() {
		return ivs;
	}

	public void setIvs(IVeilingService ivs) {
		this.ivs = ivs;
	}

	public ArrayList<Veiling> getAlleProducten() {
		return alleProducten;
	}

	public void setAlleProducten(ArrayList<Veiling> alleProducten) {
		this.alleProducten = alleProducten;
	}

	public Gebruiker getGebruiker() {
		return gebruiker;
	}

	public void setGebruiker(Gebruiker gebruiker) {
		this.gebruiker = gebruiker;
	}

	
}
