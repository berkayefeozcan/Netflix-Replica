
package prolab2_3;

import javax.swing.*;

/**
 *
 * @author BerkayEfe
 */
public class HataMesajı implements DialogMessage{

    @Override
    public void mesajVer(String mesaj,String mesajBasligi) {
         
         JOptionPane.showMessageDialog(frame,mesaj,mesajBasligi,JOptionPane.ERROR_MESSAGE);     
    }
    
}
