package thread;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadEx03_SyncMutex_Withdraw_FIX {

	public static void main(String[] args) throws InterruptedException {
		//
		// 같은 동작을 하는 스레드 사용 시 Thread(Runnable arg0) 형태로 실행해야 한다
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
	 * class 멤버변수로 선언해야 한다
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
			
			// 100, 200, 300중의 한 값을 임으로 선택해서 출금(withdraw)
			int money = (int)(Math.random() * 3 + 1) * 100;
			
			acc.withdraw(money);

			//acc.withdrawSync(money, Thread.currentThread().getName());
		}
	}
}