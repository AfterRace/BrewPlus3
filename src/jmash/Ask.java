/*
 
 *
 *  This file is part of BrewPlus.
 *
 *  BrewPlus is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  BrewPlus is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with BrewPlus; if not, write to the Free Software
 *  Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */

package jmash;

import javax.swing.JInternalFrame;


/**
 *
 * @author  Alessandro
 */
public class Ask extends ModalInternalFrame {
    
    private static final long serialVersionUID = 9109085592153232542L;
    
    public static javax.swing.ImageIcon warnIcon=new javax.swing.ImageIcon(Msg.class.getResource("/jmash/images/messagebox_warning.png"));
    public static javax.swing.ImageIcon okIcon=new javax.swing.ImageIcon(Msg.class.getResource("/jmash/images/button_ok.png"));
    public static javax.swing.ImageIcon koIcon=new javax.swing.ImageIcon(Msg.class.getResource("/jmash/images/button_cancel.png"));
    
    public Ask(String msg) {
	initComponents();
	this.txt.setText(msg);
    }
    private boolean result=false;
    public boolean get(){
	return this.result;
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setFont(getFont());

        txt.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12));
        txt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(txt, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel3.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 11));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("jmash/lang"); // NOI18N
        jLabel3.setText(bundle.getString("Attenzione_prego")); // NOI18N
        jLabel3.setMaximumSize(new java.awt.Dimension(110, 34));
        jLabel3.setMinimumSize(new java.awt.Dimension(110, 34));
        jLabel3.setPreferredSize(new java.awt.Dimension(110, 34));
        jPanel1.add(jLabel3, java.awt.BorderLayout.CENTER);

        jLabel1.setIcon(warnIcon);
        jPanel1.add(jLabel1, java.awt.BorderLayout.WEST);

        jLabel2.setIcon(warnIcon);
        jPanel1.add(jLabel2, java.awt.BorderLayout.EAST);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        jButton2.setIcon(koIcon);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);

        jButton1.setIcon(okIcon);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);

        getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-450)/2, (screenSize.height-236)/2, 450, 236);
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
	this.result=false;
	stopModal();
	dispose();
    }//GEN-LAST:event_jButton2ActionPerformed
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
	this.result=true;
	stopModal();
	dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel txt;
    // End of variables declaration//GEN-END:variables
    
    
    public static boolean doAsk(JInternalFrame frame, String what){
	Ask ask=new Ask(what);
	ask.startModal(frame);
	return ask.get();
    }
}
