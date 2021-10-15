package control.servlet;



import model.ProductModelDM;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/prodotti")
public class Prodotti extends HttpServlet {

    private static final long serialVersionUID = 1L;

    static ProductModelDM model = new ProductModelDM();

    public Prodotti() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sort = request.getParameter("sort");
        request.removeAttribute("products");
        String categoria = request.getParameter("categoria");

        if (categoria == null)
            request.setAttribute("products", model.doRetriveAll(sort));
        else if (categoria.equals("carrozzeria")) {
            request.setAttribute("products", model.doRetriveCarrozzeria(null));
        } else if (categoria.equals("pneumatici")) {
            request.setAttribute("products", model.doRetrivePneumatici(null));
        } else if (categoria.equals("meccanica")) {
            request.setAttribute("products", model.doRetriveMeccanica(null));
        }

        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/Prodotti.jsp");
        dispatcher.forward(request, response);

    }
}
