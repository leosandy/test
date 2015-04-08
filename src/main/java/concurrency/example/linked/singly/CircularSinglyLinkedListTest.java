package concurrency.example.linked.singly;


public class CircularSinglyLinkedListTest {

	public static void main(String[] args) {
		CircularSinglyLinkedList<String> list = new CircularSinglyLinkedList<String>();
		list.add("1");
		list.add("2");
		list.insert(1, "3");
		System.out.println(list.get(1));
//		list.insert(1, "20");
		System.out.println(list.get(2));
//		System.out.println(list.get(2));
		list.remove("2");
		System.out.println(list.display());
	}
}
