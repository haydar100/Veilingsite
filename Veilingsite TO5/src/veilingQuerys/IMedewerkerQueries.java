package veilingQuerys;

import veilingDomain.Medewerker;

public interface IMedewerkerQueries {
	 public boolean insert(Medewerker medewerker);
	   public boolean update(Medewerker medewerker);
	   public boolean findByEmail (String email);
	   public boolean delete(Medewerker medewerker);

}
