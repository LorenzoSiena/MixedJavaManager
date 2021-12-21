/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancamediolanum;

import java.io.*;

/**
 *
 * @author lorenzo
 */
public class InteractiveThread extends Thread {

    BufferedReader tastiera;
    Clienti c;

    public InteractiveThread(Clienti c) {
        this.c = c;
        tastiera = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        try {
            String file1;
            String file2;
            System.out.println("\tBenvenuto in Banca Mediolanum");            
            
            System.out.println("Inserisci il nome del file Clienti ");
            file1=tastiera.readLine();
            
            System.out.println("Inserisci il nome del file Movimenti ");
            file2=tastiera.readLine();
            
            c.loadClientiFiliale(file1);
            c.loadMovimenti(file2);
            
            
            
            while (true) {
                
                switch (menu()) {
                    case 1:
                        
                        c.delMovimentoDataIban();
                        
                        break;
                        
                    case 2:
                        
                        c.StampaDebitiMaggioriInData();
                        
                        break;
                    case 3:
                        c.StampaMaxCliente();
                        break;
                        
                    case 4:
                        c.Stampatutto();
                        break;
                        
                    default:
                        System.out.println("Addio Stronzo");
                        System.exit(0);
                }
                
            }
        } catch (IOException ex) {
            System.out.println("Errore tastiera");
            System.exit(-1);
        }
        
        
    }

    private int menu() {
        int scelta = -1;

        System.out.println("Scegli un opzione:\n"
                + "1:Elimina i movimenti di un cliente in una certa data\n"
                + "2:Stampa i clienti che hanno speso più di un tot in una certa data\n"
                + "3:Stampa il cliente più ricco con accrediti che superano i 5000 euro\n"
                + "4:Stampa tutto\n"
                + "5:Esci dal programma\n");

        try {
            scelta = Integer.parseInt(tastiera.readLine());
        } catch (IOException ex) {
            System.out.println("Errore lettura da tastera");
            System.exit(-1);
        }

        return scelta;

    }
}
