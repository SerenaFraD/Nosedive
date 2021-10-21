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
import java.util.List;

@WebServlet("/login")
public class Login extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private UtenteDao modelUtente = new UtenteDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        UtenteBean utenteBean = null;
        InformazioniUtenteBean utenteInformazioni;
        InformazioniUtenteDao model = new InformazioniUtenteDao();

        try {
            utenteBean = (UtenteBean) session.getAttribute("utente");
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        if (action.equals("login")) {
            if (utenteBean == null) { // non c'é nessun utente loggato
                String password = request.getParameter("pwd");
                String[] keys = null;
                keys[0] = (request.getParameter("email"));
                keys[1] = (password);

                UtenteBean utenteLoggin = null; //creo un nuovo utenteBean

                try {
                    //Here on 2021/10/21 I said a blasfemy caused by shitty a programmer (not me)
                    //I felt sad and hopeless for the rest of the day. -S
                    //(https://www.youtube.com/watch?v=PgK-dIPMIp4) --> mood

                    utenteLoggin = modelUtente.doRetrieveByKey(keys);
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
                        utenteBean.setId_utente(utenteLoggin.getId_utente());
                        utenteBean.setEmail(utenteLoggin.getEmail());
                        utenteBean.setPasswordhash(utenteLoggin.getPassword());

                        utenteInformazioni = new InformazioniUtenteBean();

                        try {
                            utenteInformazioni = model.doRetrieveByKey(utenteBean.getId_utente());
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

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

            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/homepage.jsp"));

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
