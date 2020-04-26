package controller;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML
    private VBox vbPanelNotif =null;
    @FXML
    private Label labelPelayanan;

    @FXML
    private Button btnDashboard;
    @FXML
    private Button btnNotifikasi;

    @FXML
    private Button btnPasangBaru;

    @FXML
    private  Button btnPenyesuaianDaya;

    @FXML
    private Button btnReportGangguan;

    @FXML
    private Pane paneNotifikasi;

    @FXML
    private Pane panePasangBaru;

    @FXML
    private Pane panePenyesuaianDaya;

    @FXML
    private Pane paneReportGangguan;

    @FXML
    private Pane paneDashboard;

    @FXML
    private Button btnLogout;

    @FXML
    private AnchorPane anchorPane;
    Stage stage;

    @FXML
    private Button clsBtn;
    @FXML
    public void handleClick(ActionEvent event){
        if(event.getSource() == btnNotifikasi){
            paneNotifikasi.toFront();
            Node[] nodes = new Node[10];

            for (int i = 0; i < nodes.length; i++) {
                try {

                    final int j = i;
                    nodes[i] = FXMLLoader.load(getClass().getResource("../view/viewNotifikasi.fxml"));
                    nodes[i].setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            nodes[j].setStyle("-fx-background-color : #0A0E3F");
                        }
                    });
                    nodes[i].setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            nodes[j].setStyle("-fx-background-color : #454545");
                        }
                    });

                    vbPanelNotif.getChildren().add(nodes[i]);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else if(event.getSource() == btnPasangBaru){
            panePasangBaru.toFront();
        } else if(event.getSource() == btnPenyesuaianDaya){
            panePenyesuaianDaya.toFront();
        } else if(event.getSource() == btnReportGangguan){
            paneReportGangguan.toFront();
        } else if(event.getSource() == clsBtn){
            stage = (Stage)((Button)event.getSource()).getScene().getWindow();
            stage.close();
        } else if(event.getSource() == btnDashboard){
            paneDashboard.toFront();
        } else if(event.getSource() == btnLogout){
            Helper.changePage(event,"login");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
