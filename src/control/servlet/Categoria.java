package control.servlet;

import model.ProductBean;
import model.ProductModelDM;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/Categoria")
public class Categoria extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String categoria = request.getParameter("categoria");
        Gson gson = new Gson(); //posso convertire da java a json
        ProductModelDM model = new ProductModelDM();


        switch (categoria) {
            case "tutti":
                ArrayList<ProductBean> tutti = (ArrayList<ProductBean>) model.doRetriveAll(null);
                String resultJson0 = gson.toJson(tutti);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(resultJson0);
                break;

            case "carrozzeria":
                ArrayList<ProductBean> carrozzeria = (ArrayList<ProductBean>) model.doRetriveCarrozzeria(null);
                String resultJson1 = gson.toJson(carrozzeria);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(resultJson1);
                break;

            case "pneumatici":
                ArrayList<ProductBean> pneumatici = (ArrayList<ProductBean>) model.doRetrivePneumatici(null);
                String resultJson2 = gson.toJson(pneumatici);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(resultJson2);
                break;

            case "meccanica":
                ArrayList<ProductBean> meccanica = (ArrayList<ProductBean>) model.doRetriveMeccanica(null);
                String resultJson3 = gson.toJson(meccanica);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(resultJson3);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
