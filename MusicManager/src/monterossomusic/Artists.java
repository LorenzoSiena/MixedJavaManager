/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monterossomusic;

import java.io.*;
import java.util.*;

/**
 *
 * @author lorenzo
 */
public class Artists {

    BufferedReader tastiera;
    private LinkedList<Artist> listaArtisti;
    Album bestAlbum;

    public Artists() {
        tastiera = new BufferedReader(new InputStreamReader(System.in));
        listaArtisti = new LinkedList<>();

    }

    public synchronized void loadArtist(String file1) {

        String nomeArtist;
        int tipologia;      //0=artista 1=gruppo
        String genere;

        try {
            BufferedReader br = new BufferedReader(new FileReader(file1));
            nomeArtist = br.readLine();
            while (nomeArtist != null) {

                tipologia = Integer.parseInt(br.readLine());
                genere = br.readLine();

                listaArtisti.add(new Artist(nomeArtist, tipologia, genere));

                nomeArtist = br.readLine();

            }

        } catch (IOException e) {
            System.out.println("Errore lettura da file");
            System.exit(-1);

        }

    }

    public synchronized void loadAlbum(String file2) {

        String nomeArtist;

        int codiceAlbum; //key
        String nomeAlbum;
        int numBrani;
        float costo;
        int copieVendute;

        try {
            BufferedReader br = new BufferedReader(new FileReader(file2));

            nomeArtist = br.readLine();
            while (nomeArtist != null) {

                nomeAlbum = br.readLine();
                codiceAlbum = Integer.parseInt(br.readLine());

                numBrani = Integer.parseInt(br.readLine());
                costo = Float.parseFloat(br.readLine());
                copieVendute = Integer.parseInt(br.readLine());
                for (Artist a : listaArtisti) {
                    if (a.getNomeArtist().equals(nomeArtist)) {
                        a.addAlbum(new Album(nomeAlbum, codiceAlbum, numBrani, costo, copieVendute));
                        break;
                    }

                }

                nomeArtist = br.readLine();

            }

        } catch (IOException e) {
            System.out.println("Errore lettura da file");
            System.exit(-1);

        }

    }

    //Metodi thread
    public synchronized void EliminaAlbum() {

        int codice;
        String nomeArtist;

        try {

            System.out.println("Inserisci codice album");
            codice = Integer.parseInt(tastiera.readLine());
            System.out.println("Inserisci Nome Artista");
            nomeArtist = tastiera.readLine();

            for (Artist artist : listaArtisti) {
                if (artist.getNomeArtist().equals(nomeArtist)) {
                    artist.delAlbum(codice);
                    break;
                }
            }

        } catch (IOException ex) {

            System.out.println("Errore lettura da tastiera");
            System.exit(-1);
        }

    }

    public synchronized void StampaGenere() {
        
        int totale=0;
        String genere;
        try {

            System.out.println("Inserisci il genere");
            genere = tastiera.readLine();

            for (Artist artist : listaArtisti) {
                if (artist.getGenere().equals(genere) && artist.getTipologia() == 1) {
                    totale+=artist.sommaAlbumVenduti();
                     
                    System.out.println("La somma degli album venduti per il genere "+genere+" è: "+totale);
                }
            }

        } catch (IOException ex) {

            System.out.println("Errore lettura da tastiera");
            System.exit(-1);
        }

    }

    public synchronized void StampaBestAlbum() {

         System.out.println("Per un totale di " + bestAlbum.getCopieVendute()*bestAlbum.getCosto() + " euro e " 
                 + bestAlbum.getCopieVendute() + " copie vendute \nL'album con più incassi è stato :" + bestAlbum);
    }

    public synchronized void StampaTutto() {

        for (Artist artist : listaArtisti) {
            System.out.println(artist);
         
        }

    }

    public synchronized void mostProfitAlbum() {//non si dovrebbe fare ma sticazzi

        float temp = 0;
        float max = 0;
        Album b;
        for (Artist artist : listaArtisti) {

            b = artist.topSellAlbum();
            if (b != null) {

                temp = b.getCosto() * b.getCopieVendute();
                if (temp > max) {
                    max = temp;
                    bestAlbum = b;

                }
            }

        }

      
    }
}
