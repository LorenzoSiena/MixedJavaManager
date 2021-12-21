/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package photoalbummanager;

import java.util.Objects;

/**
 *
 * @author lorenzo
 */
public class Fotografia {

    private String descrizione;//

    private String IDfoto;////KEY
    private int larghezza;
    private int altezza;
    private int dimensioneKB;
    private String dataFoto;

    public Fotografia(String descrizione, String IDfoto, int larghezza, int altezza, int dimensioneKB, String dataFoto) {
        this.descrizione = descrizione;
        this.IDfoto = IDfoto;
        this.larghezza = larghezza;
        this.altezza = altezza;
        this.dimensioneKB = dimensioneKB;
        this.dataFoto = dataFoto;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getIDfoto() {
        return IDfoto;
    }

    public int getLarghezza() {
        return larghezza;
    }

    public int getAltezza() {
        return altezza;
    }

    public int getDimensioneKB() {
        return dimensioneKB;
    }

    public String getDataFoto() {
        return dataFoto;
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
        final Fotografia other = (Fotografia) obj;
        if (!Objects.equals(this.IDfoto, other.IDfoto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fotografia{" + "descrizione=" + descrizione + ", IDfoto=" + IDfoto + ", larghezza=" + larghezza + ", altezza=" + altezza + ", dimensioneKB=" + dimensioneKB + ", dataFoto=" + dataFoto + '}';
    }

}
