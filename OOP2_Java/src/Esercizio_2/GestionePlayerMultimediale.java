package Esercizio_2;

import java.util.Scanner;

public class GestionePlayerMultimediale {

    public static void main(String[] args) {
        Audio a1 = new Audio("MioAudio", 3, 5);
        Video v1 = new Video("MioVideo", 5, 6, 3);
        Immagine i1 = new Immagine("Miaimg", 5);

        // a1.play();
        // a1.alzaVolume();
        // a1.abbassaVolume();
        // System.out.println(a1);

        // v1.play();
        // v1.alzaVolume();
        // v1.abbassaVolume();
        // v1.aumentaLuminosita();
        // v1.diminuisciLuminosita();
        // System.out.println(v1);

        // i1.show();
        // i1.aumentaLuminosita();
        // i1.diminuisciLuminosita();
        // System.out.println(i1);

        ElementoMultimediale[] arr = new ElementoMultimediale[5];
        arr[0] = a1;
        arr[1] = v1;
        arr[2] = i1;
        arr[3] = null;
        arr[4] = null;

        Scanner sc = new Scanner(System.in);

//        System.out.println("Quale elemento vuoi eseguire? Inserisci un valore da 1 a 5 o digita 0 per terminare");
//        int valore = Integer.parseInt(sc.nextLine());
//
//        while (valore >= 0 && valore < 6) {
//            if(valore == 0) {
//                System.out.println("FINE");
//                return;
//            } else {
//                System.out.println("Il valore inserito è: " + valore);
//            }
//            System.out.println("Quale elemento vuoi eseguire? Inserisci un valore da 1 a 5 o digita 0 per terminare");
//            valore = Integer.parseInt(sc.nextLine());
//        }

//        while (true) {
//            System.out.println("Quale elemento vuoi eseguire? Inserisci un valore da 1 a 5 o digita 0 per terminare");
//            int valore = Integer.parseInt(sc.nextLine());
//            if(valore == 0) {
//                System.out.println("FINE");
//                return;
//            } else {
//                System.out.println("Il valore inserito è: " + valore);
//            }
//
//        }

        do {
            for (int i = 0; i < arr.length; i++) {
                if(arr[i] != null) {
                    System.out.println(i + 1 + " - " + arr[i].getTitolo() + " (" + arr[i].getClass() + ")");
                }
            }


            System.out.println("Quale elemento vuoi eseguire? Inserisci un valore o digita 0 per terminare");
            int valore = Integer.parseInt(sc.nextLine());
            if(valore == 0) {
                System.out.println("FINE");
                return;
            } else {
                // System.out.println("Il valore inserito è: " + valore);
                for (int i = 0; i < arr.length; i++) {
                    if(i+1 == valore) {
                        if(arr[i] != null) {
                            // System.out.println(arr[i].getTitolo());
                            if(arr[i] instanceof ElementoRiproducibile) {
                                ElementoRiproducibile a = (ElementoRiproducibile) arr[i];
                                a.play();
                            } else if(arr[i] instanceof Immagine) {
                                Immagine im = (Immagine) arr[i];
                                im.show();
                            } else {
                                System.out.println("Elemento sconosciuto!!");
                            }
                        }
                    }
                }
            }
        } while (true);
    }

}
