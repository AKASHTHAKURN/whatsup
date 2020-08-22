package tct_summary;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Thread_03_Pool_ExecutorService {

	public static void main(String[] args) {

		/* 5개의 Pool을 Fix한다. */
		ExecutorService executorService=Executors.newFixedThreadPool(5);

		for (int i = 1; i <= 100; i++) {
			Runnable doThread=new PoolTest("SleepThread"+i);
			executorService.execute(doThread);
		}

		/* ExecutorService의 모든 작업 이후 다른 thread 호출을 10초 동안 차단합니다.
			executorService.awaitTermination(10, TimeUnit.SECONDS);
		*/

		/* ExecutorService 종료 */
		executorService.shutdown();

		/* ExecutorService 종료되었는지 확인 -> 대기 */
		while(!executorService.isTerminated()) {
			
		}

		System.out.println("\n모든 Thread가 종료되었습니다.");
	}
}

class PoolTest implements Runnable{

	private String threadName;

	public PoolTest(String threadName){

		this.threadName=threadName;

	}
	
	@Override
    public void run(){

		System.out.println(Thread.currentThread().getName()+"의 "+threadName+"이 시작되었습니다.");

		sleepThread();

		System.out.println(Thread.currentThread().getName()+"가 종료되었습니다");

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