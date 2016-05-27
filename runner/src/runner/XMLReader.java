
package runner;

import java.io.IOException;
import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.xml.sax.InputSource;

/**
 *
 * @author AChiari
 */
public class XMLReader {
    
    public static Document readXML(String file) throws JDOMException, IOException {
            SAXBuilder builder = new SAXBuilder();
            InputSource is = new InputSource(file);
            is.setEncoding("UTF-8");
            Document doc = builder.build(is);
            return doc;
    }
    
}
