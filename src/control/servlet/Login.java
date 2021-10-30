package control.servlet;

import model.UtenteBean;
import manager.UtenteDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import java.sql.SQLException;

@WebServlet("/login")
public class Login extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        UtenteDao modelUtente = new UtenteDao();
        InformazioniUtenteDao modelInfo = new InformazioniUtenteDao();
        UtenteBean saved;
        String email, password;

        System.out.println("sono qui hey");

        try {
            email = request.getParameter("email");
            password = request.getParameter("pwd");

            try {
                saved = modelUtente.doRetrieveByEmail(email);
                if (saved == null || !saved.getPassword().equals(password)) {
                    request.setAttribute("messaggio", "Utente non trovato");
                    response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/message.jsp"));
                } else {

                    session.setMaxInactiveInterval(60 * 60);
                    session.setAttribute("utente", saved);





                    RequestDispatcher requestDispatcher = request.getServletContext().getRequestDispatcher("/homepage.jsp");
                    requestDispatcher.forward(request, response);
                }
            } catch (SQLException e) {
                request.setAttribute("messaggio", "Errore");
                response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/error.jsp"));
            }

        } catch (NullPointerException e) {
            System.out.println("sono qui aaaa");
        }
    }
}
