package manager;

import control.servlet.DriverManagerConnectionPool;
import model.Categoria;
import model.UtenteBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FollowDao{
    private static final String TABLE_NAME = "UtenteSeguito";
    private static final DriverManagerConnectionPool pool = null;

    public void doSave(UtenteBean bean, UtenteBean other) throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;

        String insertQuery = "INSERT INTO " + TABLE_NAME + " (id_utente, id_seguito) VALUES (?, ?)";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(insertQuery);

            ps.setInt(1, bean.getId_utente());
            ps.setInt(2, other.getId_utente());

            int result = ps.executeUpdate();

            if (result != 0)
                con.commit();
        } finally {
            try {
                if (ps != null)
                    ps.close();
            } finally {
                pool.releaseConnection(con);
            }
        }
    }

    //todo
    public void doUpdate(UtenteBean bean) throws SQLException {

    }

    public void doDelete(UtenteBean bean, UtenteBean other) throws SQLException {
        Connection con;
        PreparedStatement ps;
        String deleteQuery = "DELETE FROM " + TABLE_NAME + " WHERE id_utente=? and id_seguito=?";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(deleteQuery);
            ps.setInt(1, bean.getId_utente());
            ps.setInt(2, other.getId_utente());

            ps.executeUpdate();
            con.commit();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean doRetrieveByKey(UtenteBean bean, UtenteBean other) throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs;
        String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE id_utente=? and id_seguito=?";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(selectQuery);
            ps.setInt(1, bean.getId_utente());
            ps.setInt(2, other.getId_utente());

            rs = ps.executeQuery();

            return rs.next();
        } finally {
            try {
                if (ps != null)
                    ps.close();
            } finally {
                pool.releaseConnection(con);
            }
        }
    }

    public List<UtenteBean> doRetrieveAll(Integer key) throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs;
        UtenteBean bean = null;
        String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE id_utente=?";
        List<UtenteBean> list = null;

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(selectQuery);
            ps.setInt(1, key);
            rs = ps.executeQuery();

            while (rs.next()) {
                bean = new UtenteBean();
                bean.setId_utente(rs.getInt("id_categoria"));
                bean.setNome(rs.getString("nome"));
                bean.setPunteggio(rs.getInt("punteggio"));

                list.add(bean);
            }
        } finally {
            try {
                if (ps != null)
                    ps.close();
            } finally {
                pool.releaseConnection(con);
            }
        }
        return list;
    }
}
