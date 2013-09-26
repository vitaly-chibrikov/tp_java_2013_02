package accountService;

import base.AccountService;
import base.Address;
import base.MessageSystem;
import utils.TimeHelper;

public class AccountServiceImpl implements AccountService, Runnable{
	private Address address = Address.getNew();
	private MessageSystem messageSystem;
	
	public AccountServiceImpl(MessageSystem messageSystem){
		this.messageSystem = messageSystem;
	}
	
	public void run(){
		while(true){
			while(true){
				messageSystem.execForAbonent(this);
				TimeHelper.sleep(10);
			}
		}
	}

	public Address getAddress() {
		return address;
	}
	
	public MessageSystem getMessageSystem(){
		return messageSystem;
	}
}
