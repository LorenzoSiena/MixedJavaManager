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
public class ThreadReport extends Thread {

    Artists a;

    ThreadReport(Artists a) {
        this.a=a;
    }
    
    
    
    @Override
    public void run() {
       
        while (true) {            
            
            try {
                
                a.mostProfitAlbum();
                
                sleep(5000);
                
            } catch (InterruptedException e) {
                System.out.println("Errore Sleep");
                System.exit(-1);
                
            }
            
            
            
        }
        
        
        
        
    }

}
