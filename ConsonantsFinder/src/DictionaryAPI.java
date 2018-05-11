import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;



public class DictionaryAPI {

    private final static String baseURL = "https://www.dictionaryapi.com/api/v1/references/collegiate/xml/";
    private final static String APIkey = "1def8004-9684-4a1b-869d-857bf2c307d3";

    public DictionaryAPI() {

    }

    public static String define(String word) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new URL(baseURL + word + "?key=" + APIkey).openStream());
        doc.getElementsByTagName("entry");
        String definition;
        try {
        	definition = doc.getElementsByTagName("def").item(0).getTextContent();
        }catch(Exception e) {
        	
        	definition = doc.getElementsByTagName("def").item(0).getTextContent();
        }
        try{
        	definition = definition.replaceAll(":", "");
        }catch(Exception e) {
        	
        }
        return definition;
        
        

    }
}
