package ssp.file;

import java.util.concurrent.Semaphore;

/*
 * Semaphore의 경우 동시에 실행되는 thread 갯수 제한이 가능하다
 */

public class Thread_Semaphore {
	public static void main(String[] args) {
		

		final SomeResource resource = new SomeResource(3); 
		
		for(int i = 1 ; i <= 10 ; i++) {
			Thread t = new Thread(new Runnable() {
				public void run() {
					resource.use();
				}
			});
			t.start();
		}
		
	}
}

class SomeResource {
	
	private final Semaphore semaphore;
	private final int maxThread;
	
	public SomeResource(int maxThread) {
		this.maxThread = maxThread;
		this.semaphore = new Semaphore(maxThread);	// 사용가능한 갯수
	}
	
	public void use() {
		try {
			
			// Thread 가 semaphore에게 시작을 알림
			semaphore.acquire(); 
			
			System.out.println("[" + Thread.currentThread().getName() + "]" 
											+ (maxThread - semaphore.availablePermits()) + "쓰레드가 점유중" );
			
			// semaphore.availablePermits() 사용가능한 Thread의 숫자
			
			Thread.sleep((long) (Math.random() * 10000 + 1)); // 10000
			
			// Thread 가 semaphore에게 종료를 알림
			semaphore.release(); 
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}