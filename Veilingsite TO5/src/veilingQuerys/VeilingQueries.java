package veilingQuerys;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import veilingDomain.Bieding;
import veilingDomain.Koper;
import veilingDomain.Veiling;
import veilingService.ServiceProvider;

@SuppressWarnings("rawtypes")
public class VeilingQueries implements IVeilingQueries {
	private ArrayList<Veiling> alleVeilingen;
	private ArrayList<Bieding> alleBiedingen;
	private IVeilingService ivs = ServiceProvider.getveilingService();

	@Override
	public boolean insert(Veiling nweV, String email) {

		boolean success = false;
		Connection con = GenericDAO.DatabaseConnect();
		String querygetID = "SELECT MAX(ID) FROM VEILING";
		PreparedStatement ps1 = null;
		String queryBinduser = "INSERT INTO MARKT VALUES(?,?)";
		PreparedStatement ps2 = null;
		String sql = "INSERT INTO VEILING (ID, STARTDATUM, SLUITDATUM, CATEGORIE, ARTIKELNUMMER, OMSCHRIJVING, MINIMUMBEDRAG, AANTAL) VALUES (?,?,?,?,?,?,?,?)";
		PreparedStatement ps = null;

		try {
			ps1 = con.prepareStatement(querygetID);
			ResultSet rest = ps1.executeQuery();
			int id = 0;
			while (rest.next()) {
				id = rest.getInt(1);
			}
			id++;
			System.out.println(id);
			ps2 = con.prepareStatement(queryBinduser);
			ps2.setString(1, email);
			ps2.setInt(2, id);
			ps2.execute();
			java.sql.Date CstartDatum = new Date(nweV.getStartdatum().getTime());
			java.sql.Date CsluitDatum = new Date(nweV.getSluitdatum().getTime());
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setDate(2, CstartDatum);
			ps.setDate(3, CsluitDatum);
			ps.setString(4, nweV.getCategorie());
			ps.setString(5, nweV.getArtikelnummer());
			ps.setString(6, nweV.getOmschrijving());
			ps.setDouble(7, nweV.getMinimumbedrag());
			ps.setInt(8, nweV.getAantal());
			ps.execute();
			success = true;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQLException opgetreden in de insert query");
		}
		System.out.println("Veiling toegevoegd");
		GenericDAO.DatabaseDisconnectPrepareStatement(con, ps);
		return success;
	}

	@Override
	public boolean update(Veiling nweV) {
		boolean success = false;
		Connection con = GenericDAO.DatabaseConnect();
		String sql = "UPDATE VEILING SET SLUITDATUM = ?, CATEGORIE = ? , ARTIKELNUMMER = ? , OMSCHRIJVING = ?, MINIMUMBEDRAG = ?, AANTAL = ?, WHERE ID = ?";
		PreparedStatement ps = null;

		try {
			java.sql.Date CsluitDatum = new Date(nweV.getSluitdatum().getTime());
			ps = con.prepareStatement(sql);
			ps.setDate(1, CsluitDatum);
			ps.setString(2, nweV.getCategorie());
			ps.setString(3, nweV.getArtikelnummer());
			ps.setString(4, nweV.getOmschrijving());
			ps.setDouble(5, nweV.getMinimumbedrag());
			ps.setInt(6, nweV.getAantal());
			ps.setInt(7, nweV.getId());
			ps.execute();
			success = true;

		} catch (SQLException e) {
			System.out.println("update statement failed (update veilingDAO)");
			e.printStackTrace();

		}
		GenericDAO.DatabaseDisconnectPrepareStatement(con, ps);
		return success;
	}

	@Override
	public boolean delete(int id) {
		boolean success = false;
		Connection con = GenericDAO.DatabaseConnect();
		String sql = "DELETE FROM VEILING WHERE ID = ?";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
			success = true;

		} catch (SQLException e) {
			System.out.println("Veiling verwijderen mislukt");
			e.printStackTrace();

		}
		GenericDAO.DatabaseDisconnectPrepareStatement(con, ps);
		System.out.println("Veiling verwijderd");
		return success;
	}

	@Override
	public ArrayList<Veiling> findByCategorie(String categorie) {
		Connection con = GenericDAO.DatabaseConnect();
		String sql = "SELECT * FROM VEILING WHERE CATEGORIE = ?";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, categorie);
			ResultSet rV = ps.executeQuery();
			alleVeilingen = new ArrayList<Veiling>();
			while (rV.next()) {
				Veiling v = new Veiling(rV.getInt(1), rV.getDate(2), rV.getDate(3), rV.getString(4), rV.getString(5), rV.getString(6),
						rV.getDouble(7), rV.getInt(8));
				alleVeilingen.add(v);
				System.out.println(v);
			}

		} catch (SQLException e) {
			System.out.println("Veiling sorteren by category");
			e.printStackTrace();

		}
		GenericDAO.DatabaseDisconnectPrepareStatement(con, ps);
		return alleVeilingen;
	}

	@Override
	public ArrayList<Veiling> collectAlleVeilingen() {
		Connection con = GenericDAO.DatabaseConnect();
		String sql = "SELECT * FROM VEILING ORDER BY ID ASC";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ResultSet rV = ps.executeQuery();
			alleVeilingen = new ArrayList<Veiling>();
			while (rV.next()) {
				Veiling v = new Veiling(rV.getInt(1), rV.getDate(2), rV.getDate(3), rV.getString(4), rV.getString(5), rV.getString(6),
						rV.getDouble(7), rV.getInt(8));
				alleVeilingen.add(v);
			}

		} catch (SQLException e) {
			System.out.println("verzamelen van de veilingen mislukt");
			e.printStackTrace();

		}
		GenericDAO.DatabaseDisconnectPrepareStatement(con, ps);
		return alleVeilingen;
	}

	public ArrayList<Bieding> collectAlleBiedingen(int veiling_id) {
		Connection con = GenericDAO.DatabaseConnect();
		String sql = "SELECT B.ID, G.EMAIL, B.VEILING_ID, B.BEDRAG, B.DATUM FROM BOD B, GEBRUIKER G WHERE VEILING_ID = ? AND B.GEBRUIKER_ID = G.ID";
		PreparedStatement ps = null;
		alleBiedingen = new ArrayList<Bieding>();
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, veiling_id);
			ResultSet rest = ps.executeQuery();
			while (rest.next()) {
				Bieding nweB = new Bieding(rest.getInt(1), rest.getString(2), rest.getInt(3), rest.getDouble(4), rest.getDate(5));
				alleBiedingen.add(nweB);
			}

		} catch (SQLException e) {
			System.out.println("Verzamelen van alleBiedingen mislukt");
			e.printStackTrace();

		}
		GenericDAO.DatabaseDisconnectPrepareStatement(con, ps);
		return alleBiedingen;
	}

	public Bieding collectHoogsteBiedingDag() {
		Bieding highest = null;
		Connection con = GenericDAO.DatabaseConnect();
		String sql = "SELECT B.ID, G.EMAIL, B.VEILING_ID, B.BEDRAG, B.DATUM FROM BOD B, GEBRUIKER G WHERE B.BEDRAG IN (SELECT MAX(BEDRAG) FROM BOD B WHERE TO_CHAR(DATUM, 'DD-MM-YY') IN (SELECT TO_CHAR(SYSDATE, 'DD-MM-YY') FROM DUAL)) AND G.ID = B.GEBRUIKER_ID  ORDER BY VEILING_ID ASC";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ResultSet rest = ps.executeQuery();
			while (rest.next()) {
				highest = new Bieding(rest.getInt(1), rest.getString(2), rest.getInt(3), rest.getDouble(4), rest.getDate(5));
				break;
			}

		} catch (SQLException e) {
			System.out.println("Hoogste bieding per dag mislukt");
			e.printStackTrace();

		}
		GenericDAO.DatabaseDisconnectPrepareStatement(con, ps);
		return highest;
	}
	public Veiling collectVeilingMeesteBiedingen(){
		Veiling v = null;
		Connection con = GenericDAO.DatabaseConnect();
		String sql = "SELECT V.ID, V.STARTDATUM, V.SLUITDATUM, V.CATEGORIE, V.ARTIKELNUMMER, V.OMSCHRIJVING, V.MINIMUMBEDRAG, V.AANTAL, MAX(B.BEDRAG) FROM VEILING V, BOD B WHERE B.VEILING_ID = V.ID trunc(sysdate) < V.SLUITDATUM GROUP BY V.ID, V.STARTDATUM, V.SLUITDATUM, V.CATEGORIE, V.ARTIKELNUMMER, V.OMSCHRIJVING, V.MINIMUMBEDRAG, V.AANTAL HAVING V.ID IN (SELECT VEILING_ID FROM BOD GROUP BY VEILING_ID HAVING COUNT(ID) IN (SELECT MAX(COUNT(ID)) FROM BOD GROUP BY VEILING_ID));";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ResultSet rest = ps.executeQuery();
			while (rest.next()) {
				v = new Veiling(rest.getInt(1), rest.getDate(2),rest.getDate(3), rest.getString(4), rest.getString(5), rest.getString(6), rest.getDouble(7), rest.getInt(8), rest.getDouble(9));
				break;
			}

		} catch (SQLException e) {
			System.out.println("Hoogste bieding per dag mislukt");
			e.printStackTrace();

		}
		GenericDAO.DatabaseDisconnectPrepareStatement(con, ps);
		return v;
	}

	public Bieding collectHoogsteBiedingMaand() {
		Bieding highest = null;
		Connection con = GenericDAO.DatabaseConnect();
		String sql = "SELECT B.ID, G.EMAIL, B.VEILING_ID, B.BEDRAG, B.DATUM FROM BOD B, GEBRUIKER G WHERE B.BEDRAG IN (SELECT MAX(BEDRAG) FROM BOD B WHERE TO_CHAR(DATUM, 'MM-YY') IN (SELECT TO_CHAR(SYSDATE, 'MM-YY') FROM DUAL)) AND G.ID = B.GEBRUIKER_ID  ORDER BY VEILING_ID ASC";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ResultSet rest = ps.executeQuery();
			while (rest.next()) {
				highest = new Bieding(rest.getInt(1), rest.getString(2), rest.getInt(3), rest.getDouble(4), rest.getDate(5));
				break;
			}

		} catch (SQLException e) {
			System.out.println("Hoogste bieding per dag mislukt");
			e.printStackTrace();

		}
		GenericDAO.DatabaseDisconnectPrepareStatement(con, ps);
		return highest;
	}

	public Bieding collectVeilingMeesteBieding() {
		Bieding highest = null;
		Connection con = GenericDAO.DatabaseConnect();
		String sql = "SELECT DISTINCT VEILING_ID, COUNT(ID) FROM BOD GROUP BY VEILING_ID ORDER BY COUNT(ID) DESC";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ResultSet rest = ps.executeQuery();
			while (rest.next()) {
				highest = new Bieding(rest.getInt(1), rest.getInt(2));
				break;
			}

		} catch (SQLException e) {
			System.out.println("Hoogste bieding per dag mislukt");
			e.printStackTrace();

		}
		GenericDAO.DatabaseDisconnectPrepareStatement(con, ps);
		return highest;
	}

	public Bieding collectHoogsteBiedingJaar() {
		Bieding highest = null;
		Connection con = GenericDAO.DatabaseConnect();
		String sql = "SELECT B.ID, G.EMAIL, B.VEILING_ID, B.BEDRAG, B.DATUM FROM BOD B, GEBRUIKER G WHERE B.BEDRAG IN (SELECT MAX(BEDRAG) FROM BOD B WHERE TO_CHAR(DATUM, 'YY') IN (SELECT TO_CHAR(SYSDATE, 'YY') FROM DUAL)) AND G.ID = B.GEBRUIKER_ID  ORDER BY VEILING_ID ASC";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ResultSet rest = ps.executeQuery();
			while (rest.next()) {
				highest = new Bieding(rest.getInt(1), rest.getString(2), rest.getInt(3), rest.getDouble(4), rest.getDate(5));
			}

		} catch (SQLException e) {
			System.out.println("Hoogste bieding per dag mislukt");
			e.printStackTrace();

		}
		GenericDAO.DatabaseDisconnectPrepareStatement(con, ps);
		return highest;
	}

	public boolean addBod(Koper k, Veiling v, double bid) {
		boolean success = false;
		Connection con = GenericDAO.DatabaseConnect();
		String querygetID = "SELECT MAX(ID) FROM BOD";
		PreparedStatement ps1 = null;
		String sql = "INSERT INTO BOD VALUES(?,?,?,?,?)";
		PreparedStatement ps = null;
		try {
			ps1 = con.prepareStatement(querygetID);
			ResultSet rest = ps1.executeQuery();
			int id = 0;
			while (rest.next()) {
				id = rest.getInt(1);
			}
			id++;
			java.sql.Date now = new Date(System.currentTimeMillis());
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, ivs.getGebruikerID(k));
			ps.setInt(3, v.getId());
			ps.setDouble(4, bid);
			ps.setDate(5, now);
			ps.execute();
			success = true;
		} catch (SQLException e) {
			System.out.println("update statement failed (update veilingDAO)");
			e.printStackTrace();
		}
		return success;
	}

	public Veiling collectRandomVeiling() {
		Veiling v = null;
		Connection con = GenericDAO.DatabaseConnect();
		String sql = "SELECT V.ID, V.STARTDATUM, V.SLUITDATUM, V.CATEGORIE, V.ARTIKELNUMMER, V.OMSCHRIJVING, V.MINIMUMBEDRAG, V.AANTAL, MAX(B.BEDRAG),  dbms_random.value FROM VEILING V, BOD B WHERE B.VEILING_ID = V.ID AND trunc(sysdate) < V.SLUITDATUM GROUP BY V.ID, V.STARTDATUM, V.SLUITDATUM, V.CATEGORIE, V.ARTIKELNUMMER, V.OMSCHRIJVING, V.MINIMUMBEDRAG, V.AANTAL  order by 10 ASC";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ResultSet rest = ps.executeQuery();
			while (rest.next()) {
				v = new Veiling(rest.getInt(1), rest.getDate(2),rest.getDate(3), rest.getString(4), rest.getString(5), rest.getString(6), rest.getDouble(7), rest.getInt(8), rest.getDouble(9));
				break;
			}

		} catch (SQLException e) {
			System.out.println("Hoogste bieding per dag mislukt");
			e.printStackTrace();

		}
		GenericDAO.DatabaseDisconnectPrepareStatement(con, ps);
		return v;
	}
}