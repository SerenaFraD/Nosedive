package manager;

import control.servlet.DriverManagerConnectionPool;
import model.PostBean;
import model.UtenteBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PostDao {

    private static final String TABLE_NAME = "Post";
    private static final DriverManagerConnectionPool pool = null;

    public static synchronized ArrayList<PostBean> doRetrieveAll() throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;
        PostBean bean = null;
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        ArrayList<PostBean> listapost = new ArrayList<PostBean>();

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(selectQuery);

            rs = ps.executeQuery();

            while (rs.next()) {
                bean = new PostBean();
                bean.setId_utente(rs.getInt("id_utente"));
                bean.setId_post(rs.getInt("id_post"));
                bean.setTimestamp(rs.getString("timestamp"));
                bean.setPostpic(rs.getString("postpic")) ;
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
