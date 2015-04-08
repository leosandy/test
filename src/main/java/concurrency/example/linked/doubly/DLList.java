package concurrency.example.linked.doubly;


/**
 * 
 * 创建日期:2015年3月30日
 * <br />double linked list 
 * @author 张凯
 * @mender：（文件的修改者，文件创建者之外的人）
 * @version 1.0
 * Remark：
 * <br /><a href="http://opendatastructures.org/ods-java/3_2_DLList_Doubly_Linked_Li.html">http://opendatastructures.org/ods-java/3_2_DLList_Doubly_Linked_Li.html</a>
 * @param <T>
 */
public class DLList<T> {
	 
	private int size;
	Node node;
	public DLList(){
		node = new Node();
		node.next = node;
		node.prev = node;
		this.size = 0;
	}
	
	public int size(){
		return this.size;
	}
	
	public T get(int index){
		if(index < 0 || index > size - 1){
			throw new IndexOutOfBoundsException();
		}
		return getNode(index).x;
	}
	
	/**
	 * 
	 * 功能:更新index位置节点值
	 *<br /> 作者: 张凯
	 * <br />创建日期:2015年3月30日
	 * <br />修改者: mender
	 * <br />修改日期: modifydate
	 * @param index
	 * @param x
	 * @return
	 */
	public T set(int index,T x){
		if(index < 0 || index > size - 1){
			throw new IndexOutOfBoundsException();
		}
		Node u = getNode(index);
		T y = u.x;
		u.x = x;
		return y;
	}
	
	/**
	 * 
	 * 功能:在 n节点之前添加
	 *<br /> 作者: 张凯
	 * <br />创建日期:2015年3月30日
	 * <br />修改者: mender
	 * <br />修改日期: modifydate
	 * @param n
	 * @param x
	 */
	private Node addBefore(Node n,T x){
		Node nd = new Node();
		nd.x = x;
		nd.next = n;
		nd.prev = n.prev;
		nd.prev.next = nd;
		n.prev = nd;
		size++;
		return nd;
	}
	
	/**
	 * 
	 * 功能:在 n节点之后添加
	 *<br /> 作者: 张凯
	 * <br />创建日期:2015年3月30日
	 * <br />修改者: mender
	 * <br />修改日期: modifydate
	 * @param n
	 * @param x
	 * @return
	 */
	public Node addAfter(Node n,T x){
		Node temp = new Node();
		temp.x = x;
		temp.prev = n;
		temp.next = n.next;
		temp.prev.next = temp;
		n.prev = temp;
		size++;
		return temp;
	}
	
	/**
	 * 索引添加
	 * 功能:
	 *<br /> 作者: 张凯
	 * <br />创建日期:2015年3月30日
	 * <br />修改者: mender
	 * <br />修改日期: modifydate
	 * @param index
	 * @param x
	 */
	public void add(int index,T x){
		 if (index < 0 || index > size) throw new IndexOutOfBoundsException();
		 addBefore(getNode(index), x);
	}
	
	public void add(T x){
		addBefore(getNode(size),x);
	}
	
	
	/**
	 * 
	 * 功能:获取链表节点对应元素
	 *<br /> 作者: 张凯
	 * <br />创建日期:2015年3月30日
	 * <br />修改者: mender
	 * <br />修改日期: modifydate
	 * @param index
	 * @return
	 */
	public Node getNode(int index){
		Node temp = null;
		//前半段
		if(index < (size >> 1)){
			temp = node.next;
			for(int i = 0; i < index;i++){
				temp = temp.next;
			}
		}else{
			temp = node;
			for(int i = size; i > index;i--){
				temp = temp.prev;
			}
		}
		return temp;
	}
	
	/**
	 * 
	 * 功能:删除
	 *<br /> 作者: 张凯
	 * <br />创建日期:2015年3月30日
	 * <br />修改者: mender
	 * <br />修改日期: modifydate
	 * @param now
	 */
	public void remove(Node now){
		now.prev.next = now.next;
		now.next.prev = now.prev;
		size --;
	}
	
	/**
	 * 
	 * 功能:索引删除
	 *<br /> 作者: 张凯
	 * <br />创建日期:2015年3月30日
	 * <br />修改者: mender
	 * <br />修改日期: modifydate
	 * @param index
	 */
	public T remove(int index){
		 if (index < 0 || index > size) throw new IndexOutOfBoundsException();
		 Node now = getNode(index);
		 remove(now);
		 return now.x;
	}
	
	public String display(){
		if(this.size == 0){
			return "";
		}
		StringBuilder sb = new StringBuilder();
		Node temp = this.node;
		
		while (this.node != (temp.next)) {
			temp = temp.next;
			sb.append("[").append(temp.x).append("],");
		}
		sb = sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
	
	private class Node{
		T x;
		Node prev,next;
	}
}