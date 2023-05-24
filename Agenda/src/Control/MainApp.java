package Control;

import Modelo.Persona;
import Vista.ControladorVistaPersona;
import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Agenda");
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
    
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    // AGREGAR LISTA OBVERSABLE
    private ObservableList<Persona> personaData = FXCollections.observableArrayList();
    
    // Constructor
    public MainApp(){
        // Agregar algunos datos
        personaData.add(new Persona("Rocky","Balboa"));
        personaData.add(new Persona("Avril", "Lavigne")); 
        personaData.add(new Persona("Koe", "Wetzel"));
	personaData.add(new Persona("David", "Bowie"));
	personaData.add(new Persona("Peter", "Parker"));
	personaData.add(new Persona("Wanda", "Maximoff"));
	personaData.add(new Persona("Mario", "Vargas"));
	personaData.add(new Persona("Linda", "Steff"));
	personaData.add(new Persona("Lizeth", "Ortiz"));
    }
    
    //Retornar los datos a la lista
    public ObservableList<Persona> getPersonaData() {
        return personaData;
    }
    
}