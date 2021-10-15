package control.servlet;

import model.Cart;
import model.ProductBean;
import model.ProductModelDM;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/ProductControl")
public class ProductControl extends HttpServlet {

    private static final long serialVersionUID = 1L;

    static ProductModelDM model = new ProductModelDM();


    public ProductControl() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        @SuppressWarnings("unchecked")
        Cart cart = (Cart) request.getSession().getAttribute("carrello");
        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("carrello", cart);
        }

        String sort = request.getParameter("sort");

        String action = request.getParameter("action");

        try {
            if (action != null) {
                if (action.equals("details")) {
                    String id = request.getParameter("id");
                    request.removeAttribute("product");
                    request.setAttribute("product", model.doRetrieveByKey(id));
                } else if (action.equals("addCart")) {
                    String id = request.getParameter("id");
                    ProductBean bean = model.doRetrieveByKey(id);
                    if (bean != null && !bean.isEmpty()) {
                        cart.addItem(bean);
                        request.setAttribute("message", "Product " + bean.getNome() + " added to cart");
                    }
                } else if (action.equals("clearCart")) {
                    cart.deleteItems();
                    request.setAttribute("message", "Cart cleaned");
                } else if (action.equals("deleteCart")) {
                    String id = request.getParameter("id");
                    ProductBean bean = model.doRetrieveByKey(id);
                    if (bean != null && !bean.isEmpty()) {
                        cart.deleteItem(bean);
                        request.setAttribute("message", "Product " + bean.getNome() + " deleted from cart");
                    }
                } else if (action.equals("insert")) {
                    String nome = request.getParameter("nome");
                    String descrizione = request.getParameter("descrizione");
                    int prezzo = Integer.parseInt(request.getParameter("prezzo"));

                    ProductBean bean = new ProductBean();
                    bean.setNome(nome);
                    bean.setDescrizione(descrizione);
                    bean.setPrezzo(prezzo);

                    model.doSave(bean);
                    request.setAttribute("message", "Product " + bean.getNome() + " added");
                } else if (action.equals("delete")) {
                    String id = request.getParameter("id");
                    ProductBean bean = model.doRetrieveByKey(id);
                    if (bean != null && !bean.isEmpty()) {
                        model.doDelete(bean, "prodotto");
                        request.setAttribute("message", "Product " + bean.getNome() + " deleted");
                    }
                } else if (action.equals("update")) {
                    String id = request.getParameter("id");
                    String nome = request.getParameter("nome");
                    String descrizione = request.getParameter("descrizione");
                    int prezzo = Integer.parseInt(request.getParameter("prezzo"));

                    ProductBean bean = new ProductBean();
                    bean.setCodiceProd(id);
                    bean.setNome(nome);
                    bean.setDescrizione(descrizione);
                    bean.setPrezzo(prezzo);

                    model.doUpdate(bean);
                    request.setAttribute("message", "Product " + bean.getNome() + " updated");
                }
            }
        } catch (NumberFormatException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
            request.setAttribute("error", e.getMessage());
        }

        request.setAttribute("cart", cart);

        try {
            request.removeAttribute("offerte");
            request.setAttribute("offerte", model.doRetriveOfferte(sort));
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            request.setAttribute("error", e.getMessage());
        }

        request.removeAttribute("pneumatici");
        request.setAttribute("pneumatici", model.doRetrivePneumatici(sort));

        request.removeAttribute("products");
        request.setAttribute("products", model.doRetriveAll(sort));

        request.removeAttribute("carrozzerie");
        request.setAttribute("carrozzerie", model.doRetriveCarrozzeria(sort));

        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/ProductView.jsp");
        dispatcher.forward(request, response);
    }
}
