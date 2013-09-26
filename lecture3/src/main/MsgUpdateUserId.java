package main;

public class MsgUpdateUserId extends MsgToFrontend {

	private String name;
	private Integer id;
	
	public MsgUpdateUserId(Address from, Address to, String name, Integer id) {
		super(from, to);
		this.name = name;
		this.id = id;
	}

	void exec(Frontend frontend) {
		frontend.setId(name, id);
	}

}
