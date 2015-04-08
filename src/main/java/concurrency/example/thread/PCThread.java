package concurrency.example.thread;

/**
 * 
 * 创建日期:2014年12月18日
 * <br />原生态生产消费者模型
 * @author 张凯
 * @mender：（文件的修改者，文件创建者之外的人）
 * @version 1.0
 * Remark：认为有必要的其他信息
 */
public class PCThread {

	public static void main(String[] args) {
		final BoundedBuffer bb = new BoundedBuffer();
		Thread producer = new Thread(new Runnable() {
			public void run() {
				int i = 0;
				try {
					for (;;) {
						bb.put("hello" + i);
						++i;
						Thread.sleep(30);
						System.out.println("producer :"+bb.size());
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "producer");
		producer.start();
		Thread customer = new Thread(new Runnable() {

			public void run() {
				try {
					for(;;){
						System.out.println(bb.take().toString());
						System.out.println("customer :"+bb.size());
						Thread.sleep(50);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "customer");
		customer.start();
	}
}
