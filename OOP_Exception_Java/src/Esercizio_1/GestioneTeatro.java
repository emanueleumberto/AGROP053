package Esercizio_1;

public class GestioneTeatro {
    static Teatro t = new Teatro("Topolino", 10);

    public static void main(String[] args){
        try {
            t.prenotaPosto(8);
            t.prenotaPosto(3);
            t.prenotaPosto(5);
            t.prenotaPosto(2);
            t.prenotaPosto(3);
        } catch (PostoNonValidoException e) {
            System.out.println(e.getMessage());
            stampaPostiDisponibili();
        } catch (PostoGiaOccupatoException e) {
            System.out.println(e.getMessage());
            stampaPostiDisponibili();
        } catch (PostiTerminatiException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void stampaPostiDisponibili() {
        for (int i = 0; i < t.getPosti().length; i++) {
            if(!t.getPosti()[i]) {
                System.out.println(i + 1 + " - " + t.getPosti()[i]);
            }
        }
    }

}
