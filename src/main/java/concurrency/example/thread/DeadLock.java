package concurrency.example.thread;

/**
 * 
 * 创建日期:2014年12月18日 <br />
 * 死锁测试
 * 
 * @author 张凯
 * @mender：（文件的修改者，文件创建者之外的人）
 * @version 1.0 Remark：认为有必要的其他信息
 */
public class DeadLock {

	static class Friend {

		public synchronized void reader(Friend f) {
			System.out.println(Thread.currentThread().getName()+":reader");
			f.writer(this);
		}

		public synchronized void writer(Friend f) {
			System.out.println(Thread.currentThread().getName()+":writer");
		}
		
		public void reader() {
			synchronized (this) {
				System.out.println(Thread.currentThread().getName()+":reader");
				writer();
			}
			
		}

		public void writer() {
			synchronized (this) {
				System.out.println(Thread.currentThread().getName()+":writer");	
				try {
					wait(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		final Object obj = new Object();
		while (true) {
			synchronized (obj) {
				
			}
		}
	}

}
