public class StackTest {

    public static void main(String[] args) {
        testArrayStack(); // execute method what test array stack implementation
        testLinkedStack(); // execute method what test linked stack implementation

    }

    private static void testArrayStack() {
        Stack stack = new Stack(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Pop value: " + stack.pop()); // pop value from stack
        stack.push(4);
        System.out.println("Current stack(array) state: " + stack);
        // 4 -> 2 -> 1  Stack size is 3
    }

    private static void testLinkedStack() {
        LinkedStack stack = new LinkedStack(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Pop value: " + stack.pop()); // pop value from stack
        stack.push(4);
        System.out.println("Current stack(linked) state: " + stack);
        // 4 -> 2 -> 1  Stack size is 3
    }
}
