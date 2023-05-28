package Control;

import Modelo.Persona;
import Vista.ControladorVistaEditarPersona;
import Vista.ControladorVistaPersona;
import java.io.File;
import java.io.IOException;
import java.util.prefs.Preferences;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    // AGREGAR LISTA OBVERSABLE
    private ObservableList<Persona> personData = FXCollections.observableArrayList();
    
    // Constructor
    public MainApp(){
        // Agregar algunos datos
        personData.add(new Persona("Rocky","Balboa"));
        personData.add(new Persona("Avril", "Lavigne")); 
        personData.add(new Persona("Koe", "Wetzel"));
	personData.add(new Persona("David", "Bowie"));
	personData.add(new Persona("Peter", "Parker"));
	personData.add(new Persona("Wanda", "Maximoff"));
	personData.add(new Persona("Mario", "Vargas"));
	personData.add(new Persona("Linda", "Steff"));
	personData.add(new Persona("Lizeth", "Ortiz"));
    }
    
    //Retornar los datos a la lista
    public ObservableList<Persona> getPersonaData() {
        return personData;
    }
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Agenda");
        
        // Agregar icono
        this.primaryStage.getIcons().add(new Image("/imagenes/icon.png"));
        
        // Iniciar venatans
        initRootLayout();
        showPersonOverview();
    }
    
    // Programa iniciar root layout
    public void initRootLayout() {
        try {
            // Cargar vista principal del archivo fxml
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/vista/VistaPrincipal.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            // Mostrar conteniendo a root layout
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showPersonOverview() {
        try {
            // Cargar vista persona
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/vista/VistaPersona.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();
            
            // Poner vista persona en el centro de principal
            rootLayout.setCenter(personOverview);
            
            // Usar el cotrolador para el programa principal
            ControladorVistaPersona controlador = loader.getController();
            controlador.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public boolean showPersonEditDialog(Persona persona) {
    try {
        // Cargar archivo fxml 
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("/vista/VistaEditarPersona.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        // Crear dialogo
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Editar persona");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Usar el controlador
        ControladorVistaEditarPersona controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setPersona(persona);

        // Mostrar hasta que el usuario cierre la ventana
        dialogStage.showAndWait();

        return controller.isOkClicked();
    } catch (IOException e) {
        e.printStackTrace();
        return false;
    }
}
    
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public File getPersonFilePath(){
        Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
        String filePath = prefs.get("filePath", null);
        if (filePath != null) {
            return new File(filePath);
        } else {
            return null;
        }
    }
    
    public void setPersonFilePath(File file){
        Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
        if(file != null){
            prefs.put("filePath", file.getPath());
            
            // Actualizar el titulo
            primaryStage.setTitle("AddressApp - " + file.getName());
        } else {
            prefs.remove("filePath");
            
            // Actualizar el titulo del escenario
            primaryStage.setTitle("AddressApp");
        }
    }
}