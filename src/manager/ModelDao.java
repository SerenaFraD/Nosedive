package manager;

import java.sql.SQLException;
import java.util.List;
import model.Bean;
import model.UtenteBean;

public interface ModelDao<T, S> {

    static UtenteBean doRetrieveByEmail(String email) throws SQLException {
        return null;
    }

    /*public void doSavePar(Bean bean) throws SQLException;*/

    default void doSave(T bean) throws SQLException {

    }

    void doUpdate(T bean) throws SQLException;

    void doDelete(T bean) throws SQLException;

    T doRetrieveByKey(List<S> keys) throws SQLException;

    List<T> doRetrieveAll() throws SQLException;
}
