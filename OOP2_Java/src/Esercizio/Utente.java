package Esercizio;

public class Utente {

    private static int count = 0;
    private String nome;
    private String cognome;
    private String IDUtente;
    private Libro[] listaPrestiti;

    public Utente(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
        this.IDUtente = count < 10 ? "U0"+ ++count : "U" + ++count;
        this.listaPrestiti = new Libro[3];
    }

    public String getNome() { return nome; }
    public String getCognome() { return cognome; }
    public String getIDUtente() { return IDUtente; }
    public Libro[] getListaPrestiti() { return listaPrestiti; }

    public void prendereInPrestito(Libro libro) {
        // → Aggiunge il libro alla lista e aggiorna la disponibilità
        if(libro.isDisponibile()) { // Controllo se il libro che voglio prender ein prestito è disponibile
            for (int j = 0; j < this.listaPrestiti.length; j++) {
                if(this.listaPrestiti[j] == null) {
                    this.listaPrestiti[j] =  libro;
                    libro.prestareLibro();
                    return;
                }
            }
            System.out.println("Hai già 3 libri in possesso!!");
        } else {
            System.out.println("Libro " + libro.getTitolo() + " non disponibile!!");
        }
    }

    public void restituireLibro(Libro libro) {
        //restituireLibro(Libro libro) → Rimuove il libro dalla lista e aggiorna la disponibilità

        for (int i = 0; i < this.listaPrestiti.length; i++) {
            if(this.listaPrestiti[i] != null && this.listaPrestiti[i].getISBN().equals(libro.getISBN())) {
                libro.restituireLibro();
                this.listaPrestiti[i] = null;
                return;
            }
        }

        System.out.println("Il libro che vuoi restituire non è in tuo possesso!!");

    }

    public void mostraLibriInPrestito() {
        //mostraLibriInPrestito() → Stampa i libri presi in prestito dall'utente
        System.out.println("Libri presi in prestito da " + this.nome + " " + this.cognome);
        for (int i = 0; i < listaPrestiti.length; i++) {
            if(listaPrestiti[i] != null) {
                System.out.println("   - " + listaPrestiti[i].getTitolo());
            }
        }
    }


}