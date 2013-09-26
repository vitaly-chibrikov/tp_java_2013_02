package messageSystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import base.Abonent;
import base.Address;
import base.AddressService;
import base.MessageSystem;
import base.Msg;


public class MessageSystemImpl implements MessageSystem {
	private static int QUEUE_SIZE = 100;
	private Map<Address, ArrayBlockingQueue<Msg>> messages = new HashMap<Address, ArrayBlockingQueue<Msg>>();
	private AddressServiceImpl addressService = new AddressServiceImpl();
	
	public void addFrontend(Abonent abonent){
		addressService.setAddressFrontend(abonent.getAddress());
		messages.put(abonent.getAddress(), new ArrayBlockingQueue<Msg>(QUEUE_SIZE));
	}
	
	public void addAccountService(Abonent abonent){
		addressService.setAddressAS(abonent.getAddress());
		messages.put(abonent.getAddress(), new ArrayBlockingQueue<Msg>(QUEUE_SIZE));
	}
	
	public void sendMessage(Msg message){
		Queue<Msg> messageQueue = messages.get(message.getTo());
		messageQueue.add(message);		
	}
		
	public void execForAbonent(Abonent abonent){
		Queue<Msg> messageQueue = messages.get(abonent.getAddress());
		if(messageQueue == null){
			return;
		}
		while(!messageQueue.isEmpty()){
			Msg message = messageQueue.poll();
			message.exec(abonent);
		}
	}
	
	public AddressService getAddressService(){
		return addressService;
	}

}
