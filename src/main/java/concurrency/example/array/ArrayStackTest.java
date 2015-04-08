package concurrency.example.array;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ArrayStackTest {
	
	
	public void arrayStack(){
		ArrayStack<String> array = new ArrayStack<String>();
		for(int i = 0; i < 100;i++){
			array.add(String.valueOf(i));
		}
		
		System.out.println(array.toString());
		System.out.println(array.size());
		
		List<String> list = new ArrayList<String>();
		list.add("0");
		list.add("1");
		list.add("1");
		list.add("2");
		System.out.println(list.toString());
	}
	
	
	public void arrayQueue(){
		ArrayQueue<Integer> arrayQueue = new ArrayQueue<Integer>();
		for(int i = 0; i < 29; i++){
			arrayQueue.add(i);
			
			if( i > 0 && i % 5 == 0){
				System.out.println("remove===" + arrayQueue.remove());
			}
		}
		arrayQueue.display();
		System.out.println(arrayQueue.get(0));
		
	}
	
	@Test
	public void arrayDeque(){
//		java.util.ArrayDeque<?> deque;
		ArrayDeque<Integer> arrayDeque = new ArrayDeque<Integer>();
		for(int i = 0; i < 10; i++){
//			arrayDeque.add(i,Integer.valueOf(i));
			arrayDeque.add(i);
		}
		
		System.out.println("display:"+arrayDeque.display());
		arrayDeque.remove(2);
		System.out.println("display:"+arrayDeque.display());
		arrayDeque.add(1,8);
		System.out.println("display:"+arrayDeque.display());
		System.out.println(arrayDeque.size());
		
////		
//		arrayDeque.remove(20);
//		System.out.println("display:"+arrayDeque.display());
	}
	
}
