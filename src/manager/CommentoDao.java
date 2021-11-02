package manager;

import control.servlet.DriverManagerConnectionPool;
import model.CommentoBean;
import model.PostBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentoDao implements ModelDao<CommentoBean, Integer> {
    private static final String TABLE_NAME = "Commento";
    private static final DriverManagerConnectionPool pool = null;

    @Override
    public void doSave(CommentoBean bean) throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;
        String selectQuery = "INSERT INTO " + TABLE_NAME +
                "(id_post, id_utente, timestamp, testo) VALUES (?, ?, ?, ?)";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(selectQuery);
            ps.setInt(1, bean.getId_post());
            ps.setInt(2, bean.getId_utente());
            ps.setString(3, bean.getTimestamp());
            ps.setString(4, bean.getTesto());

            ps.executeQuery();

        } finally {
            try {
                if (ps != null)
                    ps.close();
            } finally {
                pool.releaseConnection(con);
            }
        }
    }

    //todo future
    @Override
    public void doUpdate(CommentoBean bean) throws SQLException {

    }

    //todo future
    @Override
    public void doDelete(CommentoBean bean) throws SQLException {

    }

    @Override
    public CommentoBean doRetrieveByKey(Integer keys) throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs;
        CommentoBean bean = null;
        String selectQuery = "SELECT * from " + TABLE_NAME + " where id_commento = ?";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(selectQuery);
            ps.setInt(1, keys);

            rs = ps.executeQuery();

            if (rs.next()) {
                bean = new CommentoBean();
                bean.setId_commento(rs.getInt("id_commento"));
                bean.setId_post(rs.getInt("id_post"));
                bean.setId_utente(rs.getInt("id_utente"));
                bean.setTimestamp(rs.getString("timestamp"));
                bean.setTesto(rs.getString("testo"));
            }
        } finally {
            try {
                if (ps != null)
                    ps.close();
            } finally {
                pool.releaseConnection(con);
            }
        }

        return bean;
    }

    //Cerca i commenti di un post
    public ArrayList<CommentoBean> doRetrieveByPost(Integer keys) throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs;
        CommentoBean bean = null;
        String selectQuery = "SELECT * from " + TABLE_NAME + " where id_post = ?";
        ArrayList<CommentoBean> listapost = new ArrayList<>();

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(selectQuery);

            rs = ps.executeQuery();

            while (rs.next()) {
                bean = new CommentoBean();
                bean.setId_commento(rs.getInt("id_commento"));
                bean.setId_post(rs.getInt("id_post"));
                bean.setId_utente(rs.getInt("id_utente"));
                bean.setTimestamp(rs.getString("timestamp"));
                bean.setTesto(rs.getString("testo"));

                listapost.add(bean);
            }
        } finally {
            try {
                if (ps != null)
                    ps.close();
            } finally {
                pool.releaseConnection(con);
            }
        }

        return listapost;
    }

    //todo ???
    @Override
    public List<CommentoBean> doRetrieveAll() throws SQLException {
        return null;
    }
}
