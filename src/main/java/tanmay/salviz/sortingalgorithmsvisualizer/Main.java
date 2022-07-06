/*
 * Build start date: 27/Sep/2021
 *
 * Sorting Algorithm Visualizer: Learn about different types sorting algorithms with the help of a visual representation.
 *
 * Technologies used:
 * Java17 (JDK: Amazon Corretto [LTS-version])
 * JavaFx17 (SDK 17.0.0.1)
 * Scene Builder 17.0.0
 * Adobe Illustrator 2021 (v25.1.0.90)
 * FXML,CSS
 *
 * Build end date: 10/Nov/2021
 */
package tanmay.salviz.sortingalgorithmsvisualizer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("applicationInterface.fxml")));
        Scene scene = new Scene(root);
        String css = Objects.requireNonNull(getClass().getResource("styleSheets/visualAspects.css")).toExternalForm();
        scene.getStylesheets().add(css);
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("iconsAndImages/appIcon.png"))));
        //Resolution Setup: 1280*900 (1.422 aspect ratio)
        //Canvas resolution: 1000*900 (1.111 aspect ratio)
        //Vbox resolution: 280*900 (0.311 as[ect ratio)
        stage.setWidth(1280);
        stage.setHeight(900);
        stage.setResizable(false);
        stage.setTitle("Sorting Algorithms Visualizer");
        stage.setScene(scene);
        stage.show();
    }

}