package main;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class Frontend extends AbstractHandler implements Abonent, Runnable{
	private static String GAME_NAME = "/test/";
	private Address address;
	private MessageSystem ms;
	
	private Map<String, Integer> nameToId = new HashMap<String, Integer>();
	
	public Frontend(MessageSystem ms){
		this.ms = ms;
		this.address = new Address();
		ms.addService(this);
	}
	
	public void run(){
		while(true){
			ms.execForAbonent(this);
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
        
		String name = "Tully";
		Integer id = nameToId.get(name);
		if(id != null){
			response.getWriter().println("<h1>User name: " + name + " Id: " + id +"</h1>");
		} else {
			response.getWriter().println("<h1>Wait for authorization</h1>");
			Address addressAS =  ms.getAddressService().getAddress(AccountService.class);
			ms.sendMessage(new MsgGetUserId(getAddress(), addressAS, name));
		}
	}
	
	public void setId(String name, Integer id){
		nameToId.put(name, id);
	}
}
