import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        // Lo Stream è un interfaccia che restituisce un flusso di dati
        // su cui è possibile fare delle operazioni

        // La sorgente di uno Stream è l'elemento che lo genera -> Collection, Array, Stream

        Collection<String> c = new ArrayList<>();
        c.add("Java");
        c.add("Javascript");
        c.add("Python");
        c.add("C#");
        c.add("NodeJS");
        c.add("Php");

        String[] arr = {"Java", "Javascript", "Python", "C#", "NodeJS", "Php"};

        List<String> lista = Arrays.asList(arr);
        List<String> listaString = Arrays.asList("Java", "Javascript", "Python", "C#", "NodeJS", "Php");

//        Random rand = new Random();
//        double d = rand.nextDouble();
//        System.out.println(d);

        // Sorgente di tipo Stream
        Stream<String> myStream1 = c.stream();
        Stream<String> myStream2 = lista.stream();
        Stream<String> myStream3 = listaString.stream();
        Stream<String> myStream4 = Stream.of("Java", "Javascript", "Python", "C#", "NodeJS", "Php");
        Stream<Integer> myStream5 = Stream.iterate(0, n -> n+2).limit(10);
        Stream<Double> myStream6 = Stream.generate(new Random()::nextDouble).limit(10);
        Stream<String> myStream7 = Stream.<String>builder().add("Java").add("Javascript").add("Python").build();

        // Posso operare su uno Stream in due modi:
        // -> Tramite operazioni intermedie
        // -> Tramite operazioni finali

        // Operazioni intermedie
        // Sono tutte quelle operazioni che effettuano delle trasformazioni dello Stream
        // e restituiscono uno Stream modificato
        // Le operazioni intermedie possono essere concatenate
        // e la concatenazione di operazioni intermedie viene chiamate pipeline
        // Le operazioni intermedie si dividono in :
        //  --> iteration
        //  --> filtering
        //  --> mapping

        Stream<String> myStream = Stream.of("Java", "Javascript", "Python", "Java", "C#", "NodeJS", "Php");
//        myStream = myStream.distinct();
//        myStream = myStream.filter(str -> str.length() > 3);
//        myStream = myStream.sorted();
//        myStream.forEach(str -> System.out.println(str));

//        myStream.distinct()
//                .filter(str -> str.length() > 3)
//                .map(str -> str + "!!!")
//                .sorted()
//                .limit(3)
//                .forEach(str -> System.out.println(str));


        List<String> listaModificata =  myStream.distinct()
                .filter(str -> str.length() > 3)
                .map(str -> str + "!!!")
                .sorted()
                .limit(3)
                .toList();

        // listaModificata.forEach(e-> System.out.println(e));

        List<User> userList = new ArrayList<User>();
        userList.add(new User("Mario", "Rossi", "Roma", 25));
        userList.add(new User("Giuseppe", "Verdi", "Milano", 31));
        userList.add(new User("Francesca", "Neri", "Napoli", 19));
        userList.add(new User("Antonio", "Bianchi", "Roma", 29));
        userList.add(new User("Simona", "Viola", "Palermo", 41));

        userList.get(0).getHobby().add("Calcio");
        userList.get(0).getHobby().add("Padel");
        userList.get(2).getHobby().add("Calcio");
        userList.get(3).getHobby().add("Golf");
        userList.get(3).getHobby().add("Calcio");
        userList.get(1).getHobby().add("Padel");
        userList.get(1).getHobby().add("Calcio");
        userList.get(4).getHobby().add("Tennis");

//        List<User> userListFiltrata = new ArrayList<User>();
//        for (User u : userList) {
//            if(u.getAge() > 29) {
//                userListFiltrata.add(u);
//            }
//        }

        List<User> userListFiltrata = userList.stream().filter(u -> u.getAge() > 29).toList();

        OptionalDouble age =  userList.stream()
                //.forEach(System.out::println);
                .mapToInt(User::getAge)
                //.max();
                //.min();
                //.sum();
                .average();
        System.out.println(age.getAsDouble());

        userList.stream()
                .flatMap(u -> u.getHobby().stream())
                .distinct()
                .forEach(System.out::println);

        System.out.println("*************************");

        // Operazioni finali
        // Sono tutte quelle operazioni che restituiscono un valore finale
        // Terminando la manipolazione dello Stream

        // Matching
        // Reduction
        // Collection

        Stream<Integer> myStreamNum = Stream.iterate(0, n -> n+2).limit(10);
        // myStreamNum.forEach(System.out::println);

        // Reduction
        int numRed = myStreamNum.reduce(0, (acc, val) -> acc + val);
        System.out.println(numRed);

        // equivalente a:
        //        int[] arrNum = {0,2,4,6,8,10,12,14,16,18};
        //        int acc = 0;
        //        for (int i = 0; i < arrNum.length; i++) {
        //            acc += arrNum[i];
        //        }

        // Matching
        myStreamNum = Stream.iterate(0, n -> n+2).limit(10);
        //myStreamNum.anyMatch(e -> e > 5); // true -> almeno un valore è maggiore di 5
        //myStreamNum.allMatch(e -> e > 5 ); // false -> tutti i valori sono maggiori di 5
        //myStreamNum.noneMatch(e -> e > 5); // false -> nessun valore è maggiore di 5

        boolean allCalcio = userList.stream().allMatch(u -> u.getHobby().contains("Calcio"));
        System.out.println("Tutti gli utenti amano il calcio: " + allCalcio);

        boolean anyCalcio = userList.stream().anyMatch(u -> u.getHobby().contains("Calcio"));
        System.out.println("Alcuni utenti amano il calcio: " + anyCalcio);

        boolean noneSci = userList.stream().noneMatch(u -> u.getHobby().contains("Sci"));
        System.out.println("Nessun utente ama lo sci: " + noneSci);

        // Collection
        // .collect(Collectors.toSet()) -> Set<E>
        // .collect(Collectors.toList()) -> List<E>
        // .collect(Collectors.toMap()) -> Map<K, V>
        Stream<Double> myStreamRand = Stream.generate(new Random()::nextDouble).limit(10);
        Set<Long> num =  myStreamRand
                .map(n -> n * 100)
                .map(Math::round)
                //.forEach(System.out::println);
                .collect(Collectors.toSet());
        num.forEach(System.out::println);

        // Collectors
        // Collectors.toSet() -> Raccoglie tutti i dati manipolati dello Stream in un Set
        // Collectors.toList() -> Raccoglie tutti i dati manipolati dello Stream in un List
        // Collectors.toMap() -> Raccoglie tutti i dati manipolati dello Stream in un Map
        // Collectors.groupingBy() -> Raggruppa gli elementi di uno Stream in una mappa in
        //                          cui la chiave sarà la proprietà per il quale voglio raggruppare
        //                          il valore sarà una lista di elementi raggruppati
        // Collectors.summingInt() -> Calcola la somma di valori Int in uno Stream
        // Collectors.summingLong() -> Calcola la somma di valori Long in uno Stream
        // Collectors.summingDouble() -> Calcola la somma di valori Double in uno Stream
        // Collectors.averageingInt() -> Calcola la media di valori Int in uno Stream
        // Collectors.averageingLong() -> Calcola la media di valori Long in uno Stream
        // Collectors.averageingDouble() -> Calcola la media di valori Doble in uno Stream

        // Comparators
        // Comparator è un metodo per la gestione avanzata degli ordinamenti in uno Stream
        // .sorted(Comparator.comparing(Oggetto::Proprietà)
        // .sorted(Comparator.comparingInt(Oggetto::ProprietàInt)
        // .sorted(Comparator.comparingLong(Oggetto::ProprietàLong)
        // .sorted(Comparator.comparingDouble(Oggetto::ProprietàDouble)

        // Mapping
        // .mapToInt(Oggetto::Proprietà) -> Trasforma  uno Stream di oggetti in uno Stream di interi
        // .mapToLong(Oggetto::Proprietà) -> Trasforma  uno Stream di oggetti in uno Stream di long
        // .mapToDouble(Oggetto::Proprietà) -> Trasforma  uno Stream di oggetti in uno Stream di double
        // .flatMap(obj .> obj.prop.stream()) -> Trasforma uno Stream di oggetti in uno Stream di
        //                                      valori letti da uno lista contenuta in una proprietà
        //                                      dell'oggetto

        //testLambdaFunction();
    }

    public static void testLambdaFunction() {
        // () => { blocco di istruzioni }
        // (param) => { blocco di istruzioni }
        // (param1, param2, ..., paramN) => { blocco di istruzioni }
        List<String> listaString = Arrays.asList("Java", "Javascript", "Python", "C#", "NodeJS", "Php");

        System.out.println("******************************");

        for (int i = 0; i < listaString.size(); i++) {
            System.out.println(listaString.get(i));
        }

        System.out.println("******************************");

        for (String s: listaString) {
            System.out.println(s);
        }

        System.out.println("******************************");

        listaString.forEach(e -> System.out.println(e));

    }
}


