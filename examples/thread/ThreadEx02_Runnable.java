package thread;

/*
 	- 선언 시 내스레드를 선언 후 Thread에 Runnable 파라메터로 생성한다
	- Runnable 의 장점 : sleep을 주지않아도 스위칭이 됨
	

*/

public class ThreadEx02_Runnable {

	public static void main(String[] args) throws InterruptedException {

		ExThread tr = new ExThread();
		
		Thread et1 = new Thread(tr);	// Thread(Runnable arg0)
		Thread et2 = new Thread(tr);
		
		et1.start();
		et2.start();
		
		et1.join();
		et2.join();
		
		System.out.println("done");
	}

}

//class ExThreadRun extends Thread implements Runnable {	// 이것도 가능하다
class ExThreadRun implements Runnable {

	ExThreadRun() {
		
	}
	
	// extends Thread 일때만 사용 가능
	///ExThreadRun(String name) {
	//	super(name);	
	//}
	
	public void run() {

		for (int i=0; i<10; i++) {
		
			System.out.println("running : " + Thread.currentThread().getName() );
			
			//try { Thread.sleep(10); } catch (InterruptedException e) { } // -> 없어도 스위칭이 발생함
		}	
	}
}
