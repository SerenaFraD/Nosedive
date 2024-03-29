package manager;

import java.sql.SQLException;
import java.util.List;

import model.UtenteBean;

public interface ModelDao<T, S> {
    /*public void doSavePar(Bean bean) throws SQLException;*/

    void doSave(T bean) throws SQLException;

    void doUpdate(T bean) throws SQLException;

    void doDelete(T bean) throws SQLException;

    T doRetrieveByKey(S keys) throws SQLException;

    List<T> doRetrieveAll() throws SQLException;
}
