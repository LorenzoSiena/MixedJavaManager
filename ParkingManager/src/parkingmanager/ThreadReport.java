/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingmanager;

/**
 *
 * @author lorenzo
 */
public class ThreadReport extends Thread {

    Parcheggi p;

    public ThreadReport(Parcheggi p) {
        this.p = p;
    }

    @Override
    public void run() {

        while (true) {

            try {

                p.updateRicavoTot();

                Thread.sleep(5000);

            } catch (InterruptedException e) {
                System.out.println("Errore nello sleep");
                System.exit(-1);
            }

        }

    }

}
