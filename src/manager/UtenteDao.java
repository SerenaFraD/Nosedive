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

public class UtenteDao implements ModelDao<UtenteBean, Integer> {
    private static final String TABLE_NAME = "Utente";
    private static final DriverManagerConnectionPool pool = null;

    @Override
    public synchronized void doSave(UtenteBean bean) throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;

        String insertQuery = "INSERT INTO " + TABLE_NAME + " (email, nome, pwd, sup, compleanno, punteggio, id_relazione, id_lavoro, propic, sesso, deceduto) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(insertQuery);

            ps.setString(1, bean.getEmail());
            ps.setString(2, bean.getNome());
            ps.setString(3, bean.getPassword());
            ps.setBoolean(4, bean.isSupervisor());
            ps.setString(5, bean.getCompleanno());
            ps.setInt(6, bean.getPunteggio());
            ps.setInt(7, bean.getId_relazione());
            ps.setInt(8, bean.getId_lavoro());
            ps.setString(9, bean.getPropic());
            ps.setBoolean(10, bean.isSesso());
            ps.setBoolean(11, bean.isDeceduto());

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

        String updateQuery = "UPDATE " + TABLE_NAME + " SET email=?, nome=?, pwd=?, sup=?, compleanno=?, punteggio=?, id_relazione=?, id_lavoro=?, propic=?, sesso=?, deceduto=? WHERE id_utente=?";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(updateQuery);

            ps.setString(1, bean.getEmail());
            ps.setString(2, bean.getNome());
            ps.setString(3, bean.getPassword());
            ps.setBoolean(4, bean.isSupervisor());
            ps.setString(5, bean.getCompleanno());
            ps.setInt(6, bean.getPunteggio());
            ps.setInt(7, bean.getId_relazione());
            ps.setInt(8, bean.getId_lavoro());
            ps.setString(9, bean.getPropic());
            ps.setBoolean(10, bean.isSesso());
            ps.setBoolean(11, bean.isDeceduto());

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

    public void doUpdateUtente(UtenteBean bean) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String updateQuery = "UPDATE " + TABLE_NAME + " SET id_relazione=?, id_lavoro=?, propic=? WHERE id_utente=?";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(updateQuery);

            ps.setInt(1, bean.getId_relazione());
            ps.setInt(2, bean.getId_lavoro());
            ps.setString(3, bean.getPropic());
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

    public void doUpdateDeceduto(UtenteBean bean) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String updateQuery = "UPDATE " + TABLE_NAME + " SET deceduto=?  WHERE id_utente=?";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(updateQuery);

            ps.setBoolean(1, bean.isSesso());
            ps.setBoolean(2, bean.isDeceduto());

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

    public void doUpdateBloccato(UtenteBean bean) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String updateQuery = "UPDATE " + TABLE_NAME + " SET bloccato=?  WHERE id_utente=?";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(updateQuery);

            ps.setBoolean(1, bean.isSesso());
            ps.setBoolean(2, bean.isBloccato());

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

    public void doUpdatePunteggio(UtenteBean bean) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String updateQuery = "UPDATE " + TABLE_NAME + " SET punteggio=? WHERE id_utente=?";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(updateQuery);

            ps.setBoolean(1, bean.isSesso());
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
    public synchronized UtenteBean doRetrieveByKey(Integer keys) throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs;
        UtenteBean bean = null;
        String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE id_utente=?";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(selectQuery);

            ps.setInt(1, keys);

            rs = ps.executeQuery();

            if (rs.next()) {
                bean = new UtenteBean();
                bean.setId_utente(rs.getInt("id_utente"));
                bean.setEmail(rs.getString("email"));
                bean.setNome(rs.getString("nome"));
                bean.setPasswordhash(rs.getString("pwd"));
                bean.setSupervisor(rs.getBoolean("sup"));
                bean.setCompleanno(rs.getString("compleanno"));
                bean.setPunteggio(rs.getInt("punteggio"));
                bean.setId_relazione(rs.getInt("id_relazione"));
                bean.setId_lavoro(rs.getInt("id_lavoro"));
                bean.setPropic(rs.getString("propic"));
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

    public synchronized List<UtenteBean> doRetrieveByName(String nome) throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs;
        UtenteBean bean;
        List<UtenteBean> list = null;
        String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE nome=? ";

        try {
            con = pool.getConnection();
            ps = con.prepareStatement(selectQuery);

            ps.setString(1, nome);

            rs = ps.executeQuery();

            while (rs.next()) {
                bean = new UtenteBean();
                bean.setId_utente(rs.getInt("id_utente"));
                bean.setEmail(rs.getString("email"));
                bean.setNome(rs.getString("nome"));
                bean.setPasswordhash(rs.getString("pwd"));
                bean.setSupervisor(rs.getBoolean("sup"));
                bean.setCompleanno(rs.getString("compleanno"));
                bean.setPunteggio(rs.getInt("punteggio"));
                bean.setId_relazione(rs.getInt("id_relazione"));
                bean.setId_lavoro(rs.getInt("id_lavoro"));
                bean.setPropic(rs.getString("propic"));
                bean.setSesso(rs.getBoolean("sesso"));
                bean.setDeceduto(rs.getBoolean("deceduto"));

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

    public synchronized UtenteBean doRetrieveByEmail(String email) throws SQLException {
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
        List<UtenteBean> list = null;
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
                bean.setCompleanno(rs.getString("compleanno"));
                bean.setPunteggio(rs.getInt("punteggio"));
                bean.setId_relazione(rs.getInt("id_relazione"));
                bean.setId_lavoro(rs.getInt("id_lavoro"));
                bean.setPropic(rs.getString("propic"));
                bean.setSesso(rs.getBoolean("sesso"));
                bean.setDeceduto(rs.getBoolean("deceduto"));

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
