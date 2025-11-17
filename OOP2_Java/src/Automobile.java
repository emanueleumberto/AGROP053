public class Automobile extends Veicolo implements Navigatore{

    private int numPorte;

    public Automobile(String marca, String modello, String colore, int numPorte) {
        super(marca, modello, colore);
        this.numPorte = numPorte;
    }

    public int getNumPorte() { return numPorte; }

    public void start() {
        System.out.println("Start Automobile!");
    }

    @Override
    public String toString() {
        return super.toString() + " Num.Porte: " + this.numPorte;
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
        System.out.println("Navigatore Automobile aggiornato!");
    }
}
