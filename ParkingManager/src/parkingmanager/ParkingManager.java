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
public class ParkingManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Parcheggi p = new Parcheggi();

        ThreadInterattivo t1 = new ThreadInterattivo(p);
        ThreadReport t2 = new ThreadReport(p);
        t1.start();
        t2.start();
    }

}
