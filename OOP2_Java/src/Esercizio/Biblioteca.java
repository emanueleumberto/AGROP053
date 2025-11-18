package Esercizio;

public class Biblioteca {

    private String nome;
    private Libro[] catalogoLibri;
    private Utente[] utentiRegistrati;

    public Biblioteca(String nome) {
        this.nome = nome;
        this.catalogoLibri = new Libro[10];
        this.utentiRegistrati = new Utente[10];
    }

    public String getNome() { return nome; }
    public Libro[] getCatalogoLibri() { return catalogoLibri; }
    public Utente[] getUtentiRegistrati() { return utentiRegistrati; }

    public void aggiungiLibro(Libro libro) {
        //    aggiungiLibro(Libro libro) → Aggiunge un libro al catalogo se non esiste
        for (int i = 0; i < this.catalogoLibri.length; i++) {
            if(this.catalogoLibri[i] != null && this.catalogoLibri[i].getISBN().equals(libro.getISBN())){
              System.out.println("Libro " + libro.getTitolo() + " già presente nel catalogo");
              return;
            }
        }

        for (int i = 0; i < this.catalogoLibri.length; i++) {
            if(this.catalogoLibri[i] == null){
                this.catalogoLibri[i] = libro;
                System.out.println(libro.getTitolo() + " iserito nel catalogo!");
                return;
            }
        }

        System.out.println("Catalogo libri completo!");
    }

    public void registraUtente(Utente utente) {
        //    registraUtente(Utente utente) → Aggiunge un utente alla lista se non esiste
        for (int i = 0; i < this.utentiRegistrati.length; i++) {
            if(this.utentiRegistrati[i] != null && this.utentiRegistrati[i].getIDUtente().equals(utente.getIDUtente())){
                System.out.println("Utente " + utente.getNome() + " " + utente.getCognome() + " già presente nel catalogo");
                return;
            }
        }

        for (int i = 0; i < this.utentiRegistrati.length; i++) {
            if(this.utentiRegistrati[i] == null ){
                this.utentiRegistrati[i] = utente;
                System.out.println("Utente " + utente.getNome() + " " + utente.getCognome() + " inserito nel catalogo");
                return;
            }
        }

        System.out.println("Lista utenti utenti completo!");
    }

    public void mostraCatalogo() {
        //    mostraCatalogo() → Stampa tutti i libri con la loro disponibilità
        System.out.println("Catalogo libri: ");
        for (int i = 0; i < this.catalogoLibri.length; i++) {
            if(this.catalogoLibri[i] != null) {
                System.out.println("   - " + this.catalogoLibri[i].getDettagli());
            }
        }
    }

    public void mostraUtentiRegistrati() {
        //    mostraUtentiRegistrati() → Stampa tutti gli utenti registrati
        System.out.println("Lista utenti: ");
        for (int i = 0; i < this.utentiRegistrati.length; i++) {
            if(this.utentiRegistrati[i] != null) {
                System.out.println("   - " + this.utentiRegistrati[i].getIDUtente() + " -> " + this.utentiRegistrati[i].getNome() + " " + this.utentiRegistrati[i].getCognome());
            }
        }
    }

    public void prestitoLibro(String idUtente, String ISBN) {
        //    prestitoLibro(String idUtente, String ISBN) → Permette a un utente di prendere in prestito un libro
        //            (se disponibile) e se non ha già presi 3
        Utente u = cercaUtente(idUtente); // Utente | null
        Libro l = cercaLibro(ISBN); // Libro | null
        if(u != null && l != null) {
            u.prendereInPrestito(l);
        } else {
            System.out.println("Errore!!");
        }
    }

    public void restituzioneLibro(String idUtente, String ISBN) {
        Utente u = cercaUtente(idUtente); // Utente | null
        Libro l = cercaLibro(ISBN); // Libro | null
        if(u != null && l != null) {
            u.restituireLibro(l);
        } else {
            System.out.println("Errore!!");
        }
    }

    public Utente cercaUtente(String idUtente) {
        for (int i = 0; i < this.utentiRegistrati.length; i++) {
            if(this.utentiRegistrati[i] != null && this.utentiRegistrati[i].getIDUtente().equals(idUtente)) {
                return this.utentiRegistrati[i];
            }
        }
        return null;
    }

    public Libro cercaLibro(String ISBN) {
        //    restituzioneLibro(String idUtente, String ISBN) → Permette a un utente di restituire un libro
        for (int i = 0; i < this.catalogoLibri.length; i++) {
            if(this.catalogoLibri[i] != null && this.catalogoLibri[i].getISBN().equals(ISBN)) {
                return this.catalogoLibri[i];
            }
        }
        return null;
    }

}
