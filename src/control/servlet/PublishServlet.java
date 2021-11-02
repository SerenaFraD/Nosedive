package control.servlet;

import manager.PostDao;
import model.PostBean;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/postPublish")
public class PublishServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String text = request.getParameter("testo");
        String img = request.getParameter("files");
        PostBean post = new PostBean();
        PostDao postDao = new PostDao();

        post.setTesto(text);
        post.setTimestamp(java.time.LocalTime.now().toString());
        post.setPostpic(img);

        try {
            postDao.doSave(post);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //todo: dispacher
    }
}
