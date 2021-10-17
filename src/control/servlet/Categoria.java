package control.servlet;

import model.ProdottoBean;
import manager.ProdottoModelDM;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import com.google.gson.Gson;

//todo Gson ???

@WebServlet("/Categoria")
public class Categoria extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String categoria = request.getParameter("categoria");
        Gson gson = new Gson(); //posso convertire da java a json
        ProdottoModelDM model = new ProdottoModelDM();
        String resultJson;

        if(categoria == "tutti") {
            ArrayList<ProdottoBean> tutti = (ArrayList<ProdottoBean>) model.doRetriveAll(null);
            resultJson = gson.toJson(tutti);
        } else {
            // todo da modificare
            //ArrayList<ProdottoBean> educazione = (ArrayList<ProdottoBean>) model.doRetriveCategoria(null);
            resultJson = gson.toJson(categoria);
        }

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(resultJson);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
