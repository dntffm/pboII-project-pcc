package controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CutomerController implements Initializable {
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
    private Button btnKirimGangguan;

    @FXML
    private Button btnKirimPsgBaru;

    @FXML
    private TextArea txtareaDetailGangguan;

    @FXML
    private TextField txtfieldLokasiGangguan;

    @FXML
    private ChoiceBox chboxdayabaru;
    @FXML
    private ChoiceBox chboxdayaawal;

    @FXML
    private TextArea txtareaNamaPasangBaru;

    @FXML
    private TextArea txtareaAlamatPasangBaru;

    @FXML
    private TextArea txtareaHpPasangBaru;

    @FXML
    private TextArea txtareaIDPasangBaru;

    @FXML
    private TextArea txtareaEmailPasangBaru;

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
        }
        if(event.getSource() == btnPasangBaru){
            panePasangBaru.toFront();
        }
        if(event.getSource() == btnPenyesuaianDaya){
            panePenyesuaianDaya.toFront();


        }
        if(event.getSource() == btnReportGangguan){
            paneReportGangguan.toFront();

            ObservableList<String> dataReport = FXCollections.observableArrayList();
            System.out.println();
            paneReportGangguan.getChildren()
                                .filtered(node -> node instanceof TextField)
                                .forEach(node -> dataReport.add(((TextField)node).getText()));

            System.out.println(dataReport);

        }
        if(event.getSource() == clsBtn){
            stage = (Stage)((Button)event.getSource()).getScene().getWindow();
            stage.close();
        }
        if(event.getSource() == btnDashboard){
            paneDashboard.toFront();
        }
        if(event.getSource() == btnLogout){
            Helper.changePage(event,"login");
        }
        if(event.getSource() == btnKirimGangguan){
            if(txtareaDetailGangguan.getText().isEmpty() || txtfieldLokasiGangguan.getText().isEmpty()) Helper.showAlert(Alert.AlertType.ERROR, "Field Kosong", "Field Tidak boleh kosong" );
        }

        if(event.getSource() == btnKirimPsgBaru){
            if (txtareaAlamatPasangBaru.getText().isEmpty() ||
                    txtareaNamaPasangBaru.getText().isEmpty() || txtareaIDPasangBaru.getText().isEmpty() ||
                    txtareaEmailPasangBaru.getText().isEmpty() || txtareaHpPasangBaru.getText().isEmpty() || chboxdayaawal.getAccessibleText().isEmpty()) Helper.showAlert(Alert.AlertType.ERROR, "Field Kosong", "Field Tidak boleh kosong" );
        }

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        chboxdayaawal.setItems(FXCollections.observableArrayList("450kw","900kw","1300kw"));
        chboxdayabaru.setItems(FXCollections.observableArrayList("450kw","900kw","1300kw"));

    }
}
