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
    private Label lblDireccionl;
    @FXML
    private Label lblCodigoPostal;
    @FXML
    private Label lblCiudad;
    @FXML
    private Label lblCumpleanos;
    
    // Referencia a la aplicacion principal
    private MainApp mainApp;
    
    // Constructor
    public ControladorVistaPersona(){
    }
    
    /* Inicializar controlador, el metodo sera llamado despues de 
    que el archivo fxml sea cargado*/
    
    @FXML
    private void initilize(){
        nombreColumna.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        apellidoColumna.setCellValueFactory(cellData -> cellData.getValue().apellidoProperty());
    }
    
    public void setMainApp(MainApp mainApp){
        this.mainApp = mainApp;
        
        // Agregar lista observable a la tabla
        personaTabla.setItems(mainApp.getPersonaData());
    }
    
}
