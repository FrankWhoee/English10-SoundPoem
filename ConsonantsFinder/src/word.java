
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
        
        String prev = "";
        
        //For every letter of the word...
        for(String letter: word){
            //If this letter is a consonant...
            System.out.println(letter);
            if(Ref.consonants.contains(letter)){
                //if()
                //Add it to the total amount of consonants
                wordCons.add(letter);
                prev = letter;
            } 
        }
        
        if(wordCons.size() == 0){
            return 0;
        }
        
        //For every letter of the ideal word...
        for(String letter : Ideal){
            //If this letter is a consonant...
            
            System.out.println(letter);
            if(Ref.consonants.contains(letter)){
                //Add it to the total amount of consonants
                
                idealCons.add(letter);
            } 
        }
        try{
            //For every consonant of the word...
            for(int i = 0; i < this.word.length() - 1; i++){
                //If the ideal word contains this consonant of this word...
                if(idealCons.contains(wordCons.get(i))){
                    //Add it to the matching consonants.
                    matchingCons.add(wordCons.get(i));
                }
            }
        }catch (Exception e){
            
        }
        return (float)matchingCons.size()/(float)wordCons.size();
    }
}
