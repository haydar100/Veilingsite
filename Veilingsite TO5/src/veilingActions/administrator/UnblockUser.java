package veilingActions.administrator;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import veilingQuerys.IVeilingService;
import veilingService.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;
@SuppressWarnings("rawtypes")
public class UnblockUser extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 678092716979955391L;
	private IVeilingService ivs = ServiceProvider.getveilingService();
	private String email;
	private Map session;
	private ArrayList<String> allBlockedUsers = new ArrayList<String>();



	public String getEmail() {
		return email;
	}
	
	public String execute() {
		ivs.UnBlockUser(email);
		setAllBlockedUsers(ivs.collectBlockedUsers());
		addActionMessage("Gebruiker met de email " + email + " is succesvol gedeblokkeerd");
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
	
	public ArrayList<String> getAllBlockedUsers() {
		return allBlockedUsers;
	}

	public void setAllBlockedUsers(ArrayList<String> allBlockedUsers) {
		this.allBlockedUsers = allBlockedUsers;
	}
	
	


}
