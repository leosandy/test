package concurrency.example.lock;


public class DeadLock {

	public DeadLock() {

	}

	public synchronized void writer(DeadLock lock) {
		System.out.println(Thread.currentThread().getName() + ":writer");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		lock.reader();
	}
	
	public synchronized void reader(){
		System.out.println(Thread.currentThread().getName() +":reader");
	}

	public static void main(String[] args) {

		final DeadLock d1 = new DeadLock();
		final DeadLock d2 = new DeadLock();
		Thread t1 = new Thread(new Runnable() {

			public void run() {
//				while (true) {
					d1.writer(d2);
//				}
			}
		});
		t1.start();
		Thread t2 = new Thread(new Runnable() {

			public void run() {
//				while (true) {
					d2.writer(d1);
//				}
			}
		});
		t2.start();
}
	}
