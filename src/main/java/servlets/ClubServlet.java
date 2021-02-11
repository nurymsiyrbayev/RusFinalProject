package servlets;

import models.Club;
import models.User;
import services.ClubServiceImpl;
import services.interfaces.ClubService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "club")
public class ClubServlet extends HttpServlet {
    private final ClubService clubService = new ClubServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("getAll")){
            List<Club> clubs = clubService.getClubList();

            request.setAttribute("clubs" , clubs);

            request.getRequestDispatcher("clubPage.jsp").forward(request, response);
        } else if (action.equals("getClub")){
            long clubId = Long.parseLong(request.getParameter("clubId"));

            request.setAttribute("club", clubService.select(clubId));
            request.setAttribute("owner", clubService.getClubOwnerByClubId(clubId));
            request.setAttribute("userJoinRequests", clubService.getMembershipRequestsByClubId(clubId));

            List<User> members = clubService.getMembersByClubId(clubId);
            request.setAttribute("members", members);

            request.getRequestDispatcher("singleClubPage.jsp").forward(request,response);
        }
    }
}
