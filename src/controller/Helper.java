	package controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    public static void showAlert(Alert.AlertType alertType, String title, String message){
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.show();
    }
    public static ArrayList<Node> getAllNodes(Parent root) {
        ArrayList<Node> nodes = new ArrayList<>();
        addAllDescendents(root, nodes);
        return nodes;
    }

    private static void addAllDescendents(Parent parent, ArrayList<Node> nodes) {
        // Get children.
        List<Node> children = Collections.EMPTY_LIST;
        if (parent instanceof ButtonBar) {
            children = ((ButtonBar) parent).getButtons();
        } else if (parent instanceof TabPane) {
            for (Tab tab : ((TabPane) parent).getTabs()) {
                Node tabContent = tab.getContent();
                if (tabContent instanceof Parent) {
                    addAllDescendents((Parent) tab.getContent(), nodes);
                } else {
                    // You can log and get a type that is not supported.
                }
            }
        } else {
            children = parent.getChildrenUnmodifiable();
        }

        // Add nodes.
        for (Node node : children) {
            nodes.add(node);
            if (node instanceof Parent) {
                addAllDescendents((Parent) node, nodes);
            }
        }
    }
}
