import java.util.Arrays;

public class Stack {

    private final int[] array;
    private int sizeOfStack = 0;


    public Stack(int size) {
        array = new int[size];
    }

    public boolean isEmpty() {
        return sizeOfStack == 0;
    }

    public void push(int value) {
        if (isStackWillOverflow()) {
            throw new IllegalStateException("overflow");
        }

        increaseStackSize();
        addValueToArray(value);

    }

    private boolean isStackWillOverflow() {
        return sizeOfStack + 1 > array.length;
    }

    private int increaseStackSize() {
        return sizeOfStack++;
    }

    private void addValueToArray(int value) {
        array[getCurrentArrayIndex()] = value;
    }

    private int getCurrentArrayIndex() {
        return sizeOfStack - 1;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("underflow");
        }

        int value = getLastElement();
        decreaseStackSize();
        return value;
    }

    private int decreaseStackSize() {
        return sizeOfStack--;
    }

    private int getLastElement() {
        return array[getCurrentArrayIndex()];
    }

    public int size() {
        return sizeOfStack;
    }

    @Override
    public String toString() {
        String display = "";
        for (int indexOfArray = sizeOfStack - 1 /*getCurrentArrayIndex()*/;
             indexOfArray >= 0;
             indexOfArray--) {
            display = display + array[indexOfArray];
            if (indexOfArray > 0) {
                display = display + "  -> ";
            }
        }

        return display + " Stack size is " + sizeOfStack;
    }

}
