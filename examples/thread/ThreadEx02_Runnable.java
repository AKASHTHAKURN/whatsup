package thread;

/*
 * 선언 시 내스레드를 선언 후 Thread에 Runnable 파라메터로 생성한다 
 */

public class ThreadEx02_Runnable {

	public static void main(String[] args) throws InterruptedException {

		Runnable tr = new ThreadRunnable("A");
		Thread et1 = new Thread(tr);	
		Thread et2 = new Thread(tr);

		ThreadRunnable tr2 = new ThreadRunnable("B");
		Thread et3 = new Thread(tr2);
		
		et1.start();
		et2.start();
		et3.start();
		
		et1.join();
		et2.join();
		et3.join();
		
		System.out.println("done");
	}
}

class ThreadRunnable implements Runnable {

	private String name;
	
	ThreadRunnable(String name) {
		this.name = name;
	}
	
	public void run() {

		for (int i=0; i<10; i++) {
		
			System.out.println("running : " + Thread.currentThread().getName() + " " + this.name );
			
			// 스위칭이 잘 일어나게 sleep 준다, 없어도 스위칭은 발생
			try { Thread.sleep(1); } catch (InterruptedException e) { } 
		}	
	}
}
