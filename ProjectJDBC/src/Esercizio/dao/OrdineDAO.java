package Esercizio.dao;

import Esercizio.DBConnection;
import Esercizio.entities.Cliente;
import Esercizio.entities.DettaglioOrdine;
import Esercizio.entities.Ordine;
import Esercizio.entities.Prodotto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class OrdineDAO {

    public static void creaOrdine(Ordine ordine) throws SQLException {
        String sql = "INSERT INTO ordini (id_cliente) VALUES (?)";
        PreparedStatement ps = DBConnection.getInstance().getConn().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, ordine.getCliente().getId_cliente());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        if(rs.next()) {
            int order_insert_id = rs.getInt(1);
            sql = "INSERT INTO dettagli_ordini (id_ordine, id_prodotto, quantita, prezzo_unitario) " +
                    "VALUES (?, ?, ?, ?)";
            ps = DBConnection.getInstance().getConn().prepareStatement(sql);
            ps.setInt(1, order_insert_id);
            ps.setInt(2, ordine.getDettaglioOrdine().getProdotto().getId_prodotto());
            ps.setInt(3, ordine.getDettaglioOrdine().getQuantita());
            ps.setDouble(4, ordine.getDettaglioOrdine().getPrezzo_unitario());
            ps.executeUpdate();
            System.out.println("Ordine num. " + order_insert_id + " inserito nel DB!");
        }
    }

    public static Ordine leggiOrdine(int id) throws SQLException {
        String sql = "SELECT c.id_cliente, c.nome AS nome_cliente, c.cognome, c.email, c.telefono, p.id_prodotto, p.nome AS nome_prodotto, p.descrizione, " +
                    " p.prezzo, p.quantita_disponibile, o.id_ordine, o.id_cliente, o.data_ordine, do.id_dettagli_ordine, " +
                    " do.id_ordine, do.id_prodotto, do.quantita, do.prezzo_unitario " +
                    " FROM agrop053jdbc_esercizio.ordini AS o " +
                    " INNER JOIN agrop053jdbc_esercizio.dettagli_ordini AS do ON o.id_ordine = do.id_ordine " +
                    " INNER JOIN agrop053jdbc_esercizio.clienti AS c ON c.id_cliente = o.id_cliente " +
                    " INNER JOIN agrop053jdbc_esercizio.prodotti AS p ON p.id_prodotto = do.id_prodotto WHERE o.id_ordine = ?";
        PreparedStatement ps = DBConnection.getInstance().getConn().prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
            int idOrdine = rs.getInt("id_ordine");
            int idCliente = rs.getInt("id_cliente");
            String nomeCliente = rs.getString("nome_cliente");
            String cognomeCliente = rs.getString("cognome");
            String emailCliente = rs.getString("email");
            String telefonoCliente = rs.getString("telefono");
            LocalDate dataOrdine = rs.getDate("data_ordine").toLocalDate();
            int idDettaglioOrdine = rs.getInt("id_dettagli_ordine");
            int idProdotto = rs.getInt("id_prodotto");
            String nomeProdotto = rs.getString("nome_prodotto");
            String descrizioneProdotto = rs.getString("descrizione");
            double prezzoProdotto = rs.getDouble("prezzo");
            int quantitaDisponibileProdotto = rs.getInt("quantita_disponibile");
            int quantitaDettaglioOrdine = rs.getInt("quantita");
            double prezzoUnitarioDettaglioOrdine = rs.getDouble("prezzo_unitario");


            Cliente c = new Cliente(idCliente, nomeCliente, cognomeCliente, emailCliente,telefonoCliente);
            Prodotto p = new Prodotto(idProdotto, nomeProdotto, descrizioneProdotto, prezzoProdotto, quantitaDisponibileProdotto);
            DettaglioOrdine d = new DettaglioOrdine(idDettaglioOrdine, p, quantitaDettaglioOrdine, prezzoUnitarioDettaglioOrdine);
            Ordine o = new Ordine(idOrdine, c, dataOrdine, d);
            return o;
        }

        return null;

    }

    public static void modificaOdine(Ordine ordine) throws SQLException {
        String sql = "UPDATE ordini  SET id_cliente = ? WHERE id_ordine = ?";
        PreparedStatement ps = DBConnection.getInstance().getConn().prepareStatement(sql);
        ps.setInt(1, ordine.getCliente().getId_cliente());
        ps.setInt(2, ordine.getId_ordine());
        ps.executeUpdate();

        sql = "UPDATE dettagli_ordini  SET id_prodotto = ?, quantita = ?, prezzo_unitario = ? WHERE id_ordine = ?";
        ps = DBConnection.getInstance().getConn().prepareStatement(sql);
        ps.setInt(1, ordine.getDettaglioOrdine().getProdotto().getId_prodotto());
        ps.setInt(2, ordine.getDettaglioOrdine().getQuantita());
        ps.setDouble(3, ordine.getDettaglioOrdine().getPrezzo_unitario());
        ps.setInt(4, ordine.getId_ordine());
        ps.executeUpdate();
    }

    public static void eliminaOrdine(Ordine ordine) throws SQLException {
        String sql = "DELETE FROM ordini WHERE id_ordine = ?";
        PreparedStatement ps = DBConnection.getInstance().getConn().prepareStatement(sql);
        ps.setInt(1, ordine.getId_ordine());
        ps.executeUpdate();
    }
}
