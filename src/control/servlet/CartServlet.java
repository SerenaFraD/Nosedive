package control.servlet;


import model.Cart;
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

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    static ProductModelDM model = new ProductModelDM();


    public CartServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        @SuppressWarnings("unchecked")
        HttpSession session = request.getSession();
        Cart cart = (Cart) request.getSession().getAttribute("carrello");
        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("carrello", cart);
        }

        String sort = request.getParameter("sort");

        String action = request.getParameter("action");

        try {
            if (action != null) {
                if (action.equals("addCart")) {
                    String id = request.getParameter("id");
                    ProductBean bean = model.doRetrieveByKey(id);
                    if (bean != null && !bean.isEmpty()) {
                        if (cart.alReadyIn(bean)) {
                            cart.incrementItem(bean);
                        } else
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
                }
            }
        } catch (NumberFormatException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
            request.setAttribute("error", e.getMessage());
        }

        session.setAttribute("cart", cart);


        /*RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Cart.jsp");
        requestDispatcher.forward(request, response);*/
        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/Cart.jsp"));

    }
}
