package control.servlet;



import manager.ProdottoDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/prodotti")
public class Prodotti extends HttpServlet {

    private static final long serialVersionUID = 1L;

    static ProdottoDao model = new ProdottoDao();

    public Prodotti() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.removeAttribute("products");

        // I'll figure out something


        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/prodotti.jsp");
        dispatcher.forward(request, response);
    }
}
