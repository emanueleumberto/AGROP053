package Esercizio_2;

public class Immagine extends ElementoMultimediale implements GestioneLuminosita {

    private int luminosita;

    public Immagine(String titolo, int luminosita) {
        super(titolo);
        this.luminosita = luminosita;
    }

    public int getLuminosita() { return luminosita; }

    public void show() {
        System.out.println(this.getTitolo() +
                "*".repeat(this.getLuminosita()));
    }

    @Override
    public void aumentaLuminosita() {
        if(this.luminosita < 10) {
            this.luminosita++;
        } else {
            System.out.println("Valore massimo raggiunto!");
        }
    }

    @Override
    public void diminuisciLuminosita() {
        if(this.luminosita > 0) {
            this.luminosita--;
        } else {
            System.out.println("Valore minimo raggiunto!");
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                " luminosità: " + luminosita;
    }
}
