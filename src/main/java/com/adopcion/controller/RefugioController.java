package com.adopcion.controller;

import com.adopcion.dao.RefugioDAO;
import com.adopcion.model.Refugio;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.*;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.cell.PropertyValueFactory;

public class RefugioController {

    @FXML private TextField txtNombre;
    @FXML private TextField txtDireccion;
    @FXML private TextField txtTelefono;
    @FXML private TableView<Refugio> tablaRefugios;

    private RefugioDAO dao = new RefugioDAO();

    // 🔥 Se ejecuta al abrir la vista
    @FXML
    public void initialize() {

        TableColumn<Refugio, String> colNombre = new TableColumn<>("Nombre");
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        TableColumn<Refugio, String> colDireccion = new TableColumn<>("Dirección");
        colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));

        TableColumn<Refugio, String> colTelefono = new TableColumn<>("Teléfono");
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));

        tablaRefugios.getColumns().addAll(colNombre, colDireccion, colTelefono);
    }

    // =========================
    @FXML
    public void registrarRefugio(ActionEvent event) {
        try {

            Refugio r = new Refugio(
                    txtNombre.getText(),
                    txtDireccion.getText(),
                    txtTelefono.getText()
            );

            dao.guardar(r);

            mostrarMensaje("Refugio registrado correctamente");

            limpiarCampos();

        } catch (Exception e) {
            mostrarMensaje("Error: " + e.getMessage());
        }
    }

    // =========================
    @FXML
    public void cargarRefugios(ActionEvent event) {

        try {

            ObservableList<Refugio> lista =
                    FXCollections.observableArrayList(dao.obtenerTodos());

            tablaRefugios.setItems(lista);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // =========================
    @FXML
    public void volverMenu(ActionEvent event) {

        try {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/view/MainView.fxml")
            );

            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource())
                    .getScene().getWindow();

            Scene scene = new Scene(root, 800, 600);

            scene.getStylesheets().add(
                    getClass().getResource("/css/style.css").toExternalForm()
            );

            stage.setScene(scene);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // =========================
    private void limpiarCampos() {
        txtNombre.clear();
        txtDireccion.clear();
        txtTelefono.clear();
    }

    private void mostrarMensaje(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}