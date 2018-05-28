package Rest;


import Services.CountryService;
import Services.SystemModuleService;
import domain.Country;
import domain.SystemModule;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
@Path("country")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class CountryResource {

    @Inject
    CountryService countryService;

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    public Country createCountry(Country country) {
        return countryService.createCountry(country.getName(), country.getExternal().equals("true"));
    }

    @GET
    @Path("/{id}")
    public Country getCountry(@PathParam("id") Long id){
        return countryService.getCountry(id);
    }


    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public List<Country> getCountries(){
        return countryService.getCountries();
    }




}