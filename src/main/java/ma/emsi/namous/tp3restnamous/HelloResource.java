package ma.emsi.namous.tp3restnamous;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("/hello-world")
public class HelloResource {
    /*
    @GET
    @Path("personnes/{nom}")
    @Produces("text/plain")
    public String hello(@PathParam("nom") String nom) {
        return "Hello, " + nom;
    } */


    @GET
    @Path("personnes/{nom}")
    @Produces("text/plain")
    public Response hello(@PathParam("nom") String nom) {
        return Response.ok("Hello, " + nom).build();
        //return Response.serverError().build();
    }
}