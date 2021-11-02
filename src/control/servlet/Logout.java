package control.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Logout extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        session.invalidate();
        request.setAttribute("messaggio", "Logout effettuato con successo");
        RequestDispatcher requestDispatcher = request.getServletContext().getRequestDispatcher("/messaggio.jsp");
        requestDispatcher.forward(request, response);
    }
}
