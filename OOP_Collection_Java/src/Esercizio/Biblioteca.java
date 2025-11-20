package Esercizio;

import Esercizio.Exceptions.LettoreException;
import Esercizio.Exceptions.LibroException;
import Esercizio.Exceptions.PrestitoException;

import java.util.*;

public class Biblioteca {

    private String nome;
    private List<Libro> libriDisponibili;
    private Set<Lettore> utentiRegistrati;
    private Map<Lettore, Set<Libro>> prestiti;

    public Biblioteca(String nome) {
        this.nome = nome;
        this.libriDisponibili = new ArrayList<Libro>();
        this.utentiRegistrati = new HashSet<Lettore>();
        this.prestiti = new HashMap<Lettore, Set<Libro>>();
    }

    public String getNome() { return nome; }
    public List<Libro> getLibriDisponibili() { return libriDisponibili; }
    public Set<Lettore> getUtentiRegistrati() { return utentiRegistrati; }
    public Map<Lettore, Set<Libro>> getPrestiti() { return prestiti; }

    public void aggiungiLibro(Libro libro) {
        // aggiunge un nuovo libro alla biblioteca.
        this.libriDisponibili.add(libro);
    }

    public void registraLettore(Lettore lettore) throws LettoreException {
        // registra un nuovo lettore.
        if(!this.utentiRegistrati.add(lettore)) {
            // System.out.println("Utente già registrato!");
            throw new LettoreException("Utente già registrato!");
        }
    }

    public boolean prestaLibro(Lettore lettore, String isbn) throws LibroException, LettoreException {
        // assegna un libro a un lettore se disponibile,
        //    restituendo true se il prestito è andato a buon fine, altrimenti false.

        Libro lib = trovaLibroDaIsbn(isbn); // utilizzo il metodo trovaLibroDaIsbn per ottenere un libro dato un isbn
        if(lib == null) {throw new LibroException("Codice ISBN non trovato!");} // controllo se il libro esiste nella lista di libri disponibili
        if(!this.getUtentiRegistrati().contains(lettore)) {throw new LettoreException("Lettore non registrato nella biblioteca!");} // controllo se l'utente è presente tra gli utenti registrati
        Set<Libro> prestitiLettore; // creo una collection di libri in prestito
        if(this.prestiti.containsKey(lettore)) { // controllo se nella mappa dei prestiti c'è già un lettore con dei prestiti in corso
            prestitiLettore = this.prestiti.get(lettore); // se il lettore ha già dei prestiti in corso leggo la lista di prestiti
        } else {
            prestitiLettore = new HashSet<Libro>(); // altrimenti ne creo una nuova di lista di prestiti
        }

        prestitiLettore.add(lib); // aggiungo il nuovo libro alla lista di prestiti
        this.prestiti.put(lettore, prestitiLettore); // salvo la lista di prestiti associata alla chiave Lettore nella mappa di prestiti
        this.libriDisponibili.remove(lib); // Rimuovo il libro preso in prestito dalla lista dei libri disponibili
        System.out.println("Libro " + lib.getTitolo() + " preso in prestito da " + lettore.getNome());
        return true;
    }

    public boolean restituisciLibro(Lettore lettore, String isbn) throws LettoreException, LibroException {
        // permette al lettore di restituire un libro.
        if(!this.getUtentiRegistrati().contains(lettore)) {throw new LettoreException("Lettore non registrato nella biblioteca!");} // controllo se l'utente è presente tra gli utenti registrati
        if(!this.prestiti.containsKey(lettore)) {throw new LettoreException("Lettore non ha nessun prestito attivo!");} // controllo se l'utente è presente nella lista dei prestiti

        for (Libro lib : this.prestiti.get(lettore)) { // ciclo nella mappa prestiti tutti i libri presi in prestito dal lettore
            if(lib.getIsbn().equals(isbn)) { // controllo se c'è un libro con ISBN uguale a quello che voglio riconsegnare
                this.prestiti.get(lettore).remove(lib); // rimuovo il libro dal set dei prestiti del lettore
                this.libriDisponibili.add(lib); // Aggiungo di nuovo illibro riconsegnato nella lista dei libri disponibili
                System.out.println("Libro " + lib.getTitolo() + " restituito da " + lettore.getNome());
                return true;
            }
        }
        // Sollevo un eccezione se il libro è esistente, il lettore è registrato e ha dei prestiti attivi MA il codice ISBN del libro
        // che si vuole restituire non è presente nella lista di prestiti associata al lettore
        throw new LibroException("Il libro con ISBN: " + isbn + " non è presente tra i tuoi prestiti");
    }

    public Set<Libro> getLibriInPrestito(Lettore lettore) throws PrestitoException {
        // restituisce l'insieme dei libri attualmente presi in prestito da un lettore.
        if(this.prestiti.containsKey(lettore)) {
            return this.prestiti.get(lettore);
        } else {
            throw new PrestitoException("Nessun prestito è stato effettuato da questo lettore");
        }
    }

    public void stampaPrestiti(){
        // stampa tutti i lettori con i rispettivi libri in prestito.
        for (Lettore let : this.prestiti.keySet()) {
            System.out.println("Libri presi in prestito da " + let.getNome());
            for (Libro lib : this.prestiti.get(let)){
                System.out.println("   - " + lib);
            }
        }
    }

    private Libro trovaLibroDaIsbn(String isbn) {
        for (Libro l : this.libriDisponibili) {
            if(l.getIsbn().equals(isbn)) {
                return l;
            }
        }
        return null;
    }
}
