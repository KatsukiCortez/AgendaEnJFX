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
}