package Esercizio_2;

public class Video extends ElementoRiproducibile implements GestioneVolume, GestioneLuminosita{

    private int volume;
    private int luminosita;

    public Video(String titolo, int durata, int volume, int luminosita) {
        super(titolo, durata);
        this.volume = volume;
        this.luminosita = luminosita;
    }

    public int getVolume() { return volume; }
    public int getLuminosita() { return luminosita; }

    @Override
    public void play() {
//        Titolo -> MioVideo
//        Durata -> 3
//        Volume -> 5
//        Luminosità -> 2
//        play() -> MioVideo!!!!!**
//                MioVideo!!!!!**
//                MioVideo!!!!!**

        for (int i = 0; i < this.getDurata(); i++) {
            System.out.println(this.getTitolo() +
                                    "!".repeat(this.getVolume()) +
                                    "*".repeat(this.getLuminosita()));
        }
    }

    @Override
    public void alzaVolume() {
        if(this.volume < 6) {
            this.volume++;
        } else if(this.volume < 10) {
            this.volume++;
            System.out.println("Attenzione!! Non tenere il volume troppo alto.");
        } else {
            System.out.println("Volume massimo raggiunto!");
        }
    }

    @Override
    public void abbassaVolume() {
        if(this.volume > 0) {
            this.volume--;
        } else {
            System.out.println("Volume minimo raggiunto!");
        }
    }

    @Override
    public void aumentaLuminosita() {
        if(this.luminosita < 10) {
            this.luminosita++;
        } else {
            System.out.println("Valore massimo raggiunto!");
        }
    }

    @Override
    public void diminuisciLuminosita() {
        if(this.luminosita > 0) {
            this.luminosita--;
        } else {
            System.out.println("Valore minimo raggiunto!");
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                " volume: " + volume + " luminosità: " + luminosita;
    }
}
