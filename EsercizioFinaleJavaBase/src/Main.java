import com.github.javafaker.Faker;

import java.sql.SQLOutput;
import java.util.Locale;

public class Main {

    private static Faker fake = new Faker(new Locale("it-IT"));
    private static Categoria[] categorie = {Categoria.Horror, Categoria.Fantasy, Categoria.Romantico, Categoria.Letteratura, Categoria.Altro};

    public static void main(String[] args) {
        Catalogo c = new Catalogo();

        for (int i = 0; i < 25; i++) {
            int r = fake.random().nextInt(1,3);
            if(r == 1) {
                c.aggiungiMediaItems(createLibro());
            } else if(r==2) {
                c.aggiungiMediaItems(createFilm());
            } else {
                c.aggiungiMediaItems(createAlbum());
            }
        }

        c.getAll();

        try {
            System.out.println("Elementi Ricercati: ");
            c.cerca("the").forEach(i -> System.out.println(i.getInfoDettagliata()));
        } catch (ElementoNonTrovatoException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
        System.out.println("Elementi filtrati per Anno:");
        c.filtraPerAnno(2017).forEach(i -> System.out.println(i.getInfoDettagliata()));

        System.out.println();
        System.out.println("Elementi ordinati per titolo: ");
        c.ordinaPerTitolo().forEach(i -> System.out.println(i.getInfoDettagliata()));

        System.out.println();
        System.out.println("Elementi ordinati per anno: ");
        c.ordinaPerAnno().forEach(i -> System.out.println(i.getInfoDettagliata()));

        System.out.println();
        System.out.println("Elementi raggruppati per Autore: ");
        c.raggruppaContaPerAutore().forEach((k, v) -> System.out.println(k + " -> " + v));

        System.out.println();
        System.out.println("Media Anno pubblicazione Libri: " + c.mediaAnnoPubblicazione("Libro"));
        System.out.println("Media Anno pubblicazione Film: " + c.mediaAnnoPubblicazione("Film"));
        System.out.println("Media Anno pubblicazione Audio: " + c.mediaAnnoPubblicazione("AlbumMusicale"));
    }

    private static MediaItem createLibro() {
        return new Libro(
                fake.book().title(),
                fake.number().numberBetween(1990, 2025),
                fake.book().author(),
                (int) fake.number().randomNumber(3, true),
                categorie[fake.random().nextInt(0, categorie.length-1)]);
    }

    private static MediaItem createFilm() {
        return new Film(
                fake.book().title(),
                fake.number().numberBetween(1990, 2025),
                fake.book().author(),
                fake.random().nextInt(15, 180),
                fake.book().author(),
                categorie[fake.random().nextInt(0, categorie.length-1)]);
    }

    private static MediaItem createAlbum() {
        return new AlbumMusicale(
                fake.book().title(),
                fake.number().numberBetween(1990, 2025),
                fake.book().author(),
                fake.random().nextInt(5, 15),
                fake.company().name());
    }

}