package control.servlet;

import manager.InformazioniUtenteDao;
import model.InformazioniUtenteBean;
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
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

@WebServlet("/login")
public class Login extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        UtenteBean utenteBean = null;
        InformazioniUtenteBean utenteInformazioni;
        InformazioniUtenteDao model = null;

        try {
            utenteBean = (UtenteBean) session.getAttribute("utente");
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        if (action.equals("login")) {
            if (utenteBean == null) { // non c'é nessun utente loggato
                String email = request.getParameter("email");
                String password = request.getParameter("pwd");

                UtenteBean utenteLoggin = null; //creo un nuovo utenteBean

                try {
                    utenteLoggin = UtenteDao.doRetrieveByEmail(email);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

                //assegno al nuovo bean tutti i campi
                if (utenteLoggin != null) {
                    MessageDigest digest = null;

                    try {
                        digest = MessageDigest.getInstance("SHA-1");
                    } catch (NoSuchAlgorithmException e) {
                        e.printStackTrace();
                    }

                    digest.reset();
                    digest.update(password.getBytes(StandardCharsets.UTF_8));
                    String passHash = String.format("%040x", new BigInteger(1, digest.digest()));

                    if (utenteLoggin.getPassword().equals(passHash)) {
                        utenteBean = new UtenteBean();
                        utenteBean.setSupervisor(utenteLoggin.isSupervisor());
                        utenteBean.setNome(utenteLoggin.getNome());
                        utenteBean.setId_utente(utenteLoggin.getId());
                        utenteBean.setEmail(utenteLoggin.getEmail());
                        utenteBean.setPasswordhash(utenteLoggin.getPassword());

                        utenteInformazioni = new InformazioniUtenteBean();
                        try {
                            utenteInformazioni = model.doRetrieveByKey(utenteBean.getId());
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }

                        //assegno l'utente e le sue informazioni alla sessione
                        session.setAttribute("utente", utenteBean);
                        session.setAttribute("informazioniUtente", utenteInformazioni);

                    } else { //passw sbagliata
                        RequestDispatcher requestDispatcher = request.getServletContext().getRequestDispatcher("/login.jsp");
                        request.setAttribute("error", "Password errata");
                        requestDispatcher.forward(request, response);
                    }

                } else { // utente non esiste
                    RequestDispatcher requestDispatcher = request.getServletContext().getRequestDispatcher("/login.jsp");
                    request.setAttribute("error", "Utente non trovato");
                    requestDispatcher.forward(request, response);
                }
            }

            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/Homepage"));

        } else if (action.equals("logout")) {
            if (utenteBean != null) {
                session.removeAttribute("utente");
                session.removeAttribute("informazioni");
            }
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/index.jsp"));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
