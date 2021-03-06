/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolab2_3;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;

/**
 *
 * @author BerkayEfe
 */
public class PuanlamaFrame extends javax.swing.JFrame {

    /**
     * Creates new form PuanlamaFrame
     */
    public int  puan;
    private ArrayList<JRadioButton> buttonArrayList;

    public PuanlamaFrame() {
        buttonArrayList = new ArrayList<>();
        this.puan = 0;
        initComponents();
        pencereyiOrtala();
        butonlariGrupla();

        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        anaPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        RadioButton10 = new javax.swing.JRadioButton();
        RadioButton1 = new javax.swing.JRadioButton();
        RadioButton2 = new javax.swing.JRadioButton();
        RadioButton3 = new javax.swing.JRadioButton();
        RadioButton4 = new javax.swing.JRadioButton();
        RadioButton5 = new javax.swing.JRadioButton();
        RadioButton6 = new javax.swing.JRadioButton();
        RadioButton7 = new javax.swing.JRadioButton();
        RadioButton8 = new javax.swing.JRadioButton();
        RadioButton9 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);

        anaPanel.setBackground(new java.awt.Color(55, 55, 55));
        anaPanel.setMinimumSize(new java.awt.Dimension(434, 324));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Bu programa puanınnız ?");

        RadioButton10.setBackground(new java.awt.Color(55, 55, 55));
        RadioButton10.setForeground(new java.awt.Color(255, 255, 255));
        RadioButton10.setText("10");

        RadioButton1.setBackground(new java.awt.Color(55, 55, 55));
        RadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        RadioButton1.setText("1");

        RadioButton2.setBackground(new java.awt.Color(55, 55, 55));
        RadioButton2.setForeground(new java.awt.Color(255, 255, 255));
        RadioButton2.setText("2");

        RadioButton3.setBackground(new java.awt.Color(55, 55, 55));
        RadioButton3.setForeground(new java.awt.Color(255, 255, 255));
        RadioButton3.setText("3");

        RadioButton4.setBackground(new java.awt.Color(55, 55, 55));
        RadioButton4.setForeground(new java.awt.Color(255, 255, 255));
        RadioButton4.setText("4");

        RadioButton5.setBackground(new java.awt.Color(55, 55, 55));
        RadioButton5.setForeground(new java.awt.Color(255, 255, 255));
        RadioButton5.setText("5");

        RadioButton6.setBackground(new java.awt.Color(55, 55, 55));
        RadioButton6.setForeground(new java.awt.Color(255, 255, 255));
        RadioButton6.setText("6");

        RadioButton7.setBackground(new java.awt.Color(55, 55, 55));
        RadioButton7.setForeground(new java.awt.Color(255, 255, 255));
        RadioButton7.setText("7");

        RadioButton8.setBackground(new java.awt.Color(55, 55, 55));
        RadioButton8.setForeground(new java.awt.Color(255, 255, 255));
        RadioButton8.setText("8");

        RadioButton9.setBackground(new java.awt.Color(55, 55, 55));
        RadioButton9.setForeground(new java.awt.Color(255, 255, 255));
        RadioButton9.setText("9");

        jButton1.setBackground(new java.awt.Color(55, 55, 55));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Puanımı Kaydet");

        javax.swing.GroupLayout anaPanelLayout = new javax.swing.GroupLayout(anaPanel);
        anaPanel.setLayout(anaPanelLayout);
        anaPanelLayout.setHorizontalGroup(
            anaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(anaPanelLayout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addGroup(anaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(anaPanelLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(anaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RadioButton3)
                            .addComponent(RadioButton4)
                            .addComponent(RadioButton5)
                            .addComponent(RadioButton2)
                            .addComponent(RadioButton9)
                            .addComponent(RadioButton8)
                            .addComponent(RadioButton7)
                            .addComponent(RadioButton1)
                            .addComponent(RadioButton10)
                            .addComponent(RadioButton6))
                        .addGap(43, 43, 43)
                        .addComponent(jButton1)))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        anaPanelLayout.setVerticalGroup(
            anaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(anaPanelLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addGroup(anaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(anaPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(anaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(anaPanelLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(RadioButton3))
                            .addGroup(anaPanelLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(RadioButton4))
                            .addGroup(anaPanelLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(RadioButton5))
                            .addComponent(RadioButton2))
                        .addGap(17, 17, 17)
                        .addGroup(anaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(anaPanelLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(RadioButton9))
                            .addGroup(anaPanelLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(RadioButton8))
                            .addComponent(RadioButton7)))
                    .addComponent(RadioButton1)
                    .addGroup(anaPanelLayout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(RadioButton10))
                    .addGroup(anaPanelLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(RadioButton6))
                    .addGroup(anaPanelLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jButton1)))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(anaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(anaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pencereyiOrtala() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - getHeight()) / 2);
        setLocation(x, y);
    }

    private void butonlariGrupla() {
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(RadioButton1);
        buttonGroup.add(RadioButton2);
        buttonGroup.add(RadioButton3);
        buttonGroup.add(RadioButton4);
        buttonGroup.add(RadioButton5);
        buttonGroup.add(RadioButton6);
        buttonGroup.add(RadioButton7);
        buttonGroup.add(RadioButton8);
        buttonGroup.add(RadioButton9);
        buttonGroup.add(RadioButton10);
        buttonArrayList.add(RadioButton1);
        buttonArrayList.add(RadioButton2);
        buttonArrayList.add(RadioButton3);
        buttonArrayList.add(RadioButton4);
        buttonArrayList.add(RadioButton5);
        buttonArrayList.add(RadioButton6);
        buttonArrayList.add(RadioButton7);
        buttonArrayList.add(RadioButton8);
        buttonArrayList.add(RadioButton9);
        buttonArrayList.add(RadioButton10);

    }
   
    /**
     * @param args the command line arguments
     */

    public Integer getPuan() {
        return puan;
    }

    public JButton getjButton1() {
        return jButton1;
    }
    public void puaniDon(){
        
        for(JRadioButton rb :buttonArrayList){
            if(rb.isSelected()){
                 puan = Integer.parseInt(rb.getText());
              
            }
        }
        
        
    }
    public void yokOl(){
        dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton RadioButton1;
    private javax.swing.JRadioButton RadioButton10;
    private javax.swing.JRadioButton RadioButton2;
    private javax.swing.JRadioButton RadioButton3;
    private javax.swing.JRadioButton RadioButton4;
    private javax.swing.JRadioButton RadioButton5;
    private javax.swing.JRadioButton RadioButton6;
    private javax.swing.JRadioButton RadioButton7;
    private javax.swing.JRadioButton RadioButton8;
    private javax.swing.JRadioButton RadioButton9;
    private javax.swing.JPanel anaPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
