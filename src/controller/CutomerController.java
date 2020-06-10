package controller;


import com.sun.org.apache.bcel.internal.generic.I2F;
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
import java.util.ResourceBundle;
import models.Customer_model;
public class CutomerController implements Initializable {
    @FXML
    private ChoiceBox chPeruntukan;

    @FXML
    private ChoiceBox chJenisProduk;

    @FXML
    private VBox vbPanelNotif =null;
    @FXML
    private VBox vbpsgbaru = null,vboxubahdaya1,vboxubahdaya2;
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
    private Pane panePenyesuaianDaya,paneUbahDaya;

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
    private Button btnKirimGangguan,kirimAjuanBaru,btnKirimUbahDaya;
    @FXML
    private TextArea txtareaDetailGangguan;

    @FXML
    private TextField txtfieldLokasiGangguan;

    @FXML
    private ChoiceBox chboxdayabaru;
    @FXML
    private ChoiceBox chboxdayaawal;

    @FXML
    private TextField TFNamaPengajuBaru;

    @FXML
    private TextField TFAlamatPengajuBaru;

    @FXML
    private TextField TFHPPengajuBaru;

    @FXML
    private TextField TFNomerIDPengajuBaru;

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

        if(event.getSource() == btnReportGangguan){
            paneReportGangguan.toFront();
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

        }
        if(event.getSource() == btnPenyesuaianDaya){
            panePenyesuaianDaya.toFront();


        }


    }

    @FXML
    public void AddReportGangguan(ActionEvent event){
        if (event.getSource() == btnKirimGangguan){
            if(txtareaDetailGangguan.getText().isEmpty() || txtfieldLokasiGangguan.getText().isEmpty()){
                Helper.showAlert(Alert.AlertType.ERROR, "Field Kosong", "Field Tidak boleh kosong" );
            } else{
                ObservableList<String> dataReport = FXCollections.observableArrayList();
                System.out.println();
                paneReportGangguan.getChildren()
                        .filtered(node -> node instanceof TextField)
                        .forEach(node -> dataReport.add(((TextField)node).getText()));
                paneReportGangguan.getChildren()
                        .filtered(node -> node instanceof TextArea)
                        .forEach(node -> dataReport.add(((TextArea)node).getText()));


                if (Customer_model.postNewReport(dataReport) > 0){
                    Helper.showAlert(Alert.AlertType.CONFIRMATION, "Berhasil", "Report Gangguan Berhasil Dikirim, Konfirmasi Akan Dikirim Lewat Email" );
                    paneDashboard.toFront();
                }
            }
        }
    }

    public void AddPasangBaru(ActionEvent event){
        ObservableList<String> dataPasangBaru = FXCollections.observableArrayList();
        if(event.getSource() == kirimAjuanBaru){
            if (TFAlamatPengajuBaru.getText().isEmpty() ||
                    TFNamaPengajuBaru.getText().isEmpty() || TFNomerIDPengajuBaru.getText().isEmpty() ||
                    TFHPPengajuBaru.getText().isEmpty() ){
                Helper.showAlert(Alert.AlertType.ERROR, "Field Kosong", "Field Tidak boleh kosong" );
            } else {
                try {

                    vbpsgbaru.getChildren()
                            .filtered(node -> node instanceof TextField)
                            .forEach(node -> dataPasangBaru.add(((TextField)node).getText()));
                    vbpsgbaru.getChildren()
                            .filtered(node -> node instanceof ChoiceBox)
                            .forEach(node -> dataPasangBaru.add(((ChoiceBox)node).getValue().toString()));

                    if (Customer_model.addAjuanBaru(dataPasangBaru) > 0){
                        Helper.showAlert(Alert.AlertType.CONFIRMATION, "Berhasil",
                                "Ajuan Listrik Baru Berhasil Dikirim, Tunggu konfirmasi selanjutnya melalui telepon. Pastikan Nomor diinputkan Benar" );
                        paneDashboard.toFront();
                    }
                } catch (NullPointerException e){
                    Helper.showAlert(Alert.AlertType.ERROR, "Field Kosong", "Field Tidak boleh kosong" );
                }
            }
        }
    }

    public void addUbahDaya(ActionEvent event){
        ObservableList<String> dataUbahan = FXCollections.observableArrayList();
        if (event.getSource() == btnKirimUbahDaya){
            vboxubahdaya1.getChildren()
                        .filtered(node -> node instanceof ChoiceBox)
                        .forEach(node ->  dataUbahan.add(((ChoiceBox)node).getValue().toString()));
            vboxubahdaya2.getChildren()
                    .filtered(node -> node instanceof TextField)
                    .forEach(node -> dataUbahan.add(((TextField)node).getText()));

            System.out.println(dataUbahan);
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        chboxdayaawal.setItems(FXCollections.observableArrayList("450kw","900kw","1300kw"));
        chJenisProduk.setItems(FXCollections.observableArrayList("pascabayar","prabayar"));
        chPeruntukan.setItems(FXCollections.observableArrayList("Rumah Tangga","Non-Rumah tangga"));
        chboxdayabaru.setItems(FXCollections.observableArrayList("450kw","900kw","1300kw"));


    }
}
