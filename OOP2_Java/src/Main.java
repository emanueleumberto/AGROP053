import java.util.List;

public class Main {
    public static void main(String[] args) {

        Automobile a1 = new Automobile("Fiat", "Punto", "Nero", 3);
        Moto m1 = new Moto("Honda", "Hornet", "Rosso", false);
        Camper c1 = new Camper("Laika", "Ab123", "Bianco", 5);
        Automobile a2 = new Automobile("Ford", "Fiesta", "Verde", 5);
        Smartphone s1 = new Smartphone("Apple", "Iphone", "Argento", 8);
        Automobile a3 = new Automobile("Renault", "Clio", "Nero", 3);
        // Veicolo.getCount();

        Veicolo[] veicoli = new Veicolo[10];
        veicoli[0] = a1;
        veicoli[1] = m1;
        veicoli[2] = c1;
        veicoli[3] = a2;
        veicoli[4] = a3;

        for (int i = 0; i < veicoli.length; i++) {
            Veicolo v = veicoli[i];
            if(v != null) {
                System.out.println(v);
                // v.start();
            }
        }


        Navigatore[] nav = new Navigatore[10];
        nav[0] = a1;
        nav[1] = s1;
        nav[2] = c1;

        for (int i = 0; i < nav.length; i++) {
            nav[i].aggiornaNavigatore();
        }

        Navigatore n1 = new Automobile("Renault", "Clio", "Nero", 3);
        Navigatore n2 = new Smartphone("Apple", "Iphone", "Argento", 8);
    }
}