/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancamediolanum;

/**
 *
 * @author lorenzo
 */
public class BancaMediolanum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Clienti c=new Clienti();
       
       InteractiveThread t1=new InteractiveThread(c);
       ReportThread t2= new ReportThread(c);
       
       t1.start();
       t2.start();
    }
    
}
