package tct_summary;

/*

	쓰레드를 구현하는 방법은 Thread클래스를 상속받는 것과 Runnable 인터페이스를 구현하는 방법 

	이 두가지 방법 중 어느 쪽을 사용해도 별 차이는 없지만 Thread 클래스를 상속받으면 다른 클래스를 상속받을 수 없기 때문에 Runnable 인터페이스를 구현하는 것이 일반적이다.
	
	Runnable인터페이스를 구현하는 방법은 재사용성이 높고 코드의 일관성을 유지할 수 있다는 장점이 있기 때문에 보다 객체지향적인 방법이라 할 수 있다.

	<무조건 Runnable 사용해라>
	
*/


/*
 * 선언 시 내스레드를 선언 후 Thread에 Runnable 파라메터로 생성한다 
 */

public class Thread_02_Runnable {

	public static void main(String[] args) throws InterruptedException {

		Runnable tr = new ThreadRunnable("A");
		Thread et1 = new Thread(tr);	
		Thread et2 = new Thread(tr);

		ThreadRunnable tr2 = new ThreadRunnable("B");
		Thread et3 = new Thread(tr2);
		
		et1.start();
		et2.start();
		et3.start();
		
		et1.join();
		et2.join();
		et3.join();
		
		System.out.println("done");
	}
}

class ThreadRunnable implements Runnable {

	private String name;
	
	ThreadRunnable(String name) {
		this.name = name;
	}

	@Override
	public void run() 
	{
		for (int i=0; i<10; i++) 
		{
			System.out.println("running : " + Thread.currentThread().getName() + " " + this.name );
			
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
