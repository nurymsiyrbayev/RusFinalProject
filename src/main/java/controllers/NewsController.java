package controllers;

import models.GenericQueueClass;
import models.News;
import services.NewsServiceImpl;
import services.interfaces.NewsService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("news")
public class NewsController {
    private final NewsService newsService = new NewsServiceImpl();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/insert")
    public Response insertNews(News news) {
        try {
            newsService.insert(news);
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
                .entity("News was inserted successfully!")
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/remove/{news_id}")
    public Response removeNews(@PathParam("news_id") long id) {
        try {
            newsService.remove(id);
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
                .entity("News was removed successfully!")
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/update")
    public Response updateNews(News news) {
        try {
            newsService.update(news);
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
                .entity("News was updated successfully!")
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{news_id}")
    public Response getNews(@PathParam("news_id") long id) {
        News news;
        try {
            news = newsService.select(id);
        } catch (ServerErrorException ex) {
            return Response
                    .serverError()
                    .entity(ex.getMessage())
                    .build();
        } catch (BadRequestException ex) {
            return Response
                    .status(Response.Status.ACCEPTED)
                    .entity("News cannot be found!")
                    .build();
        }
        if (news == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("There are no such news!")
                    .build();
        } else {
            return Response
                    .status(Response.Status.OK)
                    .entity(news)
                    .build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public Response getNewsQueue() {
        GenericQueueClass<News> newsQueue;
        try {
            newsQueue = newsService.getNewsQueue();
        } catch (ServerErrorException ex) {
            return Response
                    .serverError()
                    .entity(ex.getMessage())
                    .build();
        } catch (BadRequestException ex) {
            return Response
                    .status(Response.Status.ACCEPTED)
                    .entity("News cannot be found!")
                    .build();
        }
        if (newsQueue.getQueue() == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("There are no news!")
                    .build();
        } else {
            return Response
                    .status(Response.Status.OK)
                    .entity(newsQueue)
                    .build();
        }
    }
}
