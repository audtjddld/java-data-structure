package doublyLinkedList;

public class DoubleLinkedListTest {
	public static void main(String[] args) {
		DoubleLinkedList arr = new DoubleLinkedList();
		for (int i = 1; i <= 5; i++) {
			arr.add("데이터-" + i);
		}
		System.out.println(arr);

		System.out.println(arr.get(0));
		System.out.println(arr.get(3));

		arr.remove(3);
		System.out.println(arr);

		arr.add(1, "데이터-4");
		System.out.println(arr);

		arr.add("데이터-6");
		System.out.println(arr);
	}
}
