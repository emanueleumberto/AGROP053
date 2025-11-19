package Soluzione_2;

public class GestioneTeatro {
    static Teatro t = new Teatro("Topolino", 10);

    public static void main(String[] args){
        try {
            Uomo u = new Uomo("Mario", "Rossi", "AB123CD5F123");
            Donna d = new Donna("Francesca", "Neri", "RE987TY2TR25");

            t.prenotaPosto(8, u);
            //t.prenotaPosto(18, d);
            t.prenotaPosto(3, d);
            //t.prenotaPosto(8, d);
            // t.prenotaPosto(5, u);
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
            if(t.getPosti()[i] == null) {
                System.out.println(i + 1 + " - " + t.getPosti()[i]);
            }
        }
    }

}
