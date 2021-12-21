/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package photoalbummanager;

import java.io.*;

/**
 *
 * @author lorenzo
 */
public class InteractiveThread extends Thread {

    Albums a;
    BufferedReader tastiera;

    InteractiveThread(Albums a) {
        this.a = a;
        tastiera = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {

        try {
            String f1, f2;

            System.out.println("Inserisci il file album.txt");
            f1 = tastiera.readLine();
            System.out.println("Inserisci il file foto.txt");
            f2 = tastiera.readLine();
            a.loadAlbum(f1);
            a.loadFotografie(f2);

            System.out.println("File caricati con successo");

            while (true) {

                switch (menu()) {
                    case 1:
                        a.eliminaFotoDaAlbum();
                        break;
                    case 2:
                        a.newFotomax3();
                        break;
                    case 3:
                        a.StampaReport();
                        break;

                    case 4:
                        a.StampaTutto();
                        break;

                    default:
                        System.out.println("Arrivederci");
                        System.exit(0);
                }

            }

        } catch (IOException e) {
            System.out.println("Errore di lettura da tastiera");
            System.exit(-1);
        }

    }

    private int menu() {

        int scelta = -1;
        try {

            System.out.println("1:Elimina foto da tutti gli album\n"
                    + "2:Inserisci nuova foto in massimo 3 album\n"
                    + "3:(Report)Stampa foto più vecchia\n"
                    + "4:Stampa tutto\n"
                    + "5:esci\n");

            scelta = Integer.parseInt(tastiera.readLine());

        } catch (IOException e) {
            System.out.println("Errore di lettura da tastiera");
            System.exit(-1);
        }

        return scelta;

    }

}
