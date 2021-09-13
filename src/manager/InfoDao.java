package manager;

import control.servlet.DriverManagerConnectionPool;
import model.InfoUtenteBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InfoUtenteBeanDao implements ModelDao<InfoUtenteBean, String> {

    private static final String TABLE_NAME = "InfoUtenteBean";
    private static final DriverManagerConnectionPool pool = null;

    @Override
    public void doSave(InfoUtenteBean bean) throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;

        String insertQuery = "INSERT INTO " + TABLE_NAME + " (compleanno, punteggio, id_relazione, id_lavoro, propic, sesso, deceduto) VALUES (?, ?)";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(insertQuery);
            InfoUtenteBean utenteBean = (InfoUtenteBean) bean;

            ps.setDate(1, bean.getCompleanno());
            ps.setInt(2, bean.getPunteggio());
            ps.setInt(3, bean.getId_relazione());
            ps.setInt(4, bean.getId_lavoro());
            ps.setBlob(5, bean.getPropic());

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

    @Override
    public void doUpdate(InfoUtenteBean bean) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String updateQuery = "UPDATE" + TABLE_NAME + "SET nome=?, punteggio=? WHERE nome=?";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(updateQuery);
            InfoUtenteBean utenteBean = (InfoUtenteBean) bean;

            ps.setString(1, utenteBean.getNome());
            ps.setInt(2, utenteBean.getPunteggio());

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

    @Override
    public void doDelete(InfoUtenteBean bean) throws SQLException {
        Connection con;
        PreparedStatement ps = null;
        String nomeInfoUtenteBean = bean.getNome();
        String deleteQuery = "DELETE FROM " + TABLE_NAME + " WHERE nome=?";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(deleteQuery);
            ps.setString(1, nomeInfoUtenteBean);

            ps.executeUpdate();
            con.commit();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public InfoUtenteBean doRetrieveByKey(List<String> keys) throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs;
        InfoUtenteBean bean = null;
        String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE nome=?";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(selectQuery);
            ps.setString(1, keys.get(0));

            rs = ps.executeQuery();

            if (rs.next()) {
                bean = new InfoUtenteBean();
                bean.setId_lavoro(rs.getInt("id_lavoro"));
                bean.setPunteggio(rs.getInt("punteggio"));
                bean.setNome(rs.getString("nome"));
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

    @Override
    public List<InfoUtenteBean> doRetrieveAll() throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;
        InfoUtenteBean bean = null;
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        ArrayList<InfoUtenteBean> listaAzioni = new ArrayList<InfoUtenteBean>();

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(selectQuery);

            rs = ps.executeQuery();

            while (rs.next()) {
                bean = new InfoUtenteBean();
                bean.setId_lavoro(rs.getInt("id_lavoro"));
                bean.setPunteggio(rs.getInt("punteggio"));
                bean.setNome(rs.getString("nome"));

                listaAzioni.add(bean);
            }
        } finally {
            try {
                if (ps != null)
                    ps.close();
            } finally {
                pool.releaseConnection(con);
            }
        }
        return listaAzioni;
    }
}
