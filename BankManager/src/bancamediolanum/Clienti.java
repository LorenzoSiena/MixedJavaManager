/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancamediolanum;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lorenzo
 */
public class Clienti {

    LinkedList<Cliente> listaClienti;
    BufferedReader tastiera;
    Cliente maxCliente;

    public Clienti() {

        tastiera = new BufferedReader(new InputStreamReader(System.in));
        listaClienti = new LinkedList<>();

    }

    public synchronized void loadClientiFiliale(String file1) {//file1 "client.txt" file2 "mov.txt"

        String iban;//Key
        int filiale;
        float saldo;
        String nome;
        int risp;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file1));
            System.out.println("Inserisci il numero di filiale da cui estrarre i clienti");
            risp = Integer.parseInt(tastiera.readLine());

            iban = br.readLine();
            while (iban != null) {
                filiale = Integer.parseInt(br.readLine());
                nome = br.readLine();
                saldo = Float.parseFloat(br.readLine());
                if (filiale == risp) {
                    listaClienti.add(new Cliente(iban, nome, filiale, saldo));
                }
                iban = br.readLine();
            }

        } catch (IOException e) {
            System.out.println("Errore lettura da file");
            System.exit(-1);

        }

    }

    public synchronized void loadMovimenti(String file2) {

        String iban; //key

        int tipologia;
        String descrizione;
        float importo;
        String data;

        try {
            BufferedReader br = new BufferedReader(new FileReader(file2));
            iban = br.readLine();
            while (iban != null) {
                tipologia = Integer.parseInt(br.readLine());
                descrizione = br.readLine();
                importo = Float.parseFloat(br.readLine());
                data = br.readLine();

                for (Cliente c : listaClienti) {
                    if (c.getIban().equals(iban)) {
                        c.addMovimento(new Movimento(tipologia, descrizione, importo, data));
                        break;
                    }
                }

                iban = br.readLine();

            }

        } catch (IOException e) {
            System.out.println("Errore lettura da file " + file2);
            System.exit(-1);
        }

    }

    //Metodi per i thread.
    public synchronized void delMovimentoDataIban() {///??????????????????????????????????????????
        String iban, data;

        System.out.println("Inserire  l'iban e la data da cui eliminare tutti i movimenti del cliente");

        try {
            System.out.print("Iban:");
            iban = tastiera.readLine();

            System.out.print("\nData");
            data = tastiera.readLine();

            for (Cliente c : listaClienti) {
                if (c.getIban().equals(iban)) {

                    c.delMov(data);

                    break;
                }

            }

        } catch (IOException e) {
            System.out.println("Errore tastiera");
            System.exit(-1);

        }
    }

    public synchronized void updateClient5000() {

        float temp = 0, max = 5000;

        for (Cliente c : listaClienti) {

            temp = c.getSaldo();
            if (temp > max) {
                max = temp;
                maxCliente = c;
            }
        }

    }

    public synchronized void StampaMaxCliente() {
        if (maxCliente==null) {
            System.out.println("Nessun cliente supera i 5000 euro");
        }else
            System.out.println("Il cliente riccone è" + maxCliente);

    }

    public synchronized void StampaDebitiMaggioriInData() {
        String data;
        float importo;

        try {
            System.out.println("Inserisci Importo");
            importo = Float.parseFloat(tastiera.readLine());
            System.out.println("Inserisci Data");
            data = tastiera.readLine();
            
            for (Cliente c : listaClienti) {
                if (c.addebitoTotaleInData(data)>importo) {
                    System.out.println(c); //stampa pure l'importo ma sticazzi
                }
            }
            
            
        } catch (IOException ex) {
            System.out.println("Errore tastiera");
            System.exit(-1);
        }

    }

    
    public synchronized void Stampatutto(){
        for (Cliente cliente : listaClienti) {
            System.out.println(cliente);
        }
    }
}
