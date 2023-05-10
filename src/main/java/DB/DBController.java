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

    public User getUser(int Id, fName, lName, password) {
        try {
            User user = new User();

            String sql = "SELECT * FROM User WHERE userID = " + Id + ";";
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
