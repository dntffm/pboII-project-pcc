package models;

import controller.Helper;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Signup_model extends DBConnection{
    public static ResultSet cekUser(String username,String password){
        String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2,password);
            resultSet = preparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    public static boolean Register(ObservableList data){
        String sql = "INSERT INTO user(username,password,email,role) VALUES(?,?,?,?)";

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setString(1,data.get(0).toString());
            preparedStatement.setString(2,data.get(2).toString());
            preparedStatement.setString(3,data.get(1).toString());
            preparedStatement.setString(4,"customer");

            preparedStatement.execute();

        } catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }
}
