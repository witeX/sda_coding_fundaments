public class QueueTest {

    public static void main(String[] args) {
        Queue queue = new Queue();
        System.out.println("initial state");
        System.out.println(queue);
        System.out.println("enqueue 1");
        queue.enqueue(1);
        System.out.println("state");
        System.out.println(queue);
        System.out.println("enqueue 2");
        queue.enqueue(2);
        System.out.println("state");
        System.out.println(queue);
        System.out.println("enqueue 3");
        queue.enqueue(3);
        System.out.println("state");
        System.out.println(queue);
        System.out.println("enqueue 4");
        queue.enqueue(4);
        System.out.println("state");
        System.out.println(queue);

        System.out.println("dequeue " + queue.dequeue());
        System.out.println("state");
        System.out.println(queue);
        System.out.println("dequeue " + queue.dequeue());
        System.out.println("state");
        System.out.println(queue);
        System.out.println("dequeue " + queue.dequeue());
        System.out.println("state");
        System.out.println(queue);
        System.out.println("dequeue " + queue.dequeue());
        System.out.println("state");
        System.out.println(queue);

    }
}
