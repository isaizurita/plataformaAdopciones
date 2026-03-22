package com.adopcion.controller;

import com.adopcion.dao.MascotaDAO;
import com.adopcion.model.Mascota;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class MascotaController {

    @FXML private TextField nombreField;
    @FXML private TextField especieField;
    @FXML private TextField razaField;
    @FXML private TextField edadField;
    @FXML private TextField refugioIdField;

    @FXML private TableView<Mascota> tablaMascotas;
    @FXML private TableColumn<Mascota, Integer> colId;
    @FXML private TableColumn<Mascota, String> colNombre;
    @FXML private TableColumn<Mascota, String> colEspecie;
    @FXML private TableColumn<Mascota, String> colRaza;
    @FXML private TableColumn<Mascota, Integer> colEdad;
    @FXML private TableColumn<Mascota, String> colEstado;
    @FXML private TableColumn<Mascota, Integer> colRefugio;

    // 🔥 NUEVA COLUMNA
    @FXML private TableColumn<Mascota, Void> colAcciones;

    @FXML private Label mensajeLabel;

    private MascotaDAO dao = new MascotaDAO();

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colEspecie.setCellValueFactory(new PropertyValueFactory<>("especie"));
        colRaza.setCellValueFactory(new PropertyValueFactory<>("raza"));
        colEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        colRefugio.setCellValueFactory(new PropertyValueFactory<>("refugioId"));

        // 🔥 BOTÓN "ADOPTAR"
        colAcciones.setCellFactory(param -> new TableCell<>() {
            private final Button btn = new Button("Adoptar");

            {
                btn.setOnAction(event -> {
                    Mascota mascota = getTableView().getItems().get(getIndex());
                    abrirSolicitud(mascota);
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(empty ? null : btn);
            }
        });

        cargarMascotas();
    }

    private void cargarMascotas() {
        try {
            ObservableList<Mascota> lista = FXCollections.observableArrayList(dao.obtenerTodas());
            tablaMascotas.setItems(lista);
        } catch (Exception e) {
            mensajeLabel.setText("Error al cargar mascotas: " + e.getMessage());
        }
    }

    @FXML
    private void agregarMascota() {
        try {
            Mascota m = new Mascota(
                nombreField.getText(),
                especieField.getText(),
                razaField.getText(),
                Integer.parseInt(edadField.getText()),
                "disponible",
                Integer.parseInt(refugioIdField.getText())
            );
            dao.agregar(m);
            mensajeLabel.setText("✅ Mascota agregada correctamente.");
            limpiarCampos();
            cargarMascotas();
        } catch (Exception e) {
            mensajeLabel.setText("❌ Error: " + e.getMessage());
        }
    }

    @FXML
    private void marcarAdoptada() {
        Mascota seleccionada = tablaMascotas.getSelectionModel().getSelectedItem();
        if (seleccionada == null) {
            mensajeLabel.setText("⚠️ Selecciona una mascota de la tabla.");
            return;
        }
        try {
            dao.marcarAdoptada(seleccionada.getId());
            mensajeLabel.setText("✅ Mascota marcada como adoptada.");
            cargarMascotas();
        } catch (Exception e) {
            mensajeLabel.setText("❌ Error: " + e.getMessage());
        }
    }

    @FXML
    private void regresar() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MainView.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) tablaMascotas.getScene().getWindow();
            Scene scene = new Scene(root, 800, 600);
            scene.getStylesheets().add(
                getClass().getResource("/css/style.css").toExternalForm()
            );
            stage.setScene(scene);
            stage.setTitle("Sistema de Adopción de Mascotas");
        } catch (Exception e) {
            mensajeLabel.setText("❌ Error al regresar: " + e.getMessage());
        }
    }

    // 🔥 MÉTODO CLAVE HU-05
    private void abrirSolicitud(Mascota mascota) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/SolicitudView.fxml"));
            Parent root = loader.load();

            SolicitudController controller = loader.getController();
            controller.setMascota(mascota.getId());

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Solicitar adopción");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void limpiarCampos() {
        nombreField.clear();
        especieField.clear();
        razaField.clear();
        edadField.clear();
        refugioIdField.clear();
    }
}