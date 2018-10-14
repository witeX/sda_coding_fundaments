public class StackUser {

    public static void main(String[] args) {
        LinkedStack stack = new LinkedStack(1000);

        System.out.println(stack);
        System.out.println("push 4");
        stack.push(4);
        System.out.println(stack);
        System.out.println("push 3");
        stack.push(3);
        System.out.println(stack);

        System.out.println("pop " + stack.pop());
        System.out.println(stack);

        System.out.println("push 10");
        stack.push(10);
        System.out.println(stack);
        System.out.println("push 11");
        stack.push(11);
        System.out.println(stack);

        System.out.println("pop " + stack.pop());
        System.out.println(stack);
        System.out.println("=========================================");
        // 2 -> 6 -> 3  Stack size is 3

        /*System.out.println("stack must be empty but is empty:" + stack.isEmpty());
        System.out.println("stack size must be 0 and  is: " + stack.size());

        stack.push(10);
        System.out.println("stack must not be empty but is empty:" + stack.isEmpty());
        System.out.println("stack size must be 1 and  is: " + stack.size());

        stack.push(20);
        System.out.println("stack must not be empty but is empty:" + stack.isEmpty());
        System.out.println("stack size must be 2 and  is: " + stack.size());

        stack.push(30);
        System.out.println("stack must not be empty but is empty:" + stack.isEmpty());
        System.out.println("stack size must be 3 and  is: " + stack.size());

        try {
            stack.push(4);
            System.out.println("We must not get that line in the logs");
        } catch (IllegalStateException e) {
            System.out.println("Exception text must be 'overflow' and text is = " + e.getMessage());
        }

        System.out.println("Pop value 30 = " + stack.pop());
        System.out.println("stack must not be empty but is empty:" + stack.isEmpty());

        System.out.println("Pop value 20 = " + stack.pop());
        System.out.println("stack must not be empty but is empty:" + stack.isEmpty());

        System.out.println("Pop value 10 = " + stack.pop());
        System.out.println("stack must be empty but is empty:" + stack.isEmpty());

        try {
            int value = stack.pop();
            System.out.println("We must not get that line in the logs");
        } catch (IllegalStateException e) {
            System.out.println("Exception text must be 'underflow' and text is = " + e.getMessage());
        }*/
    }
}
