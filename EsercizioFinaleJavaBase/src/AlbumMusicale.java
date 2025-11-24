public class AlbumMusicale extends MediaItem implements Ricercabile{

    private int numeroTracce;
    private String etichetta;

    public AlbumMusicale(String titolo, int anno, String autore, int numeroTracce, String etichetta) {
        super(titolo, anno, autore);
        this.setNumeroTracce(numeroTracce);
        this.setEtichetta(etichetta);
    }

    public int getNumeroTracce() { return numeroTracce; }
    public String getEtichetta() { return etichetta; }

    public void setNumeroTracce(int numeroTracce) {
        if(numeroTracce <= 0) throw new IllegalArgumentException("Numero tracce non può essere inferiore a 0");
        this.numeroTracce = numeroTracce;
    }

    public void setEtichetta(String etichetta) {
        this.etichetta = etichetta == null ? "---" : etichetta.trim();
    }

    @Override
    public String getInfoDettagliata() {
        return String.format("Album: %s di %s anno: %d tracce: %d Etichetta: %s",
                this.getTitolo(), this.getAutore(), this.getAnno(),
                this.getNumeroTracce(), this.getEtichetta());
    }

    @Override
    public boolean matches(String query) {
        if(query == null || query.isBlank()) return  false;
        String q = query.toLowerCase();
        return this.getTitolo().toLowerCase().contains(q)
                || getAutore().toLowerCase().contains(q)
                || getEtichetta().toLowerCase().contains(q);
    }
}
