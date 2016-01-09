package veilingQuerys;

import java.util.ArrayList;

import veilingDomain.Veiling;

public interface IVeilingQueries {
	 public boolean insert(Veiling veiling, String email);
	   public boolean update(Veiling veiling);
	   public  ArrayList<Veiling> findByCategorie(String categorie);
	   public ArrayList<Veiling> collectAlleVeilingen();
	   public boolean delete(int id);

}
