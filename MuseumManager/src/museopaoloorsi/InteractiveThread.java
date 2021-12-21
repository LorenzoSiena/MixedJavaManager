/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museopaoloorsi;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lorenzo
 */
public class InteractiveThread extends Thread {

    Sale s;
    BufferedReader tastiera;

    InteractiveThread(Sale s) {
        this.s = s;
        tastiera = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        try {
            String f1, f2;
            System.out.println("Benvenuto nel Museo Paolo Orsi");
            System.out.println("Inserisci il file sala.txt");
            f1 = tastiera.readLine();
            System.out.println("Inserisci il file opere.txt");
            f2 = tastiera.readLine();

            s.loadSala(f1);
            s.loadOpere(f2);

            while (true) {

                switch (menu()) {
                    case 1:
                        s.delOperaDaSala();
                        break;
                    case 2:
                        s.StampaStimaAutore();
                        break;
                    case 3:
                        s.StampaTipologia();
                        break;
                    case 4:
                        s.StampaTutto();
                        break;
                    default:
                        System.out.println("Arrivederci");
                        System.exit(0);
                }

            }

        } catch (IOException ex) {
            System.out.println("Errore lettura da file");
            System.exit(-1);
        }

    }

    private int menu() {
        int scelta = -1;

        System.out.print("Scegli un opzione\n"
                + "1:Elimina un opera da una sala\n"
                + "2:Stampa a video la somma stimata delle opere di un Autore\n"
                + "3:(report) Stampa il tipo di opera più comune nel museo\n"
                + "4:Stampa tutto\n"
                + "5:Esci dal programma\n");
        try {
            scelta = Integer.parseInt(tastiera.readLine());
        } catch (IOException ex) {
            System.out.println("Errore lettura da tastiera");
            System.exit(-1);
        }
        return scelta;
    }
}
