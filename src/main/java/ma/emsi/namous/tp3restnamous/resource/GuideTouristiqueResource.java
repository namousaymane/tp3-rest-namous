package ma.emsi.namous.tp3restnamous.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.inject.Inject;
import ma.emsi.namous.tp3restnamous.llm.LlmClient;

@Path("guide")
public class GuideTouristiqueResource {
    @Inject
    private LlmClient llmClient;

    /**
     * Retourne les informations touristiques d'une ville ou d'un pays
     * au format JSON, en utilisant Gemini avec LangChain4j.
     * @param villeOuPays nom de la ville ou du pays
     * @return les informations touristiques au format JSON
     */
    @GET
    @Path("lieu/{ville_ou_pays}/{nombre}")
    @Produces("application/json")
    public String endroitsDeVisite(
            @PathParam("ville_ou_pays") String villeOuPays, @PathParam("nombre") int nombre) {

        return llmClient.conversation(villeOuPays + nombre);
    }
}
