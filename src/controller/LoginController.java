package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private ResourceBundle resources;

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
    Stage stage;


    @FXML
    void handleClick(ActionEvent event) {
        if (event.getSource() == btnLogin){
            if (txtareaUsername.getText().equals("user") && txtareaPassword.getText().equals("123")){
               Helper.changePage(event,"CustomerHome");
            }
            if (txtareaUsername.getText().equals("cs") && txtareaPassword.getText().equals("123")){
                Helper.changePage(event,"CSHome");
            }
            if (txtareaUsername.getText().equals("teknisi") && txtareaPassword.getText().equals("123")){
                Helper.changePage(event,"CustomerHome");
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
