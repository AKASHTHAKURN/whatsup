import java.util.concurrent.locks.ReentrantLock;

class ThreadClassX extends Thread { // 'Thread' Class를 상속받는다 
	
	static ReentrantLock lock = new ReentrantLock();
	
    String thread_name; 
    public ThreadClassX(String name) { 
        this.thread_name = name; 
    } 

    public void run() { 
    	lock.lock();
    	try {
    		PrintNums(thread_name);
    	}
    	finally {
    		lock.unlock();
    	}
    } 
    
    static void PrintNums(String str)
    {
    	int i;
    	
    	System.out.println(str);
    	
    	for (i=1; i<=30; i++)
    	{
    		System.out.print(i+" ");
    	}	
    	System.out.println();
    }
} 

public class MutexSample { 
    public static void main(String[] args) throws InterruptedException { 
        ThreadClassX tc1 = new ThreadClassX("[Thread1] ");
        ThreadClassX tc2 = new ThreadClassX("[Thread2] ");
        tc1.start(); 
        tc2.start();

        ThreadClassX.lock.lock();
    	try {        
    		ThreadClassX.PrintNums("[Main]");
    	}
    	finally
    	{
    		ThreadClassX.lock.unlock();
    	}
        
        tc1.join();
        tc2.join();
    } 
}