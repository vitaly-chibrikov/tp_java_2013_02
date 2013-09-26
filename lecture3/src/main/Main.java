package main;

import org.eclipse.jetty.server.Server;

public class Main {
	public static void main(String[] args) throws Exception {
		MessageSystem ms = new MessageSystem();
		
		Frontend frontend = new Frontend(ms);
		AccountService accountService = new AccountService(ms);
		
		(new Thread(frontend)).start();
		(new Thread(accountService)).start();

		Server server = new Server(8080);
        server.setHandler(frontend);
        
        server.start();
        server.join();
	}
}
