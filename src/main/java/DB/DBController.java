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

    public void registerCheckIn(Registration reg, User u) {

        try {
            String sql = "INSERT INTO Registration (userID, checkIn) VALUES('"
                    + reg.getUserID() + "','" + reg.getCheckTime() + "')";

            Statement stmt = connection.createStatement();
            stmt.execute(sql);

            sql = "UPDATE User SET status = '" + u.getStatus() + "'" + "WHERE userID = '" + reg.getUserID() + "'";
            stmt.execute(sql);


            System.out.println("Connection to SQLite has been established. \n");
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void registerCheckOut(Registration reg, User u)  {
        try {
            String sql = "UPDATE Registration SET checkOut = '" + reg.getCheckTime() + "'" + "WHERE userID = '" + reg.getUserID() + "' AND checkOut IS NULL;";

            Statement stmt = connection.createStatement();
            stmt.execute(sql);

            sql = "UPDATE User SET status = '" + u.getStatus() + "'" + "WHERE userID = '" + reg.getUserID() + "'";
            stmt.execute(sql);


            System.out.println("Connection to SQLite has been established. \n");
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public User getUser(String fName, String lName, String password) {
        try {
            User user = new User();

            String sql = "SELECT * FROM User WHERE fName = '" + fName + "' AND lName = '" + lName + "' AND password = '" + password + "'";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);

            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                user.setUserID(rs.getInt("userID"));
                user.setfName(rs.getString("fName"));
                user.setlName(rs.getString("lName"));
                user.setCompany(rs.getInt("company"));
                user.setPassword(rs.getString("password"));
                user.setLocation(rs.getInt("location"));
                user.setStatus(rs.getInt("status"));
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addUser(User u) {
        try {
            String sql = "INSERT INTO user (fName,lName,company,password,location,status) VALUES('"
                    + String.valueOf(u.getfName()) + "','" + u.getlName() + "','" + u.getCompany() + "','";
            sql = sql + u.getPassword() + "','" + u.getLocation() + "','" + u.getStatus() + "')";


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
