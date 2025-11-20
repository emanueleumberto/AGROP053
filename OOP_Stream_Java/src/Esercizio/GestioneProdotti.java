package Esercizio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GestioneProdotti {

    private static List<Prodotto> listaProdotti = new ArrayList<Prodotto>();

    public static void main(String[] args) {


//        1 - Creare una lista di almeno 10 prodotti con valori diversi.
            creaProdotti();
//        2 - Filtrare e stampare i prodotti con prezzo superiore a 50€.
            filtraStampaProdotti50();
//        3 - Estrarre una lista dei nomi dei prodotti appartenenti a una categoria specifica (es. "Elettronica").
            getProdottiDaCategoria("FOOD").forEach(System.out::println);
//        4 - Calcolare e stampare il prezzo medio di tutti i prodotti.
            prezzoMedio();
//        5 - Verificare se almeno un prodotto della lista ha un prezzo inferiore a 10€.
            prezzoUnder10();
//        6 - Extra: Ordinare la lista in base al prezzo in modo crescente e stamparla.
            oridnaProdottoPerPrezzo();
//        7 - Extra: Raggruppare i prodotti per categoria e visualizzarli.
            raggruppaPerCategoria();
    }

    public static void creaProdotti() {
        listaProdotti.add(new Prodotto("Apple", "FRUIT", 1.99, 20));
        listaProdotti.add(new Prodotto("Pasta", "FOOD", 2.49, 15));
        listaProdotti.add(new Prodotto("Bread", "FOOD", 1.49, 25));
        listaProdotti.add(new Prodotto("Nike Sneakers", "SHOES", 79.99, 10));
        listaProdotti.add(new Prodotto("Adidas Running Shoes", "SHOES", 89.99, 8));
        listaProdotti.add(new Prodotto("Evening Gown", "DRESS", 120.00, 5));
        listaProdotti.add(new Prodotto("Casual T-Shirt", "DRESS", 15.99, 18));
        listaProdotti.add(new Prodotto("Samsung Galaxy", "PHONE", 699.99, 7));
        listaProdotti.add(new Prodotto("iPhone 14", "PHONE", 999.99, 4));
        listaProdotti.add(new Prodotto("Banana", "FRUIT", 0.99, 30));
        System.out.println("Lista di " + listaProdotti.size() + " prodotti creata!");
    }

    public static void filtraStampaProdotti50() {
        listaProdotti.stream().filter(p -> p.getPrezzo()>50).forEach(System.out::println);
    }

    public static List<String> getProdottiDaCategoria(String categoria) {
        return listaProdotti.stream()
                    .filter(p -> p.getCategoria().equals(categoria))
                    .map(Prodotto::getNome)
                    .toList();
    }

    public static void prezzoMedio() {
        double prezzoMedio = listaProdotti.stream()
                .mapToDouble(Prodotto::getPrezzo)
                .average()
                .orElse(0);
        System.out.println("Prezzo medio dei prodotti: " + prezzoMedio);
    }

    public static void prezzoUnder10() {
        boolean under10 = listaProdotti.stream().anyMatch(p -> p.getPrezzo()<10);
        System.out.println("Prodotto con prezzo inferiore a 10: " + under10);
    }

    public static void oridnaProdottoPerPrezzo() {
        listaProdotti.stream()
                .sorted(Comparator.comparingDouble(Prodotto::getPrezzo))
                .forEach(System.out::println);

//        listaProdotti.stream()
//                .sorted(Comparator.comparingInt(Prodotto::getQuantitaDisponibile))
//                .forEach(System.out::println);
    }

    public static void raggruppaPerCategoria() {
        Map<String, List<Prodotto>> mappaProdottiPerCategoria =
                listaProdotti.stream().collect(Collectors.groupingBy(Prodotto::getCategoria));

        mappaProdottiPerCategoria.forEach((key, val) -> System.out.println(key + " -> " + val));
    }
}
