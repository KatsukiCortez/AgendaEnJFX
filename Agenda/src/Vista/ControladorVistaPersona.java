package Vista;

import Control.MainApp;
import Modelo.Persona;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ControladorVistaPersona {
    @FXML
    private TableView<Persona> personaTabla;
    @FXML
    private TableColumn<Persona, String> nombreColumna;
    @FXML
    private TableColumn<Persona, String> apellidoColumna;

    @FXML
    private Label lblNombre;
    @FXML
    private Label lblApellido;
    @FXML
    private Label lblDireccion;
    @FXML
    private Label lblCodigoPostal;
    @FXML
    private Label lblCiudad;
    @FXML
    private Label lblCumpleanos;

    // Referencia a la aplicación principal
    private MainApp mainApp;

    // Constructor
    public ControladorVistaPersona() {
    }

    /* Inicializar controlador, el método será llamado después de
    que el archivo fxml sea cargado */
    @FXML
    private void initialize() {
        nombreColumna.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        apellidoColumna.setCellValueFactory(cellData -> cellData.getValue().apellidoProperty());

        // Limpia los detalles de la persona al inicio
        showPersonDetails(null);

        // Escucha los cambios de selección y muestra los detalles de la persona seleccionada
        personaTabla.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> showPersonDetails(newValue));
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Agrega la lista observable a la tabla
        personaTabla.setItems(mainApp.getPersonaData());
    }

    private void showPersonDetails(Persona persona) {
        if (persona != null) {
            lblNombre.setText(persona.getNombre());
            lblApellido.setText(persona.getApellido());
            lblDireccion.setText(persona.getDireccion());
            lblCodigoPostal.setText(Integer.toString(persona.getCodigoPostal()));
            lblCiudad.setText(persona.getCiudad());
        } else {
            lblNombre.setText("");
            lblApellido.setText("");
            lblDireccion.setText("");
            lblCodigoPostal.setText("");
            lblCiudad.setText("");
        }
    }
}