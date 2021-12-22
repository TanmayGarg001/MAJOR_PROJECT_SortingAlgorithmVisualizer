package tanmay.salviz.sortingalgorithmsvisualizer.sortingAlgorithms;

import javafx.scene.canvas.Canvas;

public class InsertionSort extends SortUserInterface {
    private int unsortedIndex;
    private int currentIndex;

    public InsertionSort(Canvas canvas) {
        super(canvas);
    }

    @Override
    public boolean updateOneFrame() {
        if (unsortedIndex == this.getArray().length + 1)
            return true;

        if (currentIndex != 0) {
            if (this.getArray()[currentIndex - 1] > this.getArray()[currentIndex])
                swap(currentIndex - 1, currentIndex);
            else {
                unsortedIndex++;
                currentIndex = unsortedIndex - 1;
            }
        } else {
            unsortedIndex++;
            currentIndex = unsortedIndex - 1;
        }

        return false;
    }

    @Override
    void swap(int indexOne, int indexTwo) {
        super.swap(indexOne, indexTwo);

        currentIndex--;
    }

    @Override
    public void initializeData(int size) {
        super.initializeData(size);

        this.unsortedIndex = 1;
        this.currentIndex = 1;
    }

    @Override
    public void updateCanvas() {
        super.updateCanvas();

        if (unsortedIndex < this.getArray().length)
            drawAtIndex(unsortedIndex, this.SELECT_COLOR);

        if (currentIndex != this.getArray().length)
            drawAtIndex(currentIndex, this.SORTED_TILL_COLOR);
    }


}
