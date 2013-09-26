package main;

import java.util.HashMap;
import java.util.Map;

public class AccountService implements Abonent, Runnable{
	private Address address;
	private MessageSystem ms;
	
	private Map<String, Integer> fakeAccounter = new HashMap<String, Integer>();
	
	public AccountService(MessageSystem ms){
		this.ms = ms;
		this.address = new Address();
		ms.addService(this);
		this.fakeAccounter.put("Tully", 1);
		this.fakeAccounter.put("Sully", 2);
	}
	
	
	public void run(){
		while(true){
				ms.execForAbonent(this);
				TimeHelper.sleep(10);
		}
	}

	public Integer getUserId(String name){
		TimeHelper.sleep(5000);
		return fakeAccounter.get(name);
	}
	
	public Address getAddress() {
		return address;
	}
	
	public MessageSystem getMessageSystem(){
		return ms;
	}
}
