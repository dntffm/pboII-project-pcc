package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterCustomerController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField fieldID;

    @FXML
    private TextField fieldNamaLengkap;

    @FXML
    private TextField fieldUserName;

    @FXML
    private PasswordField fieldPasswd;

    @FXML
    private PasswordField fieldKonfirmasi;

    @FXML
    private Button btnSelesaiDaftar;

    @FXML
    private Button btnLogin;
    @FXML
    private Button btnClose;
    @FXML
    void initialize() {
        assert fieldID != null : "fx:id=\"fieldID\" was not injected: check your FXML file 'registerCustomer.fxml'.";
        assert fieldNamaLengkap != null : "fx:id=\"fieldNamaLengkap\" was not injected: check your FXML file 'registerCustomer.fxml'.";
        assert fieldUserName != null : "fx:id=\"fieldUserName\" was not injected: check your FXML file 'registerCustomer.fxml'.";
        assert fieldPasswd != null : "fx:id=\"fieldPasswd\" was not injected: check your FXML file 'registerCustomer.fxml'.";
        assert fieldKonfirmasi != null : "fx:id=\"fieldKonfirmasi\" was not injected: check your FXML file 'registerCustomer.fxml'.";
        assert btnSelesaiDaftar != null : "fx:id=\"btnSelesaiDaftar\" was not injected: check your FXML file 'registerCustomer.fxml'.";
        assert btnLogin != null : "fx:id=\"btnLogin\" was not injected: check your FXML file 'registerCustomer.fxml'.";

    }
    Stage stage;
    @FXML
    void handleClick(ActionEvent event){
        if (event.getSource() == btnLogin){
            Helper.changePage(event,"login");
        } else if (event.getSource() == btnSelesaiDaftar){
            Helper.changePage(event,"login");
        } else if(event.getSource() == btnClose){
            stage = (Stage)((Button)event.getSource()).getScene().getWindow();
            stage.close();
        }
    }
}
