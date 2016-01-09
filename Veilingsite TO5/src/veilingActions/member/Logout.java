package veilingActions.member;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import veilingQuerys.IVeilingService;
import veilingService.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("rawtypes")
public class Logout extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -3246389471152797196L;
	private IVeilingService ivs = ServiceProvider.getveilingService();
	public IVeilingService getIvs() {
		return ivs;
	}

	public void setIvs(IVeilingService ivs) {
		this.ivs = ivs;
	}

	private Map session;

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public String execute() {
		session.clear();
		return ActionSupport.SUCCESS;
	}
}
