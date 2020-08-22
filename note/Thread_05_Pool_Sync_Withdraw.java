package tct_summary;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Thread_05_Pool_Sync_Withdraw {

	public static void main(String[] args) throws InterruptedException {

		// 5���� Pool�� FIX �Ѵ�
		ExecutorService executorService=Executors.newFixedThreadPool(10);

		for (int i = 1; i <= 3; i++) {
			Runnable doThread = new WithrawThread(i);
			executorService.execute(doThread);
		
		}

		// ExecutorService�� ��� �۾� ���� �ٸ� thread ȣ���� 10�� ���� �����մϴ�.
		// executorService.awaitTermination(10, TimeUnit.SECONDS);

		// ExecutorService ���� 
		executorService.shutdown();

		// ExecutorService ����Ǿ����� Ȯ�� -> ���
		while(!executorService.isTerminated()) {
			
		}

		System.out.println("\n��� Thread�� ����Ǿ����ϴ�.");
	}
}

class Acc {
	
	// Acc�� ������ ȣ���ϹǷ� balance�� static ���� �����ؾ� �Ѵ�
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