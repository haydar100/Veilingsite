package veilingActions.member;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import veilingDomain.Veiling;
import veilingQuerys.IVeilingService;
import veilingService.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;
@SuppressWarnings({"rawtypes","unused"})
public class ViewAuctionCategory extends ActionSupport implements SessionAware {
	private ArrayList<Veiling> alleVeilingen = new ArrayList<Veiling>();
	private String categorie; 
	public synchronized String getCategorie() {
		return categorie;
	}

	public synchronized void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public synchronized IVeilingService getIvs() {
		return ivs;
	}

	public synchronized void setIvs(IVeilingService ivs) {
		this.ivs = ivs;
	}

	public ArrayList<Veiling> getAlleVeilingen() {
		return alleVeilingen;
	}

	public void setAlleVeilingen(ArrayList<Veiling> alleVeilingen) {
		this.alleVeilingen = alleVeilingen;
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
		System.out.println(categorie);
		alleVeilingen = ivs.findByCategorie(categorie);
		
		return ActionSupport.SUCCESS;
	}
	
	

}
