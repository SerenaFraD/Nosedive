package control.servlet;

import model.UtenteBean;
import manager.UtenteDao;
import utils.Validator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
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

        Cookie myCookie = new Cookie("utenteLoggato", "true");
        myCookie.setMaxAge(60 * 60);
        myCookie.setPath("/");
        myCookie.setHttpOnly(true); //accesso nei js
        myCookie.setSecure(true);
        response.addCookie(myCookie);

        response.setContentType("text/jsp");

        System.out.println("Sono in register");


        if (session.getAttribute("utente") != null) {
            //non dovrei mai trovarmi in questa situazione
            request.setAttribute("messaggio", "Sei già autenticato. Per creare un nuovo account devi prima fare logout.");

            requestDispatcher = this.getServletContext().getRequestDispatcher("/webapp/message.jsp");
            requestDispatcher.forward(request, response);
        } else {
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            System.out.println(email);
            String pwd = request.getParameter("pwd");
            String pwdConf = request.getParameter("pwdConf");
            String bd = request.getParameter("eta");

            Validator validator = new Validator(email, nome, pwd, pwdConf);

            if (validator.wrongInput()) {
                System.out.println("Errore validazione");
                request.setAttribute("messaggio", "Errore nell'inserimento dei dati");
                requestDispatcher = this.getServletContext().getRequestDispatcher("/webapp/message.jsp");
                requestDispatcher.forward(request, response);
            } else {
                try {
                    if (utenteDao.doRetrieveByEmail(email) != null) {
                        System.out.println("Email già presente, provare una nuova mail");
                        session.setAttribute("messaggio", "Email già presente, provare una nuova mail");
                        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/webapp/message.jsp"));
                        /*
                        requestDispatcher = this.getServletContext().getRequestDispatcher("/webapp/message.jsp");
                        requestDispatcher.forward(request, response);
                         */
                    } else {
                        utente = new UtenteBean();
                        utente.setEmail(email);
                        utente.setNome(nome);
                        utente.setPassword(pwd);
                        utente.setSupervisor(false);

                        utenteDao.doSavePar(utente);

                        System.out.println("Registrazione effettuata con successo.");
                        session.setAttribute("messaggio", "Registrazione effettuata con successo.");
                        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/webapp/message.jsp"));

                    }
                } catch (SQLException e) {
                    System.out.println(e);
                    session.setAttribute("messaggio", "Qualcosa e' andato male");
                    response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/webapp/message.jsp"));
                }

                /*
                request.setAttribute("messaggio", "Registrazione effettuata con successo.");
                requestDispatcher = this.getServletContext().getRequestDispatcher("/webapp/message.jsp");
                requestDispatcher.forward(request, response);
                 */
            }
        }
    }
}
