package veilingActions.member;

import java.math.BigDecimal;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import veilingDomain.Koper;
import veilingQuerys.IVeilingService;
import veilingService.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("rawtypes")
public class AddCredits extends ActionSupport implements SessionAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1962442907977046933L;

	private IVeilingService ivs = ServiceProvider.getveilingService();
	private Map session;
	private String credits;

	public String execute() {
		Koper gebruiker = (Koper) session.get("loggedUser");
		try {
			gebruiker.setCredits(gebruiker.getCredits().add(new BigDecimal(credits)));
		} catch(Exception ex) {
			// Catching exceptions is for communists
		}
		ivs.updateCredits(gebruiker);
		return ActionSupport.SUCCESS;

	}

	// If this code works, it was written by Robin Kuijt. If not, I don't know
	// who wrote it.
	public void validate() {

		if (!credits.matches("^[0-9]{1,10}$")) {
			addActionError("Voer alleen getallen in, het maximumbedrag voor een transactie is 9999999999 EUR.");
		}
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
		this.session = session;	}

	public String getCredits() {
		return credits;
	}

	public void setCredits(String credits) {
		this.credits = credits;
	}
	

}
