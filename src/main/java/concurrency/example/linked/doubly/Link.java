package concurrency.example.linked.doubly;

/**
 * 
 * 创建日期:2015年3月25日
 * <br />双向链表
 * @author 张凯
 * @mender：（文件的修改者，文件创建者之外的人）
 * @version 1.0
 * Remark：认为有必要的其他信息
 */
public class Link<E> {

	private E data;
	
	private Link<E> next,previous;

	public Link(){
		this.next = null;
		this.previous = null;
	}
	
	public Link(E data){
		this.data = data;
		this.next = null;
		this.previous = null;
	}
	
	 public String toString() {
		    return "{" + data + "} ";
		  }

	public E getData() {
		return data;
	}


	public void setData(E data) {
		this.data = data;
	}


	public Link<E> getNext() {
		return next;
	}


	public void setNext(Link<E> next) {
		this.next = next;
	}


	public Link<E> getPrevious() {
		return previous;
	}


	public void setPrevious(Link<E> previous) {
		this.previous = previous;
	}
}
