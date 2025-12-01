package Esercizio.entities;

import java.time.LocalDate;

public class Ordine {

    private int id_ordine;
    private Cliente cliente;
    private LocalDate data_ordine;
    private DettaglioOrdine dettaglioOrdine;

    public Ordine(Cliente cliente, DettaglioOrdine dettaglioOrdine) {
        this.cliente = cliente;
        this.dettaglioOrdine = dettaglioOrdine;
    }

    public Ordine(int id_ordine, Cliente cliente, LocalDate data_ordine, DettaglioOrdine dettaglioOrdine) {
        this.id_ordine = id_ordine;
        this.cliente = cliente;
        this.data_ordine = data_ordine;
        this.dettaglioOrdine = dettaglioOrdine;
    }

    public int getId_ordine() {
        return id_ordine;
    }

    public void setId_ordine(int id_ordine) {
        this.id_ordine = id_ordine;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getData_ordine() {
        return data_ordine;
    }

    public void setData_ordine(LocalDate data_ordine) {
        this.data_ordine = data_ordine;
    }

    public DettaglioOrdine getDettaglioOrdine() {
        return dettaglioOrdine;
    }

    public void setDettaglioOrdine(DettaglioOrdine dettaglioOrdine) {
        this.dettaglioOrdine = dettaglioOrdine;
    }

    @Override
    public String toString() {
        return "Ordine{" +
                "id_ordine=" + id_ordine +
                ", cliente=" + cliente +
                ", data_ordine=" + data_ordine +
                ", dettaglioOrdine=" + dettaglioOrdine +
                '}';
    }
}
