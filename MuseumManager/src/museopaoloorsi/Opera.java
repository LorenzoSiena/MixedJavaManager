/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museopaoloorsi;

/**
 *
 * @author lorenzo
 */
public class Opera {

    private int codOpera;
    private String autore;
    private String tipologia; //statua quadro installazione artistica ecc...
    private float prezzoStimato;

    public Opera(int codOpera, String autore, String tipologia, float prezzoStimato) {
        this.codOpera = codOpera;
        this.tipologia = tipologia;
        this.autore = autore;
        this.prezzoStimato = prezzoStimato;
    }

    public int getCodOpera() {
        return codOpera;
    }

    public String getAutore() {
        return autore;
    }

    public String getTipologia() {
        return tipologia;
    }

    public float getPrezzoStimato() {
        return prezzoStimato;
    }

    @Override
    public String toString() {
        return "Opera{" + "codOpera=" + codOpera + ", autore=" + autore + ", tipologia=" + tipologia + ", prezzoStimato=" + prezzoStimato + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Opera other = (Opera) obj;
        if (this.codOpera != other.codOpera) {
            return false;
        }
        return true;
    }

}
