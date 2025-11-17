package Esercizio;

public class Libro {

    private String titolo;
    private String autore;
    private String ISBN;
    private boolean disponibile;

    public Libro(String titolo, String autore, String ISBN) {
        this.titolo = titolo;
        this.autore = autore;
        this.ISBN = ISBN;
        this.disponibile = true;
    }

    public String getTitolo() { return titolo; }
    public String getAutore() { return autore; }
    public String getISBN() { return ISBN; }
    public boolean isDisponibile() { return disponibile; }

    public String getDettagli() {
        // getDettagli() → Restituisce una stringa con i dettagli del libro
        return "Libro: " + this.titolo + " Autore: " + this.autore + " ISBN: " + this.ISBN + " Disponibile: " + this.disponibile;
    }

    public void prestareLibro() {
        // prestareLibro() → Imposta disponibile = false se il libro è disponibile, altrimenti stampa libro non disponibile
        if(this.isDisponibile()) {
            this.disponibile = false;
            System.out.println("Libro " + this.titolo + " preso in prestito!!");
        } else {
            System.out.println("Libro " + this.titolo + " non disponibile!!");
        }
    }

    public void restituireLibro() {
        // restituireLibro() → Imposta disponibile = true se il libro era in prestito, altrimenti stampa un Errore
        if(!this.isDisponibile()) {
            this.disponibile = true;
            System.out.println("Libro " + this.titolo + " restituito!!");
        } else {
            System.out.println("Errore!!!");
        }
    }



}
