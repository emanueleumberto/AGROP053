package Esercizio;

public class GestioneDipendenti {

    public static void main(String[] args) {
        DipendenteFullTime d1 = new DipendenteFullTime("AB001", "Mario Rossi", Dipartimento.PRODUZIONE);
        DipendenteFullTime d2 = new DipendenteFullTime("AB002", "Giuseppe Verdi", Dipartimento.VENDITE);
        DipendentePartTime d3 = new DipendentePartTime("AB003", "Francesca Neri", Dipartimento.AMMINISTRAZIONE, 20);
        Dirigente d4 = new Dirigente("AB004", "Antonio Bianchi", Dipartimento.PRODUZIONE);
        DipendentePartTime d5 = new DipendentePartTime("AB005", "Luigi Viola", Dipartimento.PRODUZIONE, 30);
        DipendenteFullTime d6 = new DipendenteFullTime("AB006", "Mara Gialli", Dipartimento.AMMINISTRAZIONE);
        DipendentePartTime d7 = new DipendentePartTime("AB007", "Giovanni Viola", Dipartimento.VENDITE, 10);
        Dirigente d8 = new Dirigente("AB008", "Giorgia Bianchi", Dipartimento.AMMINISTRAZIONE);
        Dipendente d9 = new DipendentePartTime("AB009", "Paolo Verdi", Dipartimento.PRODUZIONE, 30);

        Dipendente[] dipendenti = new Dipendente[10];
        dipendenti[0] = d1;
        dipendenti[1] = d2;
        dipendenti[2] = d3;
        dipendenti[3] = d4;
        dipendenti[4] = d5;
        dipendenti[5] = d6;
        dipendenti[6] = d7;
        dipendenti[7] = d8;
        dipendenti[8] = d9;

        for(int i=0; i< dipendenti.length; i++) {
            if(dipendenti[i] != null) {
                System.out.println(dipendenti[i].info());
            }
        }


    }

}
