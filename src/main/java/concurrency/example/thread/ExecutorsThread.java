package concurrency.example.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecutorsThread {

	public static void main(String[] args) {
		Executor executor = Executors.newFixedThreadPool(1);
		executor.execute(new Runnable() {
			public void run() {
				System.out.println("Executor Running");
			}
		});
		
	}
}
