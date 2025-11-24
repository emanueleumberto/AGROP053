public class Film extends MediaItem implements Ricercabile{

    private int durata;
    private String regista;
    private Categoria classificazione;

    public Film(String titolo, int anno, String autore, int durata, String regista, Categoria classificazione) {
        super(titolo, anno, autore);
        this.setDurata(durata);
        this.setRegista(regista);
        this.setClassificazione(classificazione);
    }

    public int getDurata() { return durata; }
    public String getRegista() { return regista; }
    public Categoria getClassificazione() { return classificazione; }

    public void setDurata(int durata) {
        if(durata <= 0) throw new IllegalArgumentException("Durata deve essere un valore > 0");
        this.durata = durata;
    }

    public void setRegista(String regista) {
        this.regista = regista == null ? "Anonimo" : regista.trim();
    }

    public void setClassificazione(Categoria classificazione) {
        this.classificazione = (classificazione == null) ? Categoria.Altro: classificazione;
    }


    @Override
    public String getInfoDettagliata() {
        return String.format("Film: %s di %s regista: %s anno: %d durata: %d Calssificazione: %s",
                this.getTitolo(), this.getAutore(), this.getRegista(), this.getAnno(),
                this.getDurata(), this.getClassificazione());
    }

    @Override
    public boolean matches(String query) {
        if(query == null || query.isBlank()) return  false;
        String q = query.toLowerCase();
        return this.getTitolo().toLowerCase().contains(q)
                || getAutore().toLowerCase().contains(q)
                || getRegista().toLowerCase().contains(q);
    }
}
