class ThClass extends Thread { // 'Thread' Class를 상속받는다 
    String thread_name; 
    public ThClass(String name) { 
        this.thread_name = name; 
    } 

    public void run() { 
        for(int i=0; i<10; i++) { 
            System.out.println(thread_name+i); 
            try { 
                sleep(10); 
            } catch (InterruptedException e) { e.printStackTrace(); } 
        } 
    } 
} 

public class ThreadSample { 
    public static void main(String[] args) throws InterruptedException { 
    	ThClass tc1 = new ThClass("[Thread1] ");
    	ThClass tc2 = new ThClass("[Thread2] ");
        tc1.start(); 
        tc2.start();

        for (int i=0; i<10; i++)
        {
        	System.out.println("[Main] "+i);
        	Thread.sleep(10);
        }
        
        tc1.join();
        tc2.join();
    } 
}