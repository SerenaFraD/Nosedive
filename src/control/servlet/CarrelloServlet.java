//todo modifica anche questa, molto sus
package control.servlet;

import model.CarrelloBean;
import model.ProdottoBean;
import manager.ProdottoDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/CartServlet")
public class CarrelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    static final ProdottoDao model = new ProdottoDao();

    public CarrelloServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession();
        CarrelloBean carrello = (CarrelloBean) request.getSession().getAttribute("carrello");
        if (carrello == null) {
            carrello = new CarrelloBean();
            request.getSession().setAttribute("carrello", carrello);
        }

        String sort = request.getParameter("sort");

        String action = request.getParameter("action");

        try {
            if (action != null) {
                switch (action) {
                    case "addCart": {
                        //Maybe errors here ----> 3 day later, I was right
                        int id = Integer.parseInt(request.getParameter("id"));
                        ProdottoBean bean = model.doRetrieveByKey(id);
                        carrello.addItem(bean);
                        request.setAttribute("message", "Prodotto " + bean.getNome() + " aggiunto al carrello");
                        break;
                    }
                    case "clearCart":
                        carrello.deleteAllItems();
                        request.setAttribute("message", "Cart cleaned");
                        break;
                    case "deleteCart": {
                        //Maybe errors here ----> 3 day later, I was right
                        int id = Integer.parseInt(request.getParameter("id"));
                        ProdottoBean bean = model.doRetrieveByKey(id);
                        carrello.deleteItem(bean);
                        request.setAttribute("message", "Prodotto " + bean.getNome() + " eliminato dal carrello");
                        break;
                    }
                }
            }
        } catch (NumberFormatException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
            request.setAttribute("error", e.getMessage());
        }

        session.setAttribute("cart", carrello);

        /*RequestDispatcher requestDispatcher = request.getRequestDispatcher("/cart.jsp");
        requestDispatcher.forward(request, response);*/
        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/cart.jsp"));
    }
}
