/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museopaoloorsi;

import java.util.*;

/**
 *
 * @author lorenzo
 */
public class Sala {

    private String nomeSala;
    private int codiceSala;
    private String periodoStorico;
    private String collocazione;
    private LinkedList<Opera> listaOpere;

    public Sala(String nomeSala, int codice, String periodoStorico, String collocazione) {
        this.nomeSala = nomeSala;
        this.codiceSala = codice;
        this.periodoStorico = periodoStorico;
        this.collocazione = collocazione;
        listaOpere = new LinkedList<>();
    }

    public String getNomeSala() {
        return nomeSala;
    }

    public int getCodiceSala() {
        return codiceSala;
    }

    public String getPeriodoStorico() {
        return periodoStorico;
    }

    public String getCollocazione() {
        return collocazione;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sala other = (Sala) obj;
        if (this.codiceSala != other.codiceSala) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String str = "Sala{" + "nomeSala=" + nomeSala + ", codice=" + codiceSala + ", periodoStorico=" + periodoStorico + ", collocazione=" + collocazione + '}';

        for (Opera opera : listaOpere) {
            str += "\n" + opera.toString();
        }

        return str;
    }

    void addOpera(Opera op) {
        listaOpere.add(op);
    }

    public void delOpera(int codOpera) throws NoOperaExistException {

        for (Opera opera : listaOpere) {
            if (opera.equals(new Opera(codOpera, "", "", 0))) {

                listaOpere.remove(opera);
                System.out.println("Opera Rimossa");
                return;
            }
        }
        throw new NoOperaExistException();
    }

    public float sommaOpereSala(String autore) {
        float somma = 0;
        for (Opera opera : listaOpere) {
            if (opera.getAutore().equals(autore)) {
                somma += opera.getPrezzoStimato();
            }
        }
        return somma;
    }

}
