	package controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.io.IOException;

public class Helper {
    private static double x,y;
    public static void changePage(ActionEvent event, String viewName){
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        Parent view = null;
        try {
            view = FXMLLoader.load(Helper.class.getResource("../view/" + viewName + ".fxml"));
            Scene scene = new Scene(view);
            stage.setScene(scene);
            stage.setResizable(false);
            view.setOnMousePressed(mouseEvent -> {
                x = mouseEvent.getSceneX();
                y = mouseEvent.getSceneY();
            });

            view.setOnMouseDragged(mouseEvent -> {

                stage.setX(mouseEvent.getScreenX() - x);
                stage.setY(mouseEvent.getScreenY() - y);

            });
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void changeScene(Event event, Parent view) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Scene scene = new Scene(view);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static FXMLLoader getLoader(String viewName){
        return new FXMLLoader(Helper.class.getResource("../view/" + viewName + ".fxml"));
    }


}
