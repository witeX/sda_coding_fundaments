public class Queue {

    private QueueNode head = null;
    private QueueNode last = null;

    private int queueSize = 0;


    public void enqueue(int value) {
        QueueNode newNode = new QueueNode(value);
        if (last == null) {
            last = newNode;
            head = newNode;
        } else {
            this.last.setTail(newNode);
            this.last = newNode;
        }
        queueSize++;
    }

    public int dequeue() {
        QueueNode oldHead = this.head;
        this.head = oldHead.getTail();

        if (this.head == null) {
            this.last = null;
        }
        queueSize--;
        return oldHead.getValue();
    }

    public int size() {
        return queueSize;
    }

    public boolean isEmpty() {
        return queueSize == 0;
    }

    @Override
    public String toString() {
        String displayQueue = "";
        if (head != null) {
            QueueNode node = head;
            displayQueue = displayQueue + node.getValue();

            while (node.getTail() != null) {
                node = node.getTail();
                displayQueue = displayQueue + " -> " + node.getValue();
            }
        }

        return "Queue size:" + size() + " (" + displayQueue + ")";
    }

    private class QueueNode {
        private final int value;
        private QueueNode tail;


        private QueueNode(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public QueueNode getTail() {
            return tail;
        }

        public void setTail(QueueNode tail) {
            this.tail = tail;
        }
    }
}
