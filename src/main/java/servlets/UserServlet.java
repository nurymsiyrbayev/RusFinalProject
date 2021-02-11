package servlets;

import exception.BadLoginException;
import models.GenericSetClass;
import models.Group;
import models.Major;
import models.User;
import services.GroupServiceImpl;
import services.MajorServiceImpl;
import services.UserServiceImpl;
import services.interfaces.GroupService;
import services.interfaces.MajorService;
import services.interfaces.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

@WebServlet(name = "UserServlet")
public class UserServlet extends HttpServlet {
    private final UserService userService = new UserServiceImpl();
    private final GroupService groupService = new GroupServiceImpl();
    private final MajorService majorService = new MajorServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        PrintWriter out = response.getWriter();

        if (action.equals("login")) {
            String email = request.getParameter("email");
            String pass = request.getParameter("pass");
            String remember = request.getParameter("remember");

            User signedUser = userService.getUserByLogin(email, pass);

            try {
                if (signedUser != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("signedUser", signedUser);

                    if (remember != null) {
                        Cookie cookie = new Cookie("userEmail", email);
                        cookie.setMaxAge(60*60*24*7);
                        response.addCookie(cookie);
                    } else {
                        Cookie[] cookies = request.getCookies();
                        for (Cookie cookie : cookies) {
                            if (cookie.getName().contains("userEmail")) {
                                cookie.setValue("");
                                cookie.setMaxAge(0);
                                response.addCookie(cookie);
                            }
                        }
                    }
                    response.setStatus(200);
                } else {
                    throw new BadLoginException("Wrong Credentials");
                }
            } catch (BadLoginException e) {
                response.setStatus(401);
                out.print(e.getMessage());
                out.flush();
            }
        } else if (action.equals("logout")) {
            HttpSession session = request.getSession();
            Cookie[] cookies = request.getCookies();

            session.invalidate();
            for (Cookie cookie : cookies) {
                if (cookie.getName().contains("userEmail")) {
                    cookie.setValue("");
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }

            request.getRequestDispatcher("loginPage.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // For student search page
        List<Integer> graduateYears = userService.getGraduateYears();
        List<Group> groupList = groupService.getGroupList();

        GenericSetClass<Major> majorGenericSetClass = majorService.getAllMajors();
        Set<Major> majorSet = majorGenericSetClass.getSet();

        request.setAttribute("graduateYears", graduateYears);
        request.setAttribute("groupList", groupList);
        request.setAttribute("majorSet", majorSet);

        request.getRequestDispatcher("studentSearchPage.jsp").forward(request, response);
    }
}