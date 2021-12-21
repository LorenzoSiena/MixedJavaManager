/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingmanager;

import java.io.*;
import java.util.*;

/**
 *
 * @author lorenzo
 */
public class Parcheggi {

    private LinkedList<Parcheggio> listaParcheggi;
    BufferedReader tastiera;
    private float ricavoTot; //report

    public Parcheggi() {

        listaParcheggi = new LinkedList<>();
        tastiera = new BufferedReader(new InputStreamReader(System.in));
    }

    public synchronized void loadParcheggi(String f1) {

        String idParcheggio; //key
        String indirizzo;
        int CapienzaMax;
        float tariffaOraria;

        try {
            BufferedReader br = new BufferedReader(new FileReader(f1));

            idParcheggio = br.readLine();

            while (idParcheggio != null) {

                indirizzo = br.readLine();
                CapienzaMax = Integer.parseInt(br.readLine());
                tariffaOraria = Float.parseFloat(br.readLine());
                listaParcheggi.add(new Parcheggio(idParcheggio, indirizzo, CapienzaMax, tariffaOraria));
                idParcheggio = br.readLine();
            }

        } catch (IOException e) {
            System.err.println("Errore nella lettura del file " + f1);
            System.exit(-1);
        }

    }

    public synchronized void loadAuto(String f2) { //ID PARCHEGGIO VIENE MESSO COME PRIMO CAMPO NEL FILE parcheggio.txt
        String idParcheggio;//indica il parcheggio in cui cercare

        String targa;//key

        String dataInizio;
        int oraIn;
        int oraOut;

        try {
            BufferedReader br = new BufferedReader(new FileReader(f2));

            idParcheggio = br.readLine();

            while (idParcheggio != null) { //check!!                
                targa = br.readLine();
                dataInizio = br.readLine();
                oraIn = Integer.parseInt(br.readLine());
                oraOut = Integer.parseInt(br.readLine());

                for (Parcheggio parcheggio : listaParcheggi) {
                    if (parcheggio.equals(new Parcheggio(idParcheggio, "", 0, 0)) && !parcheggio.isFull()) { //confronto con un Oggetto momentaneamente instanziato
                        parcheggio.addAuto(new Auto(targa, dataInizio, oraIn, oraOut));                      //in modo da mantenere privato l'id parcheggio
                        break;
                    }
                }

                idParcheggio = br.readLine();
            }

        } catch (IOException e) {
            System.err.println("Errore nella lettura del file " + f2);
            System.exit(-1);
        }

    }

    public synchronized void updateRicavoTot() {
        float ricavoParziale = 0;

        for (Parcheggio parcheggio : listaParcheggi) {
            ricavoParziale += parcheggio.ricavoParcheggio();

        }
        ricavoTot = ricavoParziale;

    }

    public synchronized void StampaParcheggiSostaMaggiore50() {

        String data;
        try {
            System.out.println("Nel caso il parcheggio risulti vuoto verrà stampato lo stesso");
            System.out.println("Inserisci  una data");
            data = tastiera.readLine();
            System.out.println("Lista dei parcheggi con Capienza minore del 50% per quel giorno:");
            for (Parcheggio parcheggio : listaParcheggi) {
                if (parcheggio.CapienzaSotto50(data)) {
                    System.out.println("\n"+parcheggio.StampaSoloParcheggio());
                }
            }
           

        } catch (IOException e) {

            System.err.println("Errore nella lettura da tastiera ");
            System.exit(-1);
        }

    }

    public synchronized void eliminaAutoMenoUnOra() {

        for (Parcheggio parcheggio : listaParcheggi) {
            parcheggio.eliminaAutoUnOra();
        }

    }

    public synchronized void StampaRicavoTot() {
        System.out.println("Il ricavo totale ammonta a " + ricavoTot + " euro");

    }

    public synchronized void StampaTutto() {

        for (Parcheggio parcheggio : listaParcheggi) {
            System.out.println(parcheggio);
        }

    }

}
