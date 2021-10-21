package control.servlet;

import model.CarrelloBean;
import model.ProdottoBean;
import manager.ProdottoDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/ControlloProdottiServlet")
public class ControlloProdottoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    static ProdottoDao model = new ProdottoDao();


    public ControlloProdottoServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        @SuppressWarnings("unchecked")
        CarrelloBean cart = (CarrelloBean) request.getSession().getAttribute("carrello");
        if (cart == null) {
            cart = new CarrelloBean();
            request.getSession().setAttribute("carrello", cart);
        }

        String sort = request.getParameter("sort");

        String action = request.getParameter("action");

        try {
            if (action != null) {
                if (action.equals("dettagli")) {
                    int id = Integer.parseInt(request.getParameter("id"));
                    request.removeAttribute("prodotto");
                    request.setAttribute("prodotto", model.doRetrieveByKey(id));
                } else if (action.equals("aggiungiCarrello")) {
                    int id = Integer.parseInt(request.getParameter("id"));
                    ProdottoBean bean = model.doRetrieveByKey(id);

                    cart.addItem(bean);
                    request.setAttribute("message", "Prodotto " + bean.getNome() + " aggiunto al carrello");

                } else if (action.equals("svuotaCarrello")) {
                    cart.deleteAllItems();
                    request.setAttribute("message", "Carrello svuotato");

                } else if (action.equals("eliminaCarrello")) {
                    int id = Integer.parseInt(request.getParameter("id"));
                    ProdottoBean bean = model.doRetrieveByKey(id);

                    cart.deleteItem(bean);
                    request.setAttribute("message", "Prodotto " + bean.getNome() + " eliminato dal carrello");

                } else if (action.equals("inserisci")) {
                    String nome = request.getParameter("nome");
                    String descrizione = request.getParameter("descrizione");
                    int costo = Integer.parseInt(request.getParameter("costo"));

                    ProdottoBean bean = new ProdottoBean();
                    bean.setNome(nome);
                    bean.setDescrizione(descrizione);
                    bean.setCosto(costo);

                    model.doSave(bean);
                    request.setAttribute("message", "Prodotto " + bean.getNome() + " aggiunto");
                } else if (action.equals("elimina")) {
                    int id = Integer.parseInt(request.getParameter("id"));
                    ProdottoBean bean = model.doRetrieveByKey(id);
                    if (bean != null) {
                        model.doDelete(bean);
                        request.setAttribute("message", "Prodotto " + bean.getNome() + " eliminato");
                    }
                } else if (action.equals("aggiorna")) {
                    int id = Integer.parseInt(request.getParameter("id"));
                    String nome = request.getParameter("nome");
                    String descrizione = request.getParameter("descrizione");
                    int costo = Integer.parseInt(request.getParameter("costo"));

                    ProdottoBean bean = new ProdottoBean();
                    bean.setId_prodotto(id);
                    bean.setNome(nome);
                    bean.setDescrizione(descrizione);
                    bean.setCosto(costo);

                    model.doUpdate(bean);
                    request.setAttribute("message", "Prodotto " + bean.getNome() + " aggiornato");
                }
            }
        } catch (NumberFormatException | SQLException e) {
            System.out.println("Errore: " + e.getMessage());
            request.setAttribute("error", e.getMessage());
        }

        request.setAttribute("carrello", cart);

        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/Prodotti.jsp");
        dispatcher.forward(request, response);
    }
}
