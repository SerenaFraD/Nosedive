package control.servlet;

import model.ProductBean;
import model.ProductModelDM;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    static ProductModelDM model = new ProductModelDM();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        //System.out.println("Dentro AdminServlet");

        if (action != null && action.equals("insert")) {
            String name = request.getParameter("name");
            String codProd = request.getParameter("codProd");
            String link = request.getParameter("img");
            String description = request.getParameter("description");
            int price = Integer.parseInt(request.getParameter("price"));
            String marca = request.getParameter("brand");
            String disponibilita = request.getParameter("availability");
            String offerta = request.getParameter("offer");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            String misure = request.getParameter("measure");
            String stagione = request.getParameter("season");
            String materiale = request.getParameter("material");
            String impiego = request.getParameter("use");

            ProductBean bean = new ProductBean();
            bean.setNome(name);
            bean.setCodiceProd(codProd);
            bean.setImg(link);
            bean.setDescrizione(description);
            bean.setPrezzo(price);
            bean.setMarca(marca);
            bean.setDisponibilita(disponibilita);
            bean.setOfferta(offerta);
            bean.setQuantita(quantity);
            bean.setMisure(misure);
            bean.setStagione(stagione);
            bean.setMateriale(materiale);
            bean.setImpiego(impiego);


            try {
                model.doSave(bean);
                if (request.getParameter("categoria").equals("Carrozzeria")) model.doSaveCarr(bean);
                if (request.getParameter("categoria").equals("Pneumatici")) model.doSavePneu(bean);
                if (request.getParameter("categoria").equals("Meccanica")) model.doSaveMecc(bean);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            request.setAttribute("message", "Prodotto " + bean.getNome() + " Aggiunto");
            response.sendRedirect(request.getContextPath() + "/prodotti");
        }

        if (action != null && action.equals("Delete")) {
            String codProd = request.getParameter("codProdEl");
            ProductBean product = null;
            try {
                product = model.doRetrieveByKey(codProd);
                if (codProd.contains("P")) {
                    model.doDelete(product, "pneumatici");
                    model.doDelete(product, "prodotto");
                } else if (codProd.contains("M")) {
                    model.doDelete(product, "meccanica");
                    model.doDelete(product, "prodotto");
                } else if (codProd.contains("C")) {
                    model.doDelete(product, "carrozzeria");
                    model.doDelete(product, "prodotto");
                } else throw new SQLException();

            } catch (SQLException e) {
                e.printStackTrace();
            }
            request.setAttribute("message", "Prodotto " + product.getNome() + " Eliminato");
            response.sendRedirect(request.getContextPath() + "/prodotti");
        }
    }
}
