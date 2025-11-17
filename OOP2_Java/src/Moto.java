public class Moto extends Veicolo{

    private boolean bauletto;

    public Moto(String marca, String modello, String colore, boolean bauletto) {
        super(marca, modello, colore);
        this.bauletto = bauletto;
    }

    public boolean isBauletto() { return bauletto; }
    public void setBauletto(boolean bauletto) { this.bauletto = bauletto; }

    public void start() {
        System.out.println("Start Moto!");
    }

    @Override
    public String toString() {
        return super.toString() + " bauletto: " + this.bauletto;
    }
}
