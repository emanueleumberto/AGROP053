package Esercizio.dao;

import Esercizio.DBConnection;
import Esercizio.entities.Cliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ClienteDAO {

    // CRUD cliente
    public void salvaCliente(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO clienti (nome, cognome, email, telefono)" +
                " VALUES (?, ?, ?, ?)";

        PreparedStatement ps = DBConnection.getInstance().getConn().prepareStatement(sql);
        ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getCognome());
        ps.setString(3, cliente.getEmail());
        ps.setString(4, cliente.getTelefono());

        ps.executeUpdate();
        System.out.println(cliente.getNome() + " " + cliente.getCognome() + " created!");
    }

    public Cliente leggiCliente(int id) throws SQLException {
        String sql = "SELECT * FROM clienti WHERE id_cliente = ?";
        PreparedStatement ps = DBConnection.getInstance().getConn().prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
            int id_cliente = rs.getInt("id_cliente");
            String name = rs.getString("nome");
            String lastname = rs.getString("cognome");
            String email = rs.getString("email");
            String phone = rs.getString("telefono");
            return new Cliente(id_cliente, name, lastname, email, phone);
        } else {
            return null;
        }
    }

    public void modificaCliente(Cliente cliente) throws SQLException {
        String sql = "UPDATE clienti SET nome=?, cognome=?, email=?, " +
                "telefono=? WHERE id_cliente=?";
        PreparedStatement ps = DBConnection.getInstance().getConn().prepareStatement(sql);
        ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getCognome());
        ps.setString(3, cliente.getEmail());
        ps.setString(4, cliente.getTelefono());
        ps.setLong(5, cliente.getId_cliente());
        ps.executeUpdate();
        System.out.println(cliente.getNome() + " " + cliente.getCognome() + " modified!");
    }

    public void eliminaCliente (Cliente cliente) throws SQLException {
        String sql = "DELETE FROM clienti WHERE id_cliente = ?";
        PreparedStatement ps = DBConnection.getInstance().getConn().prepareStatement(sql);
        ps.setLong(1, cliente.getId_cliente());
        ps.executeUpdate();
        System.out.println(cliente.getNome() + " " + cliente.getCognome() + " deleted!");
    }

    public List<Cliente> leggiTuttiClienti() { return null; }

}
