package concurrency.example.thread;

public class Drop {

	private String message;
	
	private boolean empty = true;
	
	public synchronized String take(){
		while (empty) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("take");
		empty = true;
		notifyAll();
		return message;
	}
	
	public synchronized void put(String message){
		while (!empty) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("put");
		this.message = message;
		this.empty = false;
		notifyAll();
	}
	
	public static void main(String[] args) {
		final Drop drop = new Drop();
		
		
		
		
		Thread producer = new Thread(new Runnable() {
			
			public void run() {
				for(int i = 0; i < 100; i++){
					drop.put("message" + i);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		},"producer");
		producer.start();
		Thread customer = new Thread(new Runnable() {
			public void run() {
				for(int i = 0; i < 100; i++){
					System.out.println(drop.take());
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		},"customer");
		customer.start();
	}
}
