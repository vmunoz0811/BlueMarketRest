package co.edu.unbosque.BlueMarketRest.resources;

import co.edu.unbosque.BlueMarketRest.dtos.ExceptionMessage;
import co.edu.unbosque.BlueMarketRest.dtos.User;
import co.edu.unbosque.BlueMarketRest.services.UserService;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.servlet.ServletContext;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Path("/users")
public class UsersResource {

    @Context
    ServletContext context;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        try {
            List<User> users = new UserService().getUsers();

            return Response.ok()
                    .entity(users)
                    .build();
        } catch (IOException e) {
            return Response.serverError().build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response createForm(
            @FormParam("username") String username,
            @FormParam("password") String password,
            @FormParam("name") String name,
            @FormParam("lastname") String lastname,
            @FormParam("mail") String mail,
            @FormParam("fcoins") String fcoins

    ) {
        String contextPath = context.getRealPath("") + File.separator;
        System.out.println("Entró");
        try {
            User user = new UserService().createUser(username, name, lastname, mail, password, fcoins, contextPath);
            System.out.println("creo el usuario");
            return Response.created(UriBuilder.fromResource(UsersResource.class).path(username).build())
                    .entity(user)
                    .build();
        } catch (IOException e) {
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("username") String username) {
        try {
            List<User> users = new UserService().getUsers();

            User user = users.stream()
                    .filter(u -> u.getUsername().equals(username))
                    .findFirst()
                    .orElse(null);

            if (user != null) {
                return Response.ok()
                        .entity(user)
                        .build();
            } else {
                return Response.status(404)
                        .entity(new ExceptionMessage(404, "User not found"))
                        .build();
            }
        } catch (IOException e) {
            return Response.serverError().build();
        }
    }


}