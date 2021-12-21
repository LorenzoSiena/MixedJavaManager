/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monterossomusic;

import java.util.*;

/**
 *
 * @author lorenzo
 */
public class Artist {

    private String nomeArtist;
    private int tipologia;//0=artista 1=gruppo
    private String genere;
    private LinkedList<Album> listaAlbum;

    public LinkedList<Album> getListaAlbum() {
        return listaAlbum;
    }

    public Artist(String nomeArtist, int tipologia, String genere) {
        this.nomeArtist = nomeArtist;
        this.tipologia = tipologia;
        this.genere = genere;
        listaAlbum = new LinkedList<>();
    }

    public void addAlbum(Album a) {
        listaAlbum.add(a);
    }

    public String getNomeArtist() {
        return nomeArtist;
    }

    public int getTipologia() {
        return tipologia;
    }

    public String getGenere() {
        return genere;
    }

    @Override
    public String toString() {
        String str;
        if (tipologia == 0) {
            str = " Artista: " + nomeArtist + ", genere=" + genere;

        } else {
            str = " Gruppo: " + nomeArtist + ", genere=" + genere;

        }
        str += "\n\tDiscografia";
        for (Album album : listaAlbum) {

            str += "\n" + album.toString();

        }
        return str;
    }

    void delAlbum(int codice) {

        try {

            for (Album album : listaAlbum) {
                if (album.getCodiceAlbum() == codice) {
                    listaAlbum.remove(album);
                    return;
                }
            }
            throw new NoAlbumFoundException();

        } catch (NoAlbumFoundException e) {
            System.out.println("Errore: l'album non esiste");
            System.exit(-1);
        }

    }

    void stampaDiscografia() {
        for (Album album : listaAlbum) {
            System.out.println("\n" + album);
        }
    }

    int sommaAlbumVenduti() {
        int tot = 0;

        for (Album album : listaAlbum) {
            tot += album.getCopieVendute();
        }

        return tot;

    }

    public Album topSellAlbum() {
        Album x = null;
        float max = 0;
        float temp = 0;

        for (Album album : listaAlbum) {
            temp = album.getCosto() * album.getCopieVendute();
            if (temp > max) {
                max = temp;
                x = album;
            }
        }
        return x;
    }

}
