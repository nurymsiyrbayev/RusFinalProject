package servlets;

import models.Author;
import models.User;
import services.AuthorServiceImpl;
import services.interfaces.AuthorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "author")
public class AuthorServlet extends HttpServlet {
    private final AuthorService authorService = new AuthorServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("getAll")){
            List<Author> authors = authorService.getAuthorList();

            request.setAttribute("authors" , authors);

            request.getRequestDispatcher("authorPage.jsp").forward(request, response);
        } else if (action.equals("getAuthor")){
            long authorId = Long.parseLong(request.getParameter("authorId"));

            request.setAttribute("author", authorService.select(authorId));

            request.getRequestDispatcher("singleAuthorPage.jsp").forward(request,response);
        }
    }
}
