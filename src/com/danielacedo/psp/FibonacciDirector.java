package com.danielacedo.psp;


/**
 * Thread for controlling the child threads in charge of calculating fibonacci numbers.
 * @author Daniel Acedo Calderón
 *
 */
public class FibonacciDirector {
	private int nFibs;
	private long[] fibCollection;
	
	private Object mutexCollection = new Object(); //Mutex for locking fibCollection
	
	public FibonacciDirector(int nFibs){
		this.nFibs = nFibs;
		this.fibCollection = new long[nFibs];
		this.fibCollection[0] = 0;
	}
	
	public int getnFibs() {
		return nFibs;
	}
	
	public long[] getFibCollection() {
		synchronized (mutexCollection) {
			return fibCollection;
		}
	}

	public void setFibCollection(long[] fibCollection) {
		synchronized (mutexCollection) {
			this.fibCollection = fibCollection;
		}
	}
	
	public void calculate(){
		FibonacciThread evens = new FibonacciThread(this, true);
		FibonacciThread odds = new FibonacciThread(this, false);
		
		evens.start();
		odds.start();
		
		evens.join();
		odds.join();
		
		System.out.println("Printing first "+nFibs+" values of Fibonacci's sequence");
		System.out.println("------------------");
		
		for(int i = 0; i<fibCollection.length; i++){
			System.out.println("Fib("+i+"): "+fibCollection[i]);
		}
	}
	
	
}
