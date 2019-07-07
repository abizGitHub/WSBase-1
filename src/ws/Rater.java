package ws;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Rater implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setCharacterEncoding("UTF-8");
        try {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            Object attribute = request.getSession().getAttribute("XX");
            //System.out.println(":::" + attribute);
            if (attribute == null) {
                request.getSession().setAttribute("XX", "SID:" + request.getSession().getId());
            }

            System.err.println(request.getRemoteAddr() + "> " + request.getRequestURI() + "    -> called");
            filterChain.doFilter(servletRequest, servletResponse);
            /*if (request.getSession().getAttribute("role") != null) {
                if (request.getSession().getAttribute("role").equals("register1"))
                {   filterChain.doFilter(servletRequest,servletResponse);
                }
                if (request.getRequestURI().split("/")[1]
                        .equals(request.getSession().getAttribute("role"))||
                        request.getRequestURI().split("/")[1]
                                .equals("customer")) {
                    filterChain.doFilter(servletRequest, servletResponse);
                } else {
                    servletRequest.getRequestDispatcher("../error.jsp").forward(servletRequest, servletResponse);
                }
            } else {
                servletRequest.getRequestDispatcher("../index.jsp").forward(servletRequest, servletResponse);
            }*/
        } catch (Exception e) {
            servletRequest.getRequestDispatcher("error.jsp").forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
