package control.servlet;

import manager.UtenteDao;
import model.UtenteBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/blocco")
public class BloccoServlet  extends HttpServlet {

    public BloccoServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UtenteDao utenteDao = new UtenteDao();
        UtenteBean bean;

        int id_utente = Integer.parseInt(request.getParameter("id"));
        boolean sup = Boolean.parseBoolean(request.getParameter("sup"));
        RequestDispatcher requestDispatcher;

        try {
            bean = utenteDao.doRetrieveByKey(id_utente);
            utenteDao.doUpdateBloccato(bean);
            bean = utenteDao.doRetrieveByKey(id_utente);
            request.getSession().setAttribute("otherUtente", bean);
            requestDispatcher = request.getRequestDispatcher("/webapp/utenteAdmin.jsp");
            requestDispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}