package ssp.file;

public class Thread_Multi_Array {

	public static void main(String[] args) {

		final String key = "hello";


		ConvThread[] tr = new ConvThread[20];

		for(int i=0; i<20; i++){

			tr[i] = new ConvThread(key);
			tr[i].start();

		}
		
		for (int i=0; i<20; i++) {
			try {
				tr[i].join();	// thread extend
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("first done");
		
		// =============================================//
		
		//ConvThreadRun[] ct = new ConvThreadRun[20];
		//ConvThreadRun ct = new ConvThreadRun();
		//Thread[] tc = new Thread[20];

		ConvThreadRun ct = new ConvThreadRun(key);
		Thread[] tc = new Thread[20];

		for(int i=0; i<20; i++){
			//ct = new ConvThreadRun(key);
			tc[i] = new Thread(ct);
			tc[i].start();
		}
		
		for (int i=0; i<20; i++) {
			try {
				tc[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

class ConvThread extends Thread {
	private String key;
	
	ConvThread(String key) {
		this.key = key;
	}

	public void run() { 
        System.out.println(Thread.currentThread().getName() + " is running...");
    } 
}
class ConvThreadRun implements Runnable {

	private String key;
	
	ConvThreadRun(String key) {
		this.key = key;
	}

	public void run() { 
        System.out.println(Thread.currentThread().getName() + " is running...");
    } 
}

