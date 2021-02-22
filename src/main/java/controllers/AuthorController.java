package controllers;

import models.Author;
import models.User;
import services.AuthorServiceImpl;
import services.UserServiceImpl;
import services.interfaces.AuthorService;
import services.interfaces.UserService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("author")
public class AuthorController {
    private final AuthorService authorService = new AuthorServiceImpl();
    private final UserService userService = new UserServiceImpl();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/remove/{authorId}")
    public Response removeClub(@PathParam("authorId") long id){
        try {
            authorService.remove(id);
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
                .entity("Автор был успешно удален!")
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public Response getClubList() {
        List<Author> authorList;
        try {
            authorList = authorService.getAuthorList();
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
        if (authorList == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("Нету ни одного автора!")
                    .build();
        } else {
            return Response
                    .status(Response.Status.OK)
                    .entity(authorList)
                    .build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/update")
    public Response updateAuthor(Author author) {
        try {
            authorService.update(author);
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
                .entity("Клуб был успешно обновлен!")
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{authorId}")
    public Response getClub(@PathParam("authorId") long id) {
        Author author;
        try {
            author = authorService.select(id);
        } catch (ServerErrorException ex) {
            return Response
                    .serverError()
                    .entity(ex.getMessage())
                    .build();
        } catch (BadRequestException ex) {
            return Response
                    .status(Response.Status.ACCEPTED)
                    .entity("Автор не был найден!")
                    .build();
        }
        if (author == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("Автор не существует!")
                    .build();
        } else {
            return Response
                    .status(Response.Status.OK)
                    .entity(author)
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
            authorService.insert(club);
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
            authorService.addUserRequestsToJoinTheClub(userId,clubId);
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
            authorService.addUserToClub(userId,clubId);
            authorService.removeUserRequestsToJoinTheClub(userId,clubId);
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
            authorService.removeUserFromClub(userId,clubId);
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
            authorService.removeUserRequestsToJoinTheClub(userId,clubId);
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
