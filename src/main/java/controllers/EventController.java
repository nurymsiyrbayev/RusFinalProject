package controllers;

import models.Event;

import models.GenericStackClass;
import services.EventServiceImpl;
import services.interfaces.EventService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("event")
public class EventController {
    private final EventService eventService = new EventServiceImpl();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/insert")
    public Response insertEvent(Event event){
        try{
            eventService.insert(event);
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
                .entity("Event was inserted successfully!")
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/remove/{eventId}")
    public Response removeEvent(@PathParam("eventId") long id){
        try {
            eventService.remove(id);
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
                .entity("Event was removed successfully!")
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public Response getEventStack() {
        GenericStackClass<Event> eventStack;
        try {
            eventStack = eventService.getEventStack();
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
        if (eventStack.getStack() == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("There are no events!")
                    .build();
        } else {
            return Response
                    .status(Response.Status.OK)
                    .entity(eventStack)
                    .build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/update")
    public Response updateNews(Event event) {
        try {
            eventService.update(event);
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
                .entity("Event was updated successfully!")
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{eventId}")
    public Response getEvent(@PathParam("eventId") long id) {
        Event event;
        try {
            event = eventService.select(id);
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
        if (event == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("There are no such event!")
                    .build();
        } else {
            return Response
                    .status(Response.Status.OK)
                    .entity(event)
                    .build();
        }
    }
}
