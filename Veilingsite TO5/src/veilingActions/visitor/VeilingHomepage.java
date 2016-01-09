package veilingActions.visitor;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import veilingDomain.Veiling;
import veilingQuerys.IVeilingService;
import veilingService.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class VeilingHomepage extends ActionSupport implements SessionAware {

	private IVeilingService ivs = ServiceProvider.getveilingService();
	@SuppressWarnings("rawtypes")
	private Map session;
	private Veiling veilingMeesteBiedingen, veilingRandom;


	public String execute() {
		veilingMeesteBiedingen = ivs.collectVeilingMeesteBiedingen();
		veilingRandom = ivs.collectRandomVeiling();
		return ActionSupport.SUCCESS;
	}

	


	
	

	public IVeilingService getIvs() {
		return ivs;
	}

	public void setIvs(IVeilingService ivs) {
		this.ivs = ivs;
	}

	@SuppressWarnings("rawtypes")
	public Map getSession() {
		return session;
	}


	@SuppressWarnings("rawtypes")
	public void setSession(Map session) {
		this.session = session;

	}







	public Veiling getVeilingMeesteBiedingen() {
		return veilingMeesteBiedingen;
	}







	public void setVeilingMeesteBiedingen(Veiling veilingMeesteBiedingen) {
		this.veilingMeesteBiedingen = veilingMeesteBiedingen;
	}







	public Veiling getVeilingRandom() {
		return veilingRandom;
	}







	public void setVeilingRandom(Veiling veilingRandom) {
		this.veilingRandom = veilingRandom;
	}


}
