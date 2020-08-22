package tct_summary;

import java.util.concurrent.locks.ReentrantLock;

// ���� ������ �ϴ� ������ ��� �� Thread(Runnable arg0) ���·� �����ؾ� �Ѵ� -> ��ü ����

public class Thread_04_Sync_Withdraw {

	public static void main(String[] args) throws InterruptedException {
		
		Runnable tr = new WithdrawThread();

		Thread t1 = new Thread(tr);
		Thread t2 = new Thread(tr);
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
	}
}

class Account {
	
	// class ��������� �����ؾ� �Ѵ�

	static ReentrantLock lock = new ReentrantLock(); 
	
	private int balance = 3000;
	
	Account() {
		
		System.out.println("Account created =========");
	}
	
	public int getBalance() {
		return balance;
	}

	// ����ȭ
	public synchronized void withdrawSync(int money) {
		
		if (balance >= money) {
			balance -= money;
			System.out.println("["+ Thread.currentThread().getName() + "]" + "balance:"+getBalance());			
		}
	}
	
	// Mutex
	public void withdrawMutex(int money) {
		
		lock.lock();
		
		if (balance >= money) {
			balance -= money;
			System.out.println("["+ Thread.currentThread().getName() + "]" + "balance:"+getBalance());			

		}
		
		lock.unlock();
	}
}

class WithdrawThread implements Runnable {

	Account acc;
	
	WithdrawThread() {
		acc = new Account(); 
	}
	
	public void run() {
		while(acc.getBalance()> 0) {
			
			// 100, 200, 300���� �� ���� ������ �����ؼ� ���(withdraw)
			int money = (int)(Math.random() * 3 + 1) * 100;
			
			acc.withdrawSync(money);
//			acc.withdrawMutex(money);
			
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}