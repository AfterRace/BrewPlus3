/*
 *  
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

/**
 *
 * @author  AChiari
 */
public class CalcoloForiZapap extends javax.swing.JInternalFrame {
    
    /** Creates new form CalcoloForiZapap */
    public CalcoloForiZapap() {
        initComponents();
        dFondo.setModel(35.0, 1.0,999999999.9,1.0);
        dFori.setModel(3.0, 1.0,999999999.9,1.0);
        pct.setModel(12.0, 1.0,100.0,1.0);
        setBorder(Utils.getDefaultBorder());
        //txt.setBackground(txt.getBackground().darker());
        change();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        dFondo = new jmash.component.JMashSpinner();
        jLabel2 = new javax.swing.JLabel();
        dFori = new jmash.component.JMashSpinner();
        jLabel3 = new javax.swing.JLabel();
        pct = new jmash.component.JMashSpinner();
        txt = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Numero di fori di uno zapap");
        setFont(getFont());

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(jLabel1.getFont());
        jLabel1.setText("Diametro del fondo (cm)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 0, 5);
        jPanel1.add(jLabel1, gridBagConstraints);

        dFondo.setFont(dFondo.getFont());
        dFondo.setPreferredSize(new java.awt.Dimension(64, 22));
        dFondo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                dFondoStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 0, 0);
        jPanel1.add(dFondo, gridBagConstraints);

        jLabel2.setFont(jLabel2.getFont());
        jLabel2.setText("Diametro dei fori (mm)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 0, 5);
        jPanel1.add(jLabel2, gridBagConstraints);

        dFori.setFont(dFori.getFont());
        dFori.setPreferredSize(new java.awt.Dimension(64, 22));
        dFori.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                dForiStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 10;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 0, 0);
        jPanel1.add(dFori, gridBagConstraints);

        jLabel3.setFont(jLabel3.getFont());
        jLabel3.setText("Percentuale da forare");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 0, 5);
        jPanel1.add(jLabel3, gridBagConstraints);

        pct.setFont(pct.getFont());
        pct.setPreferredSize(new java.awt.Dimension(64, 22));
        pct.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                pctStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 20;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 0, 0);
        jPanel1.add(pct, gridBagConstraints);

        txt.setEditable(false);
        txt.setFont(txt.getFont());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 30;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 0, 0);
        jPanel1.add(txt, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-261)/2, (screenSize.height-146)/2, 261, 146);
    }// </editor-fold>//GEN-END:initComponents

    private void dFondoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_dFondoStateChanged
        change();
    }//GEN-LAST:event_dFondoStateChanged

    private void dForiStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_dForiStateChanged
        change();
    }//GEN-LAST:event_dForiStateChanged

    private void pctStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_pctStateChanged
        change();
    }//GEN-LAST:event_pctStateChanged
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private jmash.component.JMashSpinner dFondo;
    private jmash.component.JMashSpinner dFori;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private jmash.component.JMashSpinner pct;
    private javax.swing.JTextField txt;
    // End of variables declaration//GEN-END:variables

    private void change(){
        double D=dFondo.getDoubleValue();
        double d=dFori.getDoubleValue();
        double p=pct.getDoubleValue();
        
        double A=Math.PI*(D*D/10000)/4;
        double a=Math.PI*(d*d/1000000)/4;
        double n=0.01*p*A/a;
        txt.setText("Numero fori necessari: "+((int)n));
    }
}
