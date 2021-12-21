/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmaciadambrogio;

/**
 *
 * @author lorenzo
 */
public class ThreadReport extends Thread {

    Clienti c;

    public ThreadReport(Clienti c) {
        this.c = c;
    }

    @Override
    public void run() {

        while (true) {
            try {

                c.updateClientiFromData(); //lista clienti che hanno acquistato almeno un farmaco da 20200501

                Thread.sleep(5000);

            } catch (InterruptedException e) {
                System.out.println("Errore sleep");
                System.exit(-1);
            }
        }

    }

}
