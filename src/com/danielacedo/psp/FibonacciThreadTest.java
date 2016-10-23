package com.danielacedo.psp;

public class FibonacciThreadTest {
	
	public static void main(String[] args) {
		
		if(args.length!=1){
			System.out.println("Incorrect number of arguments, please enter one argument");
		}
		
		int nFibs = 0;
		
		try{
			nFibs = Integer.parseInt(args[0]);
		}catch(NumberFormatException e){
			System.err.println("Error reading arguments. Please enter a number as first argument");
		}
		
		FibonacciDirector director = new FibonacciDirector(nFibs);
		director.calculate();
		
		
		System.out.println("Process is finishing");

	}

}
