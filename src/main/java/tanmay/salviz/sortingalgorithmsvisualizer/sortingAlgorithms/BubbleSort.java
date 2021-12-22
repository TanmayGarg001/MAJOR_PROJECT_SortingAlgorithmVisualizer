package tanmay.salviz.sortingalgorithmsvisualizer.sortingAlgorithms;

import javafx.scene.canvas.Canvas;

public class BubbleSort extends SortUserInterface {

    private int leftActive;
    private int rightActive;
    private int swapsPerformed;

    public BubbleSort(Canvas canvas) {
        super(canvas);
    }

    @Override
    public boolean updateOneFrame() {
        if (rightActive == this.getArray().length) {
            if (swapsPerformed == 0) {
                leftActive++;
                return true;
            } else {
                leftActive = 0;
                rightActive = 1;
                swapsPerformed = 0;
            }
        } else if (this.getArray()[leftActive] > this.getArray()[rightActive]) {
            swap(leftActive, rightActive);
        } else {
            leftActive++;
            rightActive++;
        }

        return false;
    }

    @Override
    void swap(int i1, int j) {
        super.swap(i1, j);
        swapsPerformed++;
        leftActive++;
        rightActive++;
    }

    @Override
    public void initializeData(int size) {
        super.initializeData(size);
        leftActive = 0;
        rightActive = 1;
        swapsPerformed = 0;
    }

    @Override
    public void updateCanvas() {
        super.updateCanvas();
        if (leftActive < this.getArray().length)
            this.drawAtIndex(leftActive, this.SELECT_COLOR);
        if (rightActive < this.getArray().length)
            this.drawAtIndex(rightActive, this.SORTED_TILL_COLOR);
    }

}
