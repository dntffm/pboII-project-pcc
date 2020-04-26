package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CSController {

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
    private Button btnNotifikasi;

    @FXML
    private Button btnPasangBaru;

    @FXML
    private Button btnPenyesuaianDaya;

    @FXML
    private Button btnReportGangguan;

    @FXML
    private Button btnLogout;

    @FXML
    private Pane paneNotifikasi;

    @FXML
    private VBox vbPanelNotif;

    @FXML
    private Pane paneDashboard;

    @FXML
    private Pane panePasangBaru;

    @FXML
    private Pane paneReportGangguan;

    @FXML
    private Pane panePenyesuaianDaya;
    Stage stage;
    @FXML
    void handleClick(ActionEvent event) {
        if(event.getSource() == clsBtn) {
            stage = (Stage)((Button)event.getSource()).getScene().getWindow();
            stage.close();
        } else if (event.getSource() == btnLogout){
            Helper.changePage(event,"login");
        }
    }

    @FXML
    void initialize() {
        assert anchorpane != null : "fx:id=\"anchorpane\" was not injected: check your FXML file 'CSHome.fxml'.";
        assert clsBtn != null : "fx:id=\"clsBtn\" was not injected: check your FXML file 'CSHome.fxml'.";
        assert clsBtn1 != null : "fx:id=\"clsBtn1\" was not injected: check your FXML file 'CSHome.fxml'.";
        assert btnDashboard != null : "fx:id=\"btnDashboard\" was not injected: check your FXML file 'CSHome.fxml'.";
        assert btnNotifikasi != null : "fx:id=\"btnNotifikasi\" was not injected: check your FXML file 'CSHome.fxml'.";
        assert btnPasangBaru != null : "fx:id=\"btnPasangBaru\" was not injected: check your FXML file 'CSHome.fxml'.";
        assert btnPenyesuaianDaya != null : "fx:id=\"btnPenyesuaianDaya\" was not injected: check your FXML file 'CSHome.fxml'.";
        assert btnReportGangguan != null : "fx:id=\"btnReportGangguan\" was not injected: check your FXML file 'CSHome.fxml'.";
        assert btnLogout != null : "fx:id=\"btnLogout\" was not injected: check your FXML file 'CSHome.fxml'.";
        assert paneNotifikasi != null : "fx:id=\"paneNotifikasi\" was not injected: check your FXML file 'CSHome.fxml'.";
        assert vbPanelNotif != null : "fx:id=\"vbPanelNotif\" was not injected: check your FXML file 'CSHome.fxml'.";
        assert paneDashboard != null : "fx:id=\"paneDashboard\" was not injected: check your FXML file 'CSHome.fxml'.";
        assert panePasangBaru != null : "fx:id=\"panePasangBaru\" was not injected: check your FXML file 'CSHome.fxml'.";
        assert paneReportGangguan != null : "fx:id=\"paneReportGangguan\" was not injected: check your FXML file 'CSHome.fxml'.";
        assert panePenyesuaianDaya != null : "fx:id=\"panePenyesuaianDaya\" was not injected: check your FXML file 'CSHome.fxml'.";

    }


}
