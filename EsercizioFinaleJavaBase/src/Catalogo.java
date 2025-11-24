import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Catalogo {

    private final List<MediaItem> items = new ArrayList<>();

    public void aggiungiMediaItems(MediaItem item) {
        if(item == null) throw new IllegalArgumentException("Elemento nullo!!!");
        items.add(item);
    }

    public void getAll() {
        // Stampare tutti gli elementi raggruppati per tipo
        // List<Libro> libri = getLibri();
        // List<Film> film = getFilm();
        // List<AlbumMusicale> album = getAlbum();

        groupingByType()
                .forEach((k, v) -> {
                    System.out.println(k.getName() + ":  " + v.size());
                    v.forEach(m -> System.out.println("    - " + m.getInfoDettagliata()));
                });
    }

    // Metodi sostituiti da groupingByType()
//    public List<Libro> getLibri() {
////        List<Libro> listaLibri = new ArrayList<>();
////        for (MediaItem i : this.items) {
////            if(i instanceof Libro) {
////                listaLibri.add((Libro)i);
////            }
////        }
//
//        return items.stream()
//                .filter(i -> i instanceof Libro)
//                .map(i -> (Libro) i)
//                .toList();
//    }

//    public List<Film> getFilm() {
//        return items.stream()
//                .filter(i -> i instanceof Film)
//                .map(i -> (Film) i)
//                .toList();
//    }

//    public List<AlbumMusicale> getAlbum() {
//        return items.stream()
//                .filter(i -> i instanceof AlbumMusicale)
//                .map(i -> (AlbumMusicale) i)
//                .toList();
//    }

    public Map<? extends Class<? extends MediaItem>, List<MediaItem>> groupingByType() {
        return items.stream().collect(Collectors.groupingBy(MediaItem::getClass));
    }

    public List<MediaItem> cerca(String query) throws ElementoNonTrovatoException {
//        return items.stream()
//                .filter(i -> (i instanceof Ricercabile))
//                .map(i -> (Ricercabile) i)
//                .filter(i -> i.matches(query))
//                .map(i -> (MediaItem) i)
//                .collect(Collectors.toList());
        List<MediaItem> risultati =  items.stream()
                .filter(i -> (i instanceof Ricercabile) && ((Ricercabile) i).matches(query))
                .toList();

        if(risultati.isEmpty()) throw new ElementoNonTrovatoException("Nessun elemento trovato!!");
        return risultati;
    }

    public List<MediaItem> filtraPerAnno(int anno) {
        return items.stream().filter(i -> i.getAnno() == anno).toList();
    }

    public List<MediaItem> ordinaPerTitolo() {
        return items.stream().sorted(Comparator.comparing(MediaItem::getTitolo)).toList();
    }

    public List<MediaItem> ordinaPerAnno() {
        return items.stream().sorted(Comparator.comparingInt(MediaItem::getAnno)).toList();
    }

    public Map<String, Long> raggruppaContaPerAutore() {
        return items.stream()
                .collect(Collectors.groupingBy(MediaItem::getAutore, Collectors.counting()));
    }

    public double mediaAnnoPubblicazione(String classe) {
    return items.stream()
            .filter(i -> i.getClass().getName().equals(classe))
            .mapToInt(MediaItem::getAnno)
            .average()
            .orElse(0);
    }
}
