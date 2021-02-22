package controllers;

import models.Article;
import models.GenericQueueClass;
import services.ArticleServiceImpl;
import services.interfaces.ArticleService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("article")
public class ArticleController {
    private final ArticleService articleService = new ArticleServiceImpl();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/insert")
    public Response insertArticle(Article article) {
        try {
            articleService.insert(article);
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
                .entity("Статья была успешно добавлена!")
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/remove/{article_id}")
    public Response removeArticle(@PathParam("article_id") long id) {
        try {
            articleService.remove(id);
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
                .entity("Статья была успешно удалена!")
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/update")
    public Response updateArticle(Article article) {
        try {
            articleService.update(article);
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
                .entity("Статья была успешно обновлена!")
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{article_id}")
    public Response getArticle(@PathParam("article_id") long id) {
        Article article;
        try {
            article = articleService.select(id);
        } catch (ServerErrorException ex) {
            return Response
                    .serverError()
                    .entity(ex.getMessage())
                    .build();
        } catch (BadRequestException ex) {
            return Response
                    .status(Response.Status.ACCEPTED)
                    .entity("Статья не была найдена!")
                    .build();
        }
        if (article == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("Статья не существует!")
                    .build();
        } else {
            return Response
                    .status(Response.Status.OK)
                    .entity(article)
                    .build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public Response geArticlesQueue() {
        GenericQueueClass<Article> articleQueue;
        try {
            articleQueue = articleService.getArticlesQueue();
        } catch (ServerErrorException ex) {
            return Response
                    .serverError()
                    .entity(ex.getMessage())
                    .build();
        } catch (BadRequestException ex) {
            return Response
                    .status(Response.Status.ACCEPTED)
                    .entity("Ствтьи не найдены! ")
                    .build();
        }
        if (articleQueue.getQueue() == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("Нету ни одной статьей!")
                    .build();
        } else {
            return Response
                    .status(Response.Status.OK)
                    .entity(articleQueue)
                    .build();
        }
    }
}
