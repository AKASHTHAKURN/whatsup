package ssp.file;
import java.util.concurrent.locks.ReentrantLock;

/*
 * 
 * - synchronized
 * 
 * - ReentrantLock (lock, unlock) -> mutex
 * 
 */

public class Thread_Synchronization {

	final static int CODE = 1;
	
	public static void main(String[] args) {

		/*
		 * 같은 동작을 하는 스레드 사용 시 Thread(Runnable arg0) 형태로 실행해야 한다
		 */
		if (CODE == 1)
		{
			/*
			WithdrawThread tr = new WithdrawThread();
			Thread t1 = new Thread(tr);
			Thread t2 = new Thread(tr);
			t1.start();
			t2.start();
			*/
			
			WithdrawThread wt = new WithdrawThread();;
			Thread[] tr = new Thread[5];
			
			for(int i=0; i<5; i++) {
				tr[i] = new Thread(wt);
				tr[i].start();
			}
			
			for(int i=0; i<5; i++) {
				try {
					tr[i].join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			System.out.println("program end");	
			
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
	
	private int balance = 999999999;	// 1000
	
	public int getBalance() {
		return balance;
	}

	/*
	 *  synconized	
	 */
	public synchronized void withdrawSync(int money, String threadName) {
		if (balance >= money) {
			
			/*
			 * sleep 을 줘야 context switching 이 잘 일어난다
			 * 안주면 전환이 거의 안됨
			 */
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			balance -= money;
			
			System.out.println("balance:" + getBalance() + " -> " + threadName );	
		}
	}
	
	/*
	 *  Mutex
	 */
	public void withdraw(int money) {
		lock.lock();
		if (balance >= money) {
			try {
				Thread.sleep(1);
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
			//int money = (int)(Math.random() * 3 + 1) * 100;

			int money = (int)(Math.random() * 1000000000 + 1); // 1 ~ 999999999

			//acc.withdraw(money);
			acc.withdrawSync(money, Thread.currentThread().getName());
			
			//System.out.println("balance:"+acc.getBalance());			
		}
	}
}