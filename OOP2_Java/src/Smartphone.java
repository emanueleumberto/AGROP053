public class Smartphone implements Navigatore {

    private String marca;
    private String modello;
    private String colore;
    private int memoria;

    public Smartphone(String marca, String modello, String colore, int memoria) {
        this.marca = marca;
        this.modello = modello;
        this.colore = colore;
        this.memoria = memoria;
    }

    public String getMarca() { return marca; }
    public String getModello() { return modello; }
    public String getColore() { return colore; }
    public int getMemoria() { return memoria; }

    @Override
    public String toString() {
        return "Smartphone{" +
                "marca='" + marca + '\'' +
                ", modello='" + modello + '\'' +
                ", colore='" + colore + '\'' +
                ", memoria=" + memoria +
                '}';
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
        System.out.println("Navigatore Smartphone aggiornato!");
    }
}
