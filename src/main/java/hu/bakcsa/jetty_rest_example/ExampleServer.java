package hu.bakcsa.jetty_rest_example;


import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ExampleServer {
    private final Server server;
    private final static Logger logger= LoggerFactory.getLogger(ExampleServer.class);

    public ExampleServer(int port, String servletContextPath) {
        server = new Server(port);

        ServletContextHandler ctx = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);

        ctx.setContextPath(servletContextPath);
        server.setHandler(ctx);

        ServletHolder servletHolder = ctx.addServlet(ServletContainer.class, "/*");
        servletHolder.setInitOrder(1);

        //Set the package where the rest controllers are located
        servletHolder.setInitParameter("jersey.config.server.provider.packages", "hu.bakcsa.jetty_rest_example.rest.controller");

        try {
            server.start();
            server.join();
        } catch (Exception ex) {

        } finally {
            server.destroy();
        }
    }

    public void stop(){
        try {
            server.stop();
        } catch (Exception e) {
            logger.error("Embedded webserver could not be stopped",e);
        }
    }
}
