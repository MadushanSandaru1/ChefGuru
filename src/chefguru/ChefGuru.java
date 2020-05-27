/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chefguru;

/**
 *
 * @author sanda
 */
public class ChefGuru {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Loading loading = new Loading();
        loading.setVisible(true);
        
        try {
            for (int i = 0; i <= 2000; i++) {
                Thread.sleep(1);
                
                loading.bar.setValue(i/20);
            }
        } catch (InterruptedException e) {
        } finally {
            
            new Login().setVisible(true);
            loading.setVisible(false);
        }
        //new Dashboard().setVisible(true);
        //new Login().setVisible(true);
    }
    
}
