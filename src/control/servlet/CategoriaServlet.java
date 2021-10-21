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

@WebServlet("/Categoria")
public class CategoriaServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String categoria = request.getParameter("categoria");
        Gson gson = new Gson(); //posso convertire da java a json
        ProdottoDao model = new ProdottoDao();
        String resultJson;

        if(categoria == "tutti") {
            ArrayList<ProdottoBean> result = null;
            try {
                result = (ArrayList<ProdottoBean>) model.doRetrieveAll(); //manco l'inglese certa gente
            } catch (SQLException e) {
                e.printStackTrace();
            }
            resultJson = gson.toJson(result);
        } else {
            List<ProdottoBean> result = null;
            try {
                result = model.doRetrieveByKey(categoria);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            resultJson = gson.toJson(result);
        }

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(resultJson);
    }
}
