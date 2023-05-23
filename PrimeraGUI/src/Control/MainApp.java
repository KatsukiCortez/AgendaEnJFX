package Control;

import java.io.IOException;
import javafx.application.Application;
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
            AnchorPane pane = loader.load();
            //rootLayout = (BorderPane) loader.load();
            
            // Mostrar conteniendo a root layout
            Scene scene = new Scene(pane);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showPersonOverview() {
        try {
            // Cargar vista persona
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/vista/VistaPersona.fxml"));
            //AnchorPane personOverview = (AnchorPane) loader.load();
            AnchorPane pane = loader.load();
            
            // Set person overview into the center of root layout.
            //rootLayout.setCenter(personOverview);
            //puesta en escena
            Scene scene = new Scene(pane);
            primaryStage.setScene(scene);
            primaryStage.show();
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