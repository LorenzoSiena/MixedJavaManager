/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingmanager;

import java.util.*;

/**
 *
 * @author lorenzo
 */
public class Parcheggio {

    private String idParcheggio; //key
    private String indirizzo;
    private int CapienzaMax;
    private float tariffaOraria;
    private LinkedList<Auto> listaAuto;

    public Parcheggio(String idParcheggio, String indirizzo, int CapienzaMax, float tariffaOraria) {
        this.idParcheggio = idParcheggio;
        this.indirizzo = indirizzo;
        this.CapienzaMax = CapienzaMax;
        this.tariffaOraria = tariffaOraria;
        listaAuto = new LinkedList<>();
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public int getCapienzaMax() {
        return CapienzaMax;
    }

   

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Parcheggio other = (Parcheggio) obj;
        if (!Objects.equals(this.idParcheggio, other.idParcheggio)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        String stringa = "Parcheggio{" + "idParcheggio=" + idParcheggio + ", indirizzo=" + indirizzo + ", CapienzaMax=" + CapienzaMax + ", tariffaOraria=" + tariffaOraria + ", listaAuto=" + listaAuto + '}';

        System.out.println("Contiene le seguenti auto:");
        for (Auto auto : listaAuto) {

            stringa += "\n" + auto;

        }

        return stringa;

    }

    boolean isFull() {
        if (listaAuto.size() >= CapienzaMax) {
            return true;
        } else {
            return false;
        }
    }

    void addAuto(Auto auto) {
        listaAuto.add(auto);
    }

    boolean CapienzaSotto50(String data) {
        int nMacchine = 0;

        for (Auto auto : listaAuto) {
            if (data.equals(auto.getDataInizio())) {
                nMacchine += 1;
            }
        }

        if (nMacchine < CapienzaMax / 2) {
            return true;

        } else {
            return false;
        }
    }
    
    
    float ricavoParcheggio(){
        float tot=0;
            
            for (Auto auto : listaAuto) {
                
            tot+=((auto.getOraOut()- auto.getOraIn())*tariffaOraria);
        }
        
        return tot;
    
    }
    
    void eliminaAutoUnOra() { //l'auto ha sostato per meno di un ora (viene arrotondato altrimenti sarebbe auto.getOraOut()==auto.getOraIn()+1)

        for (Auto auto : listaAuto) {
            if (auto.getOraIn() == auto.getOraOut()) {
                listaAuto.remove(auto);
            }
        }

    }

    String StampaSoloParcheggio() {
       return "Parcheggio{" + "idParcheggio=" + idParcheggio + ", indirizzo=" + indirizzo + ", CapienzaMax=" + CapienzaMax + ", tariffaOraria=" + tariffaOraria + ", listaAuto=" + listaAuto + '}';

    }

}
