package manager;

import java.sql.Connection;
import java.sql.PreparedStatement;

import control.servlet.DriverManagerConnectionPool;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import manager.DaoModel;
import model.UtenteBean;
import model.Bean;

public class UtenteDao implements DaoModel {
    private static final String TABLE_NAME = "Utente";
    private static DriverManagerConnectionPool pool = null;

    public static synchronized UserBean doRetrieveByEmail(String email) throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;
        UserBean bean = null;
        String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE email=? ";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(selectQuery);

            ps.setString(1, email);

            rs = ps.executeQuery();

            if (rs.next()) {
                bean = new UserBean();
                bean.setId_utente(rs.getInt("id_utente"));
                bean.setEmail(rs.getString("email"));
                bean.setNome(rs.getString("nome"));
                bean.setPassword(rs.getString("pwd"));
                bean.setAuth(rs.getBoolean("sup"));
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

    public synchronized void doSavePar(Bean bean) throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;

        String insertQuery = "INSERT INTO " + TABLE_NAME + " (email, nome, pwd, sup) VALUES (?, ?, SHA1(?), ?)";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(insertQuery);
            UserBean userBean = (UserBean) bean;

            ps.setString(1, userBean.getEmail());
            ps.setString(2, userBean.getNome());
            ps.setString(3, userBean.getPassword());
            ps.setBoolean(5, userBean.isAdmin());

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
    public synchronized void doSave(Bean bean) throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;

        String insertQuery = "INSERT INTO " + TABLE_NAME + " (email, pwd, nome, nazionalita, eta, auth) VALUES (?, SHA1(?), ?, ?, ?, ?)";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(insertQuery);
            UserBean userBean = (UserBean) bean;

            ps.setString(1, userBean.getEmail());
            ps.setString(2, userBean.getNome());
            ps.setString(3, userBean.getPassword());
            ps.setBoolean(4, userBean.isSupervisor());

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
    public synchronized void doUpdate(Bean bean) throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;

        String updateQuery = "UPDATE " + TABLE_NAME + " SET email=?, nome=?, pwd=?, sup=? WHERE id_utente=?";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(updateQuery);
            UserBean userBean = (UserBean) bean;

            ps.setString(1, userBean.getEmail());
            ps.setString(2, userBean.getNome());
            ps.setString(3, userBean.getPassword());
            ps.setBoolean(4, userBean.isSupervisor());

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
    public synchronized void doDelete(UserBean bean) throws SQLException {

        int id_utente = bean.getId_utente();
        String deleteQuery = "DELETE FROM " + TABLE_NAME + " WHERE id_utente=?";

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
    public synchronized UserBean doRetrieveByKey(List<String> keys) throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;
        UserBean bean = null;
        String selectQuery = (keys.size() == 2) ? "SELECT * FROM " + TABLE_NAME + " WHERE email=? and password=SHA1(?)" : "SELECT * FROM " + TABLE_NAME + " WHERE id_utente=?";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(selectQuery);

            ps.setString(1, keys.get(0));
            if (keys.size() == 2)
                ps.setString(2, keys.get(1));

            rs = ps.executeQuery();

            if (rs.next()) {
                bean = new UserBean();
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

    public synchronized UserBean doRetrieveByName(String name) throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;
        UserBean bean = null;
        String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE username=? ";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(selectQuery);

            ps.setString(1, name);

            rs = ps.executeQuery();

            if (rs.next()) {
                bean = new UserBean();
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

    @Override
    public synchronized List<Bean> doRetrieveAll() throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;
        List<Bean> list = new ArrayList<Bean>();
        UserBean bean = null;
        String selectQuery = "SELECT * FROM " + TABLE_NAME;

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(selectQuery);

            rs = ps.executeQuery();

            while (rs.next()) {
                bean = new UserBean();
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
        ResultSet rs = null;
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
