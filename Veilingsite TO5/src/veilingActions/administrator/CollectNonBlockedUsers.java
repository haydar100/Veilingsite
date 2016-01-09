package veilingActions.administrator;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import veilingQuerys.IVeilingService;
import veilingService.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("rawtypes")
public class CollectNonBlockedUsers extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private IVeilingService ivs = ServiceProvider.getveilingService();
	private static final long serialVersionUID = -7386653819090282898L;
	private ArrayList<String> allNonBlockedUsers = new ArrayList<String>();
	private Map session;
	private String email;

	public String execute() {
		setAllNonBlockedUsers(ivs.collectNonBlockedUsers());
		System.out.println(ivs.collectNonBlockedUsers());
		System.out.println("door de execute");
		return ActionSupport.SUCCESS;

	}

	public void validate() {

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
