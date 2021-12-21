package museopaoloorsi;

import java.util.*;
import java.io.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lorenzo
 */
public class Sale {

    LinkedList<Sala> listaSale;
    BufferedReader tastiera;
    String MostTipo; //report

    public Sale() {
        listaSale = new LinkedList<>();
        tastiera = new BufferedReader(new InputStreamReader(System.in));

    }

    synchronized void loadSala(String f1) {

        String nomeSala;
        int codiceSala;
        String periodoStorico;
        String collocazione;
        try {
            BufferedReader br = new BufferedReader(new FileReader(f1));

            nomeSala = br.readLine();
            while (nomeSala != null) {
                codiceSala = Integer.parseInt(br.readLine());
                periodoStorico = br.readLine();
                collocazione = br.readLine();
                listaSale.add(new Sala(nomeSala, codiceSala, periodoStorico, collocazione));

                nomeSala = br.readLine();

            }

        } catch (IOException e) {
            System.out.println("Errore lettura da file");
            System.exit(-1);

        }

    }

    synchronized void loadOpere(String f2) {

        String codSala;
        int codOpera;
        String autore;
        String tipologia; //statua quadro installazione artistica ecc...
        float prezzoStimato;

        try {
            BufferedReader br = new BufferedReader(new FileReader(f2));

            codSala = br.readLine();
            while (codSala != null) {
                codOpera = Integer.parseInt(br.readLine());
                autore = br.readLine();
                tipologia = br.readLine();
                prezzoStimato = Float.parseFloat(br.readLine());
                /*   if (!tipologie.contains(tipologia) && !tipologia.equals("statua")) {
                    tipologie.add(new tipos(0, tipologia));
                    }*/

                for (Sala sala : listaSale) {
                    //if(flag1=sala.equals(codSala)) && (flag2=!tipologia.equals("statua"))
                    if (sala.equals(new Sala("", Integer.parseInt(codSala), "", "")) && !tipologia.equals("statua")) { //FUNZIONA CON L'EQUALS?--OPPURE-->sala.getcodSala.equals(codSala)
                        sala.addOpera(new Opera(codOpera, autore, tipologia, prezzoStimato));
                        break;
                    }

                }

                codSala = br.readLine();
            }

        } catch (IOException e) {
            System.out.println("Errore lettura da file");
            System.exit(-1);
        }

    }

    //Metodi Syncronized per i thread
    public synchronized void delOperaDaSala() {

        try {
            int codOpera;
            int codSala;
            System.out.println("Inserisci il codice sala e il codice opera con cui togliere l'opera");

            System.out.println("Codice sala");
            codSala = Integer.parseInt(tastiera.readLine());
            System.out.println("Codice opera");
            codOpera = Integer.parseInt(tastiera.readLine());

            for (Sala sala : listaSale) {
                if (sala.equals(new Sala("", codSala, "", ""))) {
                    sala.delOpera(codOpera);
                    break;
                }
            }

        } catch (IOException ex) {
            System.out.println("errore lettura");
            System.exit(-1);
        } catch (NoOperaExistException ex) {
            System.err.println("ERRORE: CodiceOpera non esistente");

        }
    }

    public synchronized void StampaStimaAutore() {
        try {
            float somma = 0;
            String autore;
            System.out.println("Inserisci il nome dell autore");
            autore = tastiera.readLine();
            //cerca in tutte le sale le opere degli autori e sommando i costi 
            for (Sala sala : listaSale) {
                somma += sala.sommaOpereSala(autore);
            }
            System.out.println("L'autore " + autore + " ha totalizzato:" + somma + " euro in opere ");
        } catch (IOException ex) {
            System.out.println("errore lettura");
            System.exit(-1);
        }

    }

    //DA IMPLEMENTARE
    public synchronized void updateMostTipe() {

        //throw new UnsupportedOperationException("Ancora da implementare");
    }

    //NON IMPLEMENTATO la stringa darà null
    void StampaTipologia() {
        System.out.println("La tipologia di opera più comune è " + MostTipo);

    }

    void StampaTutto() {
        for (Sala sala : listaSale) {
            System.out.println("\n" + sala);
        }
    }

}
