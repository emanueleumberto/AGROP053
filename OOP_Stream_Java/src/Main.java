import java.util.*;
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


