public class LinkedStack {

    private final int maxSize;
    private int stackSize = 0;
    private StackNode head = null;

    public LinkedStack(int maxSize) {
        this.maxSize = maxSize;
    }

    public void push(Integer value) {
        if (stackSize == maxSize) {
            throw new IllegalStateException("overflow");
        }
        StackNode oldHead = this.head;
        StackNode newHead = new StackNode(value, oldHead);
        this.head = newHead;
        /*this.head = new StackNode(value, this.head);*/
        /*
            this.head == 0x002;


         this.head = (0x003 =  new StackNode(value=0x101, 0x002));

         */
        stackSize++;

    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("underflow");
        }
        StackNode oldHead = this.head;
        this.head = oldHead.getTail();
        stackSize--;

        return oldHead.getValue();
    }

    public int size() {
        return stackSize;
    }

    public boolean isEmpty() {
        return stackSize == 0;
    }

    public String toString() {
        String display = "";

        if (head != null) {
            StackNode currentNode = head;
            display = display + currentNode.getValue();

            while (currentNode.tail != null) {
                currentNode = currentNode.tail;

                display = display
                        + " -> "
                        + currentNode.getValue();
            }


        }

        return display + " Stack size is " + stackSize;
    }

    private class StackNode {
        private final int value;
        private final StackNode tail;

        public StackNode(int value, StackNode previousHead) {
            this.value = value;
            tail = previousHead;
        }

        public int getValue() {
            return value;
        }

        public StackNode getTail() {
            return tail;
        }
    }

}


