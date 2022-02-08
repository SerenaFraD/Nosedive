package control.filter;

import model.UtenteBean;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter", urlPatterns = {"/Admin/*", "/User/*", "/AdminServlet"})
public class SupFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        HttpSession session = request.getSession(false);
        UtenteBean utenteBean = (UtenteBean) session.getAttribute("utente");

        String uri = request.getRequestURI();
        if (uri.contains("/User/")) { //qualcuno tenta di accedere alle pagine utente
            if (utenteBean != null)
                chain.doFilter(req, resp); //se registrato vado avanti con i filtri
            else
                response.sendRedirect(response.encodeRedirectURL(request.getContextPath()) + "/index.jsp"); //se non é reg rimanda alla home
        } else if (uri.contains("/Admin/")) { //qualcuno tenta di accedere alle pagine admin
            if (utenteBean != null && (utenteBean.isSupervisor().equals(true))) chain.doFilter(req, resp);
            else response.sendRedirect(response.encodeRedirectURL(request.getContextPath()) + "/index.jsp");
        } else if (uri.contains("/UserServlet")) {
            if (utenteBean != null)
                chain.doFilter(req, resp); //se registrato vado avanti con i filtri
            else
                response.sendRedirect(response.encodeRedirectURL(request.getContextPath()) + "/index.jsp"); //se non é reg rimanda alla home
        } else if (uri.contains("/AdminServlet")) {
            if (utenteBean != null && (utenteBean.isSupervisor().equals(true)))
                chain.doFilter(req, resp); //se registrato vado avanti con i filtri
            else
                response.sendRedirect(response.encodeRedirectURL(request.getContextPath()) + "/index.jsp"); //se non é reg rimanda alla home
        }
    }

    public void init(FilterConfig config) {
    }
}
