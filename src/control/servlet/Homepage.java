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

@WebServlet(name = "Homepage", value = "/Homepage")
public class Homepage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        ArrayList<PostBean> listapost = new ArrayList<PostBean>();
        try {
            listapost = PostDao.doRetrieveAll();
            listapost.forEach(postBean -> System.out.println(postBean));
            request.getSession().setAttribute("listapost", listapost);
            response.sendRedirect(response.encodeRedirectURL("homepage.jsp"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(request.getAttribute("action").equals("post")) {

            String textarea=request.getParameter("textarea");
            PostBean pb= new PostBean();
            pb.setTesto(textarea);
            pb.setId_utente(((UtenteBean)request.getSession().getAttribute("utente")).getId());
            try {
                PostDao.CondividiPost(pb);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
}
