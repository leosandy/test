package concurrency.example.linked.singly;

/**
 * 
 * 创建日期:2015年3月25日
 * <br />单链表
 * @author 张凯
 * @mender：（文件的修改者，文件创建者之外的人）
 * @version 1.0
 * Remark：认为有必要的其他信息
 */
public class SingleLinkedList {

	
	private Node header;
	
	private int size;
	
	public SingleLinkedList(){
		header = new Node(null);
		size = 0;
	}

	public void add(Object data){
		Node temp = new Node(data);
		Node current = header;
		while (current.getNext() != null) {
			current = current.getNext();
		}
		current.setNext(temp);
		size ++;
	}
	
	public void add(Object data,int index){
		if(index < 0 || index > size){
			throw new RuntimeException("index is error");
		}
		Node temp = new Node(data);
		Node current = header;
		int t = 0;
		while (t < index &&current.getNext() != null) {
			current = current.getNext();
			t++;
		}
		temp.setNext(current.getNext());
		current.setNext(temp);
		size ++;
	}
	
	public Object get(int index){
		if(index <=0){
			return null;
		}
		Node current = header;
		for(int i = 0; i < index;i++){
			if(current.getNext() == null){
				return null;
			}
			current = current.getNext();
		}
		return current.getData();
	}
	
	public boolean remove(int index){
		if(index <=0 || index > size){
			return false;
		}
		Node current = header;
		for(int i = 0; i < index;i++){
			if(current.getNext() == null){
				return false;
			}
			current = current.getNext();
		}
		
		current.setNext(current.getNext().getNext());
		size --;
		return true;
		
	}
	
	/**
	 * 
	 * 功能:链表节点数
	 *<br /> 作者: 张凯
	 * <br />创建日期:2015年3月25日
	 * <br />修改者: mender
	 * <br />修改日期: modifydate
	 * @return
	 */
	public int size(){
		return size;
	}
	
	public String toString()
	{
		Node current = header.getNext();
		StringBuilder sb = new StringBuilder();
		while (current != null) {
			sb.append("[ ").append(current.getData()).append("]");
			current = current.getNext();
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
	 * Remark：认为有必要的其他信息
	 */
	private class Node{
		Node next;
		Object data;
		
		public Node(Object _data){
			this.data = _data;
			this.next = null;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public Object getData() {
			return data;
		}

	}
}

