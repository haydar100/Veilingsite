package veilingQuerys;

import veilingDomain.Koper;

public interface IKoperQueries {
	public boolean insert(Koper nweK);
	public boolean update(Koper nweK);
	public String findByEmail(String email);

}