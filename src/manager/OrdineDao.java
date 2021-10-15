package manager;

import control.servlet.DriverManagerConnectionPool;
import model.Ordine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

public class OrdineDao {

    private static final String TABLE_NAME = "Ordine";
    private static DriverManagerConnectionPool pool = null;

    public synchronized void doSave(Ordine ordine) throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;

        String insertQuery = "INSERT INTO " + TABLE_NAME + " (dataOrd, nPezzi, Users_id) VALUES (?, ?, ?)";

        con = pool.getConnection();
        ps = con.prepareStatement(insertQuery);
        Ordine ordineDao = (Ordine) ordine;

        ps.setString(1, ordineDao.getDataOrd());
        ps.setInt(2, ordineDao.getnPezzi());
        ps.setInt(3, ordineDao.getUserID());

        int result = ps.executeUpdate();

        if (result != 0)
            con.commit();

        pool.releaseConnection(con);
    }

    public Collection<Ordine> doRetriveAll() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        Collection<Ordine> ordini = new LinkedList<>();

        String selectSQL = "SELECT * FROM Ordine";

        connection = DriverManagerConnectionPool.getConnection();
        preparedStatement = connection.prepareStatement(selectSQL);

        System.out.println("doRetrieveAll:" + preparedStatement.toString());
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            Ordine ordine = new Ordine();

            ordine.setDataOrd(rs.getString("dataOrd"));
            ordine.setnPezzi(rs.getInt("nPezzi"));
            ordine.setUserID(rs.getInt("Users_id"));

            ordini.add(ordine);
        }

        if (preparedStatement != null)
            preparedStatement.close();

        DriverManagerConnectionPool.releaseConnection(connection);

        return ordini;
    }
}
