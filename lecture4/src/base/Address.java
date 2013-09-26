package base;

import java.util.concurrent.atomic.AtomicInteger;

public class Address {
	static private AtomicInteger abonentIdCreator = new AtomicInteger();
	final private int abonentId;

	public static Address getNew(){
		return new Address();
	}
	
	public int getAbonentId() {
		return abonentId;
	}
	
	private Address(){
		this.abonentId = abonentIdCreator.incrementAndGet();
	}	
}

