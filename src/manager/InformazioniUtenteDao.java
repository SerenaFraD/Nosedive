package manager;

import control.servlet.DriverManagerConnectionPool;
import model.InformazioniUtenteBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InformazioniUtenteDao implements ModelDao<InformazioniUtenteBean, Integer> {

    private static final String TABLE_NAME = "Informazione";
    private static final DriverManagerConnectionPool pool = null;

    @Override
    public void doSave(InformazioniUtenteBean bean) throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;

        String insertQuery = "INSERT INTO " + TABLE_NAME + " (compleanno, punteggio, id_relazione, id_lavoro, propic, sesso, deceduto) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(insertQuery);

            ps.setDate(1, (Date) bean.getCompleanno());
            ps.setInt(2, bean.getPunteggio());
            ps.setInt(3, bean.getId_relazione());
            ps.setInt(4, bean.getId_lavoro());
            ps.setBlob(5, bean.getPropic());
            ps.setBoolean(6, bean.isSesso());
            ps.setBoolean(7, bean.isDeceduto());

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
    public void doUpdate(InformazioniUtenteBean bean) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String updateQuery = "UPDATE " + TABLE_NAME + " SET compleanno=?, punteggio=?, id_relazione=?, id_lavoro=?, propic=?, sesso=?, deceduto=? WHERE id_utente=?";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(updateQuery);

            ps.setDate(1, (Date) bean.getCompleanno());
            ps.setInt(2, bean.getPunteggio());
            ps.setInt(3, bean.getId_relazione());
            ps.setInt(4, bean.getId_lavoro());
            ps.setBlob(5, bean.getPropic());
            ps.setBoolean(6, bean.isSesso());
            ps.setBoolean(7, bean.isDeceduto());
            ps.setInt(8, bean.getId_utente());

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

    public void doUpdateUtente(InformazioniUtenteBean bean) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String updateQuery = "UPDATE " + TABLE_NAME + " SET id_relazione=?, id_lavoro=?, propic=? WHERE id_utente=?";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(updateQuery);

            ps.setInt(1, bean.getId_relazione());
            ps.setInt(2, bean.getId_lavoro());
            ps.setBlob(3, bean.getPropic());
            ps.setInt(4, bean.getId_utente());

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

    public void doUpdateAdmin(InformazioniUtenteBean bean) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String updateQuery = "UPDATE " + TABLE_NAME + " SET sesso=?, deceduto=? WHERE id_utente=?";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(updateQuery);

            ps.setBoolean(1, bean.isSesso());
            ps.setBoolean(2, bean.isDeceduto());
            ps.setInt(3, bean.getId_utente());

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
    public void doDelete(InformazioniUtenteBean bean) throws SQLException {
        Connection con;
        PreparedStatement ps;

        String deleteQuery = "DELETE FROM " + TABLE_NAME + " WHERE id_utente=?";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(deleteQuery);
            ps.setInt(1, bean.getId_utente());

            ps.executeUpdate();
            con.commit();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public InformazioniUtenteBean doRetrieveByKey(Integer keys) throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs;
        InformazioniUtenteBean bean = null;
        String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE id_utente=?";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(selectQuery);
            ps.setInt(1, keys);

            rs = ps.executeQuery();

            if (rs.next()) {
                bean = new InformazioniUtenteBean();

                bean.setId_utente(rs.getInt("id_utente"));
                bean.setCompleanno(rs.getDate("compleanno"));
                bean.setPunteggio(rs.getInt("punteggio"));
                bean.setId_relazione(rs.getInt("id_relazione"));
                bean.setId_lavoro(rs.getInt("id_lavoro"));
                bean.setPropic(rs.getBlob("propic"));
                bean.setSesso(rs.getBoolean("sesso"));
                bean.setDeceduto(rs.getBoolean("deceduto"));
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
    public List<InformazioniUtenteBean> doRetrieveAll() throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs;
        InformazioniUtenteBean bean;
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        ArrayList<InformazioniUtenteBean> listaAzioni = new ArrayList<InformazioniUtenteBean>();

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(selectQuery);

            rs = ps.executeQuery();

            while (rs.next()) {
                bean = new InformazioniUtenteBean();

                bean.setId_utente(rs.getInt("id_utente"));
                bean.setCompleanno(rs.getDate("compleanno"));
                bean.setPunteggio(rs.getInt("punteggio"));
                bean.setId_relazione(rs.getInt("id_relazione"));
                bean.setId_lavoro(rs.getInt("id_lavoro"));
                bean.setPropic(rs.getBlob("propic"));
                bean.setSesso(rs.getBoolean("sesso"));
                bean.setDeceduto(rs.getBoolean("deceduto"));

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
