package Esercizio;

public abstract class Dipendente {

    private String matricola;
    private String nomeCompleto;
    private double stipendioBase;
    private double stipendio;
    private Dipartimento dipartimento;

    public Dipendente(String matricola, String nomeCompleto, Dipartimento dipartimento) {
        this.matricola = matricola;
        this.nomeCompleto = nomeCompleto;
        this.dipartimento = dipartimento;
        this.stipendioBase = 1200.00;
        this.stipendio = calcolaStipendio();
    }

    public String getMatricola() { return matricola; }
    public String getNomeCompleto() { return nomeCompleto; }
    public double getStipendioBase() { return stipendioBase; }
    public void setStipendioBase(double stipendioBase) { this.stipendioBase = stipendioBase; }
    public double getStipendio() { return stipendio; }
    public Dipartimento getDipartimento() { return dipartimento; }
    public void setDipartimento(Dipartimento dipartimento) {
        this.dipartimento = dipartimento;
        this.stipendio = calcolaStipendio();
    }

    public abstract double calculateSalary();

    private double calcolaStipendio() {
        if(this.dipartimento.equals(Dipartimento.PRODUZIONE)) {
            return this.stipendioBase + (this.stipendioBase * 0.2);
        } else if (this.dipartimento.equals(Dipartimento.VENDITE)) {
            return this.stipendioBase + (this.stipendioBase * 0.3);
        } else if (this.dipartimento.equals(Dipartimento.AMMINISTRAZIONE)) {
            return this.stipendioBase + (this.stipendioBase * 0.4);
        } else {
            return this.stipendioBase;
        }
    }

    public String info() {
        return this.getMatricola() + " - " + this.getNomeCompleto() + " (" + this.getDipartimento() + ") ";
    }

}
