/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package photoalbummanager;

import java.util.*;

/**
 *
 * @author lorenzo
 */
public class Album {

    private String nome;//KEY
    private String dataCreazione;
    private String descrizione;
    private LinkedList<Fotografia> listaFoto;

    public Album(String nome, String dataCreazione, String descrizione) {
        this.nome = nome;
        this.dataCreazione = dataCreazione;
        this.descrizione = descrizione;
        listaFoto = new LinkedList<>();
    }

    @Override
    public boolean equals(Object obj) { //confronta un valore "nome album" con altri album che hanno "nome album",sono uguali?-> true 
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Album other = (Album) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

    public void addFotografia(Fotografia f) { //aggiunge una foto alla lista
        listaFoto.add(f);
    }

    @Override
    public int hashCode() { //lo fa l'ide quando genero equals-> non serve ma se lo togli si secca l'ide quindi lo lascio
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    public String getNome() {
        return nome;
    }

    public String getDataCreazione() {
        return dataCreazione;
    }

    public String getDescrizione() {
        return descrizione;
    }

    @Override
    public String toString() {
        String str = "Album{" + "nome=" + nome + ", dataCreazione=" + dataCreazione + ", descrizione=" + descrizione + '}';

        for (Fotografia fotografia : listaFoto) {
            str += "\n" + fotografia;
        }
        return str;
    }

    Fotografia localOldFoto() { //torna la fotografia più vecchia dell'album

        
        Fotografia min=new Fotografia("", "", 0, 0, 0, "99999999"); //è una foto dal futuro e viene sostituita subito e fa da limite massimo.-> funziona
       
        for (Fotografia fotografia : listaFoto) {
            
            if (fotografia.getDataFoto().compareTo(min.getDataFoto()) < 0) {
                min = fotografia;
            }

        }
        return min;
    }
    //controlla se l'album è vuoto
    boolean isEmpty() {

        return listaFoto.isEmpty();

    }
    //cerca e distrugge la foto 
    boolean seeknDestroy(String idFoto) {

        for (Fotografia fotografia : listaFoto) {
            if (fotografia.equals(new Fotografia("", idFoto, 0, 0, 0, ""))) {
                listaFoto.remove(fotografia);
                return true;
            }
        }
        return false;

    }
 //controlla se 'album supera le 1000 foto
    void isFull() throws Over1000FotoException {
        if (listaFoto.size() > 1000) {
            throw new Over1000FotoException();

        }
    }

}
