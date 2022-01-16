package com.davydenko.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "/FilterLogin",urlPatterns = {"/withFilter/*"})
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
        HttpSession session =req.getSession(false);

        if (session.getAttribute("user") == null ) {
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            System.out.println("haven't com.davydenko.access");
            //req.getRequestDispatcher("/login.jsp").forward(req,resp);
            //session.getServletContext().getRequestDispatcher("/login.jsp").forward(req,resp);
            resp.sendRedirect("/RentalCityTransport/login.jsp");
            return;
        }
            System.out.println("com.davydenko.access granted for session id:"
                    + session.getId());
            filterChain.doFilter(servletRequest,servletResponse);
            return;

    }


    @Override
    public void destroy() {
        System.out.println("destroy filter");
        //Filter.super.destroy();
    }
}
