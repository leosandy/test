package concurrency.example;

public class SimpleThreads {

	static void threadMessage(String msg){
		System.out.format("%s: %s%n",
				Thread.currentThread().getName(),
                msg);
	}
	
	private static class MessageLoop implements Runnable{
		
		public void run() {
			final String [] messageInfo = new String[]{
					 "Mares eat oats",
		                "Does eat oats",
		                "Little lambs eat ivy",
		                "A kid will eat ivy too"
			};
			
			try {
				for (String msg : messageInfo) {
					Thread.sleep(4000);
					threadMessage(msg);
					
				}
			} catch (InterruptedException e) {
				threadMessage(e.getMessage());
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		 // Delay, in milliseconds before
        // we interrupt MessageLoop
        // thread (default one hour).
        long patience = 1000 * 60 * 60;

        // If command line argument
        // present, gives patience
        // in seconds.
        if (args.length > 0) {
            try {
                patience = Long.parseLong(args[0]) * 1000;
            } catch (NumberFormatException e) {
                System.err.println("Argument must be an integer.");
                System.exit(1);
            }
        }

        threadMessage("Starting MessageLoop thread");
        long startTime = System.currentTimeMillis();
        Thread t = new Thread(new MessageLoop());
        t.start();

        threadMessage("Waiting for MessageLoop thread to finish");
        // loop until MessageLoop
        // thread exits
        while (t.isAlive()) {
            threadMessage("Still waiting...");
            // Wait maximum of 1 second
            // for MessageLoop thread
            // to finish.
            t.join(5000);
            if (((System.currentTimeMillis() - startTime) > patience)
                  && t.isAlive()) {
                threadMessage("Tired of waiting!");
                t.interrupt();
                // Shouldn't be long now
                // -- wait indefinitely
                t.join();
            }
        }
        threadMessage("Finally!");
	}
}
