package com.fesss.repository;

import com.fesss.model.Saal;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 * Repository-Klasse fuer Datenbank-Zugriffe bezueglich der Tabelle "saal"
 */
public class SaalRepository {

    /**
     * gibt eine Liste aller Saele zurueck
     * @return
     */
    public static List<Saal> getSäle(){
        LinkedList<Saal> list = new LinkedList<Saal>();
        Connection con = null;
        ResultSet rs = null;


        Statement stmt = null;
        String query = "SELECT id, name FROM saal";

        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/servengdb");
            con = ds.getConnection();

            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                list.addLast(new Saal(rs.getInt(1), rs.getString(2)));
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


        return list;
    }
}
