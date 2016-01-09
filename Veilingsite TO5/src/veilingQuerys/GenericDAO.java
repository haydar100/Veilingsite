package veilingQuerys;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import veilingDomain.Koper;
import veilingDomain.Medewerker;
import veilingDomain.Recht.TYPE;
import veilingDomain.Verkoper;

public class GenericDAO {
	private static final String ORACLE_DB_DRIV = "oracle.jdbc.driver.OracleDriver";
	private static final String ORACLE_DB_CONN = "jdbc:oracle:thin:@ondora01.hu.nl:8521:cursus01";
	private static final String ORACLE_DB_USER = "tho5_2013_2a_team1";
	private static final String ORACLE_DB_PASS = "kaas";

	public GenericDAO() {

	}

	public static Connection DatabaseConnect() {
		Connection con = null;
		try {
			Class.forName(ORACLE_DB_DRIV).newInstance();
			con = DriverManager.getConnection(ORACLE_DB_CONN, ORACLE_DB_USER,
					ORACLE_DB_PASS);
		} catch (ClassNotFoundException nfe) {
			System.out.println("Databaseverbinding niet tot stand gebracht");
		} catch (ReflectiveOperationException roe) {
			roe.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;
	}

	public static Statement DatabaseConnectStatement(Connection con) {
		Statement st = null;
		try {
			st = con.createStatement();

		} catch (SQLException e) {

		}
		return st;
	}

	public static void DatabaseDisconnect(Connection con, Statement st) {
		try {
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Databaseverbinding kan niet verbroken worden");
		}

	}
	
	public static void DatabaseDisconnectPrepareStatement(Connection con, PreparedStatement ps) {
		try {
			ps.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Databaseverbinding kan niet verbroken worden");
		}

	}

	// Inlogquery
	public static boolean DatabaseLogin(String email, String password) {
		boolean success = false;
		Connection con = DatabaseConnect();
		Statement st = DatabaseConnectStatement(con);
		boolean checkLoginData = DatabaseCheckLogin(email, password);
		if (checkLoginData) {
			try {
				String queryGetData = "SELECT USERNAME FROM gebruiker WHERE email = '"
						+ email + "' AND password= '" + password + "';";
				ResultSet rest1 = st.executeQuery(queryGetData);
				while (rest1.next()) {
					// FOUT Gebruiker g = new Gebruiker(rest1.getString(1));
					success = true;
				}
			} catch (SQLException se) {

			}
			DatabaseDisconnect(con, st);
		}
		return success;
	}

	// Controleren of de inloggegevens overeenkomen
	public static boolean DatabaseCheckLogin(String email, String password) {
		boolean correct = false;
		Connection con = DatabaseConnect();
		Statement st = DatabaseConnectStatement(con);
		try {
			String queryCheckCombination = "SELECT ID FROM gebruiker WHERE email = \'"
					+ email + "\' AND password= \'" + password + "\'";
			ResultSet rest = st.executeQuery(queryCheckCombination);
			int rows = 0;
			while (rest.next()) {
				rows += Integer.parseInt(rest.getString(1));
			}
			if (rows > 0) {
				correct = true;
			}
		} catch (SQLException se) {

		}
		DatabaseDisconnect(con, st);
		return correct;
	}

	// Query voor het registreren van een koper
	@SuppressWarnings("unused")
	public static boolean DatabaseAddKoper(Koper nweK) {

		boolean added = false;
		String email = nweK.getEmail();
		String password = nweK.getPassword();
		TYPE recht = nweK.getRecht();
		String woonplaats = nweK.getWoonplaats();
		String straat = nweK.getStraat();
		String huisnummer = nweK.getHuisnummer();
		String postcode = nweK.getPostcode();
		String telefoonnummer = nweK.getTelefoonnummer();
		String voornaam = nweK.getVoornaam();
		String achternaam = nweK.getAchternaam();
		String geboortedatum = nweK.getGeboortedatum();
		BigDecimal credits = nweK.getCredits();
		String rekeningnummer = nweK.getRekeningnummer();

		// boolean checkEmail = DatabaseCheckEmailAvailable(email);
		// if(checkEmail) {

		Connection con = DatabaseConnect();
		Statement st = DatabaseConnectStatement(con);
		try {

			// HIER MOET LATER GEBOORTEDATUM WEER WORDENT TOEGEVOEGD
			String query = "INSERT INTO gebruiker (EMAIL, PASSWORD, RECHT, WOONPLAATS, STRAAT, HUISNUMMER, POSTCODE, "
					+ "TELEFOONNUMMER, VOORNAAM, ACHTERNAAM"
					+ ") VALUES (\'"
					+ email
					+ "\' , \'"
					+ password
					+ "\' , \'"
					+ recht.toString()
					+ "\' , \'"
					+ woonplaats
					+ "\' , \'"
					+ straat
					+ "\' , \'"
					+ huisnummer
					+ "\' , \'"
					+ postcode
					+ "\' , \'"
					+ telefoonnummer
					+ "\' , \'"
					+ voornaam
					+ "\' , \'"
					+ achternaam
					+ "\')";
			System.out.println(query);
			st.executeUpdate(query);
			added = true;
		} catch (SQLException se) {

			System.out.println(se.getMessage() + "\r\n" + se.toString());
		}
		DatabaseDisconnect(con, st);
		// }
		// else {
		// Email komt al voor
		// }
		return added;

	}

	// Query om te zoeken of de email al voorkomt
	public static boolean DatabaseCheckEmailAvailable(String email) {
		boolean success = false;
		Connection con = DatabaseConnect();
		Statement st = DatabaseConnectStatement(con);
		try {
			String query = "SELECT COUNT(*) FROM gebruiker WHERE email = '"
					+ email + "';";
			ResultSet result = st.executeQuery(query);
			int rows = 0;
			while (result.next()) {
				rows = Integer.parseInt(result.getString(1));
			}
			if (rows == 0) {
				success = true;
			}
		} catch (SQLException se) {

		}

		DatabaseDisconnect(con, st);
		return success;
	}

	// Query voor het registreren van een verkoper
	public static boolean DatabaseAddVerkoper(Verkoper nweVK) {
		boolean added = false;
		String email = nweVK.getEmail();
		String password = nweVK.getPassword();
		TYPE recht = nweVK.getRecht();
		String woonplaats = nweVK.getWoonplaats();
		String straat = nweVK.getStraat();
		String huisnummer = nweVK.getHuisnummer();
		String postcode = nweVK.getPostcode();
		String telefoonnummer = nweVK.getTelefoonnummer();
		String bedrijfsnaam = nweVK.getBedrijfsnaam();
		String kvknummer = nweVK.getKvkNummer();
		String rekeningnummer = nweVK.getRekeningnummer();
		boolean checkEmail = DatabaseCheckEmailAvailable(email);
		if (checkEmail) {
			Connection con = DatabaseConnect();
			Statement st = DatabaseConnectStatement(con);
			try {
				String query = "INSERT INTO gebruiker (email, password, recht, woonplaats, straat, huisnummer, postcode, "
						+ "telefoonnummer, voornaam, achternaam, geboortedatum, credits, rekeningnummer, functie, bedrijfsnaam, "
						+ "kvknummer, veiling_id) VALUES ('"
						+ email
						+ "' , '"
						+ password
						+ "' , '"
						+ recht
						+ "' , '"
						+ woonplaats
						+ "' , '"
						+ straat
						+ "' , '"
						+ huisnummer
						+ "' , '"
						+ postcode
						+ "' , '"
						+ telefoonnummer
						+ "' , '' , '' , '' , '' , '"
						+ rekeningnummer
						+ "' , '','"
						+ bedrijfsnaam
						+ "','"
						+ kvknummer + "','';";
				st.executeUpdate(query);
				added = true;
			} catch (SQLException se) {

			}
			DatabaseDisconnect(con, st);
		} else {
			// Email komt al voor
		}
		return added;

	}

	// Query voor het registreren van een medewerker
	public static boolean DatabaseAddMedewerker(Medewerker nweMW) {
		boolean added = false;
		String email = nweMW.getEmail();
		String password = nweMW.getPassword();
		TYPE recht = nweMW.getRecht();
		String woonplaats = nweMW.getWoonplaats();
		String straat = nweMW.getStraat();
		String huisnummer = nweMW.getHuisnummer();
		String postcode = nweMW.getPostcode();
		String telefoonnummer = nweMW.getTelefoonnummer();

		String voornaam = nweMW.getVoornaam();
		String achternaam = nweMW.getAchternaam();
		String functie = nweMW.getFunctie();
		Date geboortedatum = nweMW.getGeboortedatum();

		boolean checkEmail = DatabaseCheckEmailAvailable(email);
		if (checkEmail) {
			Connection con = DatabaseConnect();
			Statement st = DatabaseConnectStatement(con);
			try {
				String query = "INSERT INTO gebruiker (email, password, recht, woonplaats, straat, huisnummer, postcode, "
						+ "telefoonnummer, voornaam, achternaam, geboortedatum, credits, rekeningnummer, functie, bedrijfsnaam, "
						+ "kvknummer, veiling_id) VALUES ('"
						+ email
						+ "' , '"
						+ password
						+ "' , '"
						+ recht
						+ "' , '"
						+ woonplaats
						+ "' , '"
						+ straat
						+ "' , '"
						+ huisnummer
						+ "' , '"
						+ postcode
						+ "' , '"
						+ telefoonnummer
						+ "' , '"
						+ voornaam
						+ "' , '"
						+ achternaam
						+ "' , '"
						+ geboortedatum
						+ "' , '' , '' , '" + functie + "','','','';";
				st.executeUpdate(query);
				added = true;
			} catch (SQLException se) {

			}
			DatabaseDisconnect(con, st);
		}
		return added;

	}

}