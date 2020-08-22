package tct_summary;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Thread_03_Pool_ExecutorService {

	public static void main(String[] args) {

		/* 5���� Pool�� Fix�Ѵ�. */
		ExecutorService executorService=Executors.newFixedThreadPool(5);

		for (int i = 1; i <= 100; i++) {
			Runnable doThread=new PoolTest("SleepThread"+i);
			executorService.execute(doThread);
		}

		/* ExecutorService�� ��� �۾� ���� �ٸ� thread ȣ���� 10�� ���� �����մϴ�.
			executorService.awaitTermination(10, TimeUnit.SECONDS);
		*/

		/* ExecutorService ���� */
		executorService.shutdown();

		/* ExecutorService ����Ǿ����� Ȯ�� -> ��� */
		while(!executorService.isTerminated()) {
			
		}

		System.out.println("\n��� Thread�� ����Ǿ����ϴ�.");
	}
}

class PoolTest implements Runnable{

	private String threadName;

	public PoolTest(String threadName){

		this.threadName=threadName;

	}
	
	@Override
    public void run(){

		System.out.println(Thread.currentThread().getName()+"�� "+threadName+"�� ���۵Ǿ����ϴ�.");

		sleepThread();

		System.out.println(Thread.currentThread().getName()+"�� ����Ǿ����ϴ�");

    }

	private void sleepThread(){
		try {
			Thread.sleep(2000);	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return this.threadName;
	}
}