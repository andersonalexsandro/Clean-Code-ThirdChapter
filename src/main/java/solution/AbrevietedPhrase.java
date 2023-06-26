package solution;

import java.util.ArrayList;

public class AbrevietedPhrase {

    private Phrase phrase;
    private AbrevietionRules abrevietionRules;
    private ArrayList<Abrevietion> abrevietedWords;

    public AbrevietedPhrase(Phrase phrase, AbrevietionRules abrevietionRules) {
        this.phrase = phrase;
        this.abrevietionRules = abrevietionRules;
        this.abrevietedWords = genereteAbrevietedWords();
    }

    private String genereteAbrevietedStringPhrase(){
        StringBuilder stringBuilder = new StringBuilder();
        abrevietedWords.forEach(abrevietion -> stringBuilder.append(abrevietion.getAbrevietion() + " "));
        return stringBuilder.toString();
    }

    private ArrayList<Abrevietion> genereteAbrevietedWords(){
        ArrayList<Abrevietion> abrevietedWords = new ArrayList<>();
        phrase.getWords().forEach(word -> abrevietedWords.add(new Abrevietion(word, abrevietionRules)));
        return abrevietedWords;
    }

    public String toString() {
        return genereteAbrevietedStringPhrase();
    }

}
