public class LinkedList {

    private Node head;
    private Node tail;
    private int size = 0;

    public void addToBegin(String value) {// O(1)
        Node node = new Node(value);
        if (head != null) {
            head.prev = node;
        } else {
            tail = node;
        }
        node.next = head;
        head = node;
        size++;
    }

    public String removeFirst() {
        if (head != null) {
            Node temp = head;
            head = temp.next;
            size--;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
            return temp.value;
        }
        return null;
    }

    public void addToEnd(String value) { // O(1)
        Node node = new Node(value);
        node.prev = tail;
        if (tail != null) {
            tail.next = node;
        } else {
            head = node;
        }

        tail = node;
        size++;
    }

    public String removeLast() {
        if (tail != null) {
            Node temp = this.tail;
            tail = temp.prev;
            if (tail != null) {
                tail.next = null;
            } else {
                head = null;
            }
            size--;
            return temp.value;
        }
        return null;
    }

    public void addToPlace(String value, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("No index exists");
        } else if (index == size) {
            addToEnd(value);
        } else if (index == 0) {
            addToBegin(value);
        } else {
            Node temp = head.next;
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }
            Node newNode = new Node(value);
            newNode.prev = temp.prev;
            Node prevNode = newNode.prev;
            prevNode.next = newNode;
            newNode.next = temp;
            temp.prev = newNode;
            size++;
        }

    }

    public String setToPosition(String value, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("No index exists");
        }
        Node node = new Node(value);
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        if (temp.prev != null) {
            temp.prev.next = node;
        } else {
            head = node;
        }
        if (temp.next != null) {
            temp.next.prev = node;
        } else {
            tail = node;
        }
        node.prev = temp.prev;
        node.next = temp.next;


        return temp.value;
    }

    public String remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("No index exists");
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        if (temp.prev == null) {
            head = temp.next;
        } else {
            temp.prev.next = temp.next;
        }
        if (temp.next == null) {
            tail = temp.prev;
        } else {
            temp.next.prev = temp.prev;
        }


        return temp.value;
    }

    public int remove(String value) {
        Node temp = head;
        int indexToCheck = 0;
        while (temp != null) {
            if (temp.value.equals(value)) {
                if (temp.prev == null) {
                    head = temp.next;
                } else {
                    temp.prev.next = temp.next;
                }
                if (temp.next == null) {
                    tail = temp.prev;
                } else {
                    temp.next.prev = temp.prev;
                }


                return indexToCheck;
            }
            temp = temp.next;
            indexToCheck++;

        }
        return -1; // return -1 if element not exists in list
    }

    public boolean isExist(String value) {
        return findIndex(value) != -1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public String getFirst() {
        if (head != null) {
            return head.value;
        }
        return null;
    }

    public String getLast() {
        if (tail != null) {
            return tail.value;
        }
        return null;
    }

    public String get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("No index exists");
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.value; // if not element not exists on that position throw IllegalArgumentException
    }

    public int findIndex(String value) {
        Node temp = head;
        int indexToCheck = 0;
        while (temp != null) {
            if (temp.value.equals(value)) {
                return indexToCheck;
            }
            temp = temp.next;
            indexToCheck++;

        }
        return -1; // return -1 if element not exists in list
    }

    private class Node {
        private final String value;
        private Node prev;
        private Node next;

        private Node(String value) {
            this.value = value;
        }
    }

    @Override
    public String toString() { // Here I return string presentation of queue, what could be printed
        String displayQueue = "";  // init display variable, what will be returned by method
        if (head != null) { // if we have 'first', that means queue to empty. we could print it
            Node currentNode = head; // to travel over all element I need to have always reference (variable) to current state what will be added to result string
            // I initially assign to temp state variable "currentNode" queue first element
            displayQueue = displayQueue + currentNode.value;

            while (currentNode.next != null) { // I verify, do I have next value after current element or not. If condition satisfied, then run cycle block
                currentNode = currentNode.next;  // if I have next value, I change current temp state variable to next element reference
                displayQueue = displayQueue + " -> " + currentNode.value; // I adding to already existing string of elements "->" and value
            }
        }

        return "LinkedList size:" + size() + " (" + displayQueue + ")";
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addToBegin("first");
        linkedList.addToBegin("overrideFirst");
        linkedList.addToEnd("lastElement");

        System.out.println(linkedList);
        // overrideFirst, first, lastElement
        System.out.println("old value must be equals to 'first'" + linkedList.setToPosition("second", 1));
        System.out.println("old value must be equals to 'overrideFirst'" + linkedList.setToPosition("first", 0));

        // overrideFirst, second, lastElement

        linkedList.addToPlace("element number 3", 2);
        // overrideFirst, second,element number 3, lastElement

        System.out.println(linkedList.findIndex("lastElement"));
        System.out.println("get value on index 1 must be equals to 'second'" + linkedList.get(1));
        System.out.println(linkedList);
        System.out.println("old value must be equals to 'second'" + linkedList.remove(1));
        // overrideFirst, element number 3, lastElement

        System.out.println("old value index must be equals to '0'" + linkedList.remove("first"));
        // element number 3, lastElement
    }

}
