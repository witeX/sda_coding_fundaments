public class LinkedList {

    private Node head; // first element
    private Node tail; // last element
    private int size = 0; // current list size

    public void addFirst(String value) {// complexity O(1)
        Node node = new Node(value); // create value holder Node
        if (head != null) { // if head exists, then we tell our head that previous value holder will be our new Node
            head.prev = node;
        } else { // if head not exists, tail also not exists, we must init it.
            tail = node;
        }
        node.next = head; // our new Node value holder must know what is next value. next value holder is current head.
        head = node; // when our node know next value and old node know what is new value, then we could update our head
        size++; // increase size of list
    }

    public String removeFirst() {
        if (head != null) { // we could remove something if head exists and list not empty
            Node temp = head; // we store our head node to temp variable
            head = temp.next; // update head with next node (value holder)
            if (head != null) { // if new head exists, we need to remove reference to our removed element
                head.prev = null; // nullify previous node reference
            } else { // if head not exists, that means we removed last element, then we must nullify our tail
                tail = null;
            }
            size--;// decrease size of list
            return temp.value; // after all manipulations we return removed value
        }
        throw new IllegalStateException("List is empty"); // if no element exists we inform client that is empty list
    }

    public void add(String value) { // add to the end, complexity is O(1)
        Node node = new Node(value); // create value holder Node
        if (tail != null) { // if tail exists, then we tell our tail that next value holder will be our new Node
            tail.next = node;
        } else { // if tail not exists, head also not exists, we must init it.
            head = node;
        }
        node.prev = tail;// our new Node value holder must know what is previous value. previous value holder is current tail.
        tail = node;// when our node know previous value and old node know what is new value, then we could update our tail
        size++; // increase size of list
    }

    public String removeLast() {
        if (tail != null) {// we could remove something if tails exists and list not empty
            Node temp = this.tail;// we store our tail node to temp variable
            tail = temp.prev;// update tail with next node (value holder)
            if (tail != null) {// if new tail exists, we need to remove reference to our removed element
                tail.next = null;// nullify next node reference
            } else {// if tail not exists, that means we removed last element, then we must nullify our head
                head = null;
            }
            size--;// decrease size of list
            return temp.value; // after all manipulations we return removed value
        }
        throw new IllegalStateException("List is empty"); // if no element exists we inform client that is empty list
    }

    public void addTo(String value, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("No index exists");
        } else if (index == size) { // if index equals to next index after last element index, then we add to the end of list
            add(value);
        } else if (isFirstElement(index)) {// if index equals to 0, then we could execute addFirst
            addFirst(value);
        } else {
            Node temp = getNodeByIndex(index);
            Node newNode = new Node(value); // create new value holder
            Node prevNode = temp.prev; // get previous node of found "temp" element
            newNode.prev = prevNode; // our newNode previous element must be previous element of temp element
            prevNode.next = newNode; // our previous node must know, than next element now our new created node
            newNode.next = temp; // our new node now know that next element in list is our "temp" (current value on "index")
            temp.prev = newNode;// our value what was on index shifted to next index and  must know new value on it place, what is our newNode
            size++;// increase size of list
        }

    }

    private boolean isFirstElement(int index) {
        return index == 0;
    }

    private Node getNodeByIndex(int index) {
        if (isLastIndex(index)) {  // if index equals to next index after last element index, then we add to the end of list
            return tail;
        } else if (index > 0) { // iterate over whole list we need only when element not head and not last
            Node temp = head.next; // start with second element by index 1;
            for (int i = 1; i < index; i++) {// here we iterate and try to get element on index
                temp = temp.next; // here we apply to our temp value next element in list
            }
            return temp;
        }
        return head; // here we go only in case if list have more that 1 element and required index is 0
    }

    private boolean isLastIndex(int index) {
        return index == size - 1;
    }

    public String setTo(String value, int index) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("No index exists");
        }
        Node node = new Node(value); // our node can't change value inside, we need to create new Node with new value
        Node temp = getNodeByIndex(index); // find node on correct index

        if (temp.prev != null) { // if node are not first, we need to update previous and tell that it next node is our new node
            temp.prev.next = node;
        } else {
            head = node; // in case if we are on index 0, we just update head with new value
        }
        if (temp.next != null) { // in case if our node is not last, we update our next value, to show that our new node is now previous
            temp.next.prev = node;
        } else {
            tail = node; // on case if index is equals to last element
        }
        node.prev = temp.prev; // our new node must know that it prev node is same as on temp node
        node.next = temp.next; // our new node must know that it next node is same as on temp node


        return temp.value; // return old value
    }

    public String remove(int index) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("No index exists");
        }
        if (isFirstElement(index)) { //reuse methods what can be apply for first element
            return removeFirst();
        } else if (isLastIndex(index)) { //reuse methods what can be apply for last element
            return removeLast();
        }
        // that code works only when element between head and tail. when list have at list 3 elements
        Node temp = getNodeByIndex(index);
        removeNodeBetweedHeadAndTail(temp);
        return temp.value;
    }

    private void removeNodeBetweedHeadAndTail(Node temp) {
        temp.prev.next = temp.next; // temp node previous node now think that next element is our temp node next
        temp.next.prev = temp.prev; // temp node next node now think that previous element is our temp node previous
    }

    public int remove(String value) {
        Node temp = head;
        int index = -1;
        while (temp != null) { // with that cycle we try to find element
            index++;
            if (temp.value.equals(value)) { //if node value is equals to our value to remove, then we exit from cycle with break
                break;
            }
            temp = temp.next; // assign to temp our next value

        }
        if (index == -1 || index == size) { // if index -1 or index greater that last element index, means that we not found it
            return -1; // return -1 if element not exists in list
        }
        if (isFirstElement(index)) { // reuse our method remove first
            removeFirst();
        } else if (isLastIndex(index)) {// reuse our method remove last
            removeLast();
        } else {
            removeNodeBetweedHeadAndTail(temp);
        }

        return index;
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

    private class Node { // our value holder
        private final String value; //value is immutable, we can't set new
        private Node prev; // reference to previous element in list
        private Node next;// reference to next element in list

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
        linkedList.addFirst("first");
        linkedList.addFirst("overrideFirst");
        linkedList.add("lastElement");

        System.out.println(linkedList);
        // overrideFirst, first, lastElement
        System.out.println("old value must be equals to 'first' = " + linkedList.setTo("second", 1));
        System.out.println("old value must be equals to 'overrideFirst' = " + linkedList.setTo("first", 0));

        // overrideFirst, second, lastElement

        linkedList.addTo("element number 3", 2);
        // overrideFirst, second,element number 3, lastElement

        System.out.println("lastElement index must be 3 = " + linkedList.findIndex("lastElement"));
        System.out.println("get value on index 1 must be equals to 'second' = " + linkedList.get(1));
        System.out.println("old value must be equals to 'second'  =" + linkedList.remove(1));
        System.out.println(linkedList);
        // overrideFirst, element number 3, lastElement

        System.out.println("old value index must be equals to '0' = " + linkedList.remove("first"));
        System.out.println(linkedList);
        // element number 3, lastElement
    }

}
