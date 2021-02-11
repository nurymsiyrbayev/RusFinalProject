package controllers;

import models.User;
import services.UserServiceImpl;
import services.interfaces.UserService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("user")
public class UserController {
    private final UserService userService = new UserServiceImpl();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/insert")
    public Response insertUser(User user) {
        try {
            userService.insert(user);
        } catch (ServerErrorException ex) {
            return Response
                    .serverError()
                    .entity(ex.getMessage())
                    .build();

        } catch (BadRequestException ex) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(ex.getMessage())
                    .build();
        }
        return Response
                .status(Response.Status.CREATED)
                .entity("User was inserted successfully!")
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/remove/{user_id}")
    public Response removeUser(@PathParam("user_id") long id) {
        try {
            userService.remove(id);
        } catch (ServerErrorException ex) {
            return Response
                    .serverError()
                    .entity(ex.getMessage())
                    .build();

        } catch (BadRequestException ex) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(ex.getMessage())
                    .build();
        }
        return Response
                .status(Response.Status.CREATED)
                .entity("User was removed successfully!")
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/update")
    public Response updateUser(User user) {
        try {
            userService.update(user);
        } catch (ServerErrorException ex) {
            return Response
                    .serverError()
                    .entity(ex.getMessage())
                    .build();

        } catch (BadRequestException ex) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(ex.getMessage())
                    .build();
        }
        return Response
                .status(Response.Status.CREATED)
                .entity("User was updated successfully!")
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public Response getUserList() {
        List<User> userList;
        try {
            userList = userService.getUserList();
        } catch (ServerErrorException ex) {
            return Response
                    .serverError()
                    .entity(ex.getMessage())
                    .build();
        } catch (BadRequestException ex) {
            return Response
                    .status(Response.Status.ACCEPTED)
                    .entity("Users cannot be found!")
                    .build();
        }
        if (userList == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("There are no users!")
                    .build();
        } else {
            return Response
                    .status(Response.Status.OK)
                    .entity(userList)
                    .build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/search")
    public Response searchUserList(@QueryParam("userEmail") String userEmail,
                                   @QueryParam("groupId") long groupId,
                                   @QueryParam("majorId") long majorId,
                                   @QueryParam("graduateYear") int graduateYear) {
        List<User> userList;
        try {
            userList = userService.searchUserListByEmail(userEmail, groupId, majorId, graduateYear);
        } catch (ServerErrorException ex) {
            return Response
                    .serverError()
                    .entity(ex.getMessage())
                    .build();
        } catch (BadRequestException ex) {
            return Response
                    .status(Response.Status.ACCEPTED)
                    .entity("Users cannot be found!")
                    .build();
        }
        if (userList == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("There are no users!")
                    .build();
        } else {
            return Response
                    .status(Response.Status.OK)
                    .entity(userList)
                    .build();
        }
    }
}
