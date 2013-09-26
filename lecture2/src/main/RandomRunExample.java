package main;

import java.util.logging.Logger;

public class RandomRunExample extends Thread {
	//private static Logger log = Logger.getLogger("ClassName");
	
	public void run(){
		System.out.println(Thread.currentThread().getName());
		//log.info(Thread.currentThread().getName());
	}
	
	public static void example(){
		for(int i=0; i<10; ++i){
			Thread thread = new RandomRunExample();
			thread.start();
		}
	}
}
