package veilingQuerys;

import java.util.ArrayList;

import veilingDomain.Bieding;
import veilingDomain.Gebruiker;
import veilingDomain.Koper;
import veilingDomain.Medewerker;
import veilingDomain.Veiling;
import veilingDomain.Verkoper;

public interface IVeilingService {

	public void addKoper(Koper nweK);

	public String findKoperByEmail(String email);

	public void addVerkoper(Verkoper nweVK);

	public void addMedewerker(Medewerker nweMW);

	public boolean login(String email, String password);

	public boolean userExists(String email);

	public Gebruiker getGebruikerDoorEmail(String email);
	public int getGebruikerID(Gebruiker g);
	public boolean addBod(Koper k, Veiling v, double b);
	public boolean updateCredits(Koper nweK);
	public void verwijderGebruiker();

	public void changePassword();

	public void updateKoper(Koper nweK);

	public Gebruiker getGebruiker(String email, String password);

	public ArrayList<Veiling> collectAlleVeilingen();

	public ArrayList<Veiling> findByCategorie(String categorie);

	public void addVeiling(Veiling nweV, String email);

	public void deleteVeiling(int id);

	public void updateVeiling(Veiling V);

	public ArrayList<String> collectNonBlockedUsers();

	public void BlockUser(String email);

	public void UnBlockUser(String email);

	public ArrayList<String> collectBlockedUsers();

	public boolean isBlocked(String email);

	public ArrayList<Verkoper> alleVerkopers();

	public ArrayList<Koper> alleKopers();

	public void adminUpdateKoper(Koper nweK);
	
	public void adminUpdateVerkoper(Verkoper nweV);
	
	public ArrayList<Veiling> alleProductenVerkoper(Verkoper v);

	public ArrayList<Bieding> collectAlleBiedingen(int veiling_id);

	public Bieding collectHoogsteBiedingDag();

	public Bieding collectHoogsteBiedingMaand();

	public Bieding collectVeilingMeesteBieding();

	public Bieding collectHoogsteBiedingJaar();
	
	public Veiling collectVeilingMeesteBiedingen();
	
	public Veiling collectRandomVeiling();

}