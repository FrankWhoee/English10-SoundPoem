
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ref {
    
    public final static ArrayList<String> consonants = new ArrayList<String>(Arrays.asList("B", "C", "D", "F", "G", "H", "J", "K", "L", "M", "N", "P", "Q", "R", "S","T", "V","W","X","Y","Z"));
    
    //Execptions
    public static Map<String, String> e = new HashMap<String,String>();
    
    public void RefInit(){
        //Key is weird combo
        //Value is letter that it sounds like
        e.put("PH","F");
        e.put("GH","F");
        
        e.put("CH","J");
        e.put("B","P");
        
        e.put("P","B");
        e.put("D","T");
        
        e.put("T","D");
        e.put("K","G");
        
        e.put("K","G");
        e.put("Z","S");
        
        e.put("S","Z");
        e.put("F","V");
        
        e.put("V","F");
        e.put("WH","W");
        
        e.put("SH","S");
        e.put("WR","R");
        
        e.put("MB","M");
        e.put("GU","O");
        
        
    }
    
    
}
