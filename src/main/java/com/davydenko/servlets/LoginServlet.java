package com.davydenko.servlets;

import com.davydenko.access.DaoConfiguration;
import com.davydenko.access.UserDao.OperationsDB;
import com.davydenko.model.entity.UserEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "loginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

        //PrintWriter pw = resp.getWriter();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        ServletContext servletContext = getServletContext();
        System.out.println("in loginServlet doPost");
        try {
            ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DaoConfiguration.class);
            OperationsDB operationsDB = (OperationsDB) applicationContext.getBean("operationsDB");
            UserEntity user = operationsDB.selectUserByLogin(login);// OperationsDB.selectUserByLogin(login);
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
            }
            catch (ServletException | IOException e) {
            System.out.println("catch in login servlet");
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            req.setAttribute("error", "error in login.jsp");
                try {
                    servletContext.getRequestDispatcher("/login.jsp").forward(req, resp);
                } catch (ServletException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

    }

}
