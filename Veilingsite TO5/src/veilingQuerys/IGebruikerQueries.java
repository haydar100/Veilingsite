package veilingQuerys;

import veilingDomain.Gebruiker;

public interface IGebruikerQueries {
	 public boolean insert(Gebruiker gebruiker);
	   public boolean update(Gebruiker gebruiker);
	   public Gebruiker findByEmail (String email);
	   public boolean delete(Gebruiker gebruiker);

}
