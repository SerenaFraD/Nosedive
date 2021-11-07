package control.servlet;

import manager.FollowDao;
import model.UtenteBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/follow")
public class seguiServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UtenteBean utente = (UtenteBean) request.getSession().getAttribute("utente");
        UtenteBean other = (UtenteBean) request.getSession().getAttribute("otherUtente");
        FollowDao followDao = new FollowDao();

        try {
            if (followDao.doRetrieveByKey(utente, other)) {
                followDao.doDelete(utente, other);
                request.getSession().setAttribute("follow", false);
            } else {
                followDao.doSave(utente, other);
                request.getSession().setAttribute("follow", true);
            }

            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/recuperaUtente?idUtente=" + other.getId_utente()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
