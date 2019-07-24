package thread;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadEx03_SyncMutex_Withdraw_FIX {

	public static void main(String[] args) throws InterruptedException {
		//
		// ���� ������ �ϴ� ������ ��� �� Thread(Runnable arg0) ���·� �����ؾ� �Ѵ�
		//
		WithdrawThread tr = new WithdrawThread();

		Thread t1 = new Thread(tr);
		Thread t2 = new Thread(tr);
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
	}
}

class Account {
	
	/*
	 * class ��������� �����ؾ� �Ѵ�
	 */
	static ReentrantLock lock = new ReentrantLock(); 
	
	private int balance = 3000;
	
	public int getBalance() {
		return balance;
	}

	// synconized	
	public synchronized void withdrawSync(int money, String threadName) {
		if (balance >= money) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			balance -= money;
			System.out.println("balance:" + getBalance() + " -> " + threadName );	
		}
	}
	
	// Mutex
	public void withdraw(int money) {
		lock.lock();
		if (balance >= money) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			balance -= money;
			System.out.println("balance:"+getBalance());			

		}
		lock.unlock();
	}
}

class WithdrawThread implements Runnable {

	Account acc = new Account();
	
	public void run() {
		while(acc.getBalance()> 0) {
			
			// 100, 200, 300���� �� ���� ������ �����ؼ� ���(withdraw)
			int money = (int)(Math.random() * 3 + 1) * 100;
			
			acc.withdraw(money);

			//acc.withdrawSync(money, Thread.currentThread().getName());
		}
	}
}