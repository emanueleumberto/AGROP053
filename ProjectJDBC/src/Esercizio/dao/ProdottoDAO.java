package Esercizio.dao;

import Esercizio.DBConnection;
import Esercizio.entities.Cliente;
import Esercizio.entities.Prodotto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdottoDAO {

    public static void salvaProdotto(Prodotto prodotto) throws SQLException {
        String sql = "INSERT INTO prodotti (nome, descrizione, prezzo, quantita_disponibile)" +
                " VALUES (?, ?, ?, ?)";

        PreparedStatement ps = DBConnection.getInstance().getConn().prepareStatement(sql);
        ps.setString(1, prodotto.getNome());
        ps.setString(2, prodotto.getDescrizione());
        ps.setDouble(3, prodotto.getPrezzo());
        ps.setInt(4, prodotto.getQuantita_disponibile());

        ps.executeUpdate();
        System.out.println(prodotto.getNome() + " €" + prodotto.getPrezzo() + " created!");
    }

    public static Prodotto leggiProdotto(int id) throws SQLException {
        String sql = "SELECT * FROM prodotti WHERE id_prodotto = ?";
        PreparedStatement ps = DBConnection.getInstance().getConn().prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
            int idProdotto = rs.getInt("id_prodotto");
            String nome = rs.getString("nome");
            String descrizione = rs.getString("descrizione");
            double prezzo = rs.getDouble("prezzo");
            int quantitaDisponibile = rs.getInt("quantita_disponibile");
            return new Prodotto(idProdotto,nome, descrizione, prezzo, quantitaDisponibile);
        } else {
            return null;
        }
    }

    public static void modificaProdotto(Prodotto prodotto) throws SQLException {
        String sql = "UPDATE prodotti SET nome=?, descrizione=?, prezzo=?, " +
                "quantita_disponibile=? WHERE id_prodotto=?";
        PreparedStatement ps = DBConnection.getInstance().getConn().prepareStatement(sql);
        ps.setString(1, prodotto.getNome());
        ps.setString(2, prodotto.getDescrizione());
        ps.setDouble(3, prodotto.getPrezzo());
        ps.setInt(4, prodotto.getQuantita_disponibile());
        ps.setLong(5, prodotto.getId_prodotto());
        ps.executeUpdate();
        System.out.println(prodotto.getNome() + " €" + prodotto.getPrezzo() + " modified!");
    }

    public static void eliminaProdotto(Prodotto prodotto) throws SQLException {
        String sql = "DELETE FROM prodotti WHERE id_prodotto = ?";
        PreparedStatement ps = DBConnection.getInstance().getConn().prepareStatement(sql);
        ps.setLong(1, prodotto.getId_prodotto());
        ps.executeUpdate();
        System.out.println(prodotto.getNome() + " €" + prodotto.getPrezzo() + " deleted!");
    }

    public static List<Prodotto> leggiTuttiProdotti() throws SQLException {
        String sql = "SELECT * FROM prodotti";
        PreparedStatement ps = DBConnection.getInstance().getConn().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Prodotto> lista = new ArrayList<>();
        while(rs.next()) {
            int idProdotto = rs.getInt("id_prodotto");
            String nome = rs.getString("nome");
            String descrizione = rs.getString("descrizione");
            double prezzo = rs.getDouble("prezzo");
            int quantitaDisponibile = rs.getInt("quantita_disponibile");
            lista.add(new Prodotto(idProdotto, nome, descrizione, prezzo, quantitaDisponibile));
        }
        return lista;
    }

}
