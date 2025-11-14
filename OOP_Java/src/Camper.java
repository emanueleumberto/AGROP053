public class Camper extends Veicolo {

    private int numLetti;

    public Camper(String marca, String modello, int numLetti, String colore) {
        super(marca, modello, colore);
        this.numLetti = numLetti;
    }

    public void start() {
        System.out.println("Start Camper!");
    }

    @Override
    public String info() {
        return super.info() +  " Num.Letti: " + this.numLetti;
    }
}
