import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Classi -> PascalCase -> Prima lettera maiuscola e poi ogi ulteriore Parola con la prima lettera maiuscola (IntroJava)
        // Interfacce -> PascalCase -> Prima lettera maiuscola e poi ogi ulteriore Parola con la prima lettera maiuscola (IntroJava)
        // Enumeration -> PascalCase -> Prima lettera maiuscola e poi ogi ulteriore Parola con la prima lettera maiuscola (IntroJava)

        // Metodi -> camelCase -> Prima lettera minuscola e poi ogi ulteriore Parola con la prima lettera maiuscola (introJava)
        // Variabili -> camelCase -> Prima lettera minuscola e poi ogi ulteriore Parola con la prima lettera maiuscola (introJava)
        // Package -> snakeCase -> Prima lettera minuscola e poi ogi ulteriore Parola con la prima lettera minuscola ma collegata con underscore (intro_java)
        // Costanti -> snakeCase -> Tutto in Maiuscolo e poi ogi ulteriore Parola  collegata con underscore (INTRO_JAVA)

        // Tipi di dato primitivi
        // boolean  -> 1  bit
        // char     -> 16 bit
        // byte     -> 8  bit
        // short    -> 16 bit
        // int      -> 32 bit
        // long     -> 64 bit
        // float    -> 32 bit
        // double   -> 64 bit

        int x = 25;
        boolean y = true;
        double z = 25.5;

        // Tipo di dato String
        String str = "Ciao a tutti";

        // Operatori di assegnamento
        // =

        // Operatori aritmetici
        // + - * / %

        int n1 = 10;
        int n2 = 3;

        int s = n1 / n2;
        int r = n1 % n2;

        System.out.println(s);
        System.out.println(r);

        // Operatori aritmetici di assegnamento
        // += -= *= /= %=

        int zc = 10;
        zc = zc + 2;
        zc += 2;

        // Operatore unario di pre o post incremento/decremento
        int o = 5;

//        o = o + 1;
//        o += 1;
//        o++;

        // int p = o++;
        int p = ++o;

        System.out.println("O -> " + o);
        System.out.println("P -> " + p);

        // Operatori relazionali -> Restituiscono sempre un valore booleano
        // == != < > <= >=

        // Operatori Logici
        // && || !

        // condizione1 && condizione 2 --> true && true --> true
        // condizione1 && condizione 2 --> true && false --> false
        // condizione1 && condizione 2 --> false && true --> false
        // condizione1 && condizione 2 --> false && false --> false

        // condizione1 || condizione 2 --> true || true --> true
        // condizione1 || condizione 2 --> true || false --> true
        // condizione1 || condizione 2 --> false || true --> true
        // condizione1 || condizione 2 --> false || false --> false

        // !true --> false
        // !false --> true

        // Scanner -> richiedere dati da terminale
        Scanner sc = new Scanner(System.in);
        System.out.print("Inserisci il tuo nome: ");
        String nome = sc.nextLine();
        System.out.println("Ciao " + nome);

        // Metodo di una classe
        // modificatore tipoRitorno nomeMetodo(tipoParamentro nomeParamentro) { blocco di istruzioni }

        // Main m = new Main();
        // m.somma(25, 10);

        somma(25, 10);
        somma();
    }

    public static void somma() {
        int result = 50 + 10;
        System.out.println("Il risultato della somma è: " + result);
    }

    public static void somma(int x, int y) {
        int result = x + y;
        System.out.println("Il risultato della somma è: " + result);
    }

}

