package servlets;

import models.Club;
import models.Event;
import models.GenericStackClass;
import services.ClubServiceImpl;
import services.EventServiceImpl;
import services.interfaces.ClubService;
import services.interfaces.EventService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Stack;

@WebServlet(name = "EventServlet")
public class EventServlet extends HttpServlet {
    private final EventService eventService = new EventServiceImpl();
    private final ClubService clubService = new ClubServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GenericStackClass<Event> eventStack = eventService.getEventStack();
        Stack<Event> events = eventStack.getStack();

        List<Club> clubs = clubService.getClubList();

        request.setAttribute("events", events);
        request.setAttribute("clubs", clubs);

        request.getRequestDispatcher("eventPage.jsp").forward(request,response);
    }
}
