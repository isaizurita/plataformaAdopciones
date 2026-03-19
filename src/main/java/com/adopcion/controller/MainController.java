package com.adopcion.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.Node;

public class MainController {

    @FXML
    public void abrirRefugios(ActionEvent event) {

        try {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/view/RefugioView.fxml")
            );

            Parent root = loader.load();

            // 🔥 MISMA VENTANA (NO crear Stage nuevo)
            Stage stage = (Stage) ((Node) event.getSource())
                    .getScene().getWindow();

            Scene scene = new Scene(root, 800, 600);

            scene.getStylesheets().add(
                    getClass().getResource("/css/style.css").toExternalForm()
            );

            stage.setScene(scene);
            stage.setTitle("Refugios");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}