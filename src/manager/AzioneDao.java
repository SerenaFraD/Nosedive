package manager;

import control.servlet.DriverManagerConnectionPool;
import model.Azione;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AzioneDao implements ModelDao<Azione, String> {

    private static final String TABLE_NAME = "Azione";
    // private static final DriverManagerConnectionPool pool = null;

    @Override
    public void doSave(Azione bean) throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;

        String insertQuery = "INSERT INTO " + TABLE_NAME + " (nome, punteggio) VALUES (?, ?)";

        try {
            con = DriverManagerConnectionPool.getConnection();
            ps = con.prepareStatement(insertQuery);

            ps.setString(1, bean.getNome());
            ps.setInt(2, bean.getPunteggio());

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
    public void doUpdate(Azione bean) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String updateQuery = "UPDATE " + TABLE_NAME + " SET nome=?, punteggio=? WHERE nome=?";

        try {
            con = DriverManagerConnectionPool.getConnection();
            ps = con.prepareStatement(updateQuery);

            ps.setString(1, bean.getNome());
            ps.setInt(2, bean.getPunteggio());

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
    public void doDelete(Azione bean) {
        Connection con;
        PreparedStatement ps;
        String deleteQuery = "DELETE FROM " + TABLE_NAME + " WHERE nome=?";

        try {
            con = DriverManagerConnectionPool.getConnection();
            ps = con.prepareStatement(deleteQuery);
            ps.setString(1, bean.getNome());

            ps.executeUpdate();
            con.commit();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Azione doRetrieveByKey(String keys) throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs;
        Azione bean = null;
        String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE nome=?";

        try {
            con = DriverManagerConnectionPool.getConnection();
            ps = con.prepareStatement(selectQuery);
            ps.setString(1, keys);

            rs = ps.executeQuery();

            if (rs.next()) {
                bean = new Azione();
                bean.setId_azione(rs.getInt("id_azione"));
                bean.setPunteggio(rs.getInt("punteggio"));
                bean.setNome(rs.getString("nome"));
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

    @Override
    public List<Azione> doRetrieveAll() throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs;
        Azione bean;
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        ArrayList<Azione> listaAzioni = new ArrayList<>();

        try {
            con = DriverManagerConnectionPool.getConnection();
            ps = con.prepareStatement(selectQuery);

            rs = ps.executeQuery();

            while (rs.next()) {
                bean = new Azione();
                bean.setId_azione(rs.getInt("id_azione"));
                bean.setPunteggio(rs.getInt("punteggio"));
                bean.setNome(rs.getString("nome"));

                listaAzioni.add(bean);
            }
        } finally {
            try {
                if (ps != null)
                    ps.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
        return listaAzioni;
    }
}

