public abstract class Veicolo {

    protected String marca;
    protected String modello;
    protected String colore;

    public Veicolo(String marca, String modello, String colore) {
        this.marca = marca;
        this.modello = modello;
        this.colore = colore;
    }

    public abstract void start();

    public String info() {
        return this.marca + " - " + this.modello + " Colore: " + this.colore;
    }
}
