package main;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.server.nio.SelectChannelConnector;

public class Main {

	public static void main(String[] args) throws Exception {
		simpleServer();
	}
	
	private static void simpleServer() throws Exception, InterruptedException {
		Server server = new Server(8080);
        server.setHandler(new JettyServer());
        
        server.start();
        server.join();
	}
	
	private static void withStaticServer() throws Exception, InterruptedException {
		Server server = new Server();
    	
        SelectChannelConnector connector = new SelectChannelConnector();
        connector.setPort(8080);
        server.addConnector(connector);
 
        ResourceHandler resource_handler = new ResourceHandler();
        resource_handler.setDirectoriesListed(true);
        resource_handler.setWelcomeFiles(new String[]{ "index.html" });
 
        resource_handler.setResourceBase(".");
 
        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[] { resource_handler, new JettyServer() });
        server.setHandler(handlers);
 
        server.start();
        server.join();
	}
	

}
