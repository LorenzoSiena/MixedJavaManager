/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancamediolanum;

/**
 *
 * @author lorenzo
 */
public class Movimento {
    private int tipologia;//0 addebito 1 accredito
    private String descrizione;
    private float importo;
    private String data; //AAAA/MM/GG

    public Movimento(int tipologia, String descrizione, float importo, String data) {
        this.tipologia = tipologia;
        this.descrizione = descrizione;
        this.importo = importo;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Data:" +data+" Tipologia: "+tipologia+" Descrizione:"+descrizione+" Importo:"+importo+" euro ";
    }

    public String getData() {
        return data;
    }

    public int getTipologia() {
        return tipologia;
    }

    public float getImporto() {
        return importo;
    }
    
    
    
    
}
