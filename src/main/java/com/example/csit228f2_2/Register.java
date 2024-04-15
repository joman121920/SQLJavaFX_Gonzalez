package com.example.csit228f2_2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class Register {
    public Button btnRegister;
    public Button btnBackToSignIn;
    public TextField txtField_UsernameRegister;
    public TextField txtField_PasswordRegister;

    @FXML
    private void btnRegisterOnAction(){
        try (Connection c = MySQLConnection.getConnection();
             PreparedStatement statement = c.prepareStatement(
                     "INSERT INTO users (username, password) VALUES (?,?)")) {
            String Username = txtField_UsernameRegister.getText();
            String Password = txtField_PasswordRegister.getText();
            statement.setString(1, Username);
            statement.setString(2,Password);

            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0){
                System.out.println("Data Inserted Successfully");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void btnBackToSignInOnAction(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(".fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) btnBackToSignIn.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
