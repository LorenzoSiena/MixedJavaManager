/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monterossomusic;

/**
 *
 * @author lorenzo
 */
public class Album {

    private String nomeAlbum;
    private int codiceAlbum;
    private int numBrani;
    private float costo;
    private int copieVendute;

    public Album(String nomeAlbum, int codiceAlbum, int numBrani, float costo, int copieVendute) {
        this.nomeAlbum = nomeAlbum;
        this.codiceAlbum = codiceAlbum;
        this.numBrani = numBrani;
        this.costo = costo;
        this.copieVendute = copieVendute;
    }


    

    public String getNomeAlbum() {
        return nomeAlbum;
    }

    public int getCodiceAlbum() {
        return codiceAlbum;
    }

    public int getNumBrani() {
        return numBrani;
    }

    public float getCosto() {
        return costo;
    }

    public int getCopieVendute() {
        return copieVendute;
    }

    @Override
    public String toString() {
        return "nomeAlbum=" + nomeAlbum + ", codiceAlbum=" + codiceAlbum + ", numBrani=" + numBrani + ", costo=" + costo + ", copieVendute=" + copieVendute;
    }

}
