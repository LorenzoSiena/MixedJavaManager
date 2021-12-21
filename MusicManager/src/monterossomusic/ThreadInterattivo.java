/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monterossomusic;

import java.io.*;

/**
 *
 * @author lorenzo
 */
public class ThreadInterattivo extends Thread {
    
    Artists a;
    BufferedReader tastiera;
    
    ThreadInterattivo(Artists a) {
        this.a = a;
        tastiera = new BufferedReader(new InputStreamReader(System.in));
    }
    
    @Override
    public void run() {
        
        try {
            String file1, file2;
            System.out.println("Inserisci il file degli artisti");
            file1 = tastiera.readLine();
            
            System.out.println("Inserisci il file degli album");
            file2 = tastiera.readLine();
            a.loadArtist(file1);
            a.loadAlbum(file2);
            
            while (true) {                
                switch (menu()) {
                    case 1:
                        a.EliminaAlbum();
                        break;
                    case 2:
                        a.StampaGenere();
                        break;
                    case 3:
                        a.StampaBestAlbum();
                        break;
                    
                    case 4:
                        a.StampaTutto();
                        break;
                        
                    default:
                        System.out.println("addio");
                        System.exit(0);
                }
                
            }
            
        } catch (IOException e) {
            System.out.println("Errore lettura da tastiera");
            System.exit(-1);
            
        }
        
    }
    
    private int menu() {
        
        int scelta = -1;
        
        System.out.println("Scegli un opzione:\n"
                + "1:Elimina un album\n"
                + "2:Stampa tutti gli album di un genere\n"
                + "3:Stampa l'album con i maggiori profitti\n"
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
