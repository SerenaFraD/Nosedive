package manager;

import java.sql.SQLException;
import java.util.List;

public interface ModelDao<T, S> {
    /*public void doSavePar(Bean bean) throws SQLException;*/

    void doSave(T bean) throws SQLException;

    void doUpdate(T bean) throws SQLException;

    void doDelete(T bean);

    T doRetrieveByKey(S keys) throws SQLException;

    List<T> doRetrieveAll() throws SQLException;
}
