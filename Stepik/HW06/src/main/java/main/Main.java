package main;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import resources.ResourceServer;
import resources.TestResource;
import servlets.PathHandlerServlet;

import javax.management.*;
import java.lang.management.ManagementFactory;

public class Main {
    public static void main(String[] args) throws Exception {
        ResourceServer rs = new ResourceServer(new TestResource("Bob", 25));
        //ResourceServerMBean resourceServer = new ResourceServer(new TestResource("Bob", 20));
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("Admin:type=ResourceServerController");
        mbs.registerMBean(rs, name);


        Server server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(new PathHandlerServlet(rs)), PathHandlerServlet.PAGE_URL);
        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{context});
        server.setHandler(handlers);

        server.start();
        System.out.println("Server started");

    }
}
