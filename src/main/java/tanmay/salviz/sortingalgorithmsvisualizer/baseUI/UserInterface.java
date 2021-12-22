package tanmay.salviz.sortingalgorithmsvisualizer.baseUI;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class UserInterface extends AnimationTimer {

    public Color UNSORTED_COLOR = Color.rgb(198, 213, 126);//initial bar colors
    public Color SELECT_COLOR = Color.rgb(255, 175, 204);//bar pointer (being taken into consideration) color
    /*SORTED_TILL & ELEMENT_CONSIDERING_FOR_SWAP are for some particular algorithms*/
    public Color SORTED_TILL_COLOR = Color.rgb(162, 210, 255);//the array is sorted before this color
    public Color ELEMENT_CONSIDERING_FOR_SWAP_COLOR = Color.rgb(213, 126, 126);//the latest element in the iteration which is being considered for swap.
    public Color SORT_COMPLETED = Color.rgb(199, 125, 255);//the latest element in the iteration which is being considered for swap.
    public Color CANVAS_BG_COLOR = Color.rgb(47, 43, 67);//background color for canvas

    public Canvas canvas;
    private int scansPerSecond = 2;//varies from 1 to 5, 1being slowest and 5 being fastest.
    private boolean simulationStatus;

    public UserInterface() {
    }

    public UserInterface(Canvas canvas) {
        this.canvas = canvas;
    }

    public UserInterface(Canvas canvas, int scansPerSecond) {
        this.canvas = canvas;
        this.scansPerSecond = scansPerSecond;
    }

    public UserInterface(Canvas canvas, Color UNSORTED_COLOR, Color SORTED_TILL_COLOR, Color CANVAS_BG_COLOR) {
        this.canvas = canvas;
        this.UNSORTED_COLOR = UNSORTED_COLOR;
        this.SORTED_TILL_COLOR = SORTED_TILL_COLOR;
        this.CANVAS_BG_COLOR = CANVAS_BG_COLOR;
    }

    @Override
    public void start() {
        super.start();

        this.simulationStatus = true;
    }

    @Override
    public void stop() {
        super.stop();
        this.simulationStatus = false;
    }

    public void clearCanvas() {
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setFill(this.CANVAS_BG_COLOR);
        graphicsContext.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public Color getSORT_COMPLETED() {
        return SORT_COMPLETED;
    }

    public int getScansPerSecond() {
        return scansPerSecond;
    }

    public void setScansPerSecond(int scansPerSecond) {
        this.scansPerSecond = scansPerSecond;
    }

    public Color getUNSORTED_COLOR() {
        return UNSORTED_COLOR;
    }

    public Color getSELECT_COLOR() {
        return SELECT_COLOR;
    }

    public Color getSORTED_TILL_COLOR() {
        return SORTED_TILL_COLOR;
    }

    public Color getELEMENT_CONSIDERING_FOR_SWAP_COLOR() {
        return ELEMENT_CONSIDERING_FOR_SWAP_COLOR;
    }

    public Color getCANVAS_BG_COLOR() {
        return CANVAS_BG_COLOR;
    }

    public boolean getSimulationStatus() {
        return simulationStatus;
    }

    public abstract void updateCanvas();

    public abstract void initializeData(int size);

    public abstract void randomizeData();

}
