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
    private static final DriverManagerConnectionPool pool = null;

    @Override
    public void doSave(Azione bean) throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;

        String insertQuery = "INSERT INTO " + TABLE_NAME + " (nome, punteggio) VALUES (?, ?)";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(insertQuery);
            Azione utenteBean = (Azione) bean;

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
    public void doUpdate(Azione bean) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String updateQuery = "UPDATE" + TABLE_NAME + "SET nome=?, punteggio=? WHERE nome=?";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(updateQuery);
            Azione utenteBean = (Azione) bean;

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
    public void doDelete(Azione bean) throws SQLException {
        Connection con;
        PreparedStatement ps = null;
        String nomeAzione = bean.getNome();
        String deleteQuery = "DELETE FROM " + TABLE_NAME + " WHERE nome=?";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(deleteQuery);
            ps.setString(1, nomeAzione);

            ps.executeUpdate();
            con.commit();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Azione doRetrieveByKey(List<String> keys) throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;
        Azione bean = null;
        String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE nome=?";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(selectQuery);
            ps.setString(1, keys.get(0));

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
                pool.releaseConnection(con);
            }
        }

        return bean;
    }

    @Override
    public List<Azione> doRetrieveAll() throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;
        Azione bean = null;
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        ArrayList<Azione> listaAzioni = new ArrayList<Azione>();

        try {
            con = pool.getConnection();
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
                pool.releaseConnection(con);
            }
        }
        return listaAzioni;
    }
}

