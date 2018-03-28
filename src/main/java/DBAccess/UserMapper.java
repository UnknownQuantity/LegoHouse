package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The purpose of UserMapper is to...
 *
 * @author kasper
 */
public class UserMapper {

    public static void createUser(User user) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO Users (email, password, role) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            user.setId(id);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static User login(String email, String password) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT id, role FROM Users "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String role = rs.getString("role");
                int id = rs.getInt("id");
                User user = new User(email, password, role);
                user.setId(id);
                return user;
            } else {
                throw new LoginSampleException("Could not validate user");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public User getUse(int id) throws ClassNotFoundException //to test in main
    {
        User u = null;
        try {
            Connection con = Connector.connection();

            String sql = "SELECT * FROM useradmin.users where id = '" + id + "'";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultset = ps.executeQuery();

            while (resultset.next()) {
                int userid = resultset.getInt("users.id");
                String email = resultset.getString("email");
                String userpassword = resultset.getString("password");
                String role = resultset.getString("role");
                u = new User(userid, email, userpassword, role);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return u;
    }

    public static User getUser(int id) throws ClassNotFoundException //included in logic facade
    {
        User u = null;
        try {
            Connection con = Connector.connection();

            String sql = "SELECT * FROM useradmin.users where id = '" + id + "'";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultset = ps.executeQuery();

            while (resultset.next()) {
                int userid = resultset.getInt("users.id");
                String email = resultset.getString("email");
                String userpassword = resultset.getString("password");
                String role = resultset.getString("role");
                u = new User(userid, email, userpassword, role);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return u;
    }
}
