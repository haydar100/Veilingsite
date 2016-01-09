package veilingQuerys;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import veilingDomain.Koper;
import veilingDomain.Recht.TYPE;

public class KoperQueries implements IKoperQueries {
	private ArrayList<Koper> alleKopers = new ArrayList<Koper>();

	@SuppressWarnings("unused")
	public boolean insert(Koper nweK) {
		System.out.println("Insert statement bereikt");
		boolean success = false;
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
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date input_geboortedatum;
		java.sql.Date CgeboorteDatum = null;
		try {
			input_geboortedatum = sdf.parse(geboortedatum);
			CgeboorteDatum = new Date(input_geboortedatum.getTime());
		} catch (ParseException e1) {
			System.out.println("Datum niet omgezet haha");
		}

		try {
			String sql = "INSERT INTO GEBRUIKER (EMAIL, PASSWORD, RECHT, WOONPLAATS, STRAAT, HUISNUMMER, POSTCODE, TELEFOONNUMMER, VOORNAAM, ACHTERNAAM, GEBOORTEDATUM) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
			Connection con = GenericDAO.DatabaseConnect();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setEscapeProcessing(true);
			ps.setString(1, email);
			ps.setString(2, password);
			ps.setString(3, "koper");
			ps.setString(4, woonplaats);
			ps.setString(5, straat);
			ps.setString(6, huisnummer);
			ps.setString(7, postcode);
			ps.setString(8, telefoonnummer);
			ps.setString(9, voornaam);
			ps.setString(10, achternaam);
			ps.setDate(11, CgeboorteDatum);
			System.out.println(sql);
			System.out.println(geboortedatum);

			ps.executeUpdate();
			System.out.println("Toegevoegd");
			// ps.setDate(10, geboortedatum);
			GenericDAO.DatabaseDisconnectPrepareStatement(con, ps);

		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("KoperDAO insert statement failed");
		}

		return success = true;
	}
	@SuppressWarnings("unused")
	public boolean update(Koper nweK) {
		
		boolean success = false;
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
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date input_geboortedatum;
		java.sql.Date CgeboorteDatum = null;
		try {
			input_geboortedatum = sdf.parse(geboortedatum);
			CgeboorteDatum = new Date(input_geboortedatum.getTime());
		} catch (ParseException e1) {
			System.out.println("Datum niet omgezet haha");
		}
		Connection con = GenericDAO.DatabaseConnect();
		String sql = "UPDATE GEBRUIKER SET EMAIL = ?, PASSWORD = ?, RECHT = ?, WOONPLAATS = ?, STRAAT = ?, HUISNUMMER = ?, POSTCODE = ?, TELEFOONNUMMER = ?, VOORNAAM = ?, ACHTERNAAM = ?, GEBOORTEDATUM = ? WHERE EMAIL = ?";
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ps.setString(3, recht.toString());
			ps.setString(4, woonplaats);
			ps.setString(5, straat);
			ps.setString(6, huisnummer);
			ps.setString(7, postcode);
			ps.setString(8, telefoonnummer);
			ps.setString(9, voornaam);
			ps.setString(10, achternaam);
			ps.setDate(11, CgeboorteDatum);
			ps.setString(12, email);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Updaten gelukt");
		GenericDAO.DatabaseDisconnectPrepareStatement(con, ps);
		return success = true;
	}
	
	
	
	
public void adminUpdateKoper(Koper nweK) {
		String email = nweK.getEmail();
//		TYPE recht = nweK.getRecht();
		String woonplaats = nweK.getWoonplaats();
		String straat = nweK.getStraat();
		String huisnummer = nweK.getHuisnummer();
		String postcode = nweK.getPostcode();
		String telefoonnummer = nweK.getTelefoonnummer();
		String voornaam = nweK.getVoornaam();
		String achternaam = nweK.getAchternaam();
		String geboortedatum = nweK.getGeboortedatum();
//		
//		BigDecimal credits = nweK.getCredits();
//		String rekeningnummer = nweK.getRekeningnummer();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date input_geboortedatum;
		java.sql.Date CgeboorteDatum = null;
		try {
			input_geboortedatum = sdf.parse(geboortedatum);
			CgeboorteDatum = new Date(input_geboortedatum.getTime());
		} catch (ParseException e1) {
			System.out.println("Datum niet omgezet haha");
		}
		Connection con = GenericDAO.DatabaseConnect();
		String sql = "UPDATE GEBRUIKER SET WOONPLAATS = ?, STRAAT = ?, HUISNUMMER = ?, POSTCODE = ?, TELEFOONNUMMER = ?, VOORNAAM = ?, ACHTERNAAM = ?, GEBOORTEDATUM = ? WHERE EMAIL = ?";
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, woonplaats);
			ps.setString(2, straat);
			ps.setString(3, huisnummer);
			ps.setString(4, postcode);
			ps.setString(5, telefoonnummer);
			ps.setString(6, voornaam);
			ps.setString(7, achternaam);
			ps.setDate(8, CgeboorteDatum);
			ps.setString(9, email);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		GenericDAO.DatabaseDisconnectPrepareStatement(con, ps);
	}
	
	
	
	
	
	
	
	
	
	
	
public boolean updateCredits(Koper nweK) {
	boolean success = false;
	String email = nweK.getEmail();
	BigDecimal credits = nweK.getCredits();
	try {
		String sql = "UPDATE GEBRUIKER SET CREDITS = ? WHERE EMAIL = ?";
		Connection con = GenericDAO.DatabaseConnect();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setEscapeProcessing(true);
		ps.setString(2, email);
		ps.setDouble(1, credits.doubleValue());
		ps.executeUpdate();
		GenericDAO.DatabaseDisconnectPrepareStatement(con, ps);
		success = true;
	} catch (SQLException e) {
		// Catching exceptions is for communists
	}
	return success;
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@SuppressWarnings("unused")
	public boolean delete(Koper nweK) {
		boolean success = false;
		String email = nweK.getEmail();
		Connection con = GenericDAO.DatabaseConnect();
		String sql = "DELETE FROM GEBRUIKER WHERE EMAIL = (?)";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, email);
		} catch (SQLException e) {
			e.printStackTrace();

		}
		GenericDAO.DatabaseDisconnectPrepareStatement(con, ps);
		return success = true;
	}

	public String findByEmail(String email) {
		System.out.println("FindByEmail bereikt");
		Connection con = GenericDAO.DatabaseConnect();
		Statement st = GenericDAO.DatabaseConnectStatement(con);
		String foundEmail = "";
		try {
			String query = "SELECT email FROM gebruiker WHERE email = '" + email + "';";
			ResultSet result = st.executeQuery(query);
			while (result.next()) {
				System.out.println(result.getString(1));
				// foundEmail = result.getString(1);
			}
		} catch (SQLException se) {

		}

		GenericDAO.DatabaseDisconnect(con, st);
		return foundEmail;

	}
	public ArrayList<Koper> alleKopers() {
		try {
			Connection con = GenericDAO.DatabaseConnect();
			String sql = "SELECT * FROM GEBRUIKER WHERE recht = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "koper");
			ResultSet result = ps.executeQuery();	
			while (result.next()) {
				Koper g = new Koper(result.getString(2), result.getString(3),
						result.getString(5), result.getString(6),
						result.getString(7), result.getString(8),
						result.getString(9), result.getString(10),
						result.getString(11), result.getString(12));
				alleKopers.add(g);
			}
			GenericDAO.DatabaseDisconnectPrepareStatement(con, ps);
		} catch (SQLException e) {
			System.out.println("alleKopers toevoegen ging gaat");
		}
		return alleKopers;
	}
	
	
	

}