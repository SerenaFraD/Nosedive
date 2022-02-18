package control.servlet;

import model.ProdottoBean;
import manager.ProdottoDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

@WebServlet("/categoria")
public class CategoriaServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String categoria = request.getParameter("categoria");
        Gson gson = new Gson(); //posso convertire da java a json
        ProdottoDao model = new ProdottoDao();

        try {
        switch (categoria) {
            case "tutti":
                ArrayList<ProdottoBean> tutti = (ArrayList<ProdottoBean>) model.doRetrieveAll();
                String resultJson0 = gson.toJson(tutti);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(resultJson0);
                break;

            case "educazione":
                ArrayList<ProdottoBean> educazione = (ArrayList<ProdottoBean>) model.doRetrieveByKey("educazione");
                String resultJson1 = gson.toJson(educazione);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(resultJson1);
                break;

            case "internet":
                ArrayList<ProdottoBean> internet = (ArrayList<ProdottoBean>) model.doRetrieveByKey("internet");
                String resultJson2 = gson.toJson(internet);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(resultJson2);
                break;

            case "affitti":
                ArrayList<ProdottoBean> affitti = (ArrayList<ProdottoBean>) model.doRetrieveByKey("affitti");
                String resultJson3 = gson.toJson(affitti);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(resultJson3);
                break;
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
