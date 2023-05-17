package DB;

import Entity.Company;
import Entity.Registration;
import Entity.User;
import Entity.Location;

import java.sql.*;

public class DBController {

    public Connection connection;

    private Statement stmt;

    public DBController() {
        connection = null;
        stmt = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/haslevdk", "root", "1234");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void registerCheckIn(Registration reg) {

        try {
            String sql = "INSERT INTO Registration (userID, company, location, checkIn) VALUES('"
                    + reg.getUserID() + "','" + reg.getCheckTime() + "')";

            Statement stmt = connection.createStatement();
            stmt.execute(sql);

            System.out.println("Connection to SQLite has been established. \n");
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public User getUser(String fName, String lName, int licenceNr) {
        try {
            User user = new User();

            String sql = "SELECT * FROM User WHERE fName = '" + fName + "' AND lName = '" + lName + "' AND licenceNr = '" + licenceNr + "'";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);

            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                user.setUserID(rs.getInt("userID"));
                user.setfName(rs.getString("fName"));
                user.setlName(rs.getString("lName"));
                user.setLicenceNr(rs.getInt("licenceNr"));
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addUser(User u) {
        try {
            String sql = "INSERT INTO user (fName,lName,licenceNr) VALUES('"
                    + String.valueOf(u.getfName()) + "','" + u.getlName() + "','" + u.getLicenceNr() + "','";

            Statement stmt = connection.createStatement();
            stmt.execute(sql);

            System.out.println("Connection to MySQL has been established. \n");
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Company getCompany(String companyName) {
        try {
            Company company = new Company();

            String sql = "SELECT * FROM company WHERE companyName = '" + companyName + "'";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);

            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                company.setCompanyID(rs.getInt("companyID"));
                company.setCompanyName(rs.getString("companyName"));
            }
            return company;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Location getlocation(String locationName) {
        try {
            Location location = new Location();

            String sql = "SELECT * FROM location WHERE locationName = '" + locationName + "'";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);

            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                location.setLocationID(rs.getInt("locationID"));
                location.setLocationName(rs.getString("locationName"));
            }
            return location;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
