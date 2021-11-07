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
        RequestDispatcher requestDispatcher;
        HttpSession session = request.getSession();
        UtenteDao modelUtente = new UtenteDao();
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
                    requestDispatcher = this.getServletContext().getRequestDispatcher("/message.jsp");
                } else {
                    session.setMaxInactiveInterval(60 * 60);
                    request.getSession().setAttribute("utente", saved);
                    requestDispatcher = this.getServletContext().getRequestDispatcher("/homepage.jsp");
                    requestDispatcher.forward(request, response);
                }
            } catch (SQLException e) {
                request.setAttribute("messaggio", "Errore");
                requestDispatcher = request.getServletContext().getRequestDispatcher("/error.jsp");
            }
            requestDispatcher.forward(request, response);

        } catch (NullPointerException e) {
            System.out.println("sono qui aaaa");
        }

    }
}
