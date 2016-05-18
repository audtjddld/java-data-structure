package doublyLinkedList;

public class DoublyLinkedListTest {
	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		list.add(100);
		list.add(200);
		list.add(400);
		list.add(500);
		System.out.println(list.toString());

		list.add(2, 300);
		System.out.println(list.get(2));
		list.addFirst(500);

		System.out.println(list.toString());

		list.remove(2);
		list.remove(new Integer(400));
		System.out.println(list.toString());

		list.removeFirst();
		list.removeLast();
		System.out.println(list.toString());

		System.out.println("크기 : " + list.size());
	}
}
