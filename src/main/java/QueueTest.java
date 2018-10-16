public class QueueTest {

    public static void main(String[] args) {
        Queue queue = new Queue(10);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println("Dequeue element from queue:" + queue.dequeue());
        queue.enqueue(5);
        System.out.println("Queue state:" + queue);

    }
}
