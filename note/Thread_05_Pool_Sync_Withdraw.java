package tct_summary;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Thread_05_Pool_Sync_Withdraw {

	public static void main(String[] args) throws InterruptedException {

		// 5개의 Pool을 FIX 한다
		ExecutorService executorService=Executors.newFixedThreadPool(10);

		for (int i = 1; i <= 3; i++) {
			Runnable doThread = new WithrawThread(i);
			executorService.execute(doThread);
		
		}

		// ExecutorService의 모든 작업 이후 다른 thread 호출을 10초 동안 차단합니다.
		// executorService.awaitTermination(10, TimeUnit.SECONDS);

		// ExecutorService 종료 
		executorService.shutdown();

		// ExecutorService 종료되었는지 확인 -> 대기
		while(!executorService.isTerminated()) {
			
		}

		System.out.println("\n모든 Thread가 종료되었습니다.");
	}
}

class Acc {
	
	// Acc를 여러개 호출하므로 balance는 static 으로 지정해야 한다
	private static int balance = 3000;

	Acc() {
		System.out.println("Created Acc - " + getBalance());
	}
	
	public int getBalance() {
		return balance;
	}
	
	public synchronized void withraw(int money) {
		
		if(balance >= money) {
			balance -= money;
			System.out.println(Thread.currentThread().getName() + " : " + getBalance());
		} 
	}
}

class WithrawThread implements Runnable {

	Acc acc;
	
	WithrawThread(int i) {
		System.out.println("Created WithrawThread " + Thread.currentThread().getName() + "-" + i);
		acc = new Acc();
	}
	
	@Override
	public void run() {
	
		while(acc.getBalance() > 0) 
		{
			acc.withraw(100);
			
			try { Thread.sleep(1); } catch (InterruptedException e) { e.printStackTrace();}
		}
	}
}