package com.danielacedo.psp;

/**
 * 
 * MultiThreaded implementation for calculating numbers in the Fibonacci Sequence
 * @author Daniel Acedo Calderón
 *
 */
public class FibonacciThread implements Runnable{
	 
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
	
	/**
	 * Calculates a number from the Fibonacci sequence given the index
	 * @param n Index in the sequence
	 * @return Value in the sequence from the given index
	 * @author Daniel Acedo Calderón
	 */
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
