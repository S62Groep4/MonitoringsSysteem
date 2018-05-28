package Rest;


import Services.SystemModuleService;
import com.sun.deploy.net.HttpRequest;
import domain.HttpGetRequest;
import domain.SystemFeature;
import domain.SystemModule;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
@Path("status")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class SystemStatusResource {

    @Inject
    SystemModuleService systemModuleService;




    @GET
    @Path("/{id}")
    public List<HttpGetRequest> getSystemModules(@PathParam("id") int id){
        SystemFeature systemFeature = systemModuleService.getFeatureModule(id);
        return systemFeature.getStatusHistory();
    }


    @PUT
    public void updateSystemModule(SystemModule systemModule)
    {
        systemModuleService.updateSystemModule(systemModule);
    }

    @DELETE
    public void removeSystemModule(int systemModuleId) {

        throw new WebApplicationException(Response.Status.METHOD_NOT_ALLOWED);
    }





}