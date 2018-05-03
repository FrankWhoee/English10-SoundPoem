
import java.util.ArrayList;

public class word {
    public String word;
    public float score;
    
    public word(String word, float score){
        this.word = word;
        this.score = score;
    }
    
    
    public float calcScore(String ideal){
        ArrayList<String> wordCons = new ArrayList<String>();
        ArrayList<String> idealCons = new ArrayList<String>();
        ArrayList<String> matchingCons = new ArrayList<String>();
        
        String[] word = this.word.toUpperCase().split("");
        String[] Ideal = ideal.toUpperCase().split("");
        
        //For every letter of the word...
        for(String letter: word){
            //If this letter is a consonant...
            if(Ref.consonants.contains(letter)){
                //Add it to the total amount of consonants
                wordCons.add(letter);
            } 
        }
        
        for(String key : Ref.e.keySet()){
            if(this.word.contains(key)){
                wordCons.add(Ref.e.get(key));
            }
        }
        
        if(wordCons.size() == 0){
            return 0;
        }
        
        //For every letter of the ideal word...
        for(String letter : Ideal){
            //If this letter is a consonant...
            if(Ref.consonants.contains(letter)){
                //Add it to the total amount of consonants
                idealCons.add(letter);
            } 
        }
        
        for(String key : Ref.e.keySet()){
            if(ideal.contains(key)){
                idealCons.add(Ref.e.get(key));
            }
        }
        
            //For every consonant of the word...
            for(int i = 0; i < wordCons.size() - 1; i++){
                //If the ideal word contains this consonant of this word...
                try{
                    if(idealCons.contains(wordCons.get(i))){
                        //Add it to the matching consonants.
                        matchingCons.add(wordCons.get(i));
                    }
                }catch (Exception e){
                    System.out.println("[ERROR]: " + this.word +" " + e.getMessage());
                }
            }
        //System.out.println("[CALCULATION]: " + ((float)matchingCons.size()/(float)wordCons.size()) * 100);
        this.score = ((float)matchingCons.size()/(float)wordCons.size()) * 100;
        return ((float)matchingCons.size()/(float)wordCons.size()) * 100;
    }
}
