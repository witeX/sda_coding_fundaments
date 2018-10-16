public class LinkedStack {

    private final int maxSize; // Stack size limitation
    private int stackSize = 0; // current stack zie
    private StackNode head = null; // head holds last StackNode reference (or link or pointer)

    public LinkedStack(int maxSize) { // public constructor what create LinkedStack object and create initial state for it.
        this.maxSize = maxSize;
    }

    public void push(int value) { // method push - insert action. Add value to the top of the stack
        if (stackSize == maxSize) { // if our stackSize already equals to maximum stack size, then we go into if block
            throw new IllegalStateException("overflow"); // creating common exception for illegal state, with message "overflow" and throw it. That will stop method execution
        }
        StackNode oldHead = this.head; // I save my current head reference to new variable "oldHead". "oldHead" now are the same object what is "head"
        this.head = new StackNode(value, oldHead); // I create new StackNode object. to it constructor I pass value, what we push to the stack and "oldHead" variable, to able latter get next value in stack
        // after that new StackNode will be assigned to the "this.head" field variable
        /*this.head = new StackNode(value, this.head); -- description what happens with references and hat state they have */
        /*
            this.head == 0x002;


         this.head = (0x003 =  new StackNode(value=0x101, 0x002));
            now this.head == 0x003
         */
        stackSize++; // after success adding value to the stack, I increase stack size counter

    }

    public int pop() { // pop value from stack - get and delete value. remove top element from stack and return it value
        if (isEmpty()) { // we can't get any value from empty stack
            throw new IllegalStateException("underflow"); // creating common exception for illegal state, with message "underflow" and throw it. That will stop method execution
        }
        StackNode oldHead = this.head; // I save my current head reference to new variable "oldHead". "oldHead" now are the same object what is "head"
        this.head = oldHead.getNextElement(); // inside "oldHead" I reference to next element in stack. I can get next value by calling getNextElement() from "oldHead"
        // assign to current "head" (last element) next value from "oldHead"
        stackSize--; // after success removing element from the stack, I decrease stack size counter

        return oldHead.getValue();// return value of removed element
    }

    public int size() {
        return stackSize;
    } // return value of stackSize field

    public boolean isEmpty() {
        return stackSize == 0;
    }// return true if stackSize is 0

    public String toString() { // Here I return string presentation of stack, what could be printed
        String display = ""; // init display variable, what will be returned by method

        if (head != null) { // if we have head, that means stack to empty. we could print it
            StackNode currentNode = head; // to travel over all element I need to have always reference (variable) to current state what will be added to result string
            // I initially assign to temp state variable "currentNode" stack top element (head)
            display = display + ": " + currentNode.getValue(); // adding top element value to result string

            while (currentNode.getNextElement() != null) { // I verify, do I have next value after current element or not. If condition satisfied, then run cycle block
                currentNode = currentNode.getNextElement(); // if I have next value, I change current temp state variable to next element reference

                display = display  // I adding to already existing string of elements "->" and value
                        + " -> "
                        + currentNode.getValue();
            }


        }

        return "Stack size is " + stackSize + display; // final string Stack size info and stack state
    }

    private class StackNode { // Stack Node is inner class, what I don't want to show any one. Only LinkedStack class could access it
        private final int value; // here I hold value what will add to the stack; value is immutable (final)
        private final StackNode nextElement; // here I hold next element of the stack, what I could get only when return current;value is immutable (final)

        public StackNode(int value, StackNode previousHead) { // constructor for StackNode what init that node state with value and previous element, what was head of the stack
            this.value = value;
            nextElement = previousHead;
        }

        public int getValue() {
            return value;
        }

        public StackNode getNextElement() {
            return nextElement;
        }
    }

}


