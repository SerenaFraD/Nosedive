package control.servlet;

import manager.CommentoDao;
import manager.PostDao;
import model.CommentoBean;
import model.PostBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/postCommento")
public class PublishCommentServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String testo = request.getParameter("testo");
        int id_post = Integer.parseInt(request.getParameter("id_post"));
        int id_utente = (int) request.getSession().getAttribute("id_utente");
        CommentoBean commento = new CommentoBean();
        CommentoDao commentoDao = new CommentoDao();

        commento.setId_post(id_post);
        commento.setTimestamp(java.time.LocalTime.now().toString());
        commento.setId_utente(id_utente);
        commento.setTesto(testo);

        try {
            commentoDao.doSave(commento);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/homepage.jsp"));
    }
}
