package concurrency.example.thread;

import java.util.Arrays;
import java.util.List;

public class JoinThread {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Join(),"t1");
		Thread t2 = new Thread(new Join(),"t2");
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

class Join implements Runnable{

	public void run() {
			List<String> codeList = Arrays.asList(new String[]{"01","02","03","04","05"});
			List<String> winList = Arrays.asList(new String[]{"02","03"});
			for (String winCode : winList) {
				if(codeList.contains(winCode)){
					System.out.println(Thread.currentThread().getName() +" : " + winCode);
				}
			}
	}
	
}
