package Esercizio;

import Esercizio.Exceptions.LettoreException;
import Esercizio.Exceptions.LibroException;

public class GestioneBiblioteca {

    private static Biblioteca b = new Biblioteca("MiaBiblio");

    public static void main(String[] args) {

        Lettore l1 = new Lettore("Mario Rossi", "m.rossi@example.com");
        Lettore l2 = new Lettore("Giuseppe Verdi", "g.verdi@example.com");
        Lettore l3 = new Lettore("Francesca Neri", "f.neri@example.com");
        Lettore l4 = new Lettore("Antonio Bianchi", "a.bianchi@example.com"); // Utente NON registrato

        Libro b1 = new Libro("9791256291649", "Orbit orbit", "Caparezza", 2025);
        Libro b2 = new Libro("9788838948978", "Sotto mentite spoglie", "Antonio Manzini", 2022);
        Libro b3 = new Libro("9788830460577", "La bugia dell'orchidea", "Donato Carrisi",2000 );
        Libro b4 = new Libro("9788806260309", "Mandorla amara", "Cristina Cassar Scalia", 2024);
        Libro b5 = new Libro("9788850241910", "Fiori per Algernon", "Daniel Keyes", 1998);

        b.aggiungiLibro(b1);
        b.aggiungiLibro(b2);
        b.aggiungiLibro(b3);
        b.aggiungiLibro(b4);
        b.aggiungiLibro(b5);

        try {
            b.registraLettore(l1);
            b.registraLettore(l2);
            b.registraLettore(l3);
        } catch (LettoreException e) {
            System.out.println(e.getMessage());
        }

        try {
            b.prestaLibro(l2, "9788830460577");
            b.prestaLibro(l1, "9788850241910");
            b.prestaLibro(l2, "9791256291649");
            b.stampaPrestiti();

            // b.restituisciLibro(l4, "9788830460577"); // Provo a restituire un libro con un utente NON registrato
            // b.restituisciLibro(l3, "9788830460577"); // Provo a restituire un libro con un utente registrato ma che non ha prestiti attivi
            // b.restituisciLibro(l1, "9788830460577"); // Provo a restituire un libro che non è tra i prestiti attivi dell'utente
            b.restituisciLibro(l2, "9788830460577"); // Restituzione corretta

        } catch (LibroException | LettoreException e) {
            System.out.println(e.getMessage());
        }


        // stampaUtentiRegistrati();
        // stampaLibriDisponibili();
        // b.stampaPrestiti();
    }

    public static void stampaUtentiRegistrati() {
        System.out.println("Utenti registrati (" + b.getUtentiRegistrati().size() + "): ");
        for(Lettore l : b.getUtentiRegistrati()){
            System.out.println("   -> " + l);
        }
    }

    public static void stampaLibriDisponibili() {
        System.out.println("Libri disponibili (" + b.getLibriDisponibili().size() + "): ");
        for(Libro l : b.getLibriDisponibili()){
            System.out.println("   -> " + l);
        }
    }
}
