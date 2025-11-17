package Esercizio;

public class GestioneBiblioteca {
    public static void main(String[] args) {
        Libro l1 = new Libro("Orbit orbit", "Caparezza", "9791256291649");
        Libro l2 = new Libro("Sotto mentite spoglie", "Antonio Manzini", "9788838948978");
        Libro l3 = new Libro("La bugia dell'orchidea", "Donato Carrisi", "9788830460577");
        Libro l4 = new Libro("Mandorla amara", "Cristina Cassar Scalia", "9788806260309");
        Libro l5 = new Libro("Fiori per Algernon", "Daniel Keyes", "9788850241910");

//        System.out.println(l1.getDettagli());
//        System.out.println(l2.getDettagli());
//        System.out.println(l3.getDettagli());


        Utente u1 = new Utente("Mario", "Rossi");
        Utente u2 = new Utente("Giuseppe", "Verdi");
        Utente u3 = new Utente("Francesca", "Neri");


        Biblioteca b = new Biblioteca("Biblio Manzoni");

        b.aggiungiLibro(l1);
        b.aggiungiLibro(l1);
        b.aggiungiLibro(l2);
        b.aggiungiLibro(l3);
        b.aggiungiLibro(l4);
        b.aggiungiLibro(l5);

        b.registraUtente(u1);
        b.registraUtente(u2);
        b.registraUtente(u3);

        b.mostraCatalogo();
        b.mostraUtentiRegistrati();

        b.prestitoLibro("U02", "9788838948978");
        b.prestitoLibro("U01", "9788838948978");

        b.prestitoLibro("U02", "9791256291649");
        b.prestitoLibro("U02", "9788850241910");
        b.prestitoLibro("U02", "9788806260309");

        b.restituzioneLibro("U02", "9788838948978");
        b.prestitoLibro("U01", "9788838948978");

    }
}
