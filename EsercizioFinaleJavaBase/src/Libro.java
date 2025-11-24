public class Libro extends MediaItem implements Ricercabile{

    private int numeroPagine;
    private Categoria genere;

    public Libro(String titolo, int anno, String autore, int numeroPagine, Categoria genere) {
        super(titolo, anno, autore);
        this.setNumeroPagine(numeroPagine);
        this.setGenere(genere);
    }

    public int getNumeroPagine() { return numeroPagine; }
    public Categoria getGenere() { return genere; }

    public void setNumeroPagine(int numeroPagine) {
        if(numeroPagine < 0) throw new IllegalArgumentException("Numero di pagine deve essere > 0");
        this.numeroPagine = numeroPagine;
    }

    public void setGenere(Categoria genere) {
        this.genere = (genere == null) ? Categoria.Altro: genere;
    }

    @Override
    public String getInfoDettagliata() {
        //return "Libro: " + this.getTitolo() + " di " + this.getAutore() + " anno: " + this.getAnno() + " pagine: " + this.getNumeroPagine() + " Genere: " + this.getGenere();
        return String.format("Libro: %s di %s anno: %d pagine: %d Genere: %s",
                this.getTitolo(), this.getAutore(), this.getAnno(),
                this.getNumeroPagine(), this.getGenere());
    }

    @Override
    public boolean matches(String query) {
        if(query == null || query.isBlank()) return  false;
        String q = query.toLowerCase();
        return this.getTitolo().toLowerCase().contains(q) || getAutore().toLowerCase().contains(q);
    }

    @Override
    public String toString() {
        return "Libro " + super.toString() +
                " numeroPagine=" + numeroPagine +
                ", genere=" + genere;
    }
}
