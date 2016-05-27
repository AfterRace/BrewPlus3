/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package runner.test;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            download("http://brew_0.1.1.1.zip/download",
                    "C:/dwl.zip");
        } catch (Exception ex) {
            //Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

    private static void download(String from, String _to) throws Exception {

        OutputStream out = null;
        URLConnection conn = null;
        InputStream in = null;
        URL url = new URL(from);

        out = new BufferedOutputStream(
                new FileOutputStream(_to));
        conn = url.openConnection();
        in = conn.getInputStream();
        byte[] buffer = new byte[1024];
        int numRead;
        long numWritten = 0;
        int d = 0;
        while ((numRead = in.read(buffer)) != -1) {
            out.write(buffer, 0, numRead);
            numWritten += numRead;
            d += numRead;
        }
        out.close();
        in.close();
        //File f = new File(_to + "_");
        //f.delete();
    }
}
