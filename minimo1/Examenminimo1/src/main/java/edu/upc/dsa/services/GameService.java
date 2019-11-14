package edu.upc.dsa.services;

import edu.upc.dsa.GameManager;
import edu.upc.dsa.GameManagerImpl;
import edu.upc.dsa.models.Objeto;
import edu.upc.dsa.models.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/game", description = "Endpoint to game Service")
@Path("/game")
public class GameService {

    private GameManager g;

    public GameService() {
        this.g = GameManagerImpl.getInstance();
        if (g.Usersize() == 0) {
            g.addUser("12", "Pepe","Perez");
            g.addUser("13", "Alejandro","Pee");
            g.addObject("espada","12");
            g.addObject("espada2","13");
        }


    }

    @GET
    @ApiOperation(value = "get all users", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class, responseContainer = "List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {

        List<User> Users = this.g.UserOrden();

        GenericEntity<List<User>> entity = new GenericEntity<List<User>>(Users) {
        };
        return Response.status(201).entity(entity).build();

    }
//
    @GET
    @ApiOperation(value = "get user info", notes = "recibe toda la info de usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("id") String id) {
        User u = this.g.getinfoUser(id);
        if (u == null) return Response.status(404).build();
        else return Response.status(201).entity(u).build();
    }
    @GET
    @ApiOperation(value = "get user object", notes = "recibe todos los objetos de usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response =Objeto.class,responseContainer = "List"),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/object/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getObject(@PathParam("id") String id) {
        List<Objeto> o = this.g.getinfoUser(id).getObjetos();
        if (o == null) return Response.status(404).build();
        GenericEntity<List<Objeto>> entity = new GenericEntity<List<Objeto>>(o) {
        };
        return Response.status(201).entity(entity).build();
    }

    @PUT
    @ApiOperation(value = "update a User", notes = "actualizar usuario segun su id")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/")
    public Response updateUser(User user) {

        int err = this.g.editUser(user.getIdUser(),user);

        if ( err== -1) return Response.status(404).build();

        return Response.status(201).build();
    }


    @POST
    @ApiOperation(value = "create a new User", notes = "crear nuevo usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newUser(User user) {

        if (user.getNom()== null) return Response.status(500).entity(user).build();
        this.g.addUser(user.getIdUser(),user.getNom(),user.getApellidos());
        int i=0;
        while(i<user.getObjetos().size()) {
            this.g.addObject(user.getObjetos().get(i).getNombre(),user.getIdUser());

            i++;
        }
        return Response.status(201).entity(user).build();
    }
    @POST
    @ApiOperation(value = "create a new Object", notes = "crear nuevo objeto")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Object.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/user/{id}/objeto")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newObject(Objeto obj,@PathParam("id") String id ) {

        if (obj.getNombre()== null) return Response.status(500).entity(obj).build();
        this.g.addObject(obj.getNombre(),id);

        return Response.status(201).entity(obj).build();
    }
}

