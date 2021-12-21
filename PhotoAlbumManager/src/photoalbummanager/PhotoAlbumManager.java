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
public class PhotoAlbumManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Albums a = new Albums();

        ReportThread t2 = new ReportThread(a);
        InteractiveThread t1 = new InteractiveThread(a);

        t1.start();
        t2.start();
    }

}
