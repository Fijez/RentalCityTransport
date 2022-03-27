package servlets;

import access.UserDao.DBoperations;
import model.entity.Access;
import model.entity.UserEntity;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "loginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

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
        try {
            UserEntity user = DBoperations.selectUser(login);
            HttpSession session = req.getSession(true);
            session.setAttribute("user", user);
            if (user != null && user.getPassword().equals(password)) {
                System.out.println("LoginServlet if");
                //req.setAttribute("login", user);
                if (user.getAccess() == Access.FULL) {
                    List<UserEntity> userEntityList = DBoperations.getAllUsers();
                    //System.out.println(userEntityList);
                    session.setAttribute("getAll", userEntityList);
                    servletContext.getRequestDispatcher("/withFilter/admin.jsp")
                            .forward(req, resp);
                } else {
                    servletContext.getRequestDispatcher("/withFilter/main.jsp")
                            .forward(req, resp);
                }
            } else {
                System.out.println("in else");
                //resp.sendRedirect("login.jsp");
                session.removeAttribute("user");
                servletContext.getRequestDispatcher("/login.jsp")
                        .forward(req, resp);
            }
        } catch (SQLException e) {
            System.out.println("catch in login servlet");
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            req.setAttribute("error", "error in login.jsp");
            servletContext.getRequestDispatcher("/login.jsp").forward(req, resp);
        }

    }

}
