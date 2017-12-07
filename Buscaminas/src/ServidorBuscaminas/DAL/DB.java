/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServidorBuscaminas.DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Daniel
 */
public class DB {

    private String ipDB;
    private String portDB;
    private String serviceDB; // La base de datos?
    private String userDB;
    private String passDB;
    private String url;
    private boolean logConect;

    public DB(String ipDB, String portDB, String serviceDB, String userDB, String passDB) {
        this.ipDB = ipDB;
        this.portDB = portDB;
        this.serviceDB = serviceDB;
        this.userDB = userDB;
        this.passDB = passDB;
    }
    
    public Connection getConnection() {
        System.out.println("-------- MySQL JDBC Connection Testing ------------");

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Donde está tu MySQL JDBC Driver?");
            e.printStackTrace();
            return null;
        }

        System.out.println("MySQL JDBC Driver Registrado!");
        Connection connection = null;

        try {

            this.url = "jdbc:mysql://" + this.ipDB + ":" + this.portDB + "/" + this.serviceDB + "";
            connection = DriverManager
                    .getConnection(this.url, this.userDB, this.passDB);

        } catch (SQLException e) {
            System.out.println("Conexión Fallida! Chequeá la consola");
            e.printStackTrace();
            return null;
        }

        if (connection != null) {
            System.out.println("Conexión Establecida!");
        } else {
            System.out.println("Conexión Fallida al intentar crear la conexión!");
        }

        return connection;
    }
}
