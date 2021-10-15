package control.servlet;

import manager.InformazioniUtenteDao;
import manager.LavoroDao;
import manager.RelazioneDao;
import model.InformazioniUtenteBean;
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

@WebServlet("/informazioni")
public class InformazioniUtente extends HttpServlet {
    private final InformazioniUtenteDao model = new InformazioniUtenteDao();
    private final RelazioneDao relazioneModel = new RelazioneDao();
    private final LavoroDao lavoroModel = new LavoroDao();
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        @SuppressWarnings("unchecked")
        UtenteBean myProfile = (UtenteBean) request.getSession().getAttribute("mioProfilo");
        UtenteBean otherProfile = (UtenteBean) request.getSession().getAttribute("altroProfilo");
        InformazioniUtenteBean bean = null;

        String action = request.getParameter("action");

        try {
            if (action != null) {
                if (action.equals("updateInfoUtente") && otherProfile == null) {
                    String lavoro = request.getParameter("lavoro");
                    String relazione = request.getParameter("relazione");
                    Blob image = (Blob) request.getSession().getAttribute("image");

                    bean = new InformazioniUtenteBean();
                    bean.setId_utente(myProfile.getId());
                    bean.setId_relazione(relazioneModel.doRetrieveByKey(relazione).getId_relazione());
                    bean.setId_lavoro(lavoroModel.doRetrieveByKey(lavoro).getId_lavoro());
                    bean.setPropic(image);

                    model.doUpdateUtente(bean);
                    request.setAttribute("message", "Informazioni di " + myProfile.getNome() + " aggiornate");

                } else if (action.equals("updateInfoUtente") && otherProfile == null && myProfile.isSupervisor()) {
                    Boolean sesso = Boolean.valueOf(request.getParameter("sesso"));
                    Boolean deceduto = Boolean.valueOf(request.getParameter("deceduto"));

                    bean = new InformazioniUtenteBean();
                    bean.setId_utente(myProfile.getId());
                    bean.setSesso(sesso);
                    bean.setDeceduto(deceduto);

                    model.doUpdateAdmin(bean);
                    request.setAttribute("message", "Informazioni di " + myProfile.getNome() + " aggiornate");
                } else if (action.equals("retriveInfoUtente")) {
                    Blob image = (Blob) request.getSession().getAttribute("image");

                    bean = new InformazioniUtenteBean();
                    bean = model.doRetrieveByKey(myProfile.getId());

                    request.setAttribute("lavoro", lavoroModel.doRetrieveByKey(bean.getId_lavoro()));
                    request.setAttribute("relazione", relazioneModel.doRetrieveByKey(bean.getId_relazione()));
                }
            }
        } catch (SQLException | NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
            request.setAttribute("error", e.getMessage());
        }

        request.setAttribute("informazioni", bean);

        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/userinfo.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}