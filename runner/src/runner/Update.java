/*
 * Update.java
 *
 * Created on 3 ottobre 2007, 9.41
 */

package runner;

import java.awt.Color;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.FileChannel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

/**
 *
 * @author  AChiari Ixtlanas
 */
public class Update extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6826833234065506204L;
	private int webVersion=0;
	private boolean updated = false;
    
    /** Creates new form Update */
    public Update() {
	initComponents();
    }
    private void readversionfromweb(String address)
    {
    	try
    	{
    		String content="";
    		URL url = new URL(address);	
    		URLConnection yc= url.openConnection();
    		BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
    		String inputLine;
    		 while ((inputLine = in.readLine()) != null)
    		 {
                content+=inputLine;
             }
             in.close();
             webVersion=Integer.parseInt(content);
    	}
    	catch(Exception ex)
    	{
    		
    	}
    }
    private void download(String from, String _to, int size) {
	try
	{
		OutputStream out = null;
		URLConnection conn = null;
		InputStream  in = null;
		URL url = new URL(from);
		
		out = new BufferedOutputStream(
			new FileOutputStream(_to+"_"));
		conn = url.openConnection();
		in = conn.getInputStream();
		byte[] buffer = new byte[1024];
		int numRead;
		long numWritten = 0;
		int d=0;
	        if (size != 0)  {
	            jProgressBar2.setMaximum(size);
	            jProgressBar2.setStringPainted(true);
	        }
		
		while ((numRead = in.read(buffer)) != -1) {
		    out.write(buffer, 0, numRead);
		    numWritten += numRead;
	            if (size != 0)  {
	                d+=numRead;
	                jProgressBar2.setValue(d);
	                jProgressBar2.setString(d+"/"+size);
	            }
		}
		out.close();
		in.close();
		copyFile(_to+"_",_to);
		File f=new File(_to+"_");
		f.delete();
	}
	catch (Exception ex)
	{

	}
    }
    public static void copyFile(String source, String dest) throws IOException {
	FileChannel in = null, out = null;
	try {
	    in = new FileInputStream(new File(source)).getChannel();
	    out = new FileOutputStream(new File(dest)).getChannel();
	    in.transferTo( 0, in.size(), out);
	    
	} finally {
	    if (in != null)     in.close();
	    if (out != null)    out.close();
	}
    }
    
    public String remoteRoot;

    public boolean update(String remoteR, String proxyHost, String proxyPort) throws Exception{

        boolean ret = false;
	System.setProperty("http.proxyHost",proxyHost);
	System.setProperty("http.proxyPort",proxyPort);
	remoteR=remoteR.trim();
	txt.setText("Ricerca di aggiornamento in corso...");

        this.remoteRoot=remoteR;

        if(!remoteRoot.endsWith("/"))remoteRoot+="/";

        try {
            log("Check della versione in corso...\n");
            readversionfromweb(remoteRoot+"version.v");
            //download(remoteRoot+"version.v", "version_Repository.txt", 0);
        	}
        catch (Exception ex)
        {
//    		File f = new File("version_Repository.txt");
//        	if (f.exists()) {
//        		f.delete();
//        	}
//        	else
//        	{
//        		File f1 = new File("version_Repository.txt_");
//        		if (f1.exists()) {
//        			f1.delete();
//        		}
//            f1 = null;
//        	}
//        f = null;
        jButton1.setText("Chiudi");
        log("Errore nel check della versione. Riprova piu' tardi.\n");
        return ret;
        }
        log("Trovato il file di versione\n");
//IXTLANAS modificato metodo di check aggiornamento
//        File f = new File("version_Repository.txt");
//        int versioneRepository = 0;
//        if (f.exists()) {
//            FileReader in = new FileReader(f);
//
//            char[] c = new char[2048];
//            while (in.read(c)>0) {
//                try {
//                    versioneRepository = Integer.parseInt(String.valueOf(c).trim());
//                } catch (NumberFormatException nfex) {
//                    versioneRepository = 0;
//                }
//            }
//            in.close();
//        }
        
        File fVersione = new File("config/version.v");
        int versione = 0;
        if (fVersione.exists()) {
            FileReader in = new FileReader(fVersione);

            char[] c = new char[2048];
            while (in.read(c)>0) {
                try {
                    versione = Integer.parseInt(String.valueOf(c).replace("\n", "").replace("\r", "").trim());
                } catch (NumberFormatException nfex) {
                    versione = 0;
                }
            }
            in.close();
        }

        log("Versione locale: " + String.valueOf(versione) + " | Versione trovata: " + String.valueOf(webVersion) + "\n");

        if (versione != webVersion) {

            log("Trovata una nuova versione, download in corso, per maggiori informazioni vai su http://brewplus.blogspot.it\n");
            try {
                jButton1.setEnabled(false);
                download(remoteRoot+"BrewPlus.zip", "BrewPlus.zip", 0);
                jButton1.setEnabled(true);
            } catch (Exception ex) {
            	log(ex.getMessage());
                File fz = new File("BrewPlus.zip");
                if (fz.exists()) {
                    fz.delete();
                    fz = null;
                }
                jButton1.setText("Chiudi");
                log("Errore nel check della versione. Riprova più tardi.");
                return ret;
            }
            log("Scompattazione della nuova versione in corso...\n");
            File fZip = new File("BrewPlus.zip");
            if (fZip.exists()) {

                java.util.zip.ZipFile zf = new java.util.zip.ZipFile(fZip);
                if (zf.size() > 0) {
                    Enumeration enu = zf.entries();

                    while (enu.hasMoreElements()) {
                        java.util.zip.ZipEntry ze = (ZipEntry) enu.nextElement();
                        if (ze.isDirectory()) {
                            new File(ze.getName()).mkdir();
                            continue;
                        }

                        //Non sovrascrivo, in aggiornamento, i file di configurazione che contengono le informazioni customizzate dall'utente
                        if (ze.getName().contains("config.xml")) {
                            continue;
                        }
                        if (ze.getName().contains("cache.xml")) {
                            continue;
                        }
                        if (ze.getName().contains("inventario.xml")) {
                            continue;
                        }
                        copyInputStream(zf.getInputStream(ze), new BufferedOutputStream(new FileOutputStream(ze.getName())));
                    }
                }

                zf.close();
                fZip.delete();
                fZip = null;
                fVersione=null;
                //aggiornamento version.v locale in config
                try
                {
                	PrintWriter out= new PrintWriter(new FileWriter("config/version.v"));
                	out.print(webVersion);
                	out.close();
                }
                catch(IOException ex)
                {}
                
                //fVersione.delete();
                //fVersione = null;
//                copyFile("version_Repository.txt", "config/version.v");
//                f.delete();
//                f = null;
                ret = true;
                updated = true;
                log("Operazione terminata.");
            }
        } else {
            //non serve aggiornare... quindi updated = true;
            ret = true;
            updated = true;
        }

        if (ret) {
            txt.setText("Aggiornamento effettuato con successo!\n");
            txt.setBackground(Color.green);
        } else {
            log("Nessun aggiornamento effettuato.");
        }
	jProgressBar2.setIndeterminate(false);
        
	jButton1.setText("Chiudi");
    return ret;
    }

    public static final void copyInputStream(InputStream in, OutputStream out) throws IOException
    {
        byte[] buffer = new byte[1024];
        int len;

        while((len = in.read(buffer)) >= 0)
            out.write(buffer, 0, len);

        in.close();
        out.close();
    }

    String log="";
    public void log(String L){
	log+=L;
	fldLog.setText(log);
    }
    public void log(Exception ex){
	log+=ex.getMessage();
	StackTraceElement [] el=ex.getStackTrace();
	for (int i = 0; i < el.length; i++) {
	    log+="\n"+el[i].toString();    
	}
	fldLog.setText(log);
    }    
    private void error(String err){
	txt.setText(err);
	txt.setBackground(Color.red);
	txt.setForeground(Color.white);
	jButton1.setText("Esci");
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        txt = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        fldLog1 = new javax.swing.JScrollPane();
        fldLog = new javax.swing.JTextArea();
        jProgressBar2 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aggiornamento disponibile");
        setAlwaysOnTop(true);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setFocusCycleRoot(false);
        setResizable(false);

        txt.setEditable(false);
        txt.setFont(new java.awt.Font("Tahoma", 1, 11));
        txt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButton1.setText("Annulla");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        fldLog.setColumns(20);
        fldLog.setEditable(false);
        fldLog.setRows(5);
        fldLog1.setViewportView(fldLog);

        jProgressBar2.setIndeterminate(true);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, fldLog1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(jProgressBar2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 568, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jProgressBar1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 568, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jButton1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, txt, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jButton1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(jProgressBar1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jProgressBar2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(txt, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(fldLog1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-709)/2, (screenSize.height-333)/2, 709, 333);
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
	if (updated) {
            try {
                Runtime.getRuntime().exec("java -jar BrewPlus.jar");
            } catch (IOException ex) {
                Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea fldLog;
    private javax.swing.JScrollPane fldLog1;
    private javax.swing.JButton jButton1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JTextField txt;
    // End of variables declaration//GEN-END:variables
    
    
}
