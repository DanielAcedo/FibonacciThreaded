package com.danielacedo.psp;


class FibonacciThread implements Runnable{
	 
	private Thread myThread;
	private int nFibs;
	
	public FibonacciThread(int nFibs){
		myThread = new Thread(this, "Fibonnaci Thread");
		System.out.println("Creado hilo");
		this.nFibs = nFibs;
	}
	
	public void start(){
		myThread.start();
	}
	
	public void run(){
		System.out.println("Hola desde hilo creado");
		
		for(int i = 0; i<=nFibs; i++){
			System.out.println("Fib("+i+"): "+fib(i));
		}
		
		System.out.println("Hilo finalizando");
	}
	
	private long fib(int n){
		long resultado = 0;
		long resultadoAnterior = 0;
		
		for(int i = 0; i<= n; i++){
			if(i==0){
				resultado = 0;
			}
			else if(i==1){
				resultado = 1;
				resultadoAnterior = 0;
			}
			else if(i==2){
				resultado = 1;
				resultadoAnterior = 1;
			}
			else{
				long aux;
				aux = resultado;
				resultado = aux + resultadoAnterior;
				resultadoAnterior = aux;
			}
			
		}
		
		return resultado;
	}
}

public class FibonacciThreadTest {
	
	public static void main(String[] args) {
		new FibonacciThread(10).start();
		System.out.println("Hola desde hilo principal");
		
		System.out.println("Proceso acabando");

	}

}
