/*
 * Main.java
 *
 * Created on 12 settembre 2007, 11.45
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package runner;

/**
 *
 * @author AChiari
 */
public class Main {
    
    /** Creates a new instance of Main */
    public Main() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Update up=new Update();
        up.setVisible(true);
        boolean updated = false;
	if(args.length<1){
	    up.log("Too few parameters, programmer or caller error!");
	}
	else if(args.length==1){
	    updated = up.update(args[0],"","");
	}
	else {
	    updated = up.update(args[0],args[1],args[2]);
	}
    }
    
}
