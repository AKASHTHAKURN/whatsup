package thread;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadEx03_SyncMutex {

	final static int CODE = 1;
	
	public static void main(String[] args) {
		//
		// 같은 동작을 하는 스레드 사용 시 Thread(Runnable arg0) 형태로 실행해야 한다
		//
		if (CODE == 1)
		{
			WithdrawThread tr = new WithdrawThread();
			Thread t1 = new Thread(tr);
			Thread t2 = new Thread(tr);
			t1.start();
			t2.start();
		} 
		else 
		{
			/* 이 것도 꼬임
			WithdrawThread tr1 = new WithdrawThread();
			WithdrawThread tr2 = new WithdrawThread();
			tr1.start();
			tr2.start();
			*/

			WithdrawThread tr1 = new WithdrawThread();
			WithdrawThread tr2 = new WithdrawThread();
			Thread t1 = new Thread(tr1);
			Thread t2 = new Thread(tr2);
			t1.start();
			t2.start();
		}
	}
}

class Account {
	
	/*
	 * class 멤버변수로 선언해야 한다
	 */
	static ReentrantLock lock = new ReentrantLock(); 
	
	private int balance = 1000;
	
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

//class WithdrawThread extends Thread {
//class WithdrawThread implements Runnable {
class WithdrawThread extends Thread implements Runnable {

	Account acc = new Account();
	
	public void run() {
		while(acc.getBalance()> 0) {
			
			// 100, 200, 300중의 한 값을 임으로 선택해서 출금(withdraw)
			int money = (int)(Math.random() * 3 + 1) * 100;
			
			//acc.withdraw(money);
			acc.withdrawSync(money, Thread.currentThread().getName());
			
			//System.out.println("balance:"+acc.getBalance());			
		}
	}
}