package concurrency.example.linked.singly;

public class SingleLinkedListTest {

	public static void main(String[] args) {

		SingleLinkedList list = new SingleLinkedList();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		System.out.println("============add ====================");
		System.out.println(list.size() +":"+list.toString());
		
		System.out.println("============index add ====================");
		list.add("3", 2);
		System.out.println(list.size() +":"+list.toString());
		System.out.println("============remove index ====================");
		list.remove(3);
		System.out.println(list.size() +":"+list.toString());
	}
}
