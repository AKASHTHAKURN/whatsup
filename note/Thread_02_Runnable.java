package tct_summary;

/*

	�����带 �����ϴ� ����� ThreadŬ������ ��ӹ޴� �Ͱ� Runnable �������̽��� �����ϴ� ��� 

	�� �ΰ��� ��� �� ��� ���� ����ص� �� ���̴� ������ Thread Ŭ������ ��ӹ����� �ٸ� Ŭ������ ��ӹ��� �� ���� ������ Runnable �������̽��� �����ϴ� ���� �Ϲ����̴�.
	
	Runnable�������̽��� �����ϴ� ����� ���뼺�� ���� �ڵ��� �ϰ����� ������ �� �ִٴ� ������ �ֱ� ������ ���� ��ü�������� ����̶� �� �� �ִ�.

	<������ Runnable ����ض�>
	
*/


/*
 * ���� �� �������带 ���� �� Thread�� Runnable �Ķ���ͷ� �����Ѵ� 
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
