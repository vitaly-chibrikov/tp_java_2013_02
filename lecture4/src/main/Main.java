package main;

import messageSystem.MessageSystemImpl;
import org.eclipse.jetty.server.Server;
import accountService.AccountServiceImpl;
import frontend.FrontendImpl;

public class Main {
	public static void main(String[] args) throws Exception {
		MessageSystemImpl messageSystem = new MessageSystemImpl();
		
		FrontendImpl frontend = new FrontendImpl(messageSystem);
		messageSystem.addFrontend(frontend);
		
		AccountServiceImpl accountService = new AccountServiceImpl(messageSystem);
		messageSystem.addAccountService(accountService);
		
		(new Thread(frontend)).start();
		(new Thread(accountService)).start();

		Server server = new Server(8080);
        server.setHandler(frontend);
        
        server.start();
        server.join();
	}
	
	protected static void test(){
	}
	
}
