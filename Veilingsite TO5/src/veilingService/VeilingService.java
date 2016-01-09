package veilingService;

import java.util.ArrayList;

import veilingDomain.Bieding;
import veilingDomain.Gebruiker;
import veilingDomain.Koper;
import veilingDomain.Medewerker;
import veilingDomain.Veiling;
import veilingDomain.Verkoper;
import veilingQuerys.GebruikerQueries;
import veilingQuerys.GenericDAO;
import veilingQuerys.IVeilingService;
import veilingQuerys.KoperQueries;
import veilingQuerys.MedewerkerQueries;
import veilingQuerys.VeilingQueries;
import veilingQuerys.VerkoperQueries;

@SuppressWarnings({"unused","static-access"})
public class VeilingService implements IVeilingService {

	private IVeilingService ivs = ServiceProvider.getveilingService();
	private KoperQueries koper;
	private MedewerkerQueries medewerker;
	private VerkoperQueries verkoper;
	private VeilingQueries veiling;
	private GebruikerQueries gebruiker;
	private GenericDAO GDAO;

	public VeilingService() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see veilingService.IVeilingService#addKoper(veilingDomain.Koper)
	 */
	@Override
	public void addKoper(Koper nweK) {
		KoperQueries koper = new KoperQueries();
		koper.insert(nweK);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see veilingService.IVeilingService#addVerkoper(veilingDomain.Verkoper)
	 */
	@Override
	public void addVerkoper(Verkoper nweVK) {
		VerkoperQueries verkoper = new VerkoperQueries();
		verkoper.insert(nweVK);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * veilingService.IVeilingService#addMedewerker(veilingDomain.Medewerker)
	 */
	@Override
	public void addMedewerker(Medewerker nweMW) {
		MedewerkerQueries medewerker = new MedewerkerQueries();
		medewerker.insert(nweMW);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see veilingService.IVeilingService#login(java.lang.String,
	 * java.lang.String)
	 */
	
	@Override
	public boolean login(String email, String password) {
		GenericDAO GDAO = new GenericDAO();
		return GDAO.DatabaseCheckLogin(email, password);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see veilingService.IVeilingService#userExists(java.lang.String)
	 */
	@Override
	public boolean userExists(String email) {
		return GDAO.DatabaseCheckEmailAvailable(email);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * veilingService.IVeilingService#getGebruikerDoorEmail(java.lang.String)
	 */
	@Override
	public Gebruiker getGebruikerDoorEmail(String email) {
		GebruikerQueries gebruiker = new GebruikerQueries();
		return gebruiker.findByEmail(email);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see veilingService.IVeilingService#verwijderGebruiker()
	 */
	@Override
	public void verwijderGebruiker() {
		// queries nog niet gemaakt
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see veilingService.IVeilingService#changePassword()
	 */
	@Override
	public void changePassword() {
		// ook nog niet
	}

	@Override
	public String findKoperByEmail(String email) {
		KoperQueries koper = new KoperQueries();
		String foundEmail = koper.findByEmail(email);
		return foundEmail;
	}

	public KoperQueries getKoper() {
		return koper;
	}

	public void setKoper(KoperQueries koper) {
		this.koper = koper;
	}

	@Override
	public Gebruiker getGebruiker(String email, String password) {
		GebruikerQueries gebruiker = new GebruikerQueries();
		return gebruiker.getGebruiker(email, password);

	}

	@Override
	public void updateKoper(Koper nweK) {
		KoperQueries koper = new KoperQueries();
		koper.update(nweK);

	}

	@Override
	public ArrayList<Veiling> collectAlleVeilingen() {
		VeilingQueries veiling = new VeilingQueries();
		return veiling.collectAlleVeilingen();
	}
	
	@Override
	public void BlockUser (String email) {
		GebruikerQueries gebruiker = new GebruikerQueries();
		gebruiker.BlockUser(email);
	}
	
	
	@Override
	public void UnBlockUser(String email) {
		GebruikerQueries gebruiker = new GebruikerQueries();
		gebruiker.UnBlockUser(email);
		
	}

	@Override
	public ArrayList<String> collectBlockedUsers() {
		GebruikerQueries gebruiker = new GebruikerQueries();
		return gebruiker.collectBlockedUsers();
	}
	
	
	

	@Override
	public ArrayList<Veiling> findByCategorie(String categorie) {
		VeilingQueries veiling = new VeilingQueries();
		return veiling.findByCategorie(categorie);
	}
	
	
	@Override
	public ArrayList<String> collectNonBlockedUsers() {
		GebruikerQueries gebruiker = new GebruikerQueries();
		return gebruiker.collectNonBlockedUsers();
	}

	@Override
	public void addVeiling(Veiling nweV, String email) {
		VeilingQueries veiling = new VeilingQueries();
		veiling.insert(nweV, email);
	}

	@Override
	public void deleteVeiling(int id) {
		VeilingQueries veiling = new VeilingQueries();
		veiling.delete(id);
	}

	@Override
	public void updateVeiling(Veiling V) {
		VeilingQueries veiling = new VeilingQueries();
		veiling.update(V);
	}

	@Override
	public boolean isBlocked(String email) {
		GebruikerQueries gebruiker = new GebruikerQueries();
		return gebruiker.isBlocked(email);
	}

	@Override
	public ArrayList<Verkoper> alleVerkopers() {
		VerkoperQueries verkoper = new VerkoperQueries();
		return verkoper.alleVerkopers();
	}

	@Override
	public ArrayList<Koper> alleKopers() {
		KoperQueries koper = new KoperQueries();
		return koper.alleKopers();
	}
	
	public void adminUpdateKoper(Koper nweK) {
		KoperQueries koper = new KoperQueries();
		koper.adminUpdateKoper(nweK);
	}

	@Override
	public void adminUpdateVerkoper(Verkoper nweV) {
		VerkoperQueries verkoper = new VerkoperQueries();
		verkoper.adminUpdateVerkoper(nweV);
		
	}

	public ArrayList<Veiling> alleProductenVerkoper(Verkoper v) {
		VerkoperQueries verkoper = new VerkoperQueries();
		return verkoper.alleProductenVerkoper(v);
	}

	@Override
	public ArrayList<Bieding> collectAlleBiedingen(int veiling_id) {
		VeilingQueries veiling = new VeilingQueries();
		return veiling.collectAlleBiedingen(veiling_id);
	}

	@Override
	public Bieding collectHoogsteBiedingDag() {
		VeilingQueries veiling = new VeilingQueries();
		return veiling.collectHoogsteBiedingDag();
	}

	@Override
	public Bieding collectHoogsteBiedingMaand() {
		VeilingQueries veiling = new VeilingQueries();
		return veiling.collectHoogsteBiedingMaand();
	}

	@Override
	public Bieding collectVeilingMeesteBieding() {
		VeilingQueries veiling = new VeilingQueries();
		return veiling.collectVeilingMeesteBieding();
	}

	@Override
	public Bieding collectHoogsteBiedingJaar() {
		VeilingQueries veiling = new VeilingQueries();
		return veiling.collectHoogsteBiedingJaar();
	}
	
	public boolean addBod(Koper k, Veiling v, double b) {
		VeilingQueries veiling = new VeilingQueries();
		return veiling.addBod(k, v, b);
	}
	
	public int getGebruikerID(Gebruiker g) {
		GebruikerQueries gebruiker = new GebruikerQueries();
		return gebruiker.getID(g.getEmail());
	}

	@Override
	public boolean updateCredits(Koper nweK) {
		KoperQueries koper = new KoperQueries(); //;;;;;;;;;
		return koper.updateCredits(nweK);
	}

	@Override
	public Veiling collectVeilingMeesteBiedingen() {
		VeilingQueries veiling = new VeilingQueries();
		return veiling.collectVeilingMeesteBiedingen();
	}

	@Override
	public Veiling collectRandomVeiling() {
		VeilingQueries veiling = new VeilingQueries();
		return veiling.collectRandomVeiling();
	}
	
	
}
