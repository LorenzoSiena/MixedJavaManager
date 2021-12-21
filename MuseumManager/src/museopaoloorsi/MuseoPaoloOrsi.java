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
public class MuseoPaoloOrsi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Sale s = new Sale();
        InteractiveThread t1 = new InteractiveThread(s);
        ReportThread t2 = new ReportThread(s);

        t1.start();
        t2.start();

    }

}
