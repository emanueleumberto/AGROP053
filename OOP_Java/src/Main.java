public class Main {

    public static void main(String[] args) {

        Animal a1 = new Animal("Bobby", 3, "Dog", "Labrador");
        // System.out.println(a1);
//        a1.name = "Bobby";
//        a1.age = 3;
//        a1.type = "Dog";
//        a1.category = "Labrador";

        Animal a2 = new Animal("Rex", 1, "Dog", "Pastore Tedesco");
        // System.out.println(a1);
//        a2.name = "Rex";
//        a2.age = 1;
//        a2.type = "Dog";
//        a2.category = "Pastore Tedesco";

        a1.setAge(4);

        a1.info();
        a2.info();

        // Un linguaggio OOP si poggia su 4 concetti fondamentali
        // -> Incasulamento
        // -> Ereditarietà
        // -> Astrazione
        // -> Polimorfismo

        // Modificatori di accesso
        // public | private | protected | package o default

        Automobile auto1 = new Automobile("Fiat", "Panda", 3, "Rosso");
        Moto moto1 = new Moto("Honda", "Hornet", true, "Nero");
        Camper camper1 = new Camper("Laika", "Ab123", 5, "Bianco");
        Camion camion1 = new Camion("Iveco", "Daily", "Verde");
        // Veicolo veicolo1 = new Veicolo("--", "--",  "--");

        auto1.autoradio();
        moto1.interfono();
        camper1.info();

        Veicolo[] arr = new Veicolo[4];
        arr[0] = auto1;
        arr[1] = moto1;
        arr[2] = camper1;
        arr[3] = camion1;

//        System.out.println(auto1.info());
//        System.out.println(moto1.info());
//        System.out.println(camper1.info());

        for(int i=0; i<arr.length; i++) {
            Veicolo v = arr[i];

            // v.start();
            System.out.println(v.info());

            // System.out.println(v);

            if(v instanceof Automobile) {
                Automobile a = (Automobile) v;
                a.autoradio();
            } else if (v instanceof Moto) {
                Moto m = (Moto) v;
                m.interfono();
            }
        }
    }

}
