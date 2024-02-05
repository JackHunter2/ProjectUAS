/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class LoginFXMLController implements Initializable {

    @FXML
    private AnchorPane login_form;
    @FXML
    private AnchorPane register_form;
    @FXML
    private TextField username_login;
    @FXML
    private PasswordField password_login;
    @FXML
    private Button btnRegister;
    @FXML
    private Button btnLogin;
    @FXML
    private TextField name_regis;
    @FXML
    private TextField username_regis;
    @FXML
    private PasswordField password_regis;
    @FXML
    private PasswordField passwordC_regis;
    @FXML
    private Button btnRegis;
    @FXML
    private Button btnLgin;

    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private Statement statement;   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    



    @FXML
    private void btnLogin(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        alertMessage alert = new alertMessage();

        if (username_login.getText().isEmpty() || password_login.getText().isEmpty()) {
            alert.errorMessage("Incorrect Username/Password");
        } else {
            String selectData = "SELECT * FROM regis WHERE "
                    + "username = ? and password = ?";
            connect = DataBase.connectDB();

                prepare = connect.prepareStatement(selectData);
                prepare.setString(1, username_login.getText());
                prepare.setString(2, password_login.getText());

                result = prepare.executeQuery();

                if (result.next()) {
                    data.username = username_login.getText();

                    alert.successMessage("Successfully Login!");

                    Parent root = FXMLLoader.load(getClass().getResource("DashboardFXML.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    
                    stage.setResizable(false);
                    stage.setScene(scene);
                    stage.show();

                    login_form.getScene().getWindow().hide();
                    
                } else {
                    alert.errorMessage("Incorrect Username/Password");
                }
            }
    }

    @FXML
    private void btnRegis(ActionEvent event) throws ClassNotFoundException, SQLException{
        
        alertMessage alert = new alertMessage();

        if (name_regis.getText().isEmpty() || username_regis.getText().isEmpty()
                || password_regis.getText().isEmpty() || passwordC_regis.getText().isEmpty()) {
            alert.errorMessage("All fields are necessary to be filled");
        } else if (!password_regis.getText().equals(passwordC_regis.getText())) {
            alert.errorMessage("Password does not match");
        } else if (password_regis.getText().length() < 8) {
            alert.errorMessage("Invalid Password, at least 8 characters needed");
        } else {
            String checkUsername = "SELECT * FROM regis WHERE username = '"
                    + username_regis.getText() + "'";
            connect = DataBase.connectDB();
                statement = connect.createStatement();
                result = statement.executeQuery(checkUsername);

                if (result.next()) {
                    alert.errorMessage(username_regis.getText() + " is already taken");
                } else {

                    String insertData = "INSERT INTO regis "
                            + "(name, username, password) "
                            + "VALUES(?,?,?)"; // FIVE (?)

                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, name_regis.getText());
                    prepare.setString(2, username_regis.getText());
                    prepare.setString(3, password_regis.getText());
                    
                    prepare.executeUpdate();

                    alert.successMessage("Registered Successfully!");

                    registerClearFields();

                    register_form.setVisible(false);
                    login_form.setVisible(true);
                }
        }
    }
    public void registerClearFields() {
        name_regis.setText("");
        username_regis.setText("");
        password_regis.setText("");
        passwordC_regis.setText("");
    }
    
    @FXML
    public void btnLgin(ActionEvent event) {
            register_form.setVisible(false);
            login_form.setVisible(true);
    }
    
    @FXML
    public void btnRegister(ActionEvent event) {
            register_form.setVisible(true);
            login_form.setVisible(false);
    }



}
