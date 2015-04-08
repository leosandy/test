package concurrency.example.linked.doubly;



public class DoublyLinkedList<E> {

	private Link<E> head,tail;
	
	private int size;
	
	public DoublyLinkedList(){
		this.head = new Link<E>();
		this.tail = new Link<E>();
		this.head.setNext(this.tail);
		this.tail.setPrevious(this.head);
		this.size = 0;
	}
	
	public boolean isEmpty(){
		return this.size == 0;
	}

	public void insertFirst(E item){
		
	}
	
	public void add(E item){

	}
	
	
	
}
