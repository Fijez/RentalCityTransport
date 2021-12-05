package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "/FilterLogin",urlPatterns = {"/jsp/*","/servlets/withLockFilter/*"})
public class FilterLogin implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //Filter.super.init(filterConfig);
        System.out.println("filter ready");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session =req.getSession(true);
        //можно убрать пакеты в servlets и jsp и поставить условие
        //на то, является ли файл login или loginServlet
        if (session.getAttribute("user") == null) {
            System.out.println("haven't access");
           resp.sendRedirect("login.jsp");
        } else {
            System.out.println("access granted for session id:"
                    + session.getId());
            filterChain.doFilter(servletRequest,servletResponse);

        }
    }

    @Override
    public void destroy() {
        System.out.println("destroy filter");
        //Filter.super.destroy();
    }
}
