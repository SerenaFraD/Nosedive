package control.servlet;

import com.google.gson.Gson;
import manager.PostDao;
import model.PostBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@SuppressWarnings("unchecked")
@WebServlet("/postShow")
public class PostServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int utente = Integer.parseInt(request.getParameter("utente"));
        boolean flag = Boolean.parseBoolean(request.getParameter("flag"));
        Gson gson = new Gson(); //posso convertire da java a json
        PostDao model = new PostDao();
        String resultJson;

        List<PostBean> result = null;

        try {
            //prima chiamata utente è il punteggio dell'utente, seconda chiamata utente è id_utente
            result = (flag)? (List<PostBean>) model.doRetrieveHomepage(utente) : (List<PostBean>) model.doRetrieveProfile(utente);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        resultJson = gson.toJson(result);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(resultJson);
    }
}

