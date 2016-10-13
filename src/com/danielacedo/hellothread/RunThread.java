package com.danielacedo.hellothread;


class HelloThread extends Thread{
	 
	private int nFibs;
	
	public HelloThread(int nFibs){
		System.out.println("Creado hilo");
		this.nFibs = nFibs;
	}
	
	@Override
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

public class RunThread {
	
	public static void main(String[] args) {
		new HelloThread(70).start();
		System.out.println("Hola desde hilo principal");
		
		System.out.println("Proceso acabando");

	}

}
