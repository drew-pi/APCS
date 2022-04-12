

public class QDriver {

    public static void main(String[] args) {
        
        // Queue<Integer> q = new ALQ<Integer>();
        Queue<Integer> q = new LLQ<Integer>();


        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);

        System.out.println(q);

        while (!q.isEmpty()) {
            System.out.println(q.peekFront() + " " + q.dequeue());
            System.out.println(q);
        }

        System.out.println(q);

    }
}