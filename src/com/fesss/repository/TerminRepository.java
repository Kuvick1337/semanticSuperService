package com.fesss.repository;

import com.fesss.model.Termin;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

/**
 * Repository-Klasse für Datenbank-Zugriffe bezüglich der Tabelle "termin"
 */
public class TerminRepository {

    /**
     * lädt alle  Termine für einen Saal und gibt diese als Liste zurück
     *
     * @param saalId
     * @return
     */
    public static List<Termin> getTermineForSaal(int saalId) {
        LinkedList<Termin> list = new LinkedList<>();
        Connection con = null;
        ResultSet rs = null;

        PreparedStatement stmt = null;
        String query = "SELECT id, saal_id, name, date_from, date_to, participants, food " +
                "FROM termin " +
                "WHERE saal_id = ?  ORDER BY date_from ASC";

        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/servengdb");
            con = ds.getConnection();

            stmt = con.prepareStatement(query);
            stmt.setInt(1, saalId);

            rs = stmt.executeQuery();

            while (rs.next()) {
                list.addLast(new Termin(rs.getInt(1), rs.getInt(2), rs.getString(3),
                        rs.getTimestamp(4), rs.getTimestamp(5), rs.getInt(6),
                        rs.getBoolean(7)));
            }
        } catch (Exception e) {
            try {
                con.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }

            e.printStackTrace();
        } finally {
            // Always make sure result sets and statements are closed and the connection is returned to the pool
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    ;
                }
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    ;
                }
                stmt = null;
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    ;
                }
                con = null;
            }
        }

        return list;
    }

    /**
     * gibt die Anzahl an Terminen fuer einen Saal zwischen zwei TIMESTAMPs retour.
     *
     * @param saalId
     * @param from
     * @param to
     * @return
     */
    public static int getTermineForSaalBetween(int saalId, Timestamp from, Timestamp to) {
        int count = 0;
        Connection con = null;
        ResultSet rs = null;

        PreparedStatement stmt = null;
        String query = "SELECT COUNT(*)  FROM `termin` WHERE saal_id = ? AND ( (? > date_from AND ? < date_to) OR (? > date_from AND ? < date_to) OR (? < date_from AND ? > date_to))";

        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/servengdb");
            con = ds.getConnection();

            stmt = con.prepareStatement(query);
            stmt.setInt(1, saalId);
            stmt.setTimestamp(2, from);
            stmt.setTimestamp(3, from);
            stmt.setTimestamp(4, to);
            stmt.setTimestamp(5, to);
            stmt.setTimestamp(6, from);
            stmt.setTimestamp(7, to);

            rs = stmt.executeQuery();

            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            try {
                con.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }

            e.printStackTrace();
        } finally {
            // Always make sure result sets and statements are closed,
            // and the connection is returned to the pool
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    ;
                }
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    ;
                }
                stmt = null;
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    ;
                }
                con = null;
            }
        }

        return count;
    }

    public static int addTermin(Termin termin) {
        Connection con = null;
        int rowcount = 0;

        PreparedStatement stmt = null;
        String query = "INSERT INTO `termin`(saal_id, name, date_from, date_to, participants, food) VALUES (?,?,?,?,?,?); ";

        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/servengdb");
            con = ds.getConnection();

            stmt = con.prepareStatement(query);
            stmt.setInt(1, termin.getSaalId());
            stmt.setString(2, termin.getName());
            stmt.setTimestamp(3, termin.getStartDatum());
            stmt.setTimestamp(4, termin.getEndDatum());
            stmt.setInt(5, termin.getParticipants());
            stmt.setBoolean(6, termin.getNeedFood());

            rowcount = stmt.executeUpdate();

//            con.commit();

        } catch (Exception e) {
            try {
                con.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }

            e.printStackTrace();
        } finally {
            // Always make sure result sets and statements are closed and the connection is returned to the pool
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    ;
                }
                stmt = null;
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    ;
                }
                con = null;
            }
        }

        return rowcount;
    }

    public static int delete(Integer saalId, String eventName, Timestamp dateFrom) {
        Connection con = null;
        int rowcount = 0;

        PreparedStatement stmt = null;
        String query = "DELETE FROM `termin` WHERE saal_id = ? AND name = ? AND date_from = ?; ";

        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/servengdb");
            con = ds.getConnection();

            stmt = con.prepareStatement(query);
            stmt.setInt(1, saalId);
            stmt.setString(2, eventName);
            stmt.setTimestamp(3, dateFrom);

            rowcount = stmt.executeUpdate();

//            con.commit();

        } catch (Exception e) {
            try {
                con.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }

            e.printStackTrace();
        } finally {
            // Always make sure result sets and statements are closed and the connection is returned to the pool
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    ;
                }
                stmt = null;
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    ;
                }
                con = null;
            }
        }

        return rowcount;
    }
}
