
import com.google.gson.*;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import org.apache.commons.io.IOUtils;
import java.util.ArrayList;

public class DictionaryAPI {
    private static String baseURL  = "http://dictionaryapi.herokuapp.com/";
    
    public DictionaryAPI(){
        
    }
    
    public String define(String word) throws Exception{
        URL url = new URL(baseURL + "?define=" + word);
        URLConnection con = url.openConnection();
	InputStream in = con.getInputStream();
	String encoding = con.getContentEncoding();
	encoding = encoding == null ? "UTF-8" : encoding;
	String body = IOUtils.toString(in, encoding);
	JsonObject entireJSON = new JsonParser().parse(body).getAsJsonObject();
        JsonArray json = entireJSON.getAsJsonArray();
	
        ArrayList<String> options = new ArrayList<String>();
        for()
        
    }
}
