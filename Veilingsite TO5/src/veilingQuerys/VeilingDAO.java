package veilingQuerys;

import veilingDomain.Veiling;

public interface VeilingDAO {
	 public boolean insert(Veiling veiling);
	   public boolean update(Veiling veiling);
	   public boolean findByVeilingname (String naam);
	   public boolean delete(Veiling veiling);

}
