/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingmanager;

import java.util.Objects;

/**
 *
 * @author lorenzo
 */
public class Auto {
    private String targa;//key
    private String dataInizio;
    private int oraIn;
    private int oraOut;

    public Auto(String targa, String dataInizio, int oraIn, int oraOut) {
        this.targa = targa;
        this.dataInizio = dataInizio;
        this.oraIn = oraIn;
        this.oraOut = oraOut;
    }

    public String getTarga() {
        return targa;
    }

    public String getDataInizio() {
        return dataInizio;
    }

    public int getOraIn() {
        return oraIn;
    }

    public int getOraOut() {
        return oraOut;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }
    //ho preferito l'equals dell'ide perchè più robusto
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
        final Auto other = (Auto) obj;
        if (!Objects.equals(this.targa, other.targa)) {
            return false;
        }
        return true;
    }

    
    
    
    
    
    @Override
    public String toString() {
        return "Auto{" + "targa=" + targa + ", dataInizio=" + dataInizio + ", oraIn=" + oraIn + ", oraOut=" + oraOut + '}';
    }
    
    
}
