package Aplication;

import solution.AbrevietedPhrase;
import solution.Abrevietion;
import solution.AbrevietionRules;
import solution.Phrase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class ChallangeAplication {

    private static Scanner input = new Scanner(System.in);

    private static String inputString(){
        return input.nextLine();
    }

    public static void main(String[] args) {
        AbrevietionRules abrevietionRules;
        String abrevietionSymbol = ".";
        String abrevietionFormat = "%s" + abrevietionSymbol;
        int minimunWordSize = 3;
        UnaryOperator<String> abrevietionFunction = word -> String.format(abrevietionFormat, word.charAt(0));

        abrevietionRules = new AbrevietionRules(abrevietionSymbol,abrevietionFormat, minimunWordSize, abrevietionFunction);

        ArrayList<AbrevietedPhrase> userAbrevietedPhrases = new ArrayList<>();
        Phrase userPhrase;
        String stopSymbol = ".";
        System.out.println("Write some Posts! \".\" alone in a line indicates the end");
        do{
            userPhrase = new Phrase(inputString());
            userAbrevietedPhrases.add(new AbrevietedPhrase(userPhrase,abrevietionRules));
        }while(!userPhrase.getPhraseString().equals(stopSymbol));

        //removing the last phrase becouse "." is not a phrase
        userAbrevietedPhrases.remove(userAbrevietedPhrases.size()-1);

        System.out.println("All posts:");
        userAbrevietedPhrases.forEach(abrevietedPhrase -> System.out.println(abrevietedPhrase.toString()));

        System.out.println("\nThe meaning of each symbol:");
        Collections.sort(Abrevietion.getAllAbrevietions() );
        Abrevietion.getAllAbrevietions().forEach(System.out::println);
    }
}
