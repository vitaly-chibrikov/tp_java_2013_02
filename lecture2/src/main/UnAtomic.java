package main;

public class UnAtomic extends Thread{
	private static int counter=0;
	private static int j=0;
	private static int i=0;
	
	public static void main(String[] args) throws InterruptedException{
		(new UnAtomic()).start();
		(new UnAtomic()).start();
	}
	
	private static synchronized boolean increaseCounter(){
		if(counter < 100000000) {
			counter++; 
			i++;
			return true; 
		}
		return false;
	}
	
	public void run(){
		while(increaseCounter()){
			j++; 
		}
		System.out.append("Value of j: " + j + " Value of i: " + i + "\n");
	}	
}
