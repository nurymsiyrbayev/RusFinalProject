package controllers;

import models.Club;
import models.User;
import services.ClubServiceImpl;
import services.UserServiceImpl;
import services.interfaces.ClubService;
import services.interfaces.UserService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("club")
public class ClubController {
    private final ClubService clubService = new ClubServiceImpl();
    private final UserService userService = new UserServiceImpl();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/remove/{clubId}")
    public Response removeClub(@PathParam("clubId") long id){
        try {
            clubService.remove(id);
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
                .entity("Club was removed successfully!")
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public Response getClubList() {
        List<Club> clubList;
        try {
            clubList = clubService.getClubList();
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
        if (clubList == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("There are no clubs!")
                    .build();
        } else {
            return Response
                    .status(Response.Status.OK)
                    .entity(clubList)
                    .build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/update")
    public Response updateClub(Club club) {
        try {
            clubService.update(club);
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
                .entity("Club was updated successfully!")
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/update/owner/{clubId}/{ownerEmail}")
    public Response updateClub(@PathParam("clubId") long clubId, @PathParam("ownerEmail") String newOwnerEmail) {
        Club club = clubService.select(clubId);
        User newOwner = userService.getUserByLoginDate(newOwnerEmail);
        club.setClubOwnerId(newOwner.getId());
        try {
            clubService.update(club);
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
                .entity("Club was updated successfully!")
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{clubId}")
    public Response getClub(@PathParam("clubId") long id) {
        Club club;
        try {
            club = clubService.select(id);
        } catch (ServerErrorException ex) {
            return Response
                    .serverError()
                    .entity(ex.getMessage())
                    .build();
        } catch (BadRequestException ex) {
            return Response
                    .status(Response.Status.ACCEPTED)
                    .entity("Event cannot be found!")
                    .build();
        }
        if (club == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("There are no such event!")
                    .build();
        } else {
            return Response
                    .status(Response.Status.OK)
                    .entity(club)
                    .build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/insert/{userEmail}")
    public Response inserClub(@PathParam("userEmail") String email, Club club) {
        User user;
        try {
            user = userService.getUserByLoginDate(email);
            club.setClubOwnerId(user.getId());
            clubService.insert(club);
        } catch(ServerErrorException ex) {
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
                .entity("Club was inserted successfully!")
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/join/{userId}/{clubId}")
    public Response joinToClub(@PathParam("userId") long userId,@PathParam("clubId") long clubId) {
        try {
            clubService.addUserRequestsToJoinTheClub(userId,clubId);
        } catch(ServerErrorException ex) {
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
                .entity("User request to join was inserted successfully!")
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/member/add/{clubId}/{memberId}")
    public Response addUserToClub(@PathParam("memberId") long userId,@PathParam("clubId") long clubId) {
        try {
            clubService.addUserToClub(userId,clubId);
            clubService.removeUserRequestsToJoinTheClub(userId,clubId);
        } catch(ServerErrorException ex) {
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
                .entity("Member was added successfully!")
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/member/remove/{clubId}/{memberId}")
    public Response removeMember(@PathParam("memberId") long userId,@PathParam("clubId") long clubId) {
        try {
            clubService.removeUserFromClub(userId,clubId);
        } catch(ServerErrorException ex) {
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
                .entity("Member was removed successfully!")
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/joinRequest/remove/{clubId}/{memberId}")
    public Response removeUserRequestsToJoinTheClub(@PathParam("memberId") long userId,@PathParam("clubId") long clubId) {
        try {
            clubService.removeUserRequestsToJoinTheClub(userId,clubId);
        } catch(ServerErrorException ex) {
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
                .entity("User request to join was canceled successfully!")
                .build();
    }

}
