public class MiaClasseGenerics<T, E> {

    T valore;
    E altro;

    public T getValore() {
        return valore;
    }

    public void setValore(T valore) {
        this.valore = valore;
    }

    public MiaClasseGenerics(T valore, E altro) {
        this.valore = valore;
        this.altro = altro;
    }

    public E getAltro() {
        return altro;
    }

    public void setAltro(E altro) {
        this.altro = altro;
    }

    public String restituisciTesto() {
        return this.valore + " " + this.altro;
    }
}
