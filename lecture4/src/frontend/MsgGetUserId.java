package frontend;

import messageSystem.MsgToAS;
import base.AccountService;
import base.Address;

public class MsgGetUserId extends MsgToAS {

	public MsgGetUserId(Address from, Address to) {
		super(from, to);
	}

	public void exec(AccountService accountService) {
		System.out.print("Address of Account Service: " + accountService.getAddress().getAbonentId() + '\n');
		accountService.getMessageSystem().sendMessage(new MsgUpdateUserId(getTo(), getFrom()));
	}
}
