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

import java.io.File;
import java.util.Locale;
import javax.swing.ButtonGroup;
import org.jdom.Document;
import org.jdom.Element;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JInternalFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.GridBagLayout;
import javax.swing.DefaultComboBoxModel;

import jmash.Main.BitterBUGU;

/**
 *
 * @author  Alessandro
 */
public class ConfigurationTool extends javax.swing.JInternalFrame {
	JInternalFrame parent;
    
    /** Creates new form ConfigurationTool */
    public ConfigurationTool() {
	initComponents();
	parent=this;
	setBorder(Utils.getDefaultBorder());
	fldEff.setModel(75.0,1,100,1,"0","CT.eff");
	fldVolumeFin.setModel(23.0,1,9999999,1,"0.0","CT.vf");
	fldVolumeBoll.setModel(23.0,1,9999999,1,"0.0","CT.vb");
	fldSLM.setModel(300.0,1,8844,1,"0","CT.slm");
	fldDHEA.setModel(45.0,1,60,1,"0","CT.dhea");
	fldBoil.setModel(90.0,1,1000,1);

    spnEvaporazione.setModel(Main.config.getLostToTrub(),0.1,1000000,0.1,"0.0","CT.ev");
    spnLitriKg.setModel(Main.config.getLostToTrub(),0.1,1000000,0.1,"0.0","CT.lkg");
    spnLostToSparge.setModel(Main.config.getLostToTrub(),0.1,1000000,0.1,"0.0","CT.lts");
    spnLostToTrub.setModel(Main.config.getLostToTrub(),0.1,1000000,0.1,"0.0","CT.ltt");
        
	fldEff.setValue(Main.config.getEfficienza());
	fldVolumeFin.setValue(Main.config.getVolumeFin());
	fldVolumeBoll.setValue(Main.config.getVolumeBoil());
	fldSLM.setValue(Main.config.getMetriSLM());
	fldDHEA.setValue(Main.config.getAmaroDHEA());
	fldBoil.setValue(Main.config.getBoilTime());
	fldServer.setText(Main.config.getRemoteServer());
	fldNick.setText(Main.config.getNickIHB());
	fldPwd.setText(Main.config.getPasswordIHB());
	fldProxy.setText(Main.config.getProxyHost());
	fldProxyPort.setText(Main.config.getProxyPort());
	chckbxNewCheckBox.setSelected((Main.config.getPotLibGal()==1)?true:false);
	
	cmbBUGURatio = new JComboBox();
	cmbBUGURatio.setModel(new DefaultComboBoxModel(new String[] {"Tinseth", "Rager", "Daniels"}));
	GridBagConstraints gbc_comboBox = new GridBagConstraints();
	gbc_comboBox.insets = new Insets(0, 0, 0, 5);
	gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
	gbc_comboBox.gridx = 1;
	gbc_comboBox.gridy = 4;
	jPanel1.add(cmbBUGURatio, gbc_comboBox);
	if(Main.config.getBUGURatio()==BitterBUGU.TIN)cmbBUGURatio.setSelectedIndex(0);
	if(Main.config.getBUGURatio()==BitterBUGU.RAG)cmbBUGURatio.setSelectedIndex(1);
	if(Main.config.getBUGURatio()==BitterBUGU.DAN)cmbBUGURatio.setSelectedIndex(2);
	
	
	
	
	spnLostToSparge.setVolume(Main.config.getLostToSparge());
	spnLostToTrub.setVolume(Main.config.getLostToTrub());
	spnLitriKg.setVolume(Main.config.getLitriPerKg());
	spnEvaporazione.setVolume(Main.config.getEvaporazionePerOra());
	
	ButtonGroup group = new ButtonGroup();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jToolBar1 = new javax.swing.JToolBar();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        fldEff = new jmash.component.JMashSpinner();
        jLabel2 = new javax.swing.JLabel();
        fldVolumeFin = new jmash.component.JMashSpinner();
        fldVolumeBoll = new jmash.component.JMashSpinner();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelDHEA = new javax.swing.JLabel();
        fldDHEA = new jmash.component.JMashSpinner();
        fldSLM = new jmash.component.JMashSpinner();
        jLabel10 = new javax.swing.JLabel();
        fldBoil = new jmash.component.JMashSpinner();
        jPanel2 = new javax.swing.JPanel();
        jLabelBUGU = new javax.swing.JLabel();
        fldServer = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        fldNick = new javax.swing.JTextField();
        fldPwd = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        fldProxy = new javax.swing.JTextField();
        fldProxyPort = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        spnLostToTrub = new jmash.component.JVolumeSpinner();
        jLabel12 = new javax.swing.JLabel();
        spnLostToSparge = new jmash.component.JVolumeSpinner();
        spnLitriKg = new jmash.component.JVolumeSpinner();
        spnEvaporazione = new jmash.component.JVolumeSpinner();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setTitle("Configurazione");
        setFont(getFont());
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jToolBar1.setFloatable(false);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jmash/images/filesave.png"))); // NOI18N
        jButton3.setToolTipText("Salva configurazione");
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(jToolBar1, gridBagConstraints);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Defaults"));
        jPanel1.setMinimumSize(new java.awt.Dimension(550, 202));
        jPanel1.setPreferredSize(new java.awt.Dimension(550, 202));
        GridBagLayout gbl_jPanel1 = new GridBagLayout();
        gbl_jPanel1.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0};
        jPanel1.setLayout(gbl_jPanel1);
        
        chckbxNewCheckBox = new JCheckBox("Potenziale SG libbre/gallone");
        chckbxNewCheckBox.setToolTipText("");
        chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
        GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
        gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
        gbc_chckbxNewCheckBox.gridx = 0;
        gbc_chckbxNewCheckBox.gridy = 0;
        jPanel1.add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);
        
        btnNewButton = new JButton("?");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Utils.showMsg("Selezionare l'opzione se il potenziale degli ingredienti � espresso in libbre/Gallone e non in grammi/Litro.\nNota: il software Hobbybrew considera il potenziale ingredienti espresso come libbre/Gallone.",parent);
        	}
        });
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
        gbc_btnNewButton.gridx = 1;
        gbc_btnNewButton.gridy = 0;
        jPanel1.add(btnNewButton, gbc_btnNewButton);
        


        //jLabel1.setFont(jLabel1.getFont());
        jLabel1.setFont(new Font("Tahoma", Font.PLAIN, 11));
        jLabel1.setText("Efficienza %");
        gridBagConstraints_1 = new java.awt.GridBagConstraints();
        gridBagConstraints_1.insets = new Insets(0, 0, 5, 5);
        gridBagConstraints_1.gridx = 0;
        gridBagConstraints_1.gridy = 1;
        gridBagConstraints_1.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints_1.anchor = java.awt.GridBagConstraints.EAST;
        jPanel1.add(jLabel1, gridBagConstraints_1);

        fldEff.setFont(fldEff.getFont());
        gridBagConstraints_2 = new java.awt.GridBagConstraints();
        gridBagConstraints_2.insets = new Insets(0, 0, 5, 5);
        gridBagConstraints_2.gridx = 1;
        gridBagConstraints_2.gridy = 1;
        gridBagConstraints_2.fill = java.awt.GridBagConstraints.BOTH;
        jPanel1.add(fldEff, gridBagConstraints_2);
        
        //jLabel2.setFont(jLabel2.getFont());
        jLabel2.setFont(new Font("Tahoma", Font.PLAIN, 11));
        jLabel2.setText("Volume finale (litri)");
        gridBagConstraints_3 = new java.awt.GridBagConstraints();
        gridBagConstraints_3.insets = new Insets(0, 0, 5, 5);
        gridBagConstraints_3.gridx = 0;
        gridBagConstraints_3.gridy = 2;
        gridBagConstraints_3.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints_3.anchor = java.awt.GridBagConstraints.EAST;
        jPanel1.add(jLabel2, gridBagConstraints_3);

        fldVolumeFin.setBorder(null);
        fldVolumeFin.setFont(fldVolumeFin.getFont());
        gridBagConstraints_4 = new java.awt.GridBagConstraints();
        gridBagConstraints_4.insets = new Insets(0, 0, 5, 5);
        gridBagConstraints_4.gridx = 1;
        gridBagConstraints_4.gridy = 2;
        gridBagConstraints_4.fill = java.awt.GridBagConstraints.BOTH;
        jPanel1.add(fldVolumeFin, gridBagConstraints_4);

        fldVolumeBoll.setFont(fldVolumeBoll.getFont());
        gridBagConstraints_5 = new java.awt.GridBagConstraints();
        gridBagConstraints_5.insets = new Insets(0, 0, 5, 0);
        gridBagConstraints_5.gridx = 3;
        gridBagConstraints_5.gridy = 2;
        gridBagConstraints_5.fill = java.awt.GridBagConstraints.BOTH;
        jPanel1.add(fldVolumeBoll, gridBagConstraints_5);

        //jLabel3.setFont(jLabel3.getFont());
        jLabel3.setFont(new Font("Tahoma", Font.PLAIN, 11));
        jLabel3.setText("Volume bollitura (litri)");
        gridBagConstraints_6 = new java.awt.GridBagConstraints();
        gridBagConstraints_6.insets = new Insets(0, 0, 5, 5);
        gridBagConstraints_6.gridx = 2;
        gridBagConstraints_6.gridy = 2;
        gridBagConstraints_6.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints_6.anchor = java.awt.GridBagConstraints.EAST;
        jPanel1.add(jLabel3, gridBagConstraints_6);

        //jLabelDHEA.setFont(jLabelDHEA.getFont());
        jLabelDHEA.setFont(new Font("Tahoma", Font.PLAIN, 11));
        jLabelDHEA.setText("Amaro DHEA");
        gridBagConstraints_7 = new java.awt.GridBagConstraints();
        gridBagConstraints_7.insets = new Insets(0, 0, 5, 5);
        gridBagConstraints_7.gridx = 2;
        gridBagConstraints_7.gridy = 3;
        gridBagConstraints_7.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints_7.anchor = java.awt.GridBagConstraints.EAST;
        jPanel1.add(jLabelDHEA, gridBagConstraints_7);
        
        jLabel4.setFont(new Font("Tahoma", Font.PLAIN, 11));
        jLabel4.setText("Metri SLM");
        jLabel4.setToolTipText("Metri sul livello del mare");
        gridBagConstraints_8 = new java.awt.GridBagConstraints();
        gridBagConstraints_8.insets = new Insets(0, 0, 5, 5);
        gridBagConstraints_8.gridx = 0;
        gridBagConstraints_8.gridy = 3;
        gridBagConstraints_8.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints_8.anchor = java.awt.GridBagConstraints.EAST;
        jPanel1.add(jLabel4, gridBagConstraints_8);

        jLabelBUGU.setFont(new Font("Tahoma", Font.PLAIN, 11));
        jLabelBUGU.setText("Ratio BU/GU");
        gridBagConstraints_8_1 = new java.awt.GridBagConstraints();
        gridBagConstraints_8_1.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints_8_1.insets = new Insets(0, 0, 0, 5);
        gridBagConstraints_8_1.gridx = 0;
        gridBagConstraints_8_1.gridy = 4;
        gridBagConstraints_8_1.anchor = java.awt.GridBagConstraints.EAST;
        jPanel1.add(jLabelBUGU, gridBagConstraints_8_1); 
        
        fldSLM.setFont(fldSLM.getFont());
        gridBagConstraints_9 = new java.awt.GridBagConstraints();
        gridBagConstraints_9.insets = new Insets(0, 0, 5, 5);
        gridBagConstraints_9.gridx = 1;
        gridBagConstraints_9.gridy = 3;
        gridBagConstraints_9.fill = java.awt.GridBagConstraints.BOTH;
        jPanel1.add(fldSLM, gridBagConstraints_9);

        fldDHEA.setFont(fldDHEA.getFont());
        gridBagConstraints_10 = new java.awt.GridBagConstraints();
        gridBagConstraints_10.insets = new Insets(0, 0, 5, 0);
        gridBagConstraints_10.gridx = 3;
        gridBagConstraints_10.gridy = 3;
        gridBagConstraints_10.fill = java.awt.GridBagConstraints.BOTH;
        jPanel1.add(fldDHEA, gridBagConstraints_10);
        
        //jLabel10.setFont(jLabel10.getFont());
        jLabel10.setFont(new Font("Tahoma", Font.PLAIN, 11));
        jLabel10.setText("Bollitura (minuti)");
        gridBagConstraints_11 = new java.awt.GridBagConstraints();
        gridBagConstraints_11.insets = new Insets(0, 0, 5, 5);
        gridBagConstraints_11.gridx = 2;
        gridBagConstraints_11.gridy = 1;
        gridBagConstraints_11.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints_11.anchor = java.awt.GridBagConstraints.EAST;
        jPanel1.add(jLabel10, gridBagConstraints_11);

        fldBoil.setFont(fldBoil.getFont());
        gridBagConstraints_12 = new java.awt.GridBagConstraints();
        gridBagConstraints_12.insets = new Insets(0, 0, 5, 0);
        gridBagConstraints_12.gridx = 3;
        gridBagConstraints_12.gridy = 1;
        gridBagConstraints_12.fill = java.awt.GridBagConstraints.BOTH;
        jPanel1.add(fldBoil, gridBagConstraints_12);

        gridBagConstraints_13 = new java.awt.GridBagConstraints();
        gridBagConstraints_13.gridheight = 2;
        gridBagConstraints_13.gridx = 0;
        gridBagConstraints_13.gridy = 1;
        gridBagConstraints_13.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(jPanel1, gridBagConstraints_13);


        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Dati impianto"));
        jPanel4.setFont(jPanel4.getFont());
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel11.setFont(new Font("Tahoma", Font.PLAIN, 11));
        jLabel11.setText("Lost to trub");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel4.add(jLabel11, gridBagConstraints);

        spnLostToTrub.setFont(spnLostToTrub.getFont());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel4.add(spnLostToTrub, gridBagConstraints);

        jLabel12.setFont(new Font("Tahoma", Font.PLAIN, 11));
        jLabel12.setText("Lost to sparge");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel4.add(jLabel12, gridBagConstraints);

        spnLostToSparge.setFont(spnLostToSparge.getFont());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel4.add(spnLostToSparge, gridBagConstraints);

        spnLitriKg.setFont(spnLitriKg.getFont());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel4.add(spnLitriKg, gridBagConstraints);

        spnEvaporazione.setFont(spnEvaporazione.getFont());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel4.add(spnEvaporazione, gridBagConstraints);

        jLabel13.setFont(new Font("Tahoma", Font.PLAIN, 11));
        jLabel13.setText("Litri/kg");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel4.add(jLabel13, gridBagConstraints);

        jLabel14.setFont(new Font("Tahoma", Font.PLAIN, 11));
        jLabel14.setText("Evaporazione / h");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        jPanel4.add(jLabel14, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(jPanel4, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
	Config config=new Config();
	
	config.setEfficienza(fldEff.getIntegerValue());
	config.setVolumeFin(fldVolumeFin.getIntegerValue());
	config.setVolumeBoil(fldVolumeBoll.getIntegerValue());
	config.setMetriSLM(fldSLM.getIntegerValue());
	config.setAmaroDHEA(fldDHEA.getIntegerValue());
	config.setBoilTime(fldBoil.getIntegerValue());
	config.setProxyHost(fldProxy.getText());
	config.setProxyPort(fldProxyPort.getText());	
	config.setRemoteServer(fldServer.getText());
	config.setNickIHB(fldNick.getText());
	config.setPasswordIHB(fldPwd.getText());
	config.setPotLibGal((chckbxNewCheckBox.isSelected())?1:0);
	config.setLostToSparge(spnLostToSparge.getVolume());
	config.setLostToTrub(spnLostToTrub.getVolume());
	config.setLitriPerKg(spnLitriKg.getVolume());
	config.setEvaporazionePerOra(spnEvaporazione.getVolume());  
	if(cmbBUGURatio.getSelectedIndex()==0)config.setBUGURatio(BitterBUGU.TIN);
	if(cmbBUGURatio.getSelectedIndex()==1)config.setBUGURatio(BitterBUGU.RAG);
	if(cmbBUGURatio.getSelectedIndex()==2)config.setBUGURatio(BitterBUGU.DAN);
	
	Main.config=config;
        File file=new File(Main.configXML);
        Document doc=new Document();
        Element root=config.toXml();
        doc.setRootElement(root);
Utils.saveXmlAsFile(doc, file, this);
        if(config.getProxyHost()!=null)System.setProperty("http.proxyHost",config.getProxyHost());
        if(config.getProxyPort()!=null)System.setProperty("http.proxyPort",config.getProxyPort());	
    }//GEN-LAST:event_jButton3ActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private jmash.component.JMashSpinner fldBoil;
    private jmash.component.JMashSpinner fldEff;
    private javax.swing.JTextField fldNick;
    private javax.swing.JTextField fldProxy;
    private javax.swing.JTextField fldProxyPort;
    private javax.swing.JTextField fldPwd;
    private jmash.component.JMashSpinner fldSLM;
    private jmash.component.JMashSpinner fldDHEA;
    private javax.swing.JTextField fldServer;
    private jmash.component.JMashSpinner fldVolumeBoll;
    private jmash.component.JMashSpinner fldVolumeFin;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelBUGU;
    private javax.swing.JLabel jLabelDHEA;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JToolBar jToolBar1;
    private jmash.component.JVolumeSpinner spnEvaporazione;
    private jmash.component.JVolumeSpinner spnLitriKg;
    private jmash.component.JVolumeSpinner spnLostToSparge;
    private jmash.component.JVolumeSpinner spnLostToTrub;
    private GridBagConstraints gridBagConstraints_1;
    private GridBagConstraints gridBagConstraints_2;
    private GridBagConstraints gridBagConstraints_3;
    private GridBagConstraints gridBagConstraints_4;
    private GridBagConstraints gridBagConstraints_5;
    private GridBagConstraints gridBagConstraints_6;
    private GridBagConstraints gridBagConstraints_7;
    private GridBagConstraints gridBagConstraints_8;
    private GridBagConstraints gridBagConstraints_8_1;
    private GridBagConstraints gridBagConstraints_9;
    private GridBagConstraints gridBagConstraints_10;
    private GridBagConstraints gridBagConstraints_11;
    private GridBagConstraints gridBagConstraints_12;
    private GridBagConstraints gridBagConstraints_13;
    private JCheckBox chckbxNewCheckBox;
    private JButton btnNewButton;
    private JComboBox cmbBUGURatio;
    // End of variables declaration//GEN-END:variables
    
}
