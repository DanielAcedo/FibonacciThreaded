package com.danielacedo.psp;


class FibonacciThread implements Runnable{
	 
	private Thread myThread;
	private int nFibs;
	
	public FibonacciThread(int nFibs){
		myThread = new Thread(this, "Fibonnaci Thread");
		System.out.println("Thread created");
		this.nFibs = nFibs;
	}
	
	public void start(){
		myThread.start();
	}
	
	public void run(){
		System.out.println("Hello from the created thread");
		
		for(int i = 0; i<=nFibs; i++){
			System.out.println("Fib("+i+"): "+fib(i));
		}
		
		System.out.println("Thread is finishing");
	}
	
	private long fib(int n){
		long result = 0;
		long oldResult = 0;
		
		for(int i = 0; i<= n; i++){
			if(i==0){
				result = 0;
			}
			else if(i==1){
				result = 1;
				oldResult = 0;
			}
			else if(i==2){
				result = 1;
				oldResult = 1;
			}
			else{
				long aux;
				aux = result;
				result = aux + oldResult;
				oldResult = aux;
			}
			
		}
		
		return result;
	}
}

public class FibonacciThreadTest {
	
	public static void main(String[] args) {
		new FibonacciThread(10).start();
		System.out.println("Hello from the main thread");
		
		System.out.println("Process is finishing");

	}

}
