package Rest;


import Services.SystemModuleService;
import domain.SystemFeature;
import domain.SystemModule;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("systemmodules")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class SystemModulesResource {

    @Inject
    SystemModuleService systemModuleService;

    @POST
    public void createSystemModule(SystemModule systemModule) {

        systemModuleService.createSystemModule(systemModule);
    }

    @POST
    @Path("/{id}/feature")
    public void createFeature(@PathParam("id") long id, SystemFeature systemFeature) {

        systemModuleService.createSystemFeature(id, systemFeature);
    }

    @GET
    @Path("/{id}")
    public SystemModule getSystemModule(@PathParam("id") long id){
        return systemModuleService.getSystemModule(id);
    }

    @GET
    public List<SystemModule> getSystemModules(){
        return systemModuleService.getAllSystemModules();
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