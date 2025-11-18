package Esercizio_2;

public abstract class ElementoMultimediale {

    private String titolo;

    public ElementoMultimediale(String titolo) {
        this.titolo = titolo;
    }

    public String getTitolo() { return titolo; }

    @Override
    public String toString() {
        return "Titolo: " + titolo;
    }
}
