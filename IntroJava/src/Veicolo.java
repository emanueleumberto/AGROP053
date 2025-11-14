public class Veicolo {

    public String marca;
    public String modello;
    public String targa;
    public int anni;
    public boolean stato;

    public void start() {
        this.stato = true;
        System.out.println("Automobile start!");
    }

    public void stop() {
        this.stato = false;
        System.out.println("Automobile stop!");
    }

    public void info() {
        System.out.println("Automobile " + this.marca + " " + this.modello + " (" + this.targa + ") start: " + this.stato );
    }

}
