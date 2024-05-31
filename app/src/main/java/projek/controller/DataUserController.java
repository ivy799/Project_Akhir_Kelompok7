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

    public static void addUser(DataUser userData ) {
        if (usernameExists(userData.getUsername())|| emailExists(userData.getEmail())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Sign up Failed");
            alert.setHeaderText(null);
            alert.setContentText("Username or Email already exists!");
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

    public static DataUser getUserDetails(String username) {
        String query = "SELECT username, email, password FROM userData WHERE username = ?";
        DataUser userData = null;
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String name = resultSet.getString("username");
                    String email = resultSet.getString("email");
                    String password = resultSet.getString("password");
                    userData = new DataUser(name, email, password);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return userData;
    }

    public static boolean updateUserDetails(String username, String newUserName, String newEmail, String newPassword) {
        String query = "UPDATE userData SET username = ?, email = ?, password = ? WHERE username = ?";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, newUserName);
            preparedStatement.setString(2, newEmail);
            preparedStatement.setString(3, newPassword);
            preparedStatement.setString(4, username);
            int updatedRows = preparedStatement.executeUpdate();
            return updatedRows > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    
}
