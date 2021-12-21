/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monterossomusic;

/**
 *
 * @author lorenzo
 */
public class MonterossoMusic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Artists a=new Artists();
        
        ThreadInterattivo t1=new ThreadInterattivo(a);
        ThreadReport t2=new ThreadReport(a);
        t1.start();
        t2.start();
               
        
    }
    
}
