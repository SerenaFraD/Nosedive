package control.servlet;

import manager.UtenteDao;
import model.UtenteBean;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "SearchServlet", value = "/SearchServlet")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String chiave = request.getParameter("chiave");
        try {
            UtenteBean utente = UtenteDao.doRetrieveByEmail(chiave);
            if (utente != null) {
                request.getSession().setAttribute("ricercato", utente);
                response.sendRedirect(response.encodeRedirectURL("userinfo.jsp?email=" + utente.getEmail()));
            } else
                response.sendRedirect(response.encodeRedirectURL("index.jsp"));


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
