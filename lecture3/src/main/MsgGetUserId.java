package main;

public class MsgGetUserId extends MsgToAS {
	private String name;
	
	public MsgGetUserId(Address from, Address to, String name) {
		super(from, to);
		this.name= name;
	}

	void exec(AccountService accountService) {
		Integer id = accountService.getUserId(name);
		accountService.getMessageSystem().sendMessage(new MsgUpdateUserId(getTo(), getFrom(), name, id));
	}
}
