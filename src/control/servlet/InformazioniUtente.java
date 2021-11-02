package control.servlet;

import manager.LavoroDao;
import manager.RelazioneDao;
import manager.UtenteDao;
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

@WebServlet("/Informazioni")
public class InformazioniUtente extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final UtenteDao model = new UtenteDao();
        final RelazioneDao relazioneModel = new RelazioneDao();
        final LavoroDao lavoroModel = new LavoroDao();

        @SuppressWarnings("unchecked")
        UtenteBean myProfile = (UtenteBean) request.getSession().getAttribute("utente");
        UtenteBean otherProfile = (UtenteBean) request.getSession().getAttribute("altroProfilo");
        UtenteBean bean = null;

        String action = request.getParameter("action");

        try {
            if (action != null) {
                if (action.equals("updateInfoUtente") && otherProfile == null) {
                    String lavoro = request.getParameter("lavoro");
                    String relazione = request.getParameter("relazione");
                    String image = (String) request.getSession().getAttribute("image");

                    bean = new UtenteBean();
                    bean.setId_utente(myProfile.getId_utente());
                    bean.setId_relazione(relazioneModel.doRetrieveByKey(relazione).getId_relazione());
                    bean.setId_lavoro(lavoroModel.doRetrieveByKey(lavoro).getId_lavoro());
                    bean.setPropic(image);

                    model.doUpdateUtente(bean);
                    request.setAttribute("message", "Informazioni di " + myProfile.getNome() + " aggiornate");

                } else if (action.equals("updateInfoUtente") && otherProfile == null && myProfile.isSupervisor()) {
                    boolean sesso = Boolean.parseBoolean(request.getParameter("sesso"));
                    boolean deceduto = Boolean.parseBoolean(request.getParameter("deceduto"));

                    bean = new UtenteBean();
                    bean.setId_utente(myProfile.getId_utente());
                    bean.setSesso(sesso);
                    bean.setDeceduto(deceduto);

                    model.doUpdateAdmin(bean);
                    request.setAttribute("message", "Informazioni di " + myProfile.getNome() + " aggiornate");
                } else if (action.equals("retriveInfoUtente")) {
                    Blob image = (Blob) request.getSession().getAttribute("image");

                    bean = new UtenteBean();
                    bean = model.doRetrieveByKey(myProfile.getId_utente());

                    request.setAttribute("lavoro", lavoroModel.doRetrieveByKey(bean.getId_lavoro()));
                    request.setAttribute("relazione", relazioneModel.doRetrieveByKey(bean.getId_relazione()));
                }
            }
        } catch (SQLException | NumberFormatException e) {
            request.setAttribute("error", e.getMessage());
        }

        request.setAttribute("informazioni", bean);

        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/userinfo.jsp");
        dispatcher.forward(request, response);
    }
}