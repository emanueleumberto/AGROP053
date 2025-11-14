public class App {

    public static void main(String[] args) {
//        Veicolo v = new Veicolo();
//        v.marca = "Fiat";
//        v.modello = "Panda";
//        v.anni = 1;
//        v.targa = "AB123CD";
//        v.stato = false;

//        Veicolo v2 = new Veicolo();
//        v2.marca = "Renault";
//        v2.modello = "Clio";
//        v2.anni = 2;
//        v2.targa = "CD456EF";
//        v2.stato = false;

        Automobile v = new Automobile("Fiat", "Panda", 3);
        v.targa = "AB123CD";
        Automobile v2 = new Automobile("Renault", "Clio", 5);

        Moto m1 = new Moto("Honda", "Hornet");

        Camper c1 = new Camper("Laika", "Ab123", 7);

        // System.out.println(v);
        // System.out.println(v2);
        // v.start();

        v.info();
        v2.info();

        m1.info();
        c1.info();


    }

}
