package concurrency.example.array;

import java.util.NoSuchElementException;

/**
 * 
 * 创建日期:2015年4月3日
 * <br />Description：对本文件的详细描述，原则上不能少于50字
 * @author 张凯
 * @mender：（文件的修改者，文件创建者之外的人）
 * @version 1.0
 * Remark：<a href="http://opendatastructures.org/ods-java/2_3_ArrayQueue_Array_Based_.html">array queue</a>
 * @param <E>
 */
@SuppressWarnings("unchecked")
public class ArrayQueue<T> {

		T[] a;
	    int j;
	    int n;
	  
		public ArrayQueue(){
	    	a = (T[])new Object[10];
	    	j = 0;
	    	n = 0;
	    }

		public int size(){
			return n;
		}
		
		public T get(int i){
			if(i < 0 || i > n -1){
				throw new IndexOutOfBoundsException();
			}
			return a[(j+i) %a.length] ;
		}
		
	    public boolean add(T x){
	    	//扩容
	    	if(n + 1 > a.length){
	    		resize();
	    	}
	    	a[(j+n) % a.length] = x;
	    	n++;
	    	return true;
	    }
	    
	    public T remove(){
	    	if(n == 0) throw new NoSuchElementException();
	    	T x = a[j];
	    	j = (j+1) % a.length;
	    	n --;
	    	//收缩数组
	    	if(a.length >= 3 * n){
	    		resize();
	    	}
	    	return x;
	    }
	    
	    private void resize(){
	    	T [] b = (T [])new Object[Math.max(1, n*2)];
	    	for(int i = 0; i < n;i++){
	    		b[i] = a[(j+i) % a.length];
	    	}
	    	
	    	a = b;
	    	j = 0;
	    	System.out.println("resize ====" + a.length);
	    }
	    
	    public void display(){
	    	if(n == 0){
	    		System.out.println("array is empty");
	    		return;
	    	}
	    	System.out.println("a lengh ==" + a.length);
	    	StringBuilder sb = new StringBuilder("[");
	    	for (T x : a) {
				sb.append(x).append(",");
			}
	    	sb = sb.deleteCharAt(sb.length() - 1);
	    	sb.append("]");
	    	System.out.println(sb.toString());
	    	
	    }
	    
}
