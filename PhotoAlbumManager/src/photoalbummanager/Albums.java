/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package photoalbummanager;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lorenzo
 */
public class Albums {

    private LinkedList<Album> listaAlbum; //lista degli album
    BufferedReader tastiera; 
    Fotografia oldestFoto; //foto più vecchia per il report

    public Albums() {

        listaAlbum = new LinkedList<>();
        tastiera = new BufferedReader(new InputStreamReader(System.in));
        oldestFoto = new Fotografia("", "", 0, 0, 0, "99999999999");  //foto nuovissima del futuro 
    }
    
    public synchronized void loadAlbum(String f1) { //carico gli album 

        String nome;//KEY
        String dataCreazione;
        String descrizione;

        try {
            BufferedReader br = new BufferedReader(new FileReader(f1));
            nome = br.readLine();

            while (nome != null) {
                dataCreazione = br.readLine();
                descrizione = br.readLine();
                listaAlbum.add(new Album(nome, dataCreazione, descrizione));
                nome = br.readLine();

            }

        } catch (IOException e) {
            System.out.println("errore lettura del file" + f1);
            System.exit(-1);
        }

    }
    //load1
    public synchronized void loadFotografie(String f2) {

        String descrizione;
        String[] nomeAlbum = {null, null, null};//faccio un array di 3 stringhe

        String IDfoto;////KEY
        int larghezza;
        int altezza;
        int dimensioneKB;
        String dataFoto;

        try {
            int larghezzaMAX;

            System.out.print("Carica solo le foto con larghezza minore di:");
            larghezzaMAX = Integer.parseInt(tastiera.readLine());
            System.out.println("Carico solo le foto sotto i " + larghezzaMAX + " pixel di larghezza");

            BufferedReader br = new BufferedReader(new FileReader(f2));
            descrizione = br.readLine();

            while (descrizione != null) { //finchè la descrizione della foto c'è -> il file non è finito

                nomeAlbum[0] = br.readLine(); //ESISTE SEMPRE

                nomeAlbum[1] = br.readLine(); //può essere vuoto-->""

                nomeAlbum[2] = br.readLine(); //può essere vuoto-->""

                IDfoto = br.readLine();
                larghezza = Integer.parseInt(br.readLine());
                altezza = Integer.parseInt(br.readLine());
                dimensioneKB = Integer.parseInt(br.readLine());
                dataFoto = br.readLine();
                for (int i = 0; i < 3; i++) {

                    if (!nomeAlbum[i].isEmpty()) { //se la riga i-esima stringhe non è vuota

                        for (Album a : listaAlbum) {

                            if (nomeAlbum[i].equals(a.getNome()) && larghezza < larghezzaMAX) { //se il nome della stringa è uguale al nome di un album 

                                a.addFotografia(new Fotografia(descrizione, IDfoto, larghezza, altezza, dimensioneKB, dataFoto));
                                break;

                            }
                        }

                    } else { //altrimenti esci dal for
                        break;
                    }

                }

                descrizione = br.readLine(); //ricomincia il while
            }

        } catch (IOException e) {
            System.out.println("errore lettura del file" + f2);
            System.exit(-1);
        }

    }
    //load2

                                                        //metodi per i thread//
    
    public synchronized void updateOldestFoto() { // Per ogni album cerca la foto più vecchia e la salva
        Fotografia localOld; //foto da minimo locale 
        

        for (Album album : listaAlbum) {

            localOld = album.localOldFoto(); //foto più vecchia di un album
            if (localOld.getDataFoto().compareTo(oldestFoto.getDataFoto()) < 0) { //se la foto locale è minore rispetto alla foto più vecchia
                oldestFoto = localOld;   //CAMBIO!
            }

        }
    }

    public synchronized void StampaTutto() {
        for (Album album : listaAlbum) {
            System.out.println(album + "\n");

        }
    }

    public synchronized void StampaReport() {
        System.out.println("La foto più vecchia è: " + oldestFoto);

    }
    
    public synchronized void newFotomax3() { // leggi dal testo del compito la follia di questa funzione 
        String nomeAlbum[] = {"", "", ""}; //inizializzo l'array come 3 stringhe VUOTE

        String descrizione;
        String IDfoto;////KEY
        int larghezza;
        int altezza;
        int dimensioneKB;
        String dataFoto;
        int dimMAX;

        try {

            System.out.println("Inserisci una nuova fotografia in MASSIMO 3 album");

            for (int i = 0; i < 3; i++) {  //inizializzo le stringhe con i nomi degli album

                System.out.println("Nome album n." + (i + 1));
                nomeAlbum[i] = tastiera.readLine();

                if (nomeAlbum[i].isEmpty()) {                            //se una stringa è vuota perchè hai premuto invio 
                    System.out.println("Hai premuto Invio! BRAVO!");

                    break;          //esci dal for
                }

            }

            System.out.println("Inserisci la dimensione massima in KB oltre il quale la tua foto non verrà aggiunta");//Non ha senso il testo dice così
            dimMAX = Integer.parseInt(tastiera.readLine());

            System.out.println("Inserisci i dati della foto");

            System.out.println("Descrizione Foto");
            descrizione = tastiera.readLine();
            System.out.println("IDFoto");
            IDfoto = tastiera.readLine();
            System.out.println("Larghezza");
            larghezza = Integer.parseInt(tastiera.readLine());
            System.out.println("altezza");
            altezza = Integer.parseInt(tastiera.readLine());
            System.out.println("Dimensione in KB");
            dimensioneKB = Integer.parseInt(tastiera.readLine());
            System.out.println("Data foto AAAA/MM/GG");
            dataFoto = tastiera.readLine();

            if (dimensioneKB > dimMAX) {
                System.out.println("La foto ha dimensioni maggiori del limite consentito");
                return; 
            } else {
                for (int i = 0; i < 3; i++) {  //potrei fare nomeAlbum.size() MA funziona e non lo tocco

                    if (!nomeAlbum[i].isEmpty()) { //se l'album non è vuoto

                        for (Album a : listaAlbum) {  
                            if (nomeAlbum[i].equals(a.getNome())) { //se l'album ha lo stesso nome
                                a.isFull(); //Lancia un eccezione se ci sono più di 1000 foto nell'album
                                a.addFotografia(new Fotografia(descrizione, IDfoto, larghezza, altezza, dimensioneKB, dataFoto));
                                break;

                            }
                        }

                    } else {
                        break; //fine ciclo
                    }
                }
                System.out.println("Esecuzione Corretta");
            }

        } catch (IOException e) {
            System.out.println("Errore lettura da tastiera");
            System.exit(-1);
        } catch (Over1000FotoException ex) {
            System.err.println("Errore: l'album è pieno in quanto supera le 1000 fotografie");
            System.exit(-1);
        }
    }

    public synchronized void eliminaFotoDaAlbum() {
        boolean flag = false; //bandierina che scatta in caso di album vuoto DOPO la distruzione di una foto
        try {
            System.out.println("Inserisci l'id della foto:");
            String idFoto = tastiera.readLine();
            for (Album album : listaAlbum) {

                if (album.seeknDestroy(idFoto)) { //se una foto viene trovata e distrutta
                    flag = album.isEmpty();         //controlla se l'album adesso è vuoto
                }

            }
            if (flag) { 
                throw new EmptyAlbumException();
            }
        } catch (IOException ex) {
            System.out.println("Errore lettura da tastiera");
        } catch (EmptyAlbumException ex) {
            System.err.println("Errore:Uno degli album è risultato vuoto dopo l'eliminazione");
        }
    }
}
