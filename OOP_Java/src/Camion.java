public class Camion extends Veicolo {

    public Camion(String marca, String modello, String colore) {
        super(marca, modello, colore);
    }

    @Override
    public void start() {
        System.out.println("Start Camion!");
    }
}
