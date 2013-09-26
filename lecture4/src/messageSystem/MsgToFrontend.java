package messageSystem;

import base.Abonent;
import base.Address;
import base.Frontend;
import base.Msg;

public abstract class MsgToFrontend extends Msg{

	public MsgToFrontend(Address from, Address to) {
		super(from, to);
	}

	public void exec(Abonent abonent) {
		if(abonent instanceof Frontend){
			exec((Frontend)abonent);
		}
	}
	
	public abstract void exec(Frontend frontend);
}
