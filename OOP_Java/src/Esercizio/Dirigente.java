package Esercizio;

public class Dirigente extends Dipendente {

    public Dirigente(String matricola, String nomeCompleto, Dipartimento dipartimento) {
        super(matricola, nomeCompleto, dipartimento);
    }

    public double calculateSalary() {
        return this.getStipendio() * 2;
    }

    public String info() {
        return super.info() + " -> € " + this.calculateSalary();
    }

}

