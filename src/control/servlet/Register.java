package control.servlet;

import model.UtenteBean;
import manager.UtenteDao;
import utils.Validator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/register")
public class Register extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher;
        HttpSession session = request.getSession();
        UtenteDao utenteDao = new UtenteDao();
        UtenteBean utente;
        String message;

        if (session.getAttribute("utente") != null) {
            //non dovrei mai trovarmi in questa situazione
            request.setAttribute("messaggio", "Sei già autenticato. Per creare un nuovo account devi prima fare logout.");
            requestDispatcher = request.getRequestDispatcher(request.getContextPath() + "/message.jsp");
            requestDispatcher.forward(request, response);
        } else {
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String pwd = request.getParameter("pwd");
            String pwdConf = request.getParameter("pwdConf");
            String bd = request.getParameter("eta");

            Validator validator = new Validator(email, nome, pwd, pwdConf);
            if (validator.wrongInput()) {
                message = validator.nameMSG + validator.emailMSG + validator.pwdMSG + validator.matchMSG;
                request.setAttribute("messaggio", message);
                requestDispatcher = this.getServletContext().getRequestDispatcher("/error.jsp");
                requestDispatcher.forward(request, response);
            } else {
                try {
                    if (utenteDao.doRetrieveByEmail(email) != null) {
                        request.setAttribute("messaggio", "Email già presente, provare una nuova mail");
                        requestDispatcher = this.getServletContext().getRequestDispatcher("/error.jsp");
                        requestDispatcher.forward(request, response);
                    }

                    utente = new UtenteBean();
                    utente.setEmail(email);
                    utente.setNome(nome);
                    utente.setSupervisor(false);
                    utente.setPassword(pwd);
                    utente.setCompleanno(bd);

                    utenteDao.doSave(utente);

                    request.getSession().setAttribute("utente", utente);
                    request.setAttribute("messaggio", "Registrazione effettuata con successo.");
                    requestDispatcher = this.getServletContext().getRequestDispatcher("/message.jsp");
                    requestDispatcher.forward(request, response);
                } catch (SQLException e) {
                    System.out.println("Errore nella query");
                }
            }
        }
    }
}
