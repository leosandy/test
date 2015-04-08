package concurrency.example.linked.doubly;

import org.junit.Test;

public class DLListTest {

	@Test
	public void dll(){
		DLList<String> dll = new DLList<String>();
		for(int i = 0 ; i < 10; i++){
			dll.add(i, String.valueOf(i));
		}
		dll.add("10");
		dll.addAfter(dll.getNode(2), "after");
		System.out.println("size:"+dll.size());
		System.out.println(dll.get(10));
		System.out.println("display:"+dll.display());
	}
}
