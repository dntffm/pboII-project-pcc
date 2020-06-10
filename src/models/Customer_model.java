package models;

import controller.Helper;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

public class Customer_model extends DBConnection {
    public static int postNewReport(ObservableList data){
        String sql = "INSERT INTO daftar_aduan(id_user,Alamat_aduan,Nama_pengadu,detail_aduan,status,created_at)" +
                " VALUES(" +
                "?,?,?,?,?,?" +
                ")";
        LocalDate date = LocalDate.now();
        int row = 0;
        try {
            PreparedStatement stmt = DBConnection.getConnection().prepareStatement(sql);
            stmt.setInt(1,1);
            stmt.setString(2,data.get(0).toString());
            stmt.setString(3,data.get(1).toString());
            stmt.setString(4,data.get(2).toString());
            stmt.setString(5,"pending");
            stmt.setString(6,date.toString());

            row = stmt.executeUpdate();
        } catch (SQLException e){
            Helper.showAlert(Alert.AlertType.ERROR, "Gagal", "Harap Coba Lagi" );
        }

        return row;
    }

    public static int addAjuanBaru(ObservableList data){
        String sql = "INSERT INTO daftar_ajuan (`id_user`, `nama_pemohon`, `hp_pemohon`, `nomor_identitas`, `alamat_lengkap`, `perutukan`, `daya`, `jenis_produk`, `status`, `created_at`)" +
                " VALUES(" +
                "?,?,?,?,?,?,?,?,?,?" +
                ")";
        LocalDate date = LocalDate.now();
        int row = 0;
        try {
            PreparedStatement stmt = DBConnection.getConnection().prepareStatement(sql);
            stmt.setInt(1,1);
            stmt.setString(2,data.get(0).toString());
            stmt.setString(3,data.get(2).toString());
            stmt.setString(4,data.get(3).toString());
            stmt.setString(5,data.get(1).toString());
            stmt.setString(6,data.get(5).toString());
            stmt.setString(7,data.get(4).toString());
            stmt.setString(8,data.get(6).toString());
            stmt.setString(9,"pending");
            stmt.setString(10,date.toString());

            row = stmt.executeUpdate();
        } catch (SQLException e){
            Helper.showAlert(Alert.AlertType.ERROR, "Gagal", "Harap Coba Lagi" );

        }
        return row;
    }
}
