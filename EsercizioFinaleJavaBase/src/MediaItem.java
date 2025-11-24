public abstract class MediaItem {

    private String titolo;
    private int anno;
    private String autore;

    public MediaItem(String titolo, int anno, String autore) {
        this.setTitolo(titolo);
        this.setAnno(anno);
        this.setAutore(autore);
    }

    public String getTitolo() { return titolo; }
    public int getAnno() { return anno; }
    public String getAutore() { return autore; }

    public void setTitolo(String titolo) {
        if(titolo == null || titolo.isBlank()) { throw new IllegalArgumentException("Titolo non valido!");}
        this.titolo = titolo.trim();
    }

    public void setAnno(int anno) {
        if(anno < 0) { throw new IllegalArgumentException("Il valore di anno non può essere negativo!");}
        this.anno = anno;
    }

    public void setAutore(String autore) {
        if(autore == null || autore.isBlank()) autore = "Anonimo";
        this.autore = autore.trim();
    }

    @Override
    public String toString() {
        return " titolo='" + titolo + '\'' +
                ", anno=" + anno +
                ", autore='" + autore + ", ";
    }

    public abstract String getInfoDettagliata();
}
