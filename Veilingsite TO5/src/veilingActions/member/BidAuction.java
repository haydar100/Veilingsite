package veilingActions.member;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import veilingDomain.Bieding;
import veilingDomain.Koper;
import veilingDomain.Veiling;
import veilingQuerys.IVeilingService;
import veilingService.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;


public class BidAuction extends ActionSupport implements SessionAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3812256207079023043L;
	private IVeilingService ivs = ServiceProvider.getveilingService();
	private Veiling auction;
	private Map session;
	private double bid;
	private Koper user;
	private Integer id;
	Koper highestBidder;
	double highestBid = 0.0;
	private double huidigBod;
	private String huidigeBieder = "NOTHING";
	
	public String execute() {
		if (highestBidder != null) {
			highestBidder.addCredits(new BigDecimal(highestBid));
		}
		user.removeCredits(new BigDecimal(bid));
		ivs.updateCredits(user);
		ivs.updateCredits(highestBidder);
		ivs.addBod(user, auction, bid);
		List<Bieding> biedingen = ivs.collectAlleBiedingen(id);

		for (Bieding b : biedingen) {
	
			if (huidigBod < b.getBedrag()) {
				huidigBod = b.getBedrag();
				huidigeBieder = ((Koper) ivs.getGebruikerDoorEmail(b.getGebruikermail())).getVoornaam();
		
			}
		}
		return ActionSupport.SUCCESS;
	}

	public void validate() {
		
		user = (Koper) session.get("loggedUser");
		if(user != null){
		List<Veiling> veilingen = ivs.collectAlleVeilingen();
		for (Veiling v : veilingen) {
			if (v.getId() == this.id){
				auction = v;
				break;
			}
		}
		
		if (bid < auction.getMinimumbedrag()) {
			addFieldError("bid", "Het minimumbod voor deze veiling moet " + auction.getMinimumbedrag() + " EUR bedragen.");
		}
		if (new BigDecimal(bid).compareTo(user.getCredits()) == 1) {
			addFieldError("bid", "Onvoldoende credits, kies voor credits opwaarderen in het hoofdmenu.");
		}
		
		List<Bieding> biedingen = ivs.collectAlleBiedingen(id);
	
		
		
		for (Bieding b : biedingen) {
			if (highestBid < b.getBedrag()) {
				highestBid = b.getBedrag();
				highestBidder = (Koper) ivs.getGebruikerDoorEmail(b.getGebruikermail());
			}
		}
		
		if (bid < highestBid) {
			addFieldError("bid", "U moet hoger bieden dan uw voorganger, uw voorganger bood " + highestBid + " EUR.");
		}
		//Check wat het huidige hoogste bod is
		//Eat cake
		//There be dragonz
		}
		else{addFieldError("bid", "U moet inloggen om mee te kunnen bieden ");}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Veiling getAuction() {
		return auction;
	}

	public void setAuction(Veiling auction) {
		this.auction = auction;
	}

	public double getBid() {
		return bid;
	}

	public void setBid(double bid) {
		this.bid = bid;
	}
	
//                                _/|__
//            _,-------,        _/ -|  \_     /~>.
//         _-~ __--~~/\ |      (  \   /  )   | / |
//      _-~__--    //   \\      \ *   * /   / | ||   
//   _-~_--       //     ||      \     /   | /  /|  
//  ~ ~~~~-_     //       \\     |( " )|  / | || /  
//          \   //         ||    | VWV | | /  ///  
//    |\     | //           \\ _/      |/ | ./ |
//    | |    |// __         _-~         \// |  /
//   /  /   //_-~  ~~--_ _-~  /          |\// /  
//  |  |   /-~        _-~    (     /   |/ / /   
// /   /           _-~  __    |   |____|/     
//|   |__         / _-~  ~-_  (_______  `\
//|      ~~--__--~ /  _     \        __\)))
// \               _-~       |     ./  \    
//  ~~--__        /         /    _/     |
//        ~~--___/       _-_____/      /            
//         _____/     _-_____/      _-~             
//      /^<  ___       -____         -____          
//         ~~   ~~--__      ``\--__       ``\
//                    ~~--\)\)\)   ~~--\)\)\) 	
//
//	I TOLD YOU THERE WILL BE DRAGONZ!!
}
