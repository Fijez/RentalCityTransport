package com.accenture.davydenko.servlets;

import com.accenture.davydenko.access.DaoConfig;
import com.accenture.davydenko.access.UserDao;
import com.accenture.davydenko.model.entity.UserEntity;
import com.accenture.davydenko.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
@Controller
@WebServlet(name = "loginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    UserService user;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //PrintWriter pw = resp.getWriter();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        ServletContext servletContext = getServletContext();
        System.out.println("in loginServlet doPost");
        ApplicationContext context = new AnnotationConfigApplicationContext
                ("com/accenture/davydenko/access/");
//        try {
        UserDao ud= context.getBean(UserDao.class);
         UserEntity user =
                 //ud.findByLogin();
            //context.getBean(UserDao.class);
        UserDao.selectUser(login);
            HttpSession session = req.getSession(true);
            session.setAttribute("user",user);
            if (user != null && user.getPassword().equals(password)) {
                System.out.println("LoginServlet if");
                //req.setAttribute("login", user);
                servletContext.getRequestDispatcher("/withFilter/main.jsp")
                        .forward(req, resp);
            }
            else {
                System.out.println("in else");
                //resp.sendRedirect("login.jsp");
                session.removeAttribute("user");
                servletContext.getRequestDispatcher("/login.jsp")
                        .forward(req, resp);
                }
//            }
//        catch (SQLException e) {
//            System.out.println("catch in login servlet");
//            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            req.setAttribute("error", "error in login.jsp");
//            servletContext.getRequestDispatcher("/login.jsp").forward(req, resp);
//        }

    }

}
