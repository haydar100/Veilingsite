package veilingActions.administrator;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import veilingQuerys.IVeilingService;
import veilingService.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("rawtypes")
public class BlockUser extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1612997551515684335L;
	private IVeilingService ivs = ServiceProvider.getveilingService();
	private String email;
	
	private Map session;
	private ArrayList<String> allNonBlockedUsers = new ArrayList<String>();



	public String getEmail() {
		return email;
	}
	
	public String execute() {
		ivs.BlockUser(email);
		setAllNonBlockedUsers(ivs.collectNonBlockedUsers());
		addActionMessage("Gebruiker met de email " + email + " is succesvol geblokkeerd");
		return ActionSupport.SUCCESS;
	}
	
	

	
	

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public IVeilingService getIvs() {
		return ivs;
	}

	public void setIvs(IVeilingService ivs) {
		this.ivs = ivs;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}
	
	public ArrayList<String> getAllNonBlockedUsers() {
		return allNonBlockedUsers;
	}

	public void setAllNonBlockedUsers(ArrayList<String> allNonBlockedUsers) {
		this.allNonBlockedUsers = allNonBlockedUsers;
	}
	
	


}
