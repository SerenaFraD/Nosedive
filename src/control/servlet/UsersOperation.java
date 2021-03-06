package control.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;

import manager.UtenteDao;
import model.UtenteBean;

@WebServlet("/Utenti")
public class UsersOperation extends HttpServlet {
    private static final long serialVersionUID = 1L;
    static UtenteDao model = new UtenteDao();

    public UsersOperation() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String action = request.getParameter("action");
        //System.out.println("Dentro UserOperation");

        if (action != null && action.equals("Insert")) {
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String pwd = request.getParameter("pws");

            UtenteBean bean = new UtenteBean();
            bean.setNome(nome);
            bean.setEmail(email);
            bean.setPasswordhash(pwd);

            try {
                model.doSave(bean);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            request.setAttribute("message", "Utente " + bean.getNome() + " aggiunto");
            response.sendRedirect(request.getContextPath() + "/utente");
        } else {
            System.out.println();
        }

        if (action != null && action.equals("Delete")) {
            String idUtente = request.getParameter("id_utente");
            UtenteBean user = null;

            try {
                user = model.doRetrieveByKey(Collections.singletonList(idUtente));
                model.doDelete(user);
                throw new SQLException();

            } catch (SQLException e) {
                e.printStackTrace();
            }
            request.setAttribute("message", "Prodotto " + user.getNome() + " eliminato");
            response.sendRedirect(request.getContextPath() + "/utenti.jsp");
        } else {
            System.out.println();
        }
    }
}
