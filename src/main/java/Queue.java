public class Queue {

    private QueueNode first = null; //reference (or link or pointer) to first(head) value holder of the queue
    private QueueNode last = null; //reference (or link or pointer) to last(tail) value holder of the queue

    private int queueSize = 0;
    private int maximumSize;

    public Queue(int maximumSize) {// public constructor what create Queue object and create initial state for it.
        this.maximumSize = maximumSize;
    }


    public void enqueue(int value) { // enqueue=add element to end of the queue
        if (queueSize == maximumSize) {// if our queueSize already equals to maximum queue size, then we go into if block
            throw new IllegalStateException("overflow"); // creating common exception for illegal state, with message "overflow" and throw it. That will stop method execution
        }
        QueueNode newNode = new QueueNode(value); // wrap our value to special value holder
        if (last == null) { // last == null means that queue is empty
            last = newNode; // make our newNode created element as last element
            first = newNode;// make our newNode created element as first element
        } else {
            this.last.setNextElement(newNode); // our new value holder will be added as next element to the end (to last element of queue)
            this.last = newNode; // now we can tell queue that new element (newNode) is last element of the queue
        }
        queueSize++; // increase queue size counter after adding value to the queue
    }

    public int dequeue() {
        if (isEmpty()) { // we can't get any value from empty stack
            throw new IllegalStateException("underflow"); // creating common exception for illegal state, with message "underflow" and throw it. That will stop method execution
        }
        QueueNode returningElement = this.first; // I assign current first element(head) to temporary variable "returningElement"
        this.first = returningElement.getNextElement(); // inside returningElement I have reference to next element inside queue;
        // I assign nextElement of returning element to field "first"(first now pointing to next element inside queue)

        if (this.first == null) { // when we had only one element in queue - nextElement was not exists, then first element now also not exists
            this.last = null; // we clean "last" reference to the last element of queue, because that element was removed from queue
        }
        queueSize--;// after success removing element from the queue, I decrease queue size counter
        return returningElement.getValue(); //returning correct value to client
    }

    public int size() { // show correct size of queue
        return queueSize;
    }

    public boolean isEmpty() { // show is queue empty or not
        return queueSize == 0;
    }

    @Override
    public String toString() { // Here I return string presentation of queue, what could be printed
        String displayQueue = "";  // init display variable, what will be returned by method
        if (first != null) { // if we have 'first', that means queue to empty. we could print it
            QueueNode currentNode = first; // to travel over all element I need to have always reference (variable) to current state what will be added to result string
            // I initially assign to temp state variable "currentNode" queue first element
            displayQueue = displayQueue + currentNode.getValue();

            while (currentNode.getNextElement() != null) { // I verify, do I have next value after current element or not. If condition satisfied, then run cycle block
                currentNode = currentNode.getNextElement();  // if I have next value, I change current temp state variable to next element reference
                displayQueue = displayQueue + " -> " + currentNode.getValue(); // I adding to already existing string of elements "->" and value
            }
        }

        return "Queue size:" + size() + " (" + displayQueue + ")";
    }

    private class QueueNode { // QueueNode is inner class, what I don't want to show any one. Only Queue class could access it
        private final int value;// here I hold value what will add to the queue; value is immutable (final)
        private QueueNode nextElement;  // here I hold next element of the queue, what I could get only when return current; value mutable. Is't will be updated with next element adding


        private QueueNode(int value) {// constructor for QueueNode what init that node state with value
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public QueueNode getNextElement() {
            return nextElement;
        }

        public void setNextElement(QueueNode nextElement) { // set new added element reference
            this.nextElement = nextElement;
        }
    }
}
