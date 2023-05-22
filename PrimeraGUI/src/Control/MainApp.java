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
    
    // programa iniciar root layout
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/vista/Rootlayout.fxml"));
            AnchorPane pane = loader.load();
            //rootLayout = (BorderPane) loader.load();
            
            
            // no existe un controlador por el momento
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(pane);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showPersonOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/vista/PersonOverview.fxml"));
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