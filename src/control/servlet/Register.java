package control.servlet;

import manager.InformazioniUtenteDao;
import model.InformazioniUtenteBean;
import model.UtenteBean;
import manager.UtenteDao;
import exception.IllegalArgumentException;
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
import java.util.List;

@WebServlet("/register")
public class Register extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UtenteDao utenteDao = new UtenteDao();
        UtenteBean utente;
        InformazioniUtenteDao infoDao = new InformazioniUtenteDao();
        InformazioniUtenteBean info;
        String message;

        if (session.getAttribute("utente") != null) {
            //non dovrei mai trovarmi in questa situazione
            request.setAttribute("messaggio", "Sei già autenticato. Per creare un nuovo account devi prima fare logout.");
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/message.jsp"));
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
                response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/error.jsp"));
            } else {
                try {
                    if (utenteDao.doRetrieveByEmail(email) != null) {
                        request.setAttribute("messaggio", "Email già presente, provare una nuova mail");
                        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/error.jsp"));
                    }

                    utente = new UtenteBean();
                    utente.setEmail(email);
                    utente.setNome(nome);
                    utente.setSupervisor(false);
                    utente.setPassword(pwd);

                    utenteDao.doSave(utente);

                    info = new InformazioniUtenteBean();
                    info.setId_utente(utenteDao.doRetrieveByEmail(email).getId_utente());
                    info.setCompleanno(bd);

                    request.getSession().setAttribute("utente", utente);
                    request.getSession().setAttribute("info", info);
                    request.setAttribute("messaggio", "Registrazione effettuata con successo.");
                    //response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/message.jsp"));

                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
                    requestDispatcher.forward(request, response);
                } catch (SQLException e) {
                    System.out.println("Errore nella query");
                }
            }
        }
    }
}


/*
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
        requestDispatcher.forward(request, response);

 */