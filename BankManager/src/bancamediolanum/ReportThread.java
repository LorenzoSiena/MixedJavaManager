/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancamediolanum;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lorenzo
 */
public class ReportThread extends Thread{
    Clienti c;
    
    public ReportThread(Clienti c) {
        
        this.c=c;
    }
    
    
    
    @Override
    public void run() {
       
        
        while (true) {            
            
            
            try {
                
                c.updateClient5000();
                
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                System.out.println("Errore sleep");
                System.exit(-1);
            }
            
        }
    }
    
}
