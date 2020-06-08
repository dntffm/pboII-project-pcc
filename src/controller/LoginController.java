package controller;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Signup_model;
public class LoginController {
    private static double x,y;
    @FXML
    private ResourceBundle resources;

    @FXML
    private VBox vboxRegister;

    @FXML
    private URL location;

    @FXML
    private Button btnClose;
    @FXML
    private TextField txtareaUsername;

    @FXML
    private PasswordField txtareaPassword;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnDaftar;
    Stage stage = new Stage();
    Scene scene;
    @FXML
    void handleClick(ActionEvent event) {
        if (event.getSource() == btnLogin){
            if (txtareaUsername.getText().isEmpty()){
                Helper.showAlert(Alert.AlertType.ERROR , "Login Error", "Username Harus Tidak Kosong");
            }
            if (txtareaPassword.getText().isEmpty()){
                Helper.showAlert(Alert.AlertType.ERROR , "Login Error", "Password Harus Tidak Kosong");
            }


            String username = txtareaUsername.getText().toString();
            String password = txtareaPassword.getText().toString();

            ResultSet resultSet = Signup_model.cekUser(username,password);
            try {
                if(!resultSet.next()){
                    Helper.showAlert(Alert.AlertType.ERROR , "Login Error", "Username atau password salah");
                }else{
                    if (resultSet.getString(5).equals("teknisi")){
                        Helper.changePage(event,"TeknisiHome");
                    } else if (resultSet.getString(5).equals("customer")){
                        Helper.changePage(event,"CustomerHome");
                    } else if (resultSet.getString(5).equals("customer_service")){
                        Helper.changePage(event,"CSHome");
                    } else{
                        Helper.showAlert(Alert.AlertType.ERROR, "Login Eror","Login Gagal");
                    }
                }
            } catch (SQLException e){
                System.out.println("Data Tidak Ada");
            }



        }
        if(event.getSource() == btnDaftar){
            Helper.changePage(event,"registerCustomer");
        }
        if (event.getSource() == btnClose){
            stage = (Stage)((Button)event.getSource()).getScene().getWindow();
            stage.close();
        }
    }



    @FXML
    void initialize() {
        assert txtareaUsername != null : "fx:id=\"txtareaUsername\" was not injected: check your FXML file 'login.fxml'.";
        assert txtareaPassword != null : "fx:id=\"txtareaPassword\" was not injected: check your FXML file 'login.fxml'.";
        assert btnLogin != null : "fx:id=\"btnLogin\" was not injected: check your FXML file 'login.fxml'.";
        assert btnDaftar != null : "fx:id=\"btnDaftar\" was not injected: check your FXML file 'login.fxml'.";

    }
}
