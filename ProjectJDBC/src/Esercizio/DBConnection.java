package Esercizio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {

    private static DBConnection instance;
    private String url = "jdbc:mysql://localhost:3306/";
    private String user = "root";
    private String pass = "root";
    private String dbName = "agrop053jdbc_esercizio";
    Connection conn;
    Statement st;

    private DBConnection() throws SQLException {
        conn = DriverManager.getConnection(url, user, pass);
        st = conn.createStatement();
        createDatabase();
        createTableClienti();
        createTableProdotti();
        createTableOrdini();
        createTableDettagliOrdine();
    }

    private void createDatabase() throws SQLException {
        String sql = "CREATE DATABASE IF NOT EXISTS " + dbName;
        st.executeUpdate(sql);
        System.out.println("DB " + dbName + " connect!");
        conn = DriverManager.getConnection(url+dbName, user, pass); // Effettuo lo USE del DB
        st = conn.createStatement(); // Aggiorno lo statement
    }

    private void createTableClienti() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS clienti (" +
                     " id_cliente INT NOT NULL AUTO_INCREMENT," +
                     " nome VARCHAR(100) NOT NULL," +
                     " cognome VARCHAR(100) NOT NULL," +
                     " email VARCHAR(150) NOT NULL," +
                     " telefono VARCHAR(20) NULL," +
                     " CONSTRAINT email_uk UNIQUE(email)," +
                     " CONSTRAINT clienti_pk PRIMARY KEY(id_cliente)" +
                     ");";
        st.executeUpdate(sql);
        System.out.println("Table clienti created!");
    }

    private void createTableProdotti() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS prodotti (" +
                " id_prodotto INT NOT NULL AUTO_INCREMENT," +
                " nome VARCHAR(150) NOT NULL," +
                " descrizione TEXT NULL," +
                " prezzo DECIMAL(10,2) NOT NULL," +
                " quantita_disponibile INT NOT NULL," +
                " CONSTRAINT prodotti_pk PRIMARY KEY(id_prodotto)" +
                ");";
        st.executeUpdate(sql);
        System.out.println("Table prodotti created!");
    }

    private void createTableOrdini() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS ordini (" +
                " id_ordine INT NOT NULL AUTO_INCREMENT," +
                " id_cliente INT NOT NULL," +
                " data_ordine TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP," +
                " CONSTRAINT ordini_pk PRIMARY KEY(id_ordine)," +
                " CONSTRAINT ordini_clienti_fk FOREIGN KEY(id_cliente) REFERENCES clienti(id_cliente)" +
                " ON UPDATE CASCADE ON DELETE CASCADE" +
                ");";
        st.executeUpdate(sql);
        System.out.println("Table ordini created!");
    }

    private void createTableDettagliOrdine() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS dettagli_ordini (" +
                " id_dettagli_ordine INT NOT NULL AUTO_INCREMENT," +
                " id_ordine INT NOT NULL," +
                " id_prodotto INT NOT NULL," +
                " quantita INT NOT NULL," +
                " prezzo_unitario DECIMAL(10,2) NOT NULL," +
                " CONSTRAINT dettagli_ordine_pk PRIMARY KEY(id_dettagli_ordine)," +
                " CONSTRAINT ordini_dettaglio_fk FOREIGN KEY(id_ordine) REFERENCES ordini(id_ordine)" +
                " ON UPDATE CASCADE ON DELETE CASCADE," +
                " CONSTRAINT ordini_prodotto_fk FOREIGN KEY(id_prodotto) REFERENCES prodotti(id_prodotto)" +
                " ON UPDATE CASCADE ON DELETE CASCADE" +
                ");";
        st.executeUpdate(sql);
        System.out.println("Table dettaglio_ordini created!");
    }

    public Connection getConn() {
        return conn;
    }

    public Statement getSt() {
        return st;
    }

    public static DBConnection getInstance() throws SQLException {
        if(instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }
}
