package com.danielacedo.psp;

public class FibonacciThreadTest {
	
	public static void main(String[] args) {
		new FibonacciThread(10).start();
		System.out.println("Hello from the main thread");
		
		System.out.println("Process is finishing");

	}

}
