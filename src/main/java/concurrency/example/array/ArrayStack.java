package concurrency.example.array;

import java.text.MessageFormat;


/**
 * 
 * 创建日期:2015年3月31日
 * <br />Description：对本文件的详细描述，原则上不能少于50字
 * @author 张凯
 * @mender：（文件的修改者，文件创建者之外的人）
 * @version 1.0
 * Remark：认为有必要的其他信息
 * @param <T>
 */
public class ArrayStack<T> {

	private T [] a;
	private int n;
	
	private final static int DEFAULT_SIZE = 16;
	private int capacity = DEFAULT_SIZE;
	@SuppressWarnings("unchecked")
	public ArrayStack(){
		a = (T[])new Object[capacity];
		n = 0;
	}
	
	public int size(){
		return n;
	}
	
	public void add(T x){
		if( n> (a.length * 0.75)){
			//TODO 当超过3/4时，扩容
			resize();
		}
		a[n] = x;
		n++;
	}
	
	public void add(int i,T x){
		if(i < 0 || i > n - 1) throw new IndexOutOfBoundsException();
		if( n> (a.length * 0.75)){
			//TODO 当超过3/4时，扩容
			resize();
		}
		 System.arraycopy(a, i, a, i+1, n - i);
		a[i] = x;
		n++;
	}
	
	/**
	 * 
	 * 功能:获取
	 *<br /> 作者: 张凯
	 * <br />创建日期:2015年3月31日
	 * <br />修改者: mender
	 * <br />修改日期: modifydate
	 * @param i
	 * @return
	 */
	public T get(int i){
		if(i < 0 || i > n - 1){
			throw new IndexOutOfBoundsException("index bound error");
		}
		return a[i];
	}
	
	/**
	 * 
	 * 功能:替换
	 *<br /> 作者: 张凯
	 * <br />创建日期:2015年3月31日
	 * <br />修改者: mender
	 * <br />修改日期: modifydate
	 * @param i
	 * @param x
	 * @return
	 */
	public T set(int i , T x){
		if(i < 0 || i > n - 1){
			throw new IndexOutOfBoundsException("index bound error");
		}
		
		T y = a[i];
		a[i] = x;
		return y;
	}
	
	public T remove(int i){
		
		if(i < 0 || i > n - 1){
			throw new IndexOutOfBoundsException("index bound error");
		}
		 T x = a[i];
//		//i 之后的元素向前移动1位
//		for(int j = i; j < n - 1;j++){
//			a[j] = a[j+1];
//		}
		 System.arraycopy(a, i+1, a, i, n - 1);
		n --;
		if(a.length >= 3 * n) {
			//TODO 调整大小
			resize();
		}
		
		return x;
		
	}
	
	public String display(){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < size();i++){
			sb.append(a[i]).append(",");
		}
		sb = sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
	
	@SuppressWarnings("unchecked")
	private void resize(){
		int maxSize = Math.max(2 * n, 1);
		System.out.println(MessageFormat.format("resize starting .......n:{0},maxSize:{1}", new Object[]{n,maxSize}));
		T [] b = (T[])new Object[maxSize];
		
		/*for(int i = 0; i < n;i++){
			b[i] = a[i];
		}*/
		
		System.arraycopy(a, 0, b, 0, n);
		a = b;
	}
}
