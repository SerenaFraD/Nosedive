package control.servlet;

import manager.LavoroDao;
import manager.RelazioneDao;
import manager.UtenteDao;
import model.Relazione;
import model.UtenteBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

@WebServlet("/informazioniUtente")
public class InformazioniUtente extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UtenteBean bean = (UtenteBean) request.getSession().getAttribute("utente");
        String tabella = request.getParameter("tabella");
        String informazione = request.getParameter("informazione");
        final UtenteDao model = new UtenteDao();
        final RelazioneDao relazioneModel = new RelazioneDao();
        final LavoroDao lavoroModel = new LavoroDao();

        try {
            if (tabella == "relazione") {
                bean.setId_relazione(relazioneModel.doRetrieveByKey(informazione).getId_relazione());
                bean.setPunteggio(relazioneModel.doRetrieveByKey(informazione).getPunteggio());
            } else if (tabella == "lavoro") {
                bean.setId_lavoro(lavoroModel.doRetrieveByKey(informazione).getId_lavoro());
                bean.setPunteggio(lavoroModel.doRetrieveByKey(informazione).getPunteggio());
            } else if(tabella == "supervisore") {
                bean.setSupervisor(Boolean.parseBoolean(informazione));
            } else if(tabella == "deceduto") {
                bean.setDeceduto(Boolean.parseBoolean(informazione));
            } else if(tabella == "bloccato") {
                bean.setBloccato(Boolean.parseBoolean(informazione));
            } else {
                bean.setPropic(informazione);
            }

            model.doUpdateUtente(bean);

        } catch (SQLException e) {
        }

        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/userinfo.jsp"));
    }
}
