package control.servlet;

import model.ProdottoBean;
import manager.ProdottoDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    static ProdottoDao model = new ProdottoDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");

        if (action != null && action.equals("insert")) {
            String name = request.getParameter("name");

            String descrizione = request.getParameter("descrizione");
            Blob img = (Blob) request.getSession().getAttribute("img");
            int costo = Integer.parseInt(request.getParameter("costo"));
            int id_categoria = Integer.parseInt(request.getParameter("categoria"));
            int pMin = Integer.parseInt(request.getParameter("punteggio"));

            ProdottoBean bean = new ProdottoBean();
            bean.setNome(name);
            bean.setDescrizione(descrizione);
            bean.setCosto(costo);
            bean.setCategoria(id_categoria);
            bean.setPunteggio_min(pMin);
            bean.setImg(img);

            request.setAttribute("message", "Prodotto " + bean.getNome() + " Aggiunto");
            response.sendRedirect(request.getContextPath() + "/prodotti");
        }

        if (action != null && action.equals("Delete")) {
            int id_prodotto = Integer.parseInt(request.getParameter("id_prodotto"));
            ProdottoBean product = null;
            try {
                product = model.doRetrieveByKey(id_prodotto);
                model.doDelete(product);
                throw new SQLException();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            request.setAttribute("message", "Prodotto " + product.getNome() + " eliminato");
            response.sendRedirect(request.getContextPath() + "/prodotti");
        }
    }
}
