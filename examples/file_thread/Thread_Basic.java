package ssp.file;

public class Thread_Basic {

    public static void main(String[] args) { 

 
    	/*
    	 * Thread class ���
    	 */
        ThreadClass tc1 = new ThreadClass(); 
        //ThreadClass tc1 = new ThreadClass("th-1"); 
        tc1.start(); 
        
        try {
            tc1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*
         * Runnable Interface �̿�
         */
        ThreadClassRunnable m1=new ThreadClassRunnable();  
        Thread tc2 = new Thread(m1);	// �̰� �߰��ȴ� 	 
        tc2.start();  

        try {
            tc2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        
        /*
         * Lamda expression
         */
        Thread t1 = new Thread( new Runnable () {
            @Override
            public void run(){
            	System.out.println(Thread.currentThread().getName() + " is running...");  
            }
        }
        );
        t1.start();  
        try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        // Lambda Runnable 1
        Runnable taskR = () -> {
            System.out.println(Thread.currentThread().getName() + " is running");
        };
        new Thread(taskR).start();
            
        // Lambda Runnable 2
        new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " is running");
            }).start();        

    } 
}

class ThreadClass extends Thread {

	ThreadClass() {
	
	}

	ThreadClass(String name) {
		super(name);	
	}
	
	public void run() { 
        System.out.println(Thread.currentThread().getName() + " is running...");
    } 
} 

/*
 * �Ķ���͸� �޾Ƽ� ����
 */
class ThreadClassRunnable implements Runnable{  

	private String key;
	
	ThreadClassRunnable() {
		
	}

	ThreadClassRunnable(String key) {
		this.key = key;
	}
	
	public void run(){  
        System.out.println(Thread.currentThread().getName() + " is running. key = " + key);  
    }  
}


