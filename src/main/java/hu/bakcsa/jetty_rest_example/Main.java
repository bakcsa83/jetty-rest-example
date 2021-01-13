package hu.bakcsa.jetty_rest_example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private final static Logger logger= LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        int port = 8090;
        //String contextPath="/";
        String contextPath="/rest";

        ExampleServer server=new ExampleServer(port, contextPath);
    }
}
