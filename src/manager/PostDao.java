package manager;

import control.servlet.DriverManagerConnectionPool;
import model.PostBean;
import model.UtenteBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PostDao implements ModelDao<PostBean, Integer> {

    private static final String TABLE_NAME = "Post";
    private static final DriverManagerConnectionPool pool = null;

    //todo

    @Override
    public void doSave(PostBean bean) throws SQLException {

    }

    @Override
    public void doUpdate(PostBean bean) throws SQLException {

    }

    @Override
    public void doDelete(PostBean bean) throws SQLException {

    }

    @Override
    public PostBean doRetrieveByKey(Integer keys) throws SQLException {
        return null;
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

    public int CondividiPost(PostBean bean) throws SQLException {
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
            return 0;

        } finally {
            try {
                if (ps != null)
                    ps.close();
            } finally {
                pool.releaseConnection(con);
                return 1;
            }
        }
    }
}
