public abstract class Veicolo {

    private String marca;
    private String modello;
    private String colore;
    private static int count = 0;

    public Veicolo(String marca, String modello, String colore) {
        this.marca = marca;
        this.modello = modello;
        this.colore = colore;
        count++;
    }

    public String getMarca() { return marca; }
    public String getModello() { return modello; }
    public String getColore() { return colore; }

    public static void getCount() {
        System.out.println("Numero di veicoli creati: " + count);
    }

    public abstract void start();

    @Override
    public String toString() {
        return this.marca + " " + this.modello + " colore: " + this.colore;
    }
}
