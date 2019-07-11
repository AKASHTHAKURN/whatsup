package ssp.file;

import java.util.concurrent.Semaphore;

/*
 * Semaphore�� ��� ���ÿ� ����Ǵ� thread ���� ������ �����ϴ�
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
		this.semaphore = new Semaphore(maxThread);	// ��밡���� ����
	}
	
	public void use() {
		try {
			
			// Thread �� semaphore���� ������ �˸�
			semaphore.acquire(); 
			
			System.out.println("[" + Thread.currentThread().getName() + "]" 
											+ (maxThread - semaphore.availablePermits()) + "�����尡 ������" );
			
			// semaphore.availablePermits() ��밡���� Thread�� ����
			
			Thread.sleep((long) (Math.random() * 10000 + 1)); // 10000
			
			// Thread �� semaphore���� ���Ḧ �˸�
			semaphore.release(); 
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}