import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Classi Wrapper
        // Integer | Double | Character | Boolean
        int x = 25;
        String s = new String("Ciao a tutti");
        String st = "Ciao a tutti";

        Integer n = 25;


            // Collections
            // Contenitori dinamici di elementi. A differenza degli array che hanno una dimensione fissa
            // Una collection può essere ordinata o non ordinata, può ammettere duplicato o no.
            // L'interfaccia Collection non specifica nulla di quanto detto sopra
            // Collection
            //   Non memorizza l'ordine in cui sono stati inseriti gli elementi, non definisce se ci possono essere duplicati
            //   Non può contenere valori primitivi ma solo oggetti. Se ho bisogno di dati primitivi devo utilizzare le classi Wrapper
            //   -> List
            //          Gli elementi sono indicizzati può contenere duplicati
            //          I valori inseriti sono memorizzati in base all'ordine di inserimento
            //          Consente di leggere, aggiungere, rimuovere e modificare gli elementi in base ad un indice
            //          La classe principale che implementa List è ArrayList
            //   -> Set
            //          Non ammette duplicati ma gli elementi non sono indicizzati
            //          i valori inseriti NON sono memorizzati in base all'ordine di inserimento
            //          La classe principale che implementa Set è HashSet
            //   -> SortedSet
            //          Non ammette duplicati, ma a differenza di Set gli elementi sono indicizzati
            //          I valori inseriti NON sono memorizzati in base all'ordine di inserimento
            //          La classe principale che implementa SortedSet è TreeSet
            //   -> Queue
            //          Crea una coda che ha dei metodi per leggere, inserire elementi alla fine della coda
            //          La classe principale che implementa Queue è LinkedList
            // Map
            //    Definisce una funzione composta da chiave/valore. Non puo contenere valori primitivi
            //    Se ho bisogno di dati primitivi devo utilizzare le classi Wrapper
            //    Una chiave sarà un valore univoco che servirà alla mappa per recuperare il valore associato
            //    I valori inseriti NON sono memorizzati in base all'ordine di inserimento
            //    La classe principale che implementa Map è HashMap
            //   -> SortedMap
            //      Fornisce un ordine sulle chiavi
            //      La classe principale che implementa SortedMap è TreeMap


        // testCollection();
        // testList();
        // testSet();
        // testQueue();
        // testMap();

    }

    public static void testCollection() {
        Collection<String> c = new HashSet<String>();
        System.out.println("Collection size: " + c.size());

        c.add("Primo Elemento");
        c.add("Secondo Elemento");
        c.add("Terzo Elemento");
        c.add("Quinto Elemento");
        c.add("Sesto Elemento");
        if(!c.contains("Secondo Elemento")) {
            c.add("Secondo Elemento");
        }

        System.out.println("Collection size: " + c.size());

        boolean cont = c.contains("Quarto Elemento");
        System.out.println("Collection element (Quarto Elemento): " + cont);
        boolean cont2 = c.contains("Secondo Elemento");
        System.out.println("Collection element (Secondo Elemento): " + cont2);

        boolean isEmp = c.isEmpty();
        System.out.println("Collection isEmpty: " + isEmp);

        c.remove("Secondo Elemento");
        System.out.println("Collection size: " + c.size());

        for (String str : c) {
            System.out.println(str);
        }

        c.clear();

        isEmp = c.isEmpty();
        System.out.println("Collection isEmpty: " + isEmp);
        System.out.println("Collection size: " + c.size());
    }

    public static void testList() {
        List<String> l = new ArrayList<String>();

        System.out.println("List size: " + l.size());

        l.add("Primo Elemento");
        l.add("Secondo Elemento");
        l.add("Terzo Elemento");
        l.add("Quinto Elemento");
        l.add("Sesto Elemento");
        if(!l.contains("Secondo Elemento")) {
            l.add("Secondo Elemento");
        }

        System.out.println("List size: " + l.size());

        boolean cont = l.contains("Secondo Elemento");
        System.out.println("List element (Secondo Elemento): " + cont);

        boolean isEmp = l.isEmpty();
        System.out.println("List isEmpty: " + isEmp);

        // Metodi di List
        String s = l.get(2);
        System.out.println("Element index 2: " + s);

        l.set(1, "Elemento Modificato");

        int index = l.indexOf("Terzo Elemento");
        System.out.println("Index Element 'Terzo Elemento': " + index);

        l.set(index, "Altro Elemento Modificato");

        l.remove(index);

//        for (int i = 0; i < l.size(); i++) {
//            System.out.println(l.get(i));
//        }

        for (String str : l) {
            System.out.println(str);
        }

        l.clear();
        System.out.println("List isEmpty: " + l.isEmpty());
        System.out.println("Collection size: " + l.size());

    }

    public static void testSet() {
        //Set<String> s = new HashSet<String>();
        SortedSet<String> s = new TreeSet<String>();

        System.out.println("Set size: " + s.size());

        s.add("Primo Elemento");
        s.add("Secondo Elemento");
        s.add("Terzo Elemento");
        s.add("Quinto Elemento");
        System.out.println(s.add("Secondo Elemento")); // Valore duplicato -> false

        // add() -> restituisce true se il valore è stato inserito correttamente nel set
        //          restituisce false se il valore è duplicato e quindi non è stato iserito nel set

        if(s.add("Sesto Elemento")) {
            System.out.println("Valore inserito nel set!");
        } else {
            System.out.println("Valore duplicato!");
        }

        System.out.println("Set size: " + s.size());

        boolean cont = s.contains("Quarto Elemento");
        System.out.println("Set element (Quarto Elemento): " + cont);

        boolean isEmp = s.isEmpty();
        System.out.println("Set isEmpty: " + isEmp);

        s.remove("Secondo Elemento");

        for (String str : s) {
            System.out.println(str);
        }

        //s.clear();
        //System.out.println("Collection isEmpty: " + s.isEmpty());
        //System.out.println("Collection size: " + s.size());

        // Metodi di SortedSet
        String sf = s.first();
        System.out.println("First Element: " + sf);
        String sl = s.last();
        System.out.println("Last Element: " + sl);

    }

    public static void testQueue() {
        Queue<String> q = new LinkedList<String>();
        System.out.println("Queue size: " + q.size());

        q.add("Primo Elemento");
        q.add("Secondo Elemento");
        q.add("Terzo Elemento");
        q.add("Quinto Elemento");
        q.add("Sesto Elemento");



        boolean isEmp = q.isEmpty();
        System.out.println("Queue isEmpty: " + isEmp);

        System.out.println("Queue size: " + q.size());

        q.remove("Secondo Elemento");

        // Metodi di Queue
        String peekFirst = q.peek(); // Legge il primo elemento della coda
        System.out.println("First Element peek: " + peekFirst);

        String pollFirst = q.poll(); // Legge e rimuove il primo elemento della coda
        System.out.println("First Element poll: " + pollFirst);

        System.out.println("Queue size: " + q.size());

        for (String str : q) {
            System.out.println(str);
        }


    }

    public static void testMap() {
        Map<String, String> m = new HashMap<String, String>();
        m.put("A", "Primo Elemento");
        m.put("B", "Secondo Elemento");
        m.put("C", "Terzo Elemento");

        boolean key = m.containsKey("D");
        System.out.println("Contains key 'D': " + key );
        System.out.println("Contains key 'B': " + m.containsKey("B") );

        boolean val = m.containsValue("Secondo Elemento");
        System.out.println("Contains value 'Secondo Elemento': " + val );

        String ele = m.get("B");
        System.out.println("Element key 'B': " + ele );

        int size = m.size();
        System.out.println("Map size : " + size );

        boolean isEmp = m.isEmpty();
        System.out.println("Map isEmpty : " + isEmp );

        Set<String> keyList = m.keySet();
        for(String k : keyList) {
            System.out.println(k + ": " + m.get(k));
        }

        System.out.println("**************************");

        Collection<String> values =  m.values();
        for (String v: values) {
            System.out.println(v);
        }

        m.clear();
        isEmp = m.isEmpty();
        System.out.println("Map isEmpty : " + isEmp );
        size = m.size();
        System.out.println("Map size : " + size );

    }
}