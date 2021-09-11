package control.servlet;

import model.InfoUtenteBean;
import model.UtenteBean;
import model.Azione;
import model.Lavoro;
import model.Relazione;
import exception.IllegalArgumentException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;

@WebServlet("/updateInfo")
public class ModifyUserInfo {
    private static final long serialVersionUID = 1L;
    private final InfoUtenteBean info = new InfoUtenteBean();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            if (request.getSession().getAttribute("utente") != null)
                throw new IllegalArgumentException("Utente loggato.");
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        String lavoro = request.getParameter("lavoro");
        String relazione = request.getParameter("relazione");
        String file = request.getParameter("file");

        Lavoro lavoroObj = new Lavoro();

        ArrayList<String> lista = new ArrayList<String>();
        lista.addAll(lavoroObj.getKey());

        if(!lavoro.isEmpty()) {
            int id_lavoro = 0;
            int i = 0;

            while(i <= lista.size() && lista.get(i) != lavoro) {
                i++;
            }

            if(i < lista.size()) {
                id_lavoro =
            }
        }



        InfoUtenteBean info = new InfoUtenteBean();


        try {
            utenteDAO.doSavePar(utente);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        request.getSession().setAttribute("utente", utente);

        request.setAttribute("message", "Modifica effettuata con successo.");

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
        requestDispatcher.forward(request, response);
    }
}
