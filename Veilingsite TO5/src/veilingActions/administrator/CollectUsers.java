package veilingActions.administrator;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import veilingDomain.Koper;
import veilingDomain.Verkoper;
import veilingQuerys.IVeilingService;
import veilingService.ServiceProvider;

@SuppressWarnings("rawtypes")
public class CollectUsers extends ActionSupport implements SessionAware {
	/**
	 *
	 */
	
	private static final long serialVersionUID = 6868019799738586823L;
	private IVeilingService ivs = ServiceProvider.getveilingService();
	private ArrayList<Koper> alleKopers = new ArrayList<Koper>();
	private ArrayList<Verkoper> alleVerkopers = new ArrayList<Verkoper>();

	public ArrayList<Koper> getAlleKopers() {
		return alleKopers;
	}
	
	public String execute() {
		alleKopers = ivs.alleKopers();
		setAlleVerkopers(ivs.alleVerkopers());
		
		return ActionSupport.SUCCESS;
	}
	
	public void validate() {
		
	}

	public void setAlleKopers(ArrayList<Koper> alleKopers) {
		this.alleKopers = alleKopers;
	}

	public ArrayList<Verkoper> getAlleVerkopers() {
		return alleVerkopers;
	}

	public void setAlleVerkopers(ArrayList<Verkoper> alleVerkopers) {
		this.alleVerkopers = alleVerkopers;
	}

	private Map session;
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}
}




