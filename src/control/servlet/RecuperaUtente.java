package control.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

import manager.UtenteDao;
import model.UtenteBean;

@WebServlet("/recuperaUtente")
public class RecuperaUtente extends HttpServlet {

    public RecuperaUtente() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UtenteDao utenteDao = new UtenteDao();
        UtenteBean bean;
        int id_utente = Integer.parseInt(request.getParameter("otherUtente"));

        try {
            bean = utenteDao.doRetrieveByKey(id_utente);
            request.getSession().setAttribute("otherUtente", bean);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("userprofile.jsp");
            requestDispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
