package frontend;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import base.Address;
import base.Frontend;
import base.MessageSystem;

import utils.TimeHelper;

public class FrontendImpl extends AbstractHandler implements Frontend, Runnable{
	private static String GAME_NAME = "/test/";
	private Address address = Address.getNew();
	private MessageSystem messageSystem;
	
	public FrontendImpl(MessageSystem messageSystem){
		this.messageSystem = messageSystem;
	}
	
	public void run(){
		while(true){
			messageSystem.execForAbonent(this);
			TimeHelper.sleep(10);
		}
	}

	public Address getAddress() {
			return address;
	}

	public void handle(String target, Request baseRequest,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        baseRequest.setHandled(true);
        
		if(!target.equals(GAME_NAME))
			return;
        
        response.getWriter().println("<h1>"+ Thread.currentThread().getName() +"</h1>");
        
        Address addressAS =  messageSystem.getAddressService().getAddressAS();
        messageSystem.sendMessage(new MsgGetUserId(getAddress(), addressAS));
	}
	
	public MessageSystem getMessageSystem(){
		return messageSystem;
	}
}
