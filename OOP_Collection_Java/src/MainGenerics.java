public class MainGenerics {

    public static void main(String[] args) {
        // Generics -> consentono di scrivere classi, interfacce o semplici metodi generici
        //              utilizzabili con diversi tipi di dato senza dover specificare in anticipo
        //              il tipo di dato esatto.
        //              Ciò rende il codice più flessibile e riutilizzabile

        MiaClasseStringa ms = new MiaClasseStringa();
        MiaClasseIntero mi = new MiaClasseIntero();

        MiaClasseGenerics<String, Integer> mgs = new MiaClasseGenerics<>("Abc", 25);
        mgs.setValore("Ciao");

        MiaClasseGenerics<Integer, Integer> mgi = new MiaClasseGenerics<>(15, 25);
        mgi.setValore(25);
    }

}
