package manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import control.servlet.DriverManagerConnectionPool;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import model.UtenteBean;
import model.Bean;

public class UtenteDao implements ModelDao<UtenteBean, String[]> {
    private static final String TABLE_NAME = "Utente";
    private static final DriverManagerConnectionPool pool = null;

    @Override
    public synchronized void doSave(UtenteBean bean) throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;

        String insertQuery = "INSERT INTO " + TABLE_NAME + " (email, nome, pwd, auth) VALUES (?, ?, SHA1(?), ?)";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(insertQuery);

            ps.setString(1, bean.getEmail());
            ps.setString(2, bean.getPassword());
            ps.setString(3, bean.getNome());
            ps.setBoolean(4, bean.isSupervisor());

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

    public synchronized void doSavePar(Bean bean) throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;

        String insertQuery = "INSERT INTO " + TABLE_NAME + " (email, nome, pwd, sup) VALUES (?, ?, SHA1(?), ?)";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(insertQuery);
            UtenteBean utenteBean = (UtenteBean) bean;

            ps.setString(1, utenteBean.getEmail());
            ps.setString(2, utenteBean.getNome());
            ps.setString(3, utenteBean.getPassword());
            ps.setBoolean(4, utenteBean.isSupervisor());

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
    public synchronized void doUpdate(UtenteBean bean) throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;

        String updateQuery = "UPDATE " + TABLE_NAME + " SET email=?, nome=?, pwd=?, sup=? WHERE id_utente=?";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(updateQuery);

            ps.setString(1, bean.getEmail());
            ps.setString(2, bean.getNome());
            ps.setString(3, bean.getPassword());
            ps.setBoolean(4, bean.isSupervisor());
            ps.setInt(5, bean.getId_utente());

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
    public synchronized void doDelete(UtenteBean bean) throws SQLException {
        int id_utente = bean.getId_utente();

        try (Connection con = DriverManagerConnectionPool.getConnection()) {
            String sql = "DELETE FROM " + TABLE_NAME + " WHERE id_utente=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_utente);
            ps.executeUpdate();
            con.commit();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public synchronized UtenteBean doRetrieveByKey(String[] keys) throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs;
        UtenteBean bean = null;
        String selectQuery = (keys.length == 2) ? "SELECT * FROM " + TABLE_NAME + " WHERE email=? and password=SHA1(?)" : "SELECT * FROM " + TABLE_NAME + " WHERE id_utente=?";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(selectQuery);

            if(keys.length == 2) {
                ps.setInt(1, Integer.parseInt(keys[0]));
            } else {
                ps.setString(1, keys[0]);
                ps.setString(2, keys[1]);
            }

            rs = ps.executeQuery();

            if (rs.next()) {
                bean = new UtenteBean();
                bean.setId_utente(rs.getInt("id_utente"));
                bean.setEmail(rs.getString("email"));
                bean.setNome(rs.getString("nome"));
                bean.setPasswordhash(rs.getString("pwd"));
                bean.setSupervisor(rs.getBoolean("sup"));
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

    // Si, ma anche no. The fuck wrote this? Guess I have to keep it
    public synchronized UtenteBean doRetrieveByName(String nome) throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs;
        UtenteBean bean = null;
        String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE nome=? ";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(selectQuery);

            ps.setString(1, nome);

            rs = ps.executeQuery();

            if (rs.next()) {
                bean = new UtenteBean();
                bean.setId_utente(rs.getInt("id_utente"));
                bean.setEmail(rs.getString("email"));
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

    public static synchronized UtenteBean doRetrieveByEmail(String email) throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs;
        UtenteBean bean = null;
        String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE email=? ";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(selectQuery);

            ps.setString(1, email);

            rs = ps.executeQuery();

            if (rs.next()) {
                bean = new UtenteBean();
                bean.setId_utente(rs.getInt("id_utente"));
                bean.setEmail(rs.getString("email"));
                bean.setNome(rs.getString("nome"));
                bean.setPassword(rs.getString("pwd"));
                bean.setSupervisor(rs.getBoolean("sup"));
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

    public synchronized List<UtenteBean> doRetrieveAll() throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs;
        List<UtenteBean> list = new ArrayList<UtenteBean>();
        UtenteBean bean;
        String selectQuery = "SELECT * FROM " + TABLE_NAME;

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(selectQuery);

            rs = ps.executeQuery();

            while (rs.next()) {
                bean = new UtenteBean();
                bean.setId_utente(rs.getInt("id_utente"));
                bean.setEmail(rs.getString("email"));
                bean.setNome(rs.getString("nome"));
                bean.setPasswordhash(rs.getString("pwd"));
                bean.setSupervisor(rs.getBoolean("sup"));
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

    public synchronized long getNumbersOfUsers() throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs;
        long number = 0;
        String selectQuery = "SELECT count(*) FROM " + TABLE_NAME + " WHERE sup='false'";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(selectQuery);

            rs = ps.executeQuery();

            if (rs.next())
                number = rs.getLong(1);
        } finally {
            try {
                if (ps != null)
                    ps.close();
            } finally {
                pool.releaseConnection(con);
            }
        }

        return number;
    }
}
