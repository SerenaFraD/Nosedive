package manager;

import control.servlet.DriverManagerConnectionPool;
import model.PostBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PostDao implements ModelDao<PostBean, Integer> {

    private static final String TABLE_NAME = "Post";
    private static final DriverManagerConnectionPool pool = null;

    @Override
    //Permette di condividere i post
    public void doSave(PostBean bean) throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;
        String selectQuery = "INSERT INTO " + TABLE_NAME + "(id_utente, id_post, timestamp, testo) VALUES (?, ?, ?, ?)";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(selectQuery);
            ps.setInt(1, bean.getId_utente());
            ps.setInt(2, bean.getId_post());
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

    @Override
    //Future feature
    public void doUpdate(PostBean bean) throws SQLException {
    }

    @Override
    //todo L
    //Da rivedere per i punteggi
    public void doDelete(PostBean bean) throws SQLException {
        Connection con;
        PreparedStatement ps;
        String deleteQuery = "DELETE FROM " + TABLE_NAME + " WHERE id_post=?";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(deleteQuery);
            ps.setInt(1, bean.getId_post());

            ps.executeUpdate();
            con.commit();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public PostBean doRetrieveByKey(Integer keys) throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs;
        PostBean bean = null;
        String selectQuery = "SELECT * from " + TABLE_NAME + " where id_post = ?";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(selectQuery);
            ps.setInt(1, keys);

            rs = ps.executeQuery();

            if (rs.next()) {
                bean = new PostBean();
                bean.setId_post(rs.getInt("id_post"));
                bean.setId_utente(rs.getInt("id_utente"));
                bean.setTimestamp(rs.getString("timestamp"));
                bean.setPostpic(rs.getString("postpic"));
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

    public PostBean doRetrieveProfile(Integer keys) throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs;
        PostBean bean = null;
        String selectQuery = "SELECT * from " + TABLE_NAME + " where id_utente = ?";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(selectQuery);
            ps.setInt(1, keys);

            rs = ps.executeQuery();

            if (rs.next()) {
                bean = new PostBean();
                bean.setId_post(rs.getInt("id_post"));
                bean.setId_utente(rs.getInt("id_utente"));
                bean.setTimestamp(rs.getString("timestamp"));
                bean.setPostpic(rs.getString("postpic"));
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

    public PostBean doRetrieveHomepage(Integer keys) throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs;
        PostBean bean = null;
        int min = (int) (keys - (keys * 0.20));
        int max = (int) (keys + (keys * 0.30));
        String selectQuery = "SELECT testo, timestamp from post where id_utente in(select id_utente from utente where punteggio BETWEEN ? and ?)";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(selectQuery);
            ps.setInt(1, min);
            ps.setInt(2, max);

            rs = ps.executeQuery();

            if (rs.next()) {
                bean = new PostBean();
                bean.setId_post(rs.getInt("id_post"));
                bean.setId_utente(rs.getInt("id_utente"));
                bean.setTimestamp(rs.getString("timestamp"));
                bean.setPostpic(rs.getString("postpic"));
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

    public ArrayList<PostBean> doRetrieveAll() throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs;
        PostBean bean;
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        ArrayList<PostBean> listapost = new ArrayList<>();

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(selectQuery);

            rs = ps.executeQuery();

            while (rs.next()) {
                bean = new PostBean();
                bean.setId_utente(rs.getInt("id_utente"));
                bean.setId_post(rs.getInt("id_post"));
                bean.setTimestamp(rs.getString("timestamp"));
                bean.setPostpic(rs.getString("postpic"));
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

}
