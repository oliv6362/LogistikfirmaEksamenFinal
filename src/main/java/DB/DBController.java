package DB;

import Entity.Registration;
import Entity.User;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
            String sql = "INSERT INTO Registration (userID, checkIn) VALUES('"
                    + reg.getUserID() + "','" + reg.getCheckInTime() + "')";

            Statement stmt = connection.createStatement();
            stmt.execute(sql);

            System.out.println("Connection to SQLite has been established. \n");
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public String registerCheckOut(int userID, String checkOut) {
        String registration = "";
        try {

            String sql = "UPDATE Registration SET checkOut = '" + checkOut + "'" + "WHERE userID = '" + userID + "'";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);

            sql = "SELECT checkOut FROM Registration WHERE userID = '" + userID + "'";
            stmt.execute(sql);

            ResultSet rs = stmt.getResultSet();

            if (rs.next()) {
                registration = rs.getString("checkOut");
            }

            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return registration;
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
                user.setStatus(rs.getBoolean("status"));
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




}
