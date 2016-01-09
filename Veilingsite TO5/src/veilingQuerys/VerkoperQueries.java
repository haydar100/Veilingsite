package veilingQuerys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import veilingDomain.Recht.TYPE;
import veilingDomain.Veiling;
import veilingDomain.Verkoper;

public class VerkoperQueries implements VerkoperDAO {
	private ArrayList<Verkoper> alleVerkopers = new ArrayList<Verkoper>();
	private ArrayList<Veiling> alleProducten = new ArrayList<Veiling>();

	@SuppressWarnings("unused")
	public boolean insert(Verkoper nweVK) {
		System.out.println("Insert statement bereikt");
		boolean success = false;
		String email = nweVK.getEmail();
		String woonplaats = nweVK.getWoonplaats();
		String straat = nweVK.getStraat();
		String huisnummer = nweVK.getHuisnummer();
		String postcode = nweVK.getPostcode();
		String telefoonnummer = nweVK.getTelefoonnummer();
		String bedrijfsnaam = nweVK.getBedrijfsnaam();
		String kvknummer = nweVK.getKvkNummer();
		String rekeningnummer = nweVK.getRekeningnummer();
		String password = nweVK.getPassword();
		
		

		try {
			String sql = "INSERT INTO GEBRUIKER (EMAIL, PASSWORD, RECHT, WOONPLAATS, STRAAT, HUISNUMMER, POSTCODE, TELEFOONNUMMER, BEDRIJFSNAAM, REKENINGNUMMER, KVKNUMMER) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
			Connection con = GenericDAO.DatabaseConnect();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setEscapeProcessing(true);
			ps.setString(1, email);
			ps.setString(2, password);
			ps.setString(3, "verkoper");
			ps.setString(4, woonplaats);
			ps.setString(5, straat);
			ps.setString(6, huisnummer);
			ps.setString(7, postcode);
			ps.setString(8, telefoonnummer);
			ps.setString(9, rekeningnummer);
			ps.setString(10, bedrijfsnaam);
			ps.setString(11, kvknummer);
			System.out.println(sql);

			ps.executeUpdate();
			System.out.println("Toegevoegd");
			// ps.setDate(10, geboortedatum);
			GenericDAO.DatabaseDisconnectPrepareStatement(con, ps);

		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("KoperDAO insert statement failed");
			System.out.println(postcode);
		}
		
		return success = true;
	
	}

	@Override
	public boolean update(Verkoper verkoper) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Verkoper verkoper) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<Verkoper> alleVerkopers() {
		try {
			Connection con = GenericDAO.DatabaseConnect();
			String sql = "SELECT * FROM GEBRUIKER WHERE recht = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "verkoper");
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				Verkoper v = new Verkoper(result.getString(2),
						result.getString(3), result.getString(5),
						result.getString(6), result.getString(7),
						result.getString(8), result.getString(9),
						result.getString(10), result.getString(11),
						result.getString(12));
				alleVerkopers.add(v);
			}
			GenericDAO.DatabaseDisconnectPrepareStatement(con, ps);
		} catch (SQLException e) {
			System.out.println("alleVerkopers vullen gaat niet goed");
		}
		return alleVerkopers;
	}

	public void adminUpdateVerkoper(Verkoper nweV) {
		String email = nweV.getEmail();
		String woonplaats = nweV.getWoonplaats();
		String straat = nweV.getStraat();
		String huisnummer = nweV.getHuisnummer();
		String postcode = nweV.getPostcode();
		String telefoonnummer = nweV.getTelefoonnummer();
		String bedrijsfnaam = nweV.getBedrijfsnaam();
		String kvknummer = nweV.getKvkNummer();
		String rekeningnummer = nweV.getRekeningnummer();
		
		Connection con = GenericDAO.DatabaseConnect();
		String sql = "UPDATE GEBRUIKER SET WOONPLAATS = ?, STRAAT = ?, HUISNUMMER = ?, POSTCODE = ?, TELEFOONNUMMER = ?, BEDRIJFSNAAM = ?, KVKNUMMER = ?, REKENINGNUMMER = ? WHERE EMAIL = ?";
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, woonplaats);
			ps.setString(2, straat);
			ps.setString(3, huisnummer);
			ps.setString(4, postcode);
			ps.setString(5, telefoonnummer);
			ps.setString(6, bedrijsfnaam);
			ps.setString(7, kvknummer);
			ps.setString(8, rekeningnummer);
			ps.setString(9, email);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		GenericDAO.DatabaseDisconnectPrepareStatement(con, ps);
	}
	
	public ArrayList<Veiling> alleProductenVerkoper(Verkoper v) {
		String email = v.getEmail();
		Connection con = GenericDAO.DatabaseConnect();
		String sql = "SELECT V.ARTIKELNUMMER, V.OMSCHRIJVING, V.MINIMUMBEDRAG, V.AANTAL FROM MARKT M, VEILING V WHERE M.VEILING_ID = V.ID AND GEBRUIKER_EMAIL = ?";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ResultSet rest = ps.executeQuery();
			while(rest.next()) {
				Veiling vl = new Veiling(rest.getString(1), rest.getString(2), rest.getDouble(3), rest.getInt(4));
				alleProducten.add(vl);
				
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}		
		GenericDAO.DatabaseDisconnectPrepareStatement(con, ps);
		return alleProducten;
	}

}
