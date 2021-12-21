/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingmanager;

import java.io.*;

/**
 *
 * @author lorenzo
 */
public class ThreadInterattivo extends Thread {

    Parcheggi p;
    BufferedReader tastiera;

    ThreadInterattivo(Parcheggi p) {
        this.p = p;
        tastiera = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {

        try {
            String f1, f2;
            System.out.println("\nBenvenuto nella nostra catena di parcheggi!");
            System.out.println("Inserisci il file parc.txt");
            f1 = tastiera.readLine();
            System.out.println("Inserisci il file auto.txt");
            f2 = tastiera.readLine();
            p.loadParcheggi(f1);
            p.loadAuto(f2);

            System.out.println("I File sono stati caricati con successo");

            while (true) {

                switch (menu()) {
                    case 1:
                        p.StampaParcheggiSostaMaggiore50();
                        break;
                    case 2:
                        p.eliminaAutoMenoUnOra();
                        break;
                    case 3:
                        p.StampaRicavoTot();
                        break;

                    case 4:
                        p.StampaTutto();
                        break;

                    default:
                        System.out.println("Arrivederci");
                        System.exit(0);
                }

            }

        } catch (IOException e) {
            System.err.println("Errore di lettura da tastiera");
            System.exit(-1);
        }

    }

    private int menu() {

        int scelta = -1;
        try {

            System.out.println("\n1:Stampa a video tutti quei parcheggi per cui il numero di auto\n" +
"in sosta in quella data è minore del 50% della loro capienza massima.\n"
                    + "2:Elimina da tutti i parcheggi quelle automobili che hanno sostato per meno di un’ora. \n"
                    + "3:Stampa il ricavo totale della Catena (Report)\n"
                    + "4:StampaTutto\n"
                    + "5:esci\n");

            scelta = Integer.parseInt(tastiera.readLine());

        } catch (IOException e) {
            System.err.println("Errore di lettura da tastiera");
            System.exit(-1);
        }

        return scelta;

    }

}
