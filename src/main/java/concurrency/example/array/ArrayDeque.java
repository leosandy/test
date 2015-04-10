package concurrency.example.array;

/**
 * 
 * 创建日期:2015年4月7日
 * <br />双端队列
 * @author 张凯
 * @mender：（文件的修改者，文件创建者之外的人）
 * @version 1.0
 * Remark：<a href="http://opendatastructures.org/ods-java/2_4_ArrayDeque_Fast_Deque_O.html"> array deque </a>
 * @param <T>
 */
@SuppressWarnings("unchecked")
public class ArrayDeque<T> {
	T[] a;
    int j;
    int n;
  
	public ArrayDeque(){
    	a = (T[])new Object[16];
    	j = 0;
    	n = 0;
    }
	
	public int size(){
		return this.n;
	}
	
	public String display(){
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < n;i++){
			sb.append(a[(j+i) %a.length]).append(",");
		}
		
		sb = sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
	
	/**
	 * 
	 * 功能:获取
	 *<br /> 作者: 张凯
	 * <br />创建日期:2015年4月7日
	 * <br />修改者: mender
	 * <br />修改日期: modifydate
	 * @param index
	 * @return
	 */
	public T get(int index){
		 if (index < 0 || index > n) throw new IndexOutOfBoundsException();
		return a[(j+index) % a.length];
	}
	
	
	
	public T set(int i, T x) {
	        if (i < 0 || i > n-1) throw new IndexOutOfBoundsException();
	        T y = a[(j+i)%a.length];
	        a[(j+i)%a.length] = x;
	        return y;
	}
	
	public void add(T x){
		//扩容
		if((n + 1) > a.length){
			resize();
		}

		a[(j+n) % a.length] = x;
		n++;
	}
	
	public void add(int index, T x){
		if(index < 0 || index > n - 1) throw new IndexOutOfBoundsException();
		//扩容
		if((n+1) > a.length){
			resize();
		}
		
		//前半段
		if(index < (n >> 1)){
			//TODO 当队列尚未删除元素时，插入元素，头指针移到数组末尾，数组末尾插入
			j = j == 0 ? a.length - 1:j-1;
			for(int k = 0; k < index; k++){
				a[(k+j)%a.length] = a[(k + j + 1) %a.length];
			}
		}else{
			for(int k = n;k > index; k--){
				a[(k+j) % a.length] = a[(k + j  - 1) %a.length];
			}
		} 
		a[(j+index) %a.length] = x;
		System.out.println("addAfter j == " + j);
		n++;
	}
	
	public void remove(int i){
		System.out.println("remove i=" + i);
		if (i< 0 || i > n-1) throw new IndexOutOfBoundsException();
		//前半段
		if(i < (n >> 1)){
			 for (int k = i; k > 0; k--)
	                a[(j+k)%a.length] = a[(j+k -1)%a.length];
	            j = (j + 1) % a.length;
		}else{
			 for (int k = i; k < n-1; k++)
	           a[(j+k)%a.length] = a[(j+k)%a.length +1];
		}
		 n--;
		//收缩队列
		if(3 * n < a.length){
			resize();
		}
		System.out.println("removeAfter j == " + j);
	}
	
	private void resize(){
		System.out.println("resize n == " + n);
		T [] b = (T[]) new Object[Math.max(2 * n, 1)];
		for(int i = 0; i < n; i++){
			b[i] = a[i];
		}
		a = b;
		j = 0;
	}
}
