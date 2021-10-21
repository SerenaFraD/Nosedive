package manager;

import control.servlet.DriverManagerConnectionPool;
import model.Categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDao implements ModelDao<Categoria, Integer>  {
    private static final String TABLE_NAME = "Lavoro";
    private static final DriverManagerConnectionPool pool = null;

    @Override
    public void doSave(Categoria bean) throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;

        String insertQuery = "INSERT INTO " + TABLE_NAME + " (nome, descrizione) VALUES (?, ?)";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(insertQuery);

            ps.setString(1, bean.getNome());
            ps.setString(2, bean.getDescrizione());

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
    public void doUpdate(Categoria bean) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String updateQuery = "UPDATE " + TABLE_NAME + " SET descrizione=? WHERE nome=?";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(updateQuery);

            ps.setString(1, bean.getDescrizione());
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
    public void doDelete(Categoria bean) throws SQLException {
        Connection con;
        PreparedStatement ps;
        String deleteQuery = "DELETE FROM " + TABLE_NAME + " WHERE id_categoria=?";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(deleteQuery);
            ps.setInt(1, bean.getId_categoria());

            ps.executeUpdate();
            con.commit();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Categoria doRetrieveByKey(String keys) throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs;
        Categoria bean = null;
        String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE nome=?";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(selectQuery);
            ps.setString(1, keys);

            rs = ps.executeQuery();

            if (rs.next()) {
                bean = new Categoria();
                bean.setId_categoria(rs.getInt("id_categoria"));
                bean.setDescrizione(rs.getString("descrizione"));
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
    public Categoria doRetrieveByKey(Integer keys) throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs;
        Categoria bean = null;
        String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE id_categoria=?";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(selectQuery);
            ps.setString(1, String.valueOf(keys));

            rs = ps.executeQuery();

            if (rs.next()) {
                bean = new Categoria();
                bean.setId_categoria(rs.getInt("id_categoria"));
                bean.setDescrizione(rs.getString("descrizione"));
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
    public List<Categoria> doRetrieveAll() throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs;
        Categoria bean = null;
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        ArrayList<Categoria> listaAzioni = new ArrayList<Categoria>();

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(selectQuery);

            rs = ps.executeQuery();

            while (rs.next()) {
                bean = new Categoria();
                bean.setId_categoria(rs.getInt("id_categoria"));
                bean.setDescrizione(rs.getString("descrizione"));
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
