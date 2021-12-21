/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmaciadambrogio;

import java.io.*;
import java.util.*;

/**
 *
 * @author lorenzo
 */
public class Clienti {

    BufferedReader tastiera;
    private LinkedList<Cliente> listaClienti;
    private LinkedList<Cliente> listaClientiReport;
    LinkedList<Farmaco> listaFarmaci;

    public Clienti() {
        tastiera = new BufferedReader(new InputStreamReader(System.in));
        listaClienti = new LinkedList<>();
        listaClientiReport = new LinkedList<>();
        listaFarmaci = new LinkedList<>();
    }

    public synchronized void loadClienti(String file1) {

        String codFisc; //Key
        String nomeCognome;
        float punti;

        try {
            BufferedReader br = new BufferedReader(new FileReader(file1));
            codFisc = br.readLine();
            while (codFisc != null) {
                nomeCognome = br.readLine();
                punti = Float.parseFloat(br.readLine());

                listaClienti.add(new Cliente(nomeCognome, codFisc, punti));
                codFisc = br.readLine();

            }

        } catch (IOException e) {
            System.out.println("Errore lettura da tastiera");
            System.exit(-1);
        }

    }

    public synchronized void loadFarmaci(String file2) {

        String codFisc;

        String nome;
        String codice; //key
        float costo;
        String dataAcquisto;

        try {
            BufferedReader br = new BufferedReader(new FileReader(file2));

            codFisc = br.readLine();
            while (codFisc != null) {
                nome = br.readLine();
                codice = br.readLine();
                costo = Float.parseFloat(br.readLine());
                dataAcquisto = br.readLine();

                for (Cliente cliente : listaClienti) {
                    if (cliente.getCodFisc().equals(codFisc)) {

                        cliente.addAcquistoFarmaco(new Farmaco(nome, codice, costo, dataAcquisto));
                        break;
                    }
                }

                codFisc = br.readLine();

            }

        } catch (IOException e) {
            System.out.println("Errore lettura da tastiera");
            System.exit(-1);
        }
    }

    //Metodi per i threads
    public synchronized void updateClientiFromData() {

        for (Cliente cliente : listaClienti) {
            //Controllo se la lista contiene il cliente
            //e se il ha acquistato  un farmaco dal 20200501
            if (!listaClientiReport.contains(cliente) && cliente.checkData()) {
                listaClientiReport.add(cliente);
            }

        }

    }

    public synchronized void newFarmaco() {
        String codFisc;

        String nome;
        String codice;
        float costo;
        String dataAcquisto;

        System.out.print("Inserisci codice fiscale:");
        try {
            codFisc = tastiera.readLine();

            for (Cliente cliente : listaClienti) {

                if (cliente.getCodFisc().equals(codFisc)) {
                    System.out.println("Inserisci il farmaco");
                    System.out.println("Nome");
                    nome = tastiera.readLine();
                    System.out.println("codice");
                    codice = tastiera.readLine();
                    System.out.println("costo");
                    costo = Float.parseFloat(tastiera.readLine());
                    System.out.println("Data acquisto yyyymmdd");
                    dataAcquisto = tastiera.readLine();

                    cliente.addAcquistoFarmaco(new Farmaco(nome, codice, costo, dataAcquisto));
                    cliente.addPoint(costo);
                    break;
                }

                //
            }

        } catch (IOException e) {
            System.out.println("Errore lettura da tastiera");
            System.exit(-1);
        }
    }

    //Data una lista di farmaci stampare a video tutti i clienti che ne hanno acquistato almeno 1 nella lista
    public synchronized void chiMiHaComprato() {

        String codice = ""; //setto un codice da cercare come se avessi già premuto invio
        try {

            System.out.println("Inserisci il codice dei farmaci che vuoi cercare nella lista dei clienti ,premi invio per terminare la lista ");

            codice = tastiera.readLine(); //chiedo da tastiera  un codice di un farmaco da aggiungere alla lista locale che è in questa CLASSE

            while (!codice.equals("")) { //finchè il codice non è un semplice HO PREMUTO INVIO
                listaFarmaci.add(new Farmaco("", codice, 0, "")); //Inserisci nella lista locale dei farmaci SENZA CAMPI TRANNE IL CODICE DA CERCARE

                codice = tastiera.readLine(); //chiedo di nuovo da tastiera finchè non premo solo invio e smetto->""

            }
            System.out.println("I seguenti clienti hanno acquistato uno di questi farmaci");
            for (Cliente cliente : listaClienti) { //per ogni cliente della lista

                if (cliente.checkFarmaco(listaFarmaci)) { //se la lista del  cliente ha un farmaco in comune con la mia lista di riferimento 

                    System.out.println(cliente);  //STAMPA IL CLIENTE
                }

            }

        } catch (IOException ex) {
            System.out.println("Errore lettura da tastiera");
            System.exit(-1);

        }

    }

    public synchronized void stampaReport() {
        for (Cliente cliente : listaClientiReport) {
            System.out.println("\n" + cliente);
        }

    }

    public synchronized void stampaTutto() {
        for (Cliente cliente : listaClienti) {
            System.out.println("\n" + cliente);
        }

    }
}
