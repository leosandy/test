package concurrency.example.linked.singly;


/**
 * 
 * 创建日期:2015年3月25日
 * <br />单链循环列表
 * @author 张凯
 * @mender：（文件的修改者，文件创建者之外的人）
 * @version 1.0
 * Remark：<br />
 * <a href="http://www.cs.cmu.edu/~adamchik/15-121/lectures/Linked%20Lists/linked%20lists.html">http://www.cs.cmu.edu/~adamchik/15-121/lectures/Linked%20Lists/linked%20lists.html</a>
 */
public class CircularSinglyLinkedList<E>{

	private int size;
	private Node head;
	
	public CircularSinglyLinkedList(){
		this.head = new Node(null,null);
		this.head.setNext(head);
		this.size = 0;
	}
	
	/**
	 * 
	 * 功能:在头部添加一个节点
	 *<br /> 作者: 张凯
	 * <br />创建日期:2015年3月26日
	 * <br />修改者: mender
	 * <br />修改日期: modifydate
	 * @param item
	 */
	public void insertAtPrior(E item){
		Node node = new Node(item, null);
		node.setNext(head.getNext());
		head.setNext(node);
		size ++;
	}
	
	/**
	 * 
	 * 功能:是否为空
	 *<br /> 作者: 张凯
	 * <br />创建日期:2015年3月26日
	 * <br />修改者: mender
	 * <br />修改日期: modifydate
	 * @return
	 */
	public boolean isEmpty(){
		return this.size == 0;
	}
	
	/**
	 * 
	 * 功能:从最后一个节点添加
	 *<br /> 作者: 张凯
	 * <br />创建日期:2015年3月26日
	 * <br />修改者: mender
	 * <br />修改日期: modifydate
	 * @param item
	 */
	public void add(E item){
		Node temp = head;
		if(isEmpty()){
			insertAtPrior(item);
		}else{
			Node node = new Node(item, null);
			while (head != temp.getNext()) {
				temp = temp.getNext();
			}
			node.setNext(temp.getNext());
			temp.setNext(node);
			size ++;
		}
	}
	

	/**
	 * 
	 * 功能:获取元素
	 *<br /> 作者: 张凯
	 * <br />创建日期:2015年3月26日
	 * <br />修改者: mender
	 * <br />修改日期: modifydate
	 * @param index
	 * @return
	 */
	public E get(int index){
		if(index < 1 || index > size){
			throw new RuntimeException("index bound of error");
		}
		Node temp = head;
		for(int i = 0; i < index;i++){
			temp = temp.getNext();
		}
		return temp.getData();
	}
	
	/**
	 * 
	 * 功能:插入
	 *<br /> 作者: 张凯
	 * <br />创建日期:2015年3月26日
	 * <br />修改者: mender
	 * <br />修改日期: modifydate
	 * @param index
	 * @param item
	 */
	public void insert(int index,E item){
		if(index < 0 || index > size){
			throw new RuntimeException("index bound of error");
		}
			Node temp = head;
			Node node = new Node(item, null);
			for(int i = 0; i < index;i++){
				temp = temp.getNext();
			}
			node.setNext(temp.getNext());
			temp.setNext(node);
			size++;
	}
	
	public void remove(int index){
		if(index < 1 || index > size){
			throw new RuntimeException("index bound of error");
		}
		
		Node temp = head;
		if(index == 1){
			if(head != temp.getNext())
			head.setNext(temp.getNext().getNext());
		}else{
			for(int i = 1; i < index;i++){
				if(head != temp.getNext()){
					temp = temp.getNext();
				}
			}
			temp.setNext(temp.getNext().getNext());
		}
	}
	
	public void remove(E item){
		Node temp = head;
		int index = 1;
		while (head != (temp = temp.getNext())) {
			if(item == temp.getData() || item.equals(temp.getData())){
				remove(index);
			}
			index++;
		}
	}
	
	
	
	public String display(){
		StringBuilder sb = new StringBuilder();
		Node temp = head;
		while (head !=  (temp = temp.getNext())) {
			sb.append("[").append(temp.getData()).append("]");
		}
		return sb.toString();
	}
	
	/**
	 * 
	 * 创建日期:2015年3月25日
	 * <br />节点
	 * @author 张凯
	 * @mender：（文件的修改者，文件创建者之外的人）
	 * @version 1.0
	 */
	private class Node{
		private Node next;
		private E data;
		    public Node(E data, Node next) {
		        this.data = data;
		        this.next = next;
		    }
	
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		public E getData() {
			return data;
		}
	}
}
