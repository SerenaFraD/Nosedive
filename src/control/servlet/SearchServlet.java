package control.servlet;

import manager.UtenteDao;
import model.UtenteBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
    UtenteDao modelUtente = new UtenteDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String chiave = request.getParameter("chiave");

        try {
            List<UtenteBean> utente = modelUtente.doRetrieveByName(chiave);

            if (utente != null) {
                request.getSession().setAttribute("result", utente);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("results.jsp");
                requestDispatcher.forward(request, response);
            }
        } catch (SQLException | ServletException throwables) {
            throwables.printStackTrace();
        }
    }
}
