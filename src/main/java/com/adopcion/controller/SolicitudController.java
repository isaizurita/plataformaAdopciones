package com.adopcion.controller;

import com.adopcion.dao.SolicitudAdopcionDAO;
import com.adopcion.model.SolicitudAdopcion;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class SolicitudController {

    @FXML
    private TextField txtNombre;

    private int idMascotaSeleccionada;

    public void setMascota(int idMascota) {
        this.idMascotaSeleccionada = idMascota;
    }

    @FXML
    private void solicitarAdopcion() {
        String nombre = txtNombre.getText();

        if (nombre.isEmpty()) {
            mostrarAlerta("Error", "Ingresa tu nombre");
            return;
        }

        SolicitudAdopcion solicitud = new SolicitudAdopcion(idMascotaSeleccionada, nombre);
        SolicitudAdopcionDAO.registrarSolicitud(solicitud);

        mostrarAlerta("Éxito", "Solicitud registrada correctamente");
        txtNombre.clear();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}