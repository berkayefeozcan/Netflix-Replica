/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolab2_3;

import javax.swing.JOptionPane;
/**
 *
 * @author BerkayEfe
 */
public class BilgiMesajı implements DialogMessage{
    
    @Override
    public void mesajVer(String mesaj,String mesajBasligi) {
        
         JOptionPane.showMessageDialog(frame,mesaj,mesajBasligi,JOptionPane.INFORMATION_MESSAGE);     
    }
}
