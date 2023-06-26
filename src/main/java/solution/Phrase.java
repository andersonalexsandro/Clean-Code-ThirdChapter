package solution;

import java.util.ArrayList;
import java.util.Arrays;

public class Phrase {

    private String phraseString;
    private ArrayList<String> words;

    public Phrase(String phraseString) {
        this.phraseString = phraseString;
        this.words = phrseToWords(this.phraseString);
    }

    public String getPhraseString() {
        return phraseString;
    }

    public void setPhraseString(String phraseString) {
        this.phraseString = phraseString;
        this.words = phrseToWords(this.phraseString);
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public static ArrayList<String> phrseToWords(String phrase){
        return new ArrayList<>(Arrays.asList(phrase.split(" ")));
    }

}
