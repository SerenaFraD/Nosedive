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
            } else if (tabella == "lavoro") {
                bean.setId_lavoro(lavoroModel.doRetrieveByKey(informazione).getId_lavoro());
            } else {
                bean.setPropic(informazione);
            }

            model.doUpdateUtente(bean);

        } catch (SQLException e) {
        }

        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/userinfo.jsp"));

    }
}

     /*
         if (action.equals("updateInfoUtente") && otherProfile == null && myProfile.isSupervisor()) {
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
    } catch(SQLException |
    NumberFormatException e)

    {
        request.setAttribute("error", e.getMessage());
    }

        request.setAttribute("informazioni",bean);

    RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/userinfo.jsp");
        dispatcher.forward(request,response);

      */
