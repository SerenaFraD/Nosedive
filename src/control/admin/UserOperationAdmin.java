

public class UserOperationAdmin extends HttpServlet {
    private static final long serialVersionUID = 1L;
    static UtenteDao model = new UtenteDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");

        if (action != null && action.equals("insertUser")) {
        	String id_utente = request.getParameter("id_utente");
            String email = request.getParameter("email");
            String nome = request.getParameter("nome");
            int sup = Integer.parseInt(request.getParameter("sup"));

            UtenteBean bean = new UtenteBean();
            bean.setId_utente(id_utente);
            bean.setEmail(email);
            bean.setNome(nome);
           
            bean.setAuth(sup);
        }

            try {
                model.doSave(bean);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            response.sendRedirect(request.getContextPath() + "/Admin/userManagement.jsp");

        }

        if (action != null && action.equals("deleteUser")) {
            //Elimina utente
        }

        if (action != null && action.equals("modifyUser")) {
        	String id_utente = request.getParameter("id_utente");
            String email = request.getParameter("email");
            String nome = request.getParameter("nome");
            int sup = Integer.parseInt(request.getParameter("sup"));

            UtenteBean bean = new  UtenteBean();
            bean.setId_utente(id_utente);
            bean.setEmail(email);
            bean.setNome(nome);
        }

            try {
                model.doUpdate(bean);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            response.sendRedirect(request.getContextPath() + "/Admin/userManagement.jsp");

        }

        if (action != null && action.equals("retrieveAll")) {
            try {
                request.setAttribute("utenti", model.doRetrieveAll());
            } catch (SQLException e) {
                e.printStackTrace();
            }

            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/Admin/userManagement.jsp");
            dispatcher.forward(request, response);
        }

    }
}
