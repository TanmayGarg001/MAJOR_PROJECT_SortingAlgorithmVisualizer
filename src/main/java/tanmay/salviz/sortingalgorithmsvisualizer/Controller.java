package tanmay.salviz.sortingalgorithmsvisualizer;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import tanmay.salviz.sortingalgorithmsvisualizer.baseUI.UserInterface;
import tanmay.salviz.sortingalgorithmsvisualizer.sortingAlgorithms.BubbleSort;
import tanmay.salviz.sortingalgorithmsvisualizer.sortingAlgorithms.InsertionSort;
import tanmay.salviz.sortingalgorithmsvisualizer.sortingAlgorithms.SelectionSort;
import tanmay.salviz.sortingalgorithmsvisualizer.sortingAlgorithms.SortUserInterface;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    public Canvas canvas;
    @FXML
    public ChoiceBox<String> sortingAlgorithmChoice;
    @FXML
    public ChoiceBox<Integer> arraySizeChoice;
    @FXML
    public Slider sortSpeed;
    @FXML
    public Button startSorting;

    SortUserInterface elementArray;
    String[] algorithms = {"Bubble Sort", "Selection Sort", "Insertion Sort"};
    Integer[] sizeChoice = {10, 25, 50, 100, 125, 200, 250};

    private UserInterface userInterface;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sortingAlgorithmChoice.getItems().addAll(algorithms);
        sortingAlgorithmChoice.getSelectionModel().selectFirst();

        arraySizeChoice.getItems().addAll(sizeChoice);
        arraySizeChoice.getSelectionModel().selectFirst();

        userInterface = new BubbleSort(canvas);
        userInterface.clearCanvas();
    }

    public void sortMe() {
        int size = arraySizeChoice.getSelectionModel().getSelectedItem();
        if (this.userInterface != null && this.userInterface.getSimulationStatus())
            this.userInterface.stop();

        this.userInterface = getSortingSimulation(sortingAlgorithmChoice.getValue());
        if (this.userInterface != null) {
            this.userInterface.clearCanvas();
            this.userInterface.setScansPerSecond((int) sortSpeed.getValue() * 2);
            this.userInterface.initializeData(size);
            this.userInterface.randomizeData();
            this.userInterface.start();
        }
    }

    private UserInterface getSortingSimulation(String algorithm) {
        return switch (algorithm) {
            case "Bubble Sort" -> new BubbleSort(canvas);
            case "Selection Sort" -> new SelectionSort(canvas);
            case "Insertion Sort" -> new InsertionSort(canvas);
            default -> null;
        };
    }


}

