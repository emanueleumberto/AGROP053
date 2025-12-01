package Esercizio;

import java.sql.SQLException;

public class GestioneOrdini {
    public static void main(String[] args) {
        try {
            DBConnection db = DBConnection.getInstance();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
