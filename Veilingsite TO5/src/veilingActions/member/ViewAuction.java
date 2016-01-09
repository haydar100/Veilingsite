package veilingActions.member;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import veilingDomain.Veiling;
import veilingQuerys.IVeilingService;
import veilingService.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;
@SuppressWarnings({"rawtypes","unused"})
public class ViewAuction extends ActionSupport implements SessionAware {
	private ArrayList<Veiling> alleVeilingen = new ArrayList<Veiling>();
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
		alleVeilingen = ivs.collectAlleVeilingen();
		return ActionSupport.SUCCESS;
	}

	public ArrayList<Veiling> getAlleVeilingen() {
		return alleVeilingen;
	}

	public void setAlleVeilingen(ArrayList<Veiling> alleVeilingen) {
		this.alleVeilingen = alleVeilingen;
	}
	
	

}
