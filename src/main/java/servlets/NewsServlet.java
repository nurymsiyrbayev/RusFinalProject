package servlets;

import models.GenericQueueClass;
import models.News;
import services.NewsServiceImpl;
import services.interfaces.NewsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Queue;

@WebServlet(name = "NewsServlet")
public class NewsServlet extends HttpServlet {
    private final NewsService newsService = new NewsServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GenericQueueClass<News> newsGenericQueueClass = newsService.getNewsQueue();
        Queue<News> newsQueue = newsGenericQueueClass.getQueue();
        request.setAttribute("newsQueue", newsQueue);
        request.getRequestDispatcher("newsPage.jsp").forward(request, response);
    }
}
