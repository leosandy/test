package concurrency.example.thread;


public class SyncThread {
	 private long c1 = 0;
	    private long c2 = 0;
	    private Object lock1 = new Object();
	    
	    public void inc1(){
	    	synchronized (lock1) {
	    		c1++;
	    		System.out.println(c1);
			}
	    }
	    
	    public void inc2(){
	    	synchronized (lock1) {
	    		c2++;
	    		System.out.println(c2);
			}
	    }
	    
	    public static void main(String[] args) {
			final SyncThread sync = new SyncThread();
			for(int i = 0;i < 10;i++){
				new Thread(new Runnable() {
					
					public void run() {
						sync.inc1();
						sync.inc2();
					}
				}).start();
			}
			
		}
}
