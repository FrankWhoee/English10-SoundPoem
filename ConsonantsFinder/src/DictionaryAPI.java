import java.net.URL;
import java.util.ArrayList;
import com.google.gson.*;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.Arrays;
import org.apache.commons.io.IOUtils;


public class DictionaryAPI {

    private final static String baseURL = "https://www.dictionaryapi.com/api/v1/references/collegiate/xml/";
    private final static String APIkey = "1def8004-9684-4a1b-869d-857bf2c307d3";
    private final static String googleDictURL = "http://dictionaryapi.herokuapp.com/?define=";
    private final static ArrayList<String> wordTypes = new ArrayList<>(Arrays.asList("noun","adjective", "verb","adverb","pronoun","preposition", "conjunction", "determiner", "exclamation"));

    public DictionaryAPI() {

    }

    public static String define(String word) throws Exception {
        URL url = new URL(googleDictURL + word);
		URLConnection con = url.openConnection();
		InputStream in = con.getInputStream();
		String encoding = con.getContentEncoding();
		encoding = encoding == null ? "UTF-8" : encoding;
		String body = IOUtils.toString(in, encoding);
		JsonObject entireJSON = new JsonParser().parse(body).getAsJsonObject();
		
		String definition = word.substring(0,1).toUpperCase() + word.substring(1) + ":\n";
		
		for(String type : wordTypes) {
			String def = "";
			String example = "";
			try {
				def = entireJSON.get(type).getAsJsonArray().get(0).getAsJsonObject().get("definition").getAsString();
				example = entireJSON.get(type).getAsJsonArray().get(0).getAsJsonObject().get("example").getAsString();
				definition += type.substring(0,1).toUpperCase() + type.substring(1) + ":\n" + def.substring(0,1).toUpperCase() + def.substring(1) + "\nExample: " + example.substring(0,1).toUpperCase() + example.substring(1) + "\n\n";
				//System.out.println("[SUCCESS]: " + type);
			}catch(Exception e) {
				//System.out.println("[ERROR]: " + type);
			}
			
		}
		
		
        return definition;
        		

    }
}
