public class Automobile extends Veicolo {

    private int numPorte;

    public Automobile(String marca, String modello, int numPorte, String colore) {
        super(marca, modello, colore);
        this.numPorte = numPorte;
    }

    public void start() {
        System.out.println("Start Automobile!");
    }

    public void autoradio() {
        System.out.println("Start Autoradio!");
    }

    @Override
    public String info() {
        return super.info() + " num.porte: " + this.numPorte;
    }
}
