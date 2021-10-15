package manager;

import model.ProductBean;

import java.sql.SQLException;
import java.util.Collection;

public interface ProductModel<T> {

    public T doRetrieveByKey(String codiceProd) throws SQLException;

    public Collection<T> doRetriveAll(String order) throws SQLException;

    public Collection<T> doRetriveOfferte(String order) throws SQLException;

    public Collection<ProductBean> doRetrivePneumatici(String order) throws SQLException;

    public Collection<ProductBean> doRetriveCarrozzeria(String order) throws SQLException;

    public Collection<ProductBean> doRetriveMeccanica(String order) throws SQLException;

    public void doSave(T product) throws SQLException;

    public void doUpdate(T product) throws SQLException;

    public void doDelete(T product, String table) throws SQLException;
    //volendo possiamo passarci il codice
    //public void doDeleteCode(int codice)

}