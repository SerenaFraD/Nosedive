package manager;

import control.servlet.DriverManagerConnectionPool;
import model.ProdottoBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdottoDao implements ModelDao<ProdottoBean, Integer> {
    private static final String TABLE_NAME = "Prodotto";
    private static final DriverManagerConnectionPool pool = null;

    @Override
    public void doSave(ProdottoBean bean) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;

        String insertSQL = "INSERT INTO " + TABLE_NAME +
                "(nome, descrizione, img, costo, id_categoria, punteggio_minimo) VALUES (?, ?, ?, ?, ?, ?);";

        try {
            con = DriverManagerConnectionPool.getConnection();
            ps = con.prepareStatement(insertSQL);

            ps.setString(1, bean.getNome());
            ps.setString(2, bean.getDescrizione());
            ps.setBlob(3, bean.getImg());
            ps.setDouble(4, bean.getCosto());
            ps.setInt(5, bean.getCategoria());
            ps.setInt(6, bean.getPunteggio_min());

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
    public void doUpdate(ProdottoBean bean) throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;

        String updateQuery = "UPDATE " + TABLE_NAME + " SET nome=?, descrizione=?, img=?, costo=?, id_categoria=?, punteggio_minimo=? WHERE id_prodotto=?";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(updateQuery);

            ps.setString(1, bean.getNome());
            ps.setString(2, bean.getDescrizione());
            ps.setBlob(3, bean.getImg());
            ps.setDouble(4, bean.getCosto());
            ps.setInt(5, bean.getCategoria());
            ps.setInt(6, bean.getPunteggio_min());
            ps.setInt(7, bean.getId_prodotto());

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
    public ProdottoBean doRetrieveByKey(Integer keys) throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs;
        ProdottoBean bean = null;
        String retriveQuery = "SELECT * FROM " + TABLE_NAME + " WHERE id_prodotto=?";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(retriveQuery);

            ps.setInt(1, keys);

            rs = ps.executeQuery();

            if (rs.next()) {
                bean = new ProdottoBean();

                bean.setId_prodotto(rs.getInt("id_prodotto"));
                bean.setNome(rs.getString("nome"));
                bean.setDescrizione(rs.getString("descrizione"));
                bean.setImg(rs.getBlob("img"));
                bean.setCosto(rs.getDouble("costo"));
                bean.setCategoria(rs.getInt("id_categoria"));
                bean.setPunteggio_min(rs.getInt("punteggio_minimo"));
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

    //Ricerca per categoria
    public List<ProdottoBean> doRetrieveByKey(String keys) throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs;
        List<ProdottoBean> list = new ArrayList<>();
        ProdottoBean bean;
        String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE categoria=?";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(selectQuery);
            ps.setString(1, keys);

            rs = ps.executeQuery();

            while (rs.next()) {
                bean = new ProdottoBean();

                bean.setId_prodotto(rs.getInt("id_prodotto"));
                bean.setNome(rs.getString("nome"));
                bean.setDescrizione(rs.getString("descrizione"));
                bean.setImg(rs.getBlob("img"));
                bean.setCosto(rs.getDouble("costo"));
                bean.setCategoria(rs.getInt("id_categoria"));
                bean.setPunteggio_min(rs.getInt("punteggio_minimo"));

                list.add(bean);
            }
        } finally {
            try {
                if (ps != null)
                    ps.close();
            } finally {
                pool.releaseConnection(con);
            }
        }

        return list;
    }

    @Override
    public List<ProdottoBean> doRetrieveAll() throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs;
        List<ProdottoBean> list = new ArrayList<>();
        ProdottoBean bean;
        String selectQuery = "SELECT * FROM " + TABLE_NAME;

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(selectQuery);

            rs = ps.executeQuery();

            while (rs.next()) {
                bean = new ProdottoBean();

                bean.setId_prodotto(rs.getInt("id_prodotto"));
                bean.setNome(rs.getString("nome"));
                bean.setDescrizione(rs.getString("descrizione"));
                bean.setImg(rs.getBlob("img"));
                bean.setCosto(rs.getDouble("costo"));
                bean.setCategoria(rs.getInt("id_categoria"));
                bean.setPunteggio_min(rs.getInt("punteggio_minimo"));

                list.add(bean);
            }
        } finally {
            try {
                if (ps != null)
                    ps.close();
            } finally {
                pool.releaseConnection(con);
            }
        }

        return list;
    }

    @Override
    public void doDelete(ProdottoBean bean) throws SQLException {
        try (Connection con = DriverManagerConnectionPool.getConnection()) {
            String sql = "DELETE FROM " + TABLE_NAME + " WHERE id_prodotto=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, bean.getId_prodotto());
            ps.executeUpdate();
            con.commit();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
