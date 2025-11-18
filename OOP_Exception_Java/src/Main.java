import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("Hello World!!!");



        int result = 0;
        try {
            result = calcolaDivisione();
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("La divisione è: " + result);



    }

    public static int calcolaDivisione() throws CustomException {
        int num1 = inserisciValore();
        int num2 = inserisciValore();

        try {
            int div = num1 / num2;
            if(div % 2 == 0) { throw new CustomException("Non voglio numeri pari!!!!"); }
            return div;
        } catch (ArithmeticException e) {
            System.out.println("Non puoi dividere per 0");
            return 0;
        }

    }

    public static int inserisciValore() {
        try {
            System.out.print("Inserisci un numero: ");
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Valore errato!!");
            return 1;
        }
    }
}