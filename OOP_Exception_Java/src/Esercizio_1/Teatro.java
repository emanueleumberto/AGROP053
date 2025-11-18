package Esercizio_1;

public class Teatro {

    private String nome;
    private boolean posti[];

    public Teatro(String nome, int numPosti) {
        this.nome = nome;
        this.posti = new boolean[numPosti];
    }

    public String getNome() { return nome; }
    public boolean[] getPosti() { return posti; }

    public void prenotaPosto(int numeroPosto) throws PostoNonValidoException, PostoGiaOccupatoException, PostiTerminatiException {
        // Teatro Pieno
        if(!postiDisponibili()) {
            throw new PostiTerminatiException("Sold Out!!!");
        }

        // Posto fuori range
        if(numeroPosto <= 0 || numeroPosto-1 > posti.length) {
            throw new PostoNonValidoException("Valore non valido, devi inserire un valore compreso tra 1 e " + this.posti.length);
        }
        // Posto occupato
        if(posti[numeroPosto-1]) {
            throw new PostoGiaOccupatoException("Posto " + numeroPosto + " occupato!!");
        }
        this.posti[numeroPosto -1] = true;
        System.out.println("Prenotazione posto " + numeroPosto + " effettuata correttamente!");
    }

    public boolean postiDisponibili() {
        for (int i = 0; i < posti.length; i++) {
            if(!posti[i]) {
                return true;
            }
        }
        return false;
    }

}
