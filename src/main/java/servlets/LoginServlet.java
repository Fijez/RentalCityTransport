package servlets;

import database.DBoperations;
import database.DButils;
import org.h2.engine.Constants;
import org.h2.engine.User;
import users.Admin;
import users.Tenant;
import utils.Access;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet(name = "loginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter pw = resp.getWriter();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        ServletContext servletContext = getServletContext();

        try {
            users.User user = DBoperations.selectUser(login);
            if (user.getPassword().equals(password)) {
                HttpSession session = req.getSession(true);
                session.setAttribute(user.getLogin(), user);
                resp.setCharacterEncoding("UTF-8");

                servletContext.getRequestDispatcher("/closedAccess/main.jsp").forward(req, resp);
            }else {
                System.out.println("in else");
                //servletContext.getRequestDispatcher("/login").include(req,resp);
                resp.sendRedirect("login.jsp");
            }
            } catch (SQLException e) {
            System.out.println("catch in login servlet");
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            req.setAttribute("error", "Ошбика в login.jsp");
            servletContext.getRequestDispatcher("/login.jsp").forward(req, resp);
        }

    }

}
