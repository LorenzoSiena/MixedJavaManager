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
public class FarmaciaDambrogio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Clienti c = new Clienti();

        ThreadInterattivo t1 = new ThreadInterattivo(c);
        ThreadReport t2 = new ThreadReport(c);
        t1.start();
        t2.start();
    }

}
