package com.danielacedo.psp;

/**
 * 
 * MultiThreaded implementation for calculating numbers in the Fibonacci Sequence
 * @author Daniel Acedo Calderón
 *
 */
public class FibonacciThread implements Runnable{
	 
	private Thread myThread;
	private FibonacciDirector director;
	private boolean even; //If true, calculates the even index. Otherwise it will calculate the odd ones
	
	public FibonacciThread(FibonacciDirector director, boolean even){
		myThread = new Thread(this, "Fibonnaci Thread");
		this.even = even;
		this.director = director;
	}
	
	public void start(){
		myThread.start();
	}
	
	public void run(){
		for(int i = 1; i<director.getnFibs(); i++){
			if(even && i%2==0){
				director.getFibCollection()[i] = fib(i);
			}
			else if((!even) && i%2!=0){
				director.getFibCollection()[i] = fib(i);
			}
			
		}
	}
	
	public void join(){
		try {
			this.myThread.join();
		} catch (InterruptedException e) {
			System.err.println("Thread failed to join");
		}
	}
	
	/**
	 * Calculates a number from the Fibonacci sequence given the index
	 * @param n Index in the sequence
	 * @return Value in the sequence from the given index
	 * @author Daniel Acedo Calderón
	 */
	private long fib(int n){
		long oldResult = 0;
		long result = 1;
		
		if(n == 0){
			result = 0;
		}
		
		for(int i = 2; i<= n; i++){
			long aux = result;
			result = result + oldResult;
			oldResult = aux;
		}
		
		return result;
	}
}
