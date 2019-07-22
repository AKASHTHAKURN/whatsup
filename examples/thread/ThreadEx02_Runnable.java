package thread;

/*
 	- ���� �� �������带 ���� �� Thread�� Runnable �Ķ���ͷ� �����Ѵ�
	- Runnable �� ���� : sleep�� �����ʾƵ� ����Ī�� ��
	

*/

public class ThreadEx02_Runnable {

	public static void main(String[] args) throws InterruptedException {

		ExThread tr = new ExThread();
		
		Thread et1 = new Thread(tr);	// Thread(Runnable arg0)
		Thread et2 = new Thread(tr);
		
		et1.start();
		et2.start();
		
		et1.join();
		et2.join();
		
		System.out.println("done");
	}

}

//class ExThreadRun extends Thread implements Runnable {	// �̰͵� �����ϴ�
class ExThreadRun implements Runnable {

	ExThreadRun() {
		
	}
	
	// extends Thread �϶��� ��� ����
	///ExThreadRun(String name) {
	//	super(name);	
	//}
	
	public void run() {

		for (int i=0; i<10; i++) {
		
			System.out.println("running : " + Thread.currentThread().getName() );
			
			//try { Thread.sleep(10); } catch (InterruptedException e) { } // -> ��� ����Ī�� �߻���
		}	
	}
}
