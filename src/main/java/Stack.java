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
        if (sizeOfStack + 1 > array.length) {
            throw new IllegalStateException("overflow");
        }
        array[sizeOfStack] = value;
        sizeOfStack++;

    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("underflow");
        }

        sizeOfStack--;
        return array[sizeOfStack];
    }

    public int size() {
        return sizeOfStack;
    }
}
