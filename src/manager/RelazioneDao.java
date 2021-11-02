package manager;

import control.servlet.DriverManagerConnectionPool;
import model.Lavoro;
import model.Relazione;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RelazioneDao implements ModelDao<Relazione, String> {

    private static final String TABLE_NAME = "Relazione";
    private static final DriverManagerConnectionPool pool = null;

    @Override
    public void doSave(Relazione bean) throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;

        String insertQuery = "INSERT INTO " + TABLE_NAME + " (nome, punteggio) VALUES (?, ?)";

        try {
            con = pool.getConnection();
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
                pool.releaseConnection(con);
            }
        }
    }

    @Override
    public void doUpdate(Relazione bean) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String updateQuery = "UPDATE" + TABLE_NAME + "SET punteggio=? WHERE nome=?";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(updateQuery);

            ps.setInt(1, bean.getPunteggio());
            ps.setString(2, bean.getNome());

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
    public void doDelete(Relazione bean) throws SQLException {
        Connection con;
        PreparedStatement ps;
        String deleteQuery = "DELETE FROM " + TABLE_NAME + " WHERE id_relazione=?";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(deleteQuery);
            ps.setInt(1, bean.getId_relazione());

            ps.executeUpdate();
            con.commit();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Relazione doRetrieveByKey(String keys) throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs;
        Relazione bean = null;
        String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE nome=?";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(selectQuery);
            ps.setString(1, keys);

            rs = ps.executeQuery();

            if (rs.next()) {
                bean = new Relazione();
                bean.setId_relazione(rs.getInt("id_Relazione"));
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

    public Relazione doRetrieveByKey(Integer keys) throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs;
        Lavoro bean = null;
        String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE id_relazione=?";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(selectQuery);
            ps.setInt(1, keys);

            rs = ps.executeQuery();

            if (rs.next()) {
                bean = new Lavoro();
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
    public List<Relazione> doRetrieveAll() throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs;
        Relazione bean;
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        ArrayList<Relazione> listaAzioni = new ArrayList<Relazione>();

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(selectQuery);
            rs = ps.executeQuery();

            while (rs.next()) {
                bean = new Relazione();
                bean.setId_relazione(rs.getInt("id_Relazione"));
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
