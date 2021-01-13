package hu.bakcsa.jetty_rest_example.rest.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("")
public class ExampleController {

    // http://localhost:8090/rest/John
    @GET()
    @Produces(MediaType.TEXT_PLAIN)
    public String greetings() {
        return "Hello world";
    }

    // http://localhost:8090/rest/John
    @GET()
    @Path("{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String greet(@PathParam("name")String name) {

        return "Hello "+name;
    }

    // http://localhost:8090/rest/getobj
    @GET()
    @Path("getobj")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseObject getMessage2() {
        ResponseObject response=new ResponseObject();
        response.setStringProp("test1");
        response.setIntProp(111);
        return response;
    }

    //Setting specific response status
    //Response

    // http://localhost:8090/rest/getobj-with-status
    @GET()
    @Path("getobj-with-status")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMessage3() {
        ResponseObject response=new ResponseObject();
        response.setStringProp("test2");
        response.setIntProp(222);
        return Response.status(Response.Status.CREATED).entity(response).build();
    }
}
