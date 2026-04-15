package dao;

import java.sql.*;
import util.DBConnection;
import model.User;

public class UserDAO {

    public void saveUser(User user){
        String sql = "INSERT INTO users(name,email,password) VALUES(?,?,?)";
        try {
            Connection conn = DBConnection.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());

            ps.executeUpdate();

            conn.close();
            ps.close();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    public User getUserByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                User user = new User();

                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));

                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
