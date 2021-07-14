package manager;

import java.sql.SQLException;
import java.util.List;
import model.Bean;
import model.UtenteBean;

public interface ModelDao {

    static UtenteBean doRetrieveByEmail(String email) throws SQLException {
        return null;
    }

    /*public void doSavePar(Bean bean) throws SQLException;*/

    default void doSave(UtenteBean bean) throws SQLException {

    }

    void doUpdate(UtenteBean bean) throws SQLException;

    void doDelete(UtenteBean bean) throws SQLException;

    Bean doRetrieveByKey(List<String> keys) throws SQLException;

    List<Bean> doRetrieveAll() throws SQLException;
}
