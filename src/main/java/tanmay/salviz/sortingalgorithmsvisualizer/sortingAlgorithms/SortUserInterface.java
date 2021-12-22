package tanmay.salviz.sortingalgorithmsvisualizer.sortingAlgorithms;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import tanmay.salviz.sortingalgorithmsvisualizer.baseUI.UserInterface;

import java.util.Arrays;
import java.util.Random;

public abstract class SortUserInterface extends UserInterface {

    public int RES_WIDTH = 1000;
    public int RES_HEIGHT = 900;
    private Integer[] array;
    private long lastFrame = 0;
    private int PADDING = 1;
    private int width;
    private int height;


    public SortUserInterface(Canvas canvas) {
        super(canvas);
    }


    public Integer[] getArray() {
        return array;
    }

    @Override
    public void initializeData(int arraySize) {
        this.array = new Integer[arraySize];
        for (int i = 0; i < arraySize; i++) {
            this.array[i] = (int) (Math.random() * 700) + 75;
        }
    }

    @Override
    public void randomizeData() {
        Random random = new Random();
        int randomIndex;
        int temp;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < array.length; j++) {
                randomIndex = random.nextInt(array.length);
                temp = array[i];
                array[i] = array[randomIndex];
                array[randomIndex] = temp;
            }
        }
    }

    public void drawArrayOnCanvas() {//displaying data on canvas
//        GraphicsContext graphicsContext = this.canvas.getGraphicsContext2D();
//        int width = (RES_WIDTH / array.length) - (2 * PADDING);
        for (int i = 0; i < array.length; i++) {
//            graphicsContext.setFill(UNSORTED_COLOR);
//            //((width + GAP_BETWEEN_ELEMENTS) * (i + 2)) - width {bank space shifts right due to wrong algorithm/formula}
//            graphicsContext.fillRect((((i * ((int) (RES_WIDTH / array.length)))) + PADDING), RES_HEIGHT - array[i], width, array[i]);
            this.drawAtIndex(i, UNSORTED_COLOR);
        }
    }

    public void drawAtIndex(int i, Color color) {
        GraphicsContext graphicsContext = this.canvas.getGraphicsContext2D();
        int width = (RES_WIDTH / array.length) - (2 * PADDING);
        graphicsContext.setFill(color);
        graphicsContext.fillRect(Math.round(((i * ((int) (RES_WIDTH / array.length)))) + PADDING), RES_HEIGHT - array[i], width, array[i]);
    }

    void swap(int i, int j) {
        int temp = this.getArray()[i];
        this.getArray()[i] = this.getArray()[j];
        this.getArray()[j] = temp;
    }

    @Override
    public void handle(long now) {
        int framesPerSecond = 144;
        if ((now - lastFrame) > ((10 - this.getScansPerSecond()) * 1000000000L / array.length)) {
            lastFrame = now;
            int numberOfUpdates;
            if (array.length <= framesPerSecond)
                numberOfUpdates = 1;
            else
                numberOfUpdates = this.getScansPerSecond() * array.length / framesPerSecond + 1;
            boolean moreFramesRemaining;
            for (int i = 0; i < numberOfUpdates; i++) {
                moreFramesRemaining = updateOneFrame();
                if (moreFramesRemaining) {
                    this.updateCanvas();
                    this.stop();
                }
            }
            this.updateCanvas();
        }
    }

    @Override
    public void updateCanvas() {
        this.clearCanvas();
        if (this.array == null) {//to avoid exception if canvas is clear already
            return;
        }
        this.drawArrayOnCanvas();
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    public abstract boolean updateOneFrame();

}


//    public Integer[] initializeArr(int arraySize) {//initializing data (randomizing)
//        clearCanvas();
//        array = new Integer[arraySize];
//        for (int i = 0; i < arraySize; i++) {
//            this.array[i] = (int) (Math.random() * 700) + 75;
//        }
//        return this.array;
//    }
//

//

//
//
//    public void swap(int i, int j) {
//        GraphicsContext graphicsContext = this.canvas.getGraphicsContext2D();
//        int width = (RES_WIDTH / array.length) - (2 * PADDING);
//        graphicsContext.setFill(CANVAS_BG_COLOR);
//        graphicsContext.fillRect(Math.round(((i * ((int) (RES_WIDTH / array.length)))) + PADDING), RES_HEIGHT - array[i], width, array[i]);
//        graphicsContext.fillRect(Math.round(((j * ((int) (RES_WIDTH / array.length)))) + PADDING), RES_HEIGHT - array[j], width, array[j]);
//
//        int temp = array[i];
//        array[i] = array[j];
//        array[j] = temp;
//
//        graphicsContext.setFill(SELECT_COLOR);
//        graphicsContext.fillRect(Math.round(((i * ((int) (RES_WIDTH / array.length)))) + PADDING), RES_HEIGHT - array[i], width, array[i]);
//        graphicsContext.setFill(SELECT_COLOR);
//        graphicsContext.fillRect(Math.round(((j * ((int) (RES_WIDTH / array.length)))) + PADDING), RES_HEIGHT - array[j], width, array[j]);
//    }
//
//    public void clearCanvas() {
//        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
//        graphicsContext.setFill(this.CANVAS_BG_COLOR);
//        graphicsContext.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
//    }

//    public void bubbleSortAlgorithm() throws InterruptedException {
//        for (int i = 0; i < ARRAY_SIZE; i++) {
//            for (int j = 0; j < ARRAY_SIZE - i - 1; j++) {
//                if (array[j] > array[j + 1]) {
//                    swap(j, j + 1);
//
//                }
//            }
//        }
//    }
//
//    public void sortingFinished() {
//        GraphicsContext graphicsContext = this.canvas.getGraphicsContext2D();
//        int width = (RES_WIDTH / array.length) - (2 * PADDING);
//        for (int i = 0; i < ARRAY_SIZE; i++) {
//            graphicsContext.setFill(SORT_COMPLETED);
//            graphicsContext.fillRect(Math.round(((i * ((int) (RES_WIDTH / array.length)))) + PADDING), RES_HEIGHT - array[i], width, array[i]);
//        }
//    }
