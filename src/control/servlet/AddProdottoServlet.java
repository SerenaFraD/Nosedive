package control.servlet;

import manager.CategoriaDao;
import manager.ProdottoDao;
import model.ProdottoBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.SQLException;

@WebServlet("/aggiungiProdotto")
public class AddProdottoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String descrizione = request.getParameter("descrizione");
        Double costo = Double.parseDouble(request.getParameter("costo"));
        int pMin = Integer.parseInt(request.getParameter("punteggio"));
        String categoria = request.getParameter("categoria");
        Part filePart = request.getPart("file");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        InputStream fileContent = filePart.getInputStream();
        ProdottoDao prodottoDao = new ProdottoDao();
        CategoriaDao categoriaDao = new CategoriaDao();

        ProdottoBean bean = new ProdottoBean();
        bean.setPunteggio_min(pMin);

        try {
            bean.setCategoria(categoriaDao.doRetrieveByKey(categoria).getId_categoria());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        bean.setNome(nome);
        bean.setCosto(costo);
        bean.setDescrizione(descrizione);
        bean.setImg((Blob) fileContent);

        try {
            prodottoDao.doSave(bean);
        }  catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/prodotti.jsp"));
    }
}