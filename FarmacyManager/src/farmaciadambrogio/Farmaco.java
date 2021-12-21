/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmaciadambrogio;

import java.util.Objects;

/**
 *
 * @author lorenzo
 */
public class Farmaco {

    private String nome;
    private String codice;
    private float costo;
    private String dataAcquisto;

    public String getNome() {
        return nome;
    }

    public String getCodice() {
        return codice;
    }

    public float getCosto() {
        return costo;
    }

    public String getDataAcquisto() {
        return dataAcquisto;
    }

    public Farmaco(String nome, String codice, float costo, String dataAcquisto) {
        this.nome = nome;
        this.codice = codice;
        this.costo = costo;
        this.dataAcquisto = dataAcquisto;
    }
    
    @Override 
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    //Tecnicamete funziona(tasto destro ->insert code->equals-> codice) (hashcode() è in omaggio ma non serve) 
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
        final Farmaco other = (Farmaco) obj;
        if (!Objects.equals(this.codice, other.codice)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Farmaco{" + "nome=" + nome + ", codice=" + codice + ", costo=" + costo + ", dataAcquisto=" + dataAcquisto + '}';
    }

}
