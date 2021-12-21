/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package photoalbummanager;

/**
 *
 * @author lorenzo
 */
public class ReportThread extends Thread {

    Albums a;

    public ReportThread(Albums a) {
        this.a = a;
    }

    @Override
    public void run() {

        while (true) {

            try {

                a.updateOldestFoto();

                Thread.sleep(5000);

            } catch (InterruptedException e) {
                System.out.println("Errore sleep");
                System.exit(-1);
            }

        }

    }

}
