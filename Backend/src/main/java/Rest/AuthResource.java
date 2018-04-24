package Rest;


import Services.SystemModuleService;
import domain.SystemModule;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.UnsupportedEncodingException;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;


@Stateless
@Path("auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class AuthResource {

    @Inject
    SystemModuleService systemModuleService;

    @POST
    @Path("/")
    public Response  getToken(SystemModule systemModule) {
        String token = null;
        try {
            token = genToken();
        } catch (UnsupportedEncodingException e) {
            throw new WebApplicationException(Response.Status.FORBIDDEN);

        }
        return Response.ok()
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                .header("Access-Control-Expose-Headers", "Authorization")
                .build();
    }


private String genToken() throws UnsupportedEncodingException {
    return Jwts.builder()
            .setSubject("static testPerson")
            .setId("15a96c27-f703-4f1b-adbd-e4c1b007cb83")
            .setIssuedAt(Date.from(Instant.ofEpochSecond(1523363772)))
            .setExpiration(Date.from(Instant.ofEpochSecond(1523367372)))
            .claim("name", "John Doe")
            .claim("admin", true)
            .signWith(SignatureAlgorithm.HS256, "LandenMonitoring".getBytes("UTF-8"))
            .compact();
}

}