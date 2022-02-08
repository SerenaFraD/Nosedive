package manager;

import control.servlet.DriverManagerConnectionPool;
import model.OrdineBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdineDao implements ModelDao<OrdineBean, Integer>   {
    private static final String TABLE_NAME = "Ordine";
    private static final DriverManagerConnectionPool pool = null;

    public synchronized void doSave(OrdineBean ordine) throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;

        String insertQuery = "INSERT INTO " + TABLE_NAME + " (id_carrello, data) VALUES (?, ?)";

        try {
            con = DriverManagerConnectionPool.getConnection();
            ps = con.prepareStatement(insertQuery);

            ps.setString(1, String.valueOf(ordine.getId_carrello()));
            ps.setString(2, String.valueOf(ordine.getData()));

            int result = ps.executeUpdate();

            if (result != 0)
                con.commit();
        } finally {
            try {
                if (ps != null)
                    ps.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
    }

    public List<OrdineBean> doRetrieveAll() throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs;
        List<OrdineBean> list = new ArrayList<>();
        OrdineBean bean;
        String selectQuery = "SELECT * FROM " + TABLE_NAME;

        try {
            con = DriverManagerConnectionPool.getConnection();
            ps = con.prepareStatement(selectQuery);

            rs = ps.executeQuery();

            while (rs.next()) {
                bean = new OrdineBean();

                bean.setData(rs.getString("data"));
                bean.setId_ordine(rs.getInt("id_ordine"));
                bean.setId_carrello(rs.getInt("id_carrello"));

                list.add(bean);
            }
        } finally {
            try {
                if (ps != null)
                    ps.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }

        return list;
    }

    @Override
    public void doUpdate(OrdineBean bean) throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;

        String updateQuery = "UPDATE " + TABLE_NAME + " SET id_carrello=?, data=? WHERE id_ordine=?";

        try {
            con = DriverManagerConnectionPool.getConnection();
            ps = con.prepareStatement(updateQuery);

            ps.setString(1, String.valueOf(bean.getId_carrello()));
            ps.setString(2, bean.getData());
            ps.setString(3, String.valueOf(bean.getId_ordine()));

            int result = ps.executeUpdate();

            if (result != 0)
                con.commit();
        } finally {
            try {
                if (ps != null)
                    ps.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
    }

    @Override
    public void doDelete(OrdineBean bean) {
        try (Connection con = DriverManagerConnectionPool.getConnection()) {
            String sql = "DELETE FROM " + TABLE_NAME + " WHERE id_ordine=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, bean.getId_ordine());
            ps.executeUpdate();
            con.commit();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public OrdineBean doRetrieveByKey(Integer keys) throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs;
        OrdineBean bean = null;
        String retriveQuery = "SELECT * FROM " + TABLE_NAME + " WHERE id_ordine=?";

        try {
            con = DriverManagerConnectionPool.getConnection();
            ps = con.prepareStatement(retriveQuery);

            ps.setString(1, String.valueOf(keys));

            rs = ps.executeQuery();

            if (rs.next()) {
                bean = new OrdineBean();

                bean.setData(rs.getString("data"));
                bean.setId_ordine(rs.getInt("id_ordine"));
                bean.setId_carrello(rs.getInt("id_carrello"));
            }
        } finally {
            try {
                if (ps != null)
                    ps.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }

        return bean;
    }

}
