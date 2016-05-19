package queue;

public class QueueTest {
	public static void main(String[] args) {
		ArrayQueue s = new ArrayQueue(5);
		// ListQueue s = new ListQueue();
		for (int i = 0; i < 5; i++) {
			s.insert("data-" + i);
		}
		// s.insert("data-6");
		System.out.println(s.remove());
		System.out.println(s.remove());
		System.out.println(s.peek());
		System.out.println(s.peek());
		System.out.println(s.remove());
		System.out.println(s.remove());
		System.out.println(s.remove());
	}
}
