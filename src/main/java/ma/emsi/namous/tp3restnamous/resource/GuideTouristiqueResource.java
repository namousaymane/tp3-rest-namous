package ma.emsi.namous.tp3restnamous.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("guide")
public class GuideTouristiqueResource {
    @GET
    @Path("lieu/{ville_ou_pays}")
    @Produces("application/json")
    /*
    public String endroitsDeVisite(@PathParam("ville_ou_pays") String villeOuPays) {
        return villeOuPays;
    }
    */
    public String[] endroitsDeVisite(@PathParam("ville_ou_pays") String villeOuPays) {
        return new String[]{villeOuPays};
    }
}
