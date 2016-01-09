package veilingActions.administrator;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import veilingDomain.Bieding;
import veilingDomain.Veiling;
import veilingQuerys.IVeilingService;
import veilingService.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;
@SuppressWarnings("rawtypes")
public class ShowAuctionBids extends ActionSupport implements SessionAware {
	private ArrayList<Bieding> alleBiedingen = new ArrayList<Bieding>();
	private String id;
	private int veiling_id;
	
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
		veiling_id = Integer.parseInt(id);
		alleBiedingen = ivs.collectAlleBiedingen(veiling_id);
		return ActionSupport.SUCCESS;
	}

	public ArrayList<Bieding> getAlleBiedingen() {
		return alleBiedingen;
	}

	public void setAlleBiedingen(ArrayList<Bieding> alleBiedingen) {
		this.alleBiedingen = alleBiedingen;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getVeiling_id() {
		return veiling_id;
	}

	public void setVeiling_id(int veiling_id) {
		this.veiling_id = veiling_id;
	}

	
	
	

}
