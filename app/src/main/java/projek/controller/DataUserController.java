package projek.controller;


import java.sql.ResultSet;
import java.sql.SQLException;
import config.DBconfig;
import javafx.scene.control.Alert;
import projek.model.DataUser;


public class DataUserController extends DBconfig{

    public static boolean usernameExists(String username) {
        String query = "SELECT COUNT(*) FROM userData WHERE username = ?";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static boolean emailExists(String email) {
        String query = "SELECT COUNT(*) FROM userData WHERE email = ?";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static void addUser(DataUser userData) {
        if (usernameExists(userData.getUsername())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Sign up Failed");
            alert.setHeaderText(null);
            alert.setContentText("Username already exists!");
            alert.showAndWait();
            return;
        }

        if (emailExists(userData.getEmail())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Sign up Failed");
            alert.setHeaderText(null);
            alert.setContentText("Email already exists!");
            alert.showAndWait();
            return;
        }

        String query = "INSERT INTO userData(username, email, password) VALUES(?,?,?)";
        try{
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userData.getUsername());
            preparedStatement.setString(2, userData.getEmail());
            preparedStatement.setString(3, userData.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean loginUser(String username, String password) {
        String query = "SELECT COUNT(*) FROM userData WHERE username = ? AND password = ?";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
