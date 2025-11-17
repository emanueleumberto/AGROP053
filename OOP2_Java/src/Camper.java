public class Camper extends Veicolo implements Navigatore{

    private int numLetti;

    public Camper(String marca, String modello, String colore, int numLetti) {
        super(marca, modello, colore);
        this.numLetti = numLetti;
    }

    public int getNumLetti() { return numLetti; }

    public void start() {
        System.out.println("Start Camper!");
    }

    @Override
    public String toString() {
        return super.toString() + " Posti letto: " + this.numLetti;
    }

    @Override
    public void startNavigatore() {

    }

    @Override
    public void stopNavigatore() {

    }

    @Override
    public void impostaMappa() {

    }

    @Override
    public void aggiornaNavigatore() {
        System.out.println("Navigatore Camper aggiornato!");
    }
}
