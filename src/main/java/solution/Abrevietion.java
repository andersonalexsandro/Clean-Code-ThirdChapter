package solution;

import java.util.ArrayList;
import java.util.Objects;

public class Abrevietion implements Comparable<Abrevietion> {

    private static final ArrayList<Abrevietion> ALL_ABREVIETIONS = new ArrayList<>();
    private AbrevietionRules abrevietionRules;
    private String word;
    private String abrevietion;
    private boolean abrevieted;

    public Abrevietion(String word, AbrevietionRules abrevietionRules) {
        this.word = word;
        this.abrevietionRules = abrevietionRules;
        this.abrevietion = abrevieteWord();
        this.abrevieted = isWordAbrevieteble();
        appendToAllAbrivietions(this);
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
        this.abrevietion = abrevieteWord();
        this.abrevieted = isWordAbrevieteble();
    }

    public String getAbrevietion() {
        return abrevietion;
    }

    public boolean isAbrevieted() {
        return abrevieted;
    }

    private boolean isWordAbrevieteble(){
        if(isThisWordAlreadyAbrevieted()) return true;
        if(isThisWordAbrevietionEqualsAnotherAbrevietion()) return false;
        if(isWordAdequate()) return true;
        return false;
    }

    private boolean isWordAdequate(){
        if(word.length() >= abrevietionRules.getMinimumWordSize() && !isThisWordAlreadyAbrevieted()) return true;
        return false;
    }

    public String abrevieteWord(){

        if(isWordAbrevieteble()) return abrevietionRules.getAbrevieteFunction().apply(this.word);
        return word;
    }

    private boolean isThisWordAbrevietionEqualsAnotherAbrevietion(){
        if(getAbrevitionsEqualsThisAbrevietionWord().size() > 0) return true;
        return false;
    }

    private ArrayList<Abrevietion> getAbrevitionsEqualsThisAbrevietionWord(){
        return new ArrayList<>(ALL_ABREVIETIONS.stream().filter(Abrevietion::isAbrevieted).filter(abrevietion -> abrevietion.getAbrevietion().equalsIgnoreCase(abrevietionRules.getAbrevieteFunction().apply(word))).toList());
    }

    private ArrayList<Abrevietion> getAbrevietionsWithThisWord(){
        return new ArrayList<>(ALL_ABREVIETIONS.stream().filter(Abrevietion::isAbrevieted).filter(abrevietion -> abrevietion.getWord().equalsIgnoreCase(word)).toList());
    }

    private boolean isThisWordAlreadyAbrevieted(){
        if(getAbrevietionsWithThisWord().size() > 0) return true;
        return false;
    }

    public static ArrayList<Abrevietion> getAllAbrevietions(){
        return ALL_ABREVIETIONS;
    }

    private void appendToAllAbrivietions(Abrevietion abrevietion){
        if (isAbrevieted() && !ALL_ABREVIETIONS.contains(this)) ALL_ABREVIETIONS.add(abrevietion);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Abrevietion that = (Abrevietion) o;
        return abrevieted == that.abrevieted && Objects.equals(word, that.word) && Objects.equals(abrevietion, that.abrevietion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, abrevietion, abrevieted);
    }

    @Override
    public String toString(){
        return abrevietion + " = " + word;
    }

    @Override
    public int compareTo(Abrevietion abrevietion) {
        return this.word.compareTo(abrevietion.getAbrevietion());
    }
}
