package control.servlet;

import manager.PostDao;
import model.PostBean;
import model.UtenteBean;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

//todo, da eliminare cosaa??? Rispondimi serena del passato
@WebServlet(name = "Homepage", value = "/Homepage")
public class Homepage extends HttpServlet {

    private final PostDao model = new PostDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ArrayList<PostBean> listapost;
        try {
            listapost = model.doRetrieveAll();
            listapost.forEach(System.out::println);
            request.getSession().setAttribute("listapost", listapost);
            response.sendRedirect(response.encodeRedirectURL("homepage.jsp"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        if (request.getAttribute("action").equals("post")) {

            String textarea = request.getParameter("textarea");
            PostBean pb = new PostBean();
            pb.setTesto(textarea);
            pb.setId_utente(((UtenteBean) request.getSession().getAttribute("utente")).getId_utente());
            try {
                model.doSave(pb);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
}
