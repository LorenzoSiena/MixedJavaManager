/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmaciadambrogio;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lorenzo
 */
public class ThreadInterattivo extends Thread {

    Clienti c;
    BufferedReader tastiera;

    public ThreadInterattivo(Clienti c) {
        this.c = c;
        tastiera = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {

        try {
            String f1, f2;
            System.out.println("Inserisci il nome del file ->client.txt");
            f1 = tastiera.readLine();
            System.out.println("Inserisci il nome del file ->farm.txt");
            f2 = tastiera.readLine();
            c.loadClienti(f1);
            c.loadFarmaci(f2);

            while (true) {

                switch (menu()) {
                    case 1:
                        c.newFarmaco();
                        break;
                    case 2:
                        c.chiMiHaComprato();
                        break;
                    case 3:
                        c.stampaReport();
                        break;
                    case 4:
                        c.stampaTutto();
                        break;
                    default:
                        System.out.println("Arrivederci!\n");
                        System.exit(0);
                }

            }

        } catch (IOException ex) {
            System.err.println("Errore lettura del File");
            System.exit(-1);
        }

    }

    private int menu() {
        int scelta = -1;
        try {
            System.out.println("Scegli un opzione:\n"
                    + "1:Vendi un farmaco ad un cliente e aggiorna punti\n"
                    + "2:Inserisci una lista di farmaci e vedi se uno dei clienti lo ha acquistato\n"
                    + "3:(Report)Stampa i clienti che hanno acquistato un farmaco dopo 2020/05/01\n"
                    + "4:Stampa tutto\n"
                    + "5:esci dal programma\n");

            scelta = Integer.parseInt(tastiera.readLine());

        } catch (IOException ex) {
            System.err.println("Errore lettura da tastiera");
            System.exit(-1);
        }

        return scelta;

    }
}
