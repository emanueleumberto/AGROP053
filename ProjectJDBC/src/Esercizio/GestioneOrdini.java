package Esercizio;

import Esercizio.dao.ClienteDAO;
import Esercizio.dao.OrdineDAO;
import Esercizio.dao.ProdottoDAO;
import Esercizio.entities.Cliente;
import Esercizio.entities.DettaglioOrdine;
import Esercizio.entities.Ordine;
import Esercizio.entities.Prodotto;
import com.github.javafaker.Faker;

import java.sql.SQLException;
import java.util.Locale;

public class GestioneOrdini {
    static Faker fake = new Faker(new Locale("it-IT"));

    public static void main(String[] args) {
        try {
            DBConnection db = DBConnection.getInstance();
            // generaClienti(15);
            // generaProdotti(25);

            // CRUD Clienti
            // Cliente c = ClienteDAO.leggiCliente(3);
            // System.out.println(c);
            // c.setCognome("Rossi");
            // c.setEmail("furio.rossi@example.com");
            // ClienteDAO.modificaCliente(c);
            // ClienteDAO.eliminaCliente(c);
            // ClienteDAO.leggiTuttiClienti().forEach(System.out::println);

            // CRUD Prodotti
            // Prodotto p = ProdottoDAO.leggiProdotto(7);
            // System.out.println(p);
            // p.setQuantita_disponibile(7);
            // ProdottoDAO.modificaProdotto(p);
            // ProdottoDAO.eliminaProdotto(p);
            // ProdottoDAO.leggiTuttiProdotti().forEach(System.out::println);

            // CRUD Ordini
            // Cliente c = ClienteDAO.leggiCliente(8);
            // Prodotto p = ProdottoDAO.leggiProdotto(13);
            // DettaglioOrdine dettaglio = new DettaglioOrdine(p, 1);
            // Ordine o = new Ordine(c, dettaglio);
            // OrdineDAO.creaOrdine(o);

            // Ordine o = OrdineDAO.leggiOrdine(2);
            // System.out.println(o);

            // o.getDettaglioOrdine().setQuantita(2);
            // OrdineDAO.modificaOdine(o);
            // OrdineDAO.eliminaOrdine(o);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void generaClienti(int num) throws SQLException {
        for (int i = 0; i < num; i++) {
            String name = fake.name().firstName();
            String lastname = fake.name().lastName();
            String email = name.toLowerCase() + "." + lastname.toLowerCase() + "@" + fake.internet().domainName();
            String phone = fake.phoneNumber().cellPhone();
            ClienteDAO.salvaCliente(new Cliente(name, lastname, email, phone));
        }
    }

    public static void generaProdotti(int num) throws SQLException {
        for (int i = 0; i < num; i++) {
            String nome = fake.commerce().productName();
            String descrizione = fake.lorem().paragraph();
            double prezzo = fake.number().randomDouble(2, 10, 1000);
            int quantitaDisponibile = fake.number().numberBetween(0, 10);
            ProdottoDAO.salvaProdotto(new Prodotto(nome,descrizione,prezzo,quantitaDisponibile));
        }
    }
}
