package homework;

public class QueueWithArray {

    private final int[] array;

    private int head = 0;


    public QueueWithArray(int maximumSize) {
        this.array = new int[maximumSize];
    }


    public void enqueue(int value) { // enqueue=add element to end of the queue
        if (head == array.length) {// if our queueSize already equals to maximum queue size, then we go into if block
            throw new IllegalStateException("overflow"); // creating common exception for illegal state, with message "overflow" and throw it. That will stop method execution
        }
        if (head >= 0) {
            System.arraycopy(array, 0, array, 1, head);
        }
        array[0] = value;
        head++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("underflow");
        }
        head--;
        return array[head];
    }

    public int size() { // show correct size of queue
        return head;
    }

    public boolean isEmpty() { // show is queue empty or not
        return head == 0;
    }

    @Override
    public String toString() { // Here I return string presentation of queue, what could be printed
        String display = "";  // init display variable, what will be returned by method
        //reversal cycle
        int currentArrayIndexOfTopElement = head - 1;
        for (int indexOfArray = currentArrayIndexOfTopElement; //start iterate from top element
             indexOfArray >= 0; // iterate while index is in array boundaries
             indexOfArray--) // decrease array index with each iteration
        {
            if (indexOfArray == currentArrayIndexOfTopElement) { // if first element, then add ":" to begining of the string. but we need at least 1 value to get here
                display = display + ": ";
            }
            display = display + array[indexOfArray]; //adding value to string
            if (indexOfArray > 0) { // add "->" while we are not on last element
                display = display + " -> ";
            }
        }

        return "Queue size is " + size() + display; // final string Stack size info and stack state
    }


    public static void main(String[] args) {
        QueueWithArray queue = new QueueWithArray(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println(queue);

        System.out.println("Dequeue value" + queue.dequeue());
        queue.enqueue(10);
        System.out.println(queue);
    }

}
