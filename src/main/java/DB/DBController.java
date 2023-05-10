package DB;

import Entity.User;

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

    public String registerCheckIn(int userID, String checkIn) {
        String registration = "";
        try {

            String sql = "UPDATE Registration SET checkIn = '" + checkIn + "'" + "WHERE userID = '" + userID + "'" ;
            Statement stmt = connection.createStatement();
            stmt.execute(sql);

            sql = "SELECT checkIn FROM Registration WHERE userID = '" + userID + "'";
            stmt.execute(sql);

            ResultSet rs = stmt.getResultSet();

            if (rs.next()) {
                registration = rs.getString("checkIn");
            }

            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return registration;
    }

    public String registerCheckOut(int userID, String checkOut) {
        String registration = "";
        try {

            String sql = "UPDATE Registration SET checkOut = '" + checkOut + "'" + "WHERE userID = '" + userID + "'" ;
            Statement stmt = connection.createStatement();
            stmt.execute(sql);

            sql = "SELECT checkOut FROM Registration WHERE userID = '" + userID + "'";
            stmt.execute(sql);

            ResultSet rs = stmt.getResultSet();

            if (rs.next()) {
                registration = rs.getString("checkIn");
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

            String sql = "SELECT * FROM User WHERE fName = " + fName + " AND lName = " + lName + " AND password = " + password + ";";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);

            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                user.setId(rs.getInt("userID"));
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
