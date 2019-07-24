package thread;

/*
 - et1.join() : et1이 끝날때 까지 대기
 - super(name) : 스레드 이름 지정 
 - Thread.currentThread().getName() : 현재 스레드의 이름을 획득
 - Thread.sleep(10) 

 */

public class ThreadEx01_Thread {

	public static void main(String[] args) throws InterruptedException {

		ExThread et1 = new ExThread();
		ExThread et2 = new ExThread("th-1");
		
		et1.start();
		et2.start();
		
		et1.join();
		et2.join();
		
		System.out.println("done");
	}

}

class ExThread extends Thread {

	ExThread() {
		
	}
	
	ExThread(String name) {
		super(name);	
	}
	
	public void run() {
		for (int i=0; i<10; i++) {
			System.out.println("running : " + Thread.currentThread().getName() );
			try { Thread.sleep(1); } catch (InterruptedException e) { }
		}	
	}
}
