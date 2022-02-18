package control.servlet;

import manager.CategoriaDao;
import manager.ProdottoDao;
import model.Categoria;
import model.ProdottoBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/aggiungiProdotto")
public class AddProdottoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String descrizione = request.getParameter("descrizione");
        double costo = Double.parseDouble(request.getParameter("costo"));
        int pMin = Integer.parseInt(request.getParameter("punteggio"));
        String categoria = request.getParameter("categoria");

        String fileName = request.getParameter("file");
        ProdottoDao prodottoDao = new ProdottoDao();
        CategoriaDao categoriaDao = new CategoriaDao();

        ProdottoBean bean = new ProdottoBean();
        bean.setPunteggio_min(pMin);

        try {
            Categoria cat = categoriaDao.doRetrieveByKey(categoria);
            bean.setCategoria(cat.getId_categoria());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        bean.setNome(nome);
        bean.setCosto(costo);
        bean.setDescrizione(descrizione);
        bean.setImg(fileName);

        try {
            prodottoDao.doSave(bean);
        }  catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/webapp/prodotti.jsp"));
    }
}