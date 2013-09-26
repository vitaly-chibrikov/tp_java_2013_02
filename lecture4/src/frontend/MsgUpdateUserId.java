package frontend;

import messageSystem.MsgToFrontend;
import base.Address;
import base.Frontend;

public class MsgUpdateUserId extends MsgToFrontend {

	public MsgUpdateUserId(Address from, Address to) {
		super(from, to);
	}

	public void exec(Frontend frontend) {
		System.out.print("Address of Frontend: " + frontend.getAddress().getAbonentId() + '\n');		
	}

}
