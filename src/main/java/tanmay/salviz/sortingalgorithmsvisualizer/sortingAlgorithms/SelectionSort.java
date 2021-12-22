package tanmay.salviz.sortingalgorithmsvisualizer.sortingAlgorithms;

import javafx.scene.canvas.Canvas;

public class SelectionSort extends SortUserInterface {

    private int activeIndex;
    private int smallestIndex = 0;
    private int sortedIndex = 0;

    public SelectionSort(Canvas canvas) {
        super(canvas);
    }

    @Override
    public boolean updateOneFrame() {
        activeIndex++;
        if (activeAndSmallestIndicesInRange())
            updateSmallestIndex();
        else if (smallestInRange())
            this.swap(smallestIndex, sortedIndex);

        return (sortedIndex == this.getArray().length);
    }

    private boolean smallestInRange() {
        return (smallestIndex != this.getArray().length);
    }

    private boolean activeAndSmallestIndicesInRange() {
        return (activeIndex != this.getArray().length && smallestIndex != this.getArray().length);
    }

    private void updateSmallestIndex() {
        if (this.getArray()[activeIndex] < this.getArray()[smallestIndex])
            smallestIndex = activeIndex;
    }

    @Override
    void swap(int indexOne, int indexTwo) {
        super.swap(indexOne, indexTwo);

        sortedIndex++;
        activeIndex = sortedIndex;
        smallestIndex = sortedIndex;
    }

    @Override
    public void initializeData(int size) {
        super.initializeData(size);

        this.activeIndex = 0;
        this.smallestIndex = 0;
        this.sortedIndex = 0;
    }

    @Override
    public void updateCanvas() {
        super.updateCanvas();

        if (activeIndex < this.getArray().length)
            this.drawAtIndex(activeIndex, this.SELECT_COLOR);

        if (sortedIndex < this.getArray().length)
            this.drawAtIndex(sortedIndex, this.SORTED_TILL_COLOR);

        if (smallestIndex < this.getArray().length)
            this.drawAtIndex(smallestIndex, this.SORT_COMPLETED);
    }

}
