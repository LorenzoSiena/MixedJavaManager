/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museopaoloorsi;

/**
 *
 * @author lorenzo
 */
public class ReportThread extends Thread {

    Sale s;

    ReportThread(Sale s) {
        this.s = s;

    }

    @Override
    public void run() {

        try {

            while (true) {

                s.updateMostTipe(); //DA IMPLEMENTARE
                Thread.sleep(5000);

            }

        } catch (InterruptedException e) {
            System.out.println("Errore sleep");
            System.exit(-1);
        }

    }

}
