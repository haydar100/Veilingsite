package veilingQuerys;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.jasypt.util.password.BasicPasswordEncryptor;

import veilingDomain.Gebruiker;
import veilingDomain.Koper;
import veilingDomain.Medewerker;
import veilingDomain.Recht;
import veilingDomain.Verkoper;

public class GebruikerQueries implements IGebruikerQueries {
	private ArrayList<String> allNonBlockedUsers = new ArrayList<String>();
	BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();

	@SuppressWarnings("unused")
	// public boolean insert(Gebruiker nweK) {
	// System.out.println("Insert statement bereikt");
	// boolean success = false;
	// String email = nweK.getEmail();
	// String password = nweK.getPassword();
	// TYPE recht = nweK.getRecht();
	// String woonplaats = nweK.getWoonplaats();
	// String straat = nweK.getStraat();
	// String huisnummer = nweK.getHuisnummer();
	// String postcode = nweK.getPostcode();
	// String telefoonnummer = nweK.getTelefoonnummer();
	// String voornaam = null;
	// String achternaam = null;
	// Date geboortedatum = null;
	// BigDecimal credits = null;
	// String rekeningnummer = null;
	// if (nweK instanceof Koper) {
	// voornaam = ((Koper) nweK).getVoornaam();
	// achternaam = ((Koper) nweK).getAchternaam();
	// geboortedatum = ((Koper) nweK).getGeboortedatum();
	// credits = ((Koper) nweK).getCredits();
	// rekeningnummer =((Koper) nweK).getRekeningnummer();
	// }
	//
	//
	//
	//
	// try {
	// String sql = "INSERT INTO gebruiker VALUES (?,?,?,?,?,?,?,?,?);";
	// Connection con = GenericDAO.DatabaseConnect();
	// PreparedStatement ps = con.prepareStatement(sql);
	// ps.setString(1, email);
	// ps.setString(2, password);
	// ps.setString(3, "ja");
	// ps.setString(4, woonplaats);
	// ps.setString(5, straat);
	// ps.setString(6, huisnummer);
	// ps.setString(7, postcode);
	// ps.setString(8, telefoonnummer);
	// ps.setString(9, voornaam);
	// ps.setString(10, achternaam);
	// ps.setDate(11, (java.sql.Date) geboortedatum);
	//
	// ps.executeUpdate();
	// System.out.println("Toegevoegd");
	// // ps.setDate(10, geboortedatum);
	// GenericDAO.DatabaseDisconnectPrepareStatement(con, ps);
	//
	// } catch (SQLException e) {
	// e.printStackTrace();
	// System.out.println("KoperDAO insert statement failed");
	// }
	//
	// return success = true;
	// }
	public boolean update(Gebruiker nweK) {
		//
		// boolean success = false;
		// String email = nweK.getEmail();
		// String password = nweK.getPassword();
		// // TYPE recht = nweK.getRecht();
		// String woonplaats = nweK.getWoonplaats();
		// String straat = nweK.getStraat();
		// String huisnummer = nweK.getHuisnummer();
		// String postcode = nweK.getPostcode();
		// String telefoonnummer = nweK.getTelefoonnummer();
		// String voornaam = null;
		// String achternaam = null;
		// Date geboortedatum = null;
		// BigDecimal credits = null;
		// String rekeningnummer = null;
		// if (nweK instanceof Koper) {
		// voornaam = ((Koper) nweK).getVoornaam();
		// achternaam = ((Koper) nweK).getAchternaam();
		// geboortedatum = ((Koper) nweK).getGeboortedatum();
		// credits = ((Koper) nweK).getCredits();
		// rekeningnummer =((Koper) nweK).getRekeningnummer();
		// }
		// Connection con = GenericDAO.DatabaseConnect();
		// String sql = "update gebruiker values(?,?,?,?,?,?,?,?,?)";
		// PreparedStatement ps = null;
		//
		// try {
		// ps = con.prepareStatement(sql);
		// ps.setString(1, email);
		// ps.setString(2, password);
		// ps.setString(3, voornaam);
		// ps.setString(4, achternaam);
		// ps.setString(5, woonplaats);
		// ps.setString(6, straat);
		// ps.setString(7, postcode);
		// ps.setString(8, huisnummer);
		// ps.setString(9, telefoonnummer);
		// // ps.setDate(10, geboortedatum);
		//
		// } catch (SQLException e) {
		// e.printStackTrace();
		// }
		// GenericDAO.DatabaseDisconnectPrepareStatement(con, ps);
		// return success = true;
		// }
		// public boolean delete(Gebruiker nweK) {
		// boolean success = false;
		// String email = nweK.getEmail();
		// Connection con = GenericDAO.DatabaseConnect();
		// String sql = "DELETE FROM GEBRUIKER WHERE EMAIL = (?)";
		// PreparedStatement ps = null;
		// try {
		// ps = con.prepareStatement(sql);
		// ps.setString(1, email);
		// } catch (SQLException e) {
		// e.printStackTrace();
		//
		// }
		// GenericDAO.DatabaseDisconnectPrepareStatement(con, ps);
		return false;
	}

	public Gebruiker findByEmail(String email) {
		Gebruiker g = null;
		try {
			Connection con = GenericDAO.DatabaseConnect();
			String sql = "SELECT * FROM GEBRUIKER WHERE EMAIL = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				if (result.getString(4).equals("koper")) {
					g = new Koper(result.getString(2), result.getString(3),
							result.getString(5), result.getString(6),
							result.getString(7), result.getString(8),
							result.getString(9), result.getString(10),
							result.getString(11), result.getString(12));
					g.setRecht(new Recht(result.getString(4)));
				} else if (result.getString(4).equals("admin")) {
					g = new Gebruiker(result.getString(2), result.getString(3),
							(new Recht(result.getString(4))).getRechtObj(),
							result.getString(5), result.getString(6),
							result.getString(7), result.getString(8),
							result.getString(9));
				} else if (result.getString(4).equals("verkoper")) {
					g = new Verkoper(result.getString(2), result.getString(3),
							result.getString(5), result.getString(6),
							result.getString(7), result.getString(8),
							result.getString(9), result.getString(16),
							result.getString(17), result.getString(14));
				} else if (result.getString(4).equals("medewerker")) {
					g = new Medewerker(result.getString(2),
							result.getString(3), result.getString(5),
							result.getString(6), result.getString(7),
							result.getString(8), result.getString(9),
							result.getString(10), result.getString(11),
							result.getString(15), null);
				}
			}
			GenericDAO.DatabaseDisconnectPrepareStatement(con, ps);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return g;
	}

	public Gebruiker getGebruiker(String email, String password) {
		Gebruiker g = null;
		try {
			Connection con = GenericDAO.DatabaseConnect();
			String sql = "SELECT *	 FROM GEBRUIKER WHERE EMAIL = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				String passwordEncrypted = result.getString(3);
				if (passwordEncryptor.checkPassword(password, passwordEncrypted)) {
				if (result.getString(4).equals("koper")) {
					g = new Koper(result.getString(2), result.getString(3),
							result.getString(5), result.getString(6),
							result.getString(7), result.getString(8),
							result.getString(9), result.getString(10),
							result.getString(11), result.getString(12));
					g.setRecht(new Recht(result.getString(4)));
					((Koper) g).setCredits(new BigDecimal(result.getString(13)));
				} else if (result.getString(4).equals("admin")) {
					g = new Gebruiker(result.getString(2), result.getString(3),
							(new Recht(result.getString(4))).getRechtObj(),
							result.getString(5), result.getString(6),
							result.getString(7), result.getString(8),
							result.getString(9));
				} else if (result.getString(4).equals("verkoper")) {
					g = new Verkoper(result.getString(2), result.getString(3),
							result.getString(5), result.getString(6),
							result.getString(7), result.getString(8),
							result.getString(9), result.getString(16),
							result.getString(17), result.getString(14));
				} else if (result.getString(4).equals("medewerker")) {
					g = new Medewerker(result.getString(2),
							result.getString(3), result.getString(5),
							result.getString(6), result.getString(7),
							result.getString(8), result.getString(9),
							result.getString(10), result.getString(11),
							result.getString(15), null);
				}
				}
				System.out.println("Setting rights from user " + g.getEmail()
						+ " to " + g.getRecht());
			}
			GenericDAO.DatabaseDisconnectPrepareStatement(con, ps);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return g;
	}

	@Override
	public boolean delete(Gebruiker gebruiker) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insert(Gebruiker gebruiker) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<String> collectNonBlockedUsers() {
		try {
			Connection con = GenericDAO.DatabaseConnect();
			String sql = "SELECT email FROM gebruiker WHERE blocked IS null AND recht != 'admin' ORDER BY email ASC";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				allNonBlockedUsers.add(rs.getString(1));
			}
			GenericDAO.DatabaseDisconnectPrepareStatement(con, ps);
		} catch (SQLException e) {
			System.out.println("collectNonBlockedUsers ging fout");
		}
		return allNonBlockedUsers;
	}

	public ArrayList<String> collectBlockedUsers() {
		try {
			Connection con = GenericDAO.DatabaseConnect();
			String sql = "SELECT email FROM gebruiker WHERE blocked = 'YES' AND recht != 'admin' ORDER BY email ASC";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				allNonBlockedUsers.add(rs.getString(1));
			}
			GenericDAO.DatabaseDisconnectPrepareStatement(con, ps);
		} catch (SQLException e) {
			System.out.println("collectBlockedUsers ging fout");
		}
		return allNonBlockedUsers;
	}

	public void BlockUser(String email) {
		try {
			Connection con = GenericDAO.DatabaseConnect();
			String sql = "update GEBRUIKER set blocked = ? where email = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "YES");
			ps.setString(2, email);
			ps.execute();
			GenericDAO.DatabaseDisconnectPrepareStatement(con, ps);
		} catch (SQLException e) {
			System.out.println("Gebruiker met de email" + email
					+ " is niet geblokkeerd !!! ");
		}
	}

	public void UnBlockUser(String email) {
		try {
			Connection con = GenericDAO.DatabaseConnect();
			String sql = "update GEBRUIKER set blocked = ? where email = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "");
			ps.setString(2, email);
			ps.execute();
			GenericDAO.DatabaseDisconnectPrepareStatement(con, ps);
		} catch (SQLException e) {
			System.out.println("Gebruiker met de email" + email
					+ " is niet unblocked!!! ");
		}
	}

	public boolean isBlocked(String email) {
		boolean block = false;
		try {
			Connection con = GenericDAO.DatabaseConnect();
			String sql = "select blocked from GEBRUIKER where email = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			String blocked = "";
			while (rs.next()) {
				blocked = rs.getString(1);
			}
			if (blocked != null) {
				if (blocked.equals("YES")) {
					block = true;
				}
			}
			GenericDAO.DatabaseDisconnectPrepareStatement(con, ps);
		} catch (SQLException e) {
			System.out.println("Gebruiker met de email" + email
					+ " is niet unblocked!!! ");
		}
		return block;
	}
	
	public int getID(String email) {
		int id = -1;
		try {
			Connection con = GenericDAO.DatabaseConnect();
			String sql = "select id from GEBRUIKER where email = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				id = rs.getInt(1);
			}
			GenericDAO.DatabaseDisconnectPrepareStatement(con, ps);
		} catch (SQLException e) {
		}
		return id;
	}
}
