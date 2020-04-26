package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TeknisiController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchorpane;

    @FXML
    private Button clsBtn;

    @FXML
    private Button clsBtn1;

    @FXML
    private Button btnDashboard;

    @FXML
    private Button btnPelayanan;

    @FXML
    private Button btnLogout;

    @FXML
    private Pane paneDashboard;

    @FXML
    private Pane panePelayanan;
    Stage stage;
    @FXML
    void handleClick(ActionEvent event) {
        if (event.getSource() == btnLogout){
            Helper.changePage(event,"login");
        } else if(event.getSource() == clsBtn){
            stage = (Stage)((Button)event.getSource()).getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    void initialize() {
        assert anchorpane != null : "fx:id=\"anchorpane\" was not injected: check your FXML file 'TeknisiHome.fxml'.";
        assert clsBtn != null : "fx:id=\"clsBtn\" was not injected: check your FXML file 'TeknisiHome.fxml'.";
        assert clsBtn1 != null : "fx:id=\"clsBtn1\" was not injected: check your FXML file 'TeknisiHome.fxml'.";
        assert btnDashboard != null : "fx:id=\"btnDashboard\" was not injected: check your FXML file 'TeknisiHome.fxml'.";
        assert btnPelayanan != null : "fx:id=\"btnPelayanan\" was not injected: check your FXML file 'TeknisiHome.fxml'.";
        assert btnLogout != null : "fx:id=\"btnLogout\" was not injected: check your FXML file 'TeknisiHome.fxml'.";
        assert paneDashboard != null : "fx:id=\"paneDashboard\" was not injected: check your FXML file 'TeknisiHome.fxml'.";
        assert panePelayanan != null : "fx:id=\"panePelayanan\" was not injected: check your FXML file 'TeknisiHome.fxml'.";

    }
}
