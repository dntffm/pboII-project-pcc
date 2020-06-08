package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Signup_model;

public class RegisterCustomerController {
    @FXML
    private VBox vboxRegister;
    @FXML
    private TextField fieldNamaLengkap;

    @FXML
    private TextField fieldUserName;

    @FXML
    private TextField fieldEmail;

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
       // assert fieldID != null : "fx:id=\"fieldID\" was not injected: check your FXML file 'registerCustomer.fxml'.";
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
        }

        if (event.getSource() == btnSelesaiDaftar){

            if (fieldEmail.getText().isEmpty()
                    || fieldKonfirmasi.getText().isEmpty() || fieldNamaLengkap.getText().isEmpty() ||
                    fieldPasswd.getText().isEmpty() || fieldUserName.getText().isEmpty()){
                Helper.showAlert(Alert.AlertType.ERROR,"Error","Field Tidak Boleh Kosong");
            }
            if(!fieldPasswd.getText().equals(fieldKonfirmasi.getText())){
                Helper.showAlert(Alert.AlertType.ERROR,"Error","Password harus Sama");
            }
            ObservableList<String> dataRegister = FXCollections.observableArrayList();
            vboxRegister.getChildren()
                    .filtered(node -> node instanceof TextField)
                    .forEach(node -> dataRegister.add (((TextField) node).getText()));

            if (Signup_model.Register(dataRegister)){
                Helper.showAlert(Alert.AlertType.CONFIRMATION,"Register Berhasil","Register Berhasil Silahkan Login");
                Helper.changePage(event,"login");
            } else{
                Helper.showAlert(Alert.AlertType.ERROR,"Error","Register Gagal");
            }
        }

        if(event.getSource() == btnClose){
            stage = (Stage)((Button)event.getSource()).getScene().getWindow();
            stage.close();
        }
    }
}
