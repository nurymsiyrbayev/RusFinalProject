package servlets;

import models.Article;
import models.GenericQueueClass;
import services.ArticleServiceImpl;
import services.interfaces.ArticleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Queue;

@WebServlet(name = "article")
public class ArticleServlet extends HttpServlet {
    private final ArticleService articleService = new ArticleServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GenericQueueClass<Article> articleGenericQueueClass = articleService.getArticlesQueue();
        Queue<Article> articleQueue = articleGenericQueueClass.getQueue();
        request.setAttribute("articlesQueue", articleQueue);
        request.getRequestDispatcher("articlePage.jsp").forward(request, response);
    }
}
