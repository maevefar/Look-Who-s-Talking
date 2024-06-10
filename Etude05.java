/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package etude05;

import java.util.*;

/**
 *
 * @author Maeve Farley and Tara Glennie
 * Group Name: Fast WiFi
 */
public class Etude05 {
     public static void main(String[] args) {

        //Standard input set up 
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String sentence = sc.nextLine();
            if (sentence.equals("")) {
                return;
            }
            sentence = sentence.toLowerCase(); // converts whole sentence to lower case
            String verb = getVerb(sentence); // sets verb to the verb found in the sentence 
            String finalVerb = verbTranslate(verb);
            String finalSentenceStarter = tense(sentence, verb);
            String finalPronoun = personalPronoun(sentence);

            if (finalVerb.equals("INVALID") || finalSentenceStarter.equals("INVALID")
                    || finalPronoun.equals("INVALID")) {
                System.out.println("INVALID");
            } else {
                System.out.println(finalSentenceStarter + " " + finalVerb + " " + finalPronoun);
            }
        }
    }

    /*Method which translates the verb based on the tense of the sentence */
    public static String tense(String sentence, String verb) {
        String sentenceStarter = "INVALID"; // defaults the Māori sentence starter to invalid 
        ArrayList<String> pastVerbs = new ArrayList<String>(); //creates an array list of verbs which are in the past tense term (which don't have an "ed")
        pastVerbs.add("went");
        pastVerbs.add("made");
        pastVerbs.add("saw");
        pastVerbs.add("read");

        int lengthOfVerb = verb.length(); //sets lengthOfVerb to the length of the verb
            if (sentence.contains("will")) { // if the verb is future tense
                sentenceStarter = "Ka";
            } else if (pastVerbs.contains(verb) || (verb.substring(lengthOfVerb - 2).equals("ed"))) { // if the verb is past tense
                sentenceStarter = "I";
            } else if (verb.substring(lengthOfVerb - 3).equals("ing")) { // if the verb is present tense
                sentenceStarter = "Kei te";
            }
        return sentenceStarter;
    }

    /* Method which translates the personal pronoun of the sentence */
    public static String personalPronoun(String sentence) {
        String finalPronoun = " ";
        String[] splitSentence = sentence.split(" "); //Splits the sentence by space
        int number = 0;
        char[] chars = sentence.toCharArray();
        
        //Goes through and checks if any of the words are numbers
        StringBuilder sb = new StringBuilder();
        for(char c : chars){
            if (Character.isDigit(c)) {
                sb.append(Character.getNumericValue(c));
                String stringNumber = sb.toString();
                number = Integer.valueOf(stringNumber);
            }
        }
        if (number == 2) { // If there is a 2 in the sentence -> indicating 2 incl/excl 
            finalPronoun = twoPeopleInclusive(sentence, splitSentence);
        } else if (number >= 3) { // If there is a 3 in the sentence -> indicating 3 incl/excl 
            finalPronoun = threePeopleInclusive(sentence, splitSentence);
        } else {  //else assume single person
            finalPronoun = singlePersonInclusive(sentence, splitSentence);
        }
    return finalPronoun;
    }

public static String singlePersonInclusive(String sentence, String[] splitSentence){
    String finalPronoun = "INVALID";
    Dictionary<String, String> onePersonInclusivity = new Hashtable<>(); //create a dictionary of pronouns which are one person incl/excl
    onePersonInclusivity.put("i", "au");
    onePersonInclusivity.put("me", "ahau");
    onePersonInclusivity.put("you", "koe");
    onePersonInclusivity.put("he", "ia");
    onePersonInclusivity.put("him", "ia");
    onePersonInclusivity.put("she", "ia");
    onePersonInclusivity.put("her", "ia");

    String pronoun = splitSentence[0];
    finalPronoun = onePersonInclusivity.get(pronoun); // sets final pronoun to the Māori translation of the english pronoun from the dictionary 

    if (finalPronoun == null) { //if the english pronoun is not in the dictionary return invalid 
        return "INVALID";
    }
return finalPronoun;
}


public static String twoPeopleInclusive(String sentence, String[] splitSentence){
    String finalPronoun = "INVALID";
    Dictionary<String, String> twoPeopleInclusivityTable = new Hashtable<>(); //create a dictionary of pronouns which are two people incl/excl
            twoPeopleInclusivityTable.put("you", "kōrua");
            twoPeopleInclusivityTable.put("they", "rāua");
            twoPeopleInclusivityTable.put("them", "rāua");

            String pronoun = splitSentence[0]; //set pronoun to the english pronoun 
            finalPronoun = twoPeopleInclusivityTable.get(pronoun); // sets final pronoun to the Māori translation of the english pronoun from the dictionary 

            if (finalPronoun == null) { //if the english pronoun was not in the dictionary 
                if (sentence.contains("excl")) { // and the sentence contains excl, set the final pronoun to the Māori translation of we/us (two+ people), which excludes the listener
                    finalPronoun = "māua";
                } else if (sentence.contains("incl")) { // or the sentence contains incl, set the final pronoun to the Māori translation of we/us (two+ people), which includes the listener
                    finalPronoun = "tāua";
                }
            }
    return finalPronoun;
}

public static String threePeopleInclusive(String sentence, String[] splitSentence){
    String finalPronoun = "INVALID";
    Dictionary<String, String> threePeopleInclusivityTable = new Hashtable<>(); //create a dictionary of pronouns which are three people incl/excl
    threePeopleInclusivityTable.put("you", "koutou");
    threePeopleInclusivityTable.put("they", "rātou");
    threePeopleInclusivityTable.put("them", "rātou");

    String pronoun = splitSentence[0]; //set pronoun to the english pronoun 
    finalPronoun = threePeopleInclusivityTable.get(pronoun); // sets final pronoun to the Māori translation of the english pronoun from the dictionary 

    if (finalPronoun == null) { //if the english pronoun was not in the dictionary 
        if (sentence.contains("excl")) {  // and the sentence contains excl, set the final pronoun to the Māori translation of we/us (three+ people), which excludes the listener
            finalPronoun = "mātou";
        } else if (sentence.contains("incl")) { // or the sentence contains incl, set the final pronoun to the Māori translation of we/us (three+ people), which includes the listener
            finalPronoun = "tātou";
        }
    }
    return finalPronoun;
}


    // Method that translates an english verb to Māori
    public static String verbTranslate(String verb) {
        Dictionary<String, String> verbDictionary = new Hashtable<>(); //Translation dictionary set up 
        verbDictionary.put("go", "haere");
        verbDictionary.put("make", "hanga");
        verbDictionary.put("see", "kite");
        verbDictionary.put("want", "hiahia");
        verbDictionary.put("call", "karanga");
        verbDictionary.put("ask", "pātai");
        verbDictionary.put("read", "pānui");
        verbDictionary.put("learn", "ako");
        verbDictionary.put("went", "haere");
        verbDictionary.put("made", "hanga");
        verbDictionary.put("saw", "kite");
        verbDictionary.put("making", "hanga");

        int verbLength = verb.length();

        // These if statements check if the verb is in its base form or not, if it's not then it will revert it back to the base form so every form doesn't have to be added to the dictionary
        if (verbLength > 2) {
            if (verb.substring(verbLength - 3).equals("ing") && !verb.equals("making")) { //Checks if the verb has an "ing" on the end, if it does, remove it 
                verb = verb.substring(0, verbLength - 3);
            } else if (verb.substring(verbLength - 2).equals("ed")) { //Checks if the verb has "ed" on the end, if it does, remove it 
                verb = verb.substring(0, verbLength - 2);
            } 
        }

        String translatedVerb = verbDictionary.get(verb);

        // If the verb isn't in the dictionary, return invalid 
        if (translatedVerb == null) {
            return "INVALID";
        }

        return translatedVerb;

    }

    // Method which retreieves english verb from the sentence. If there is no verb, it will return invalid 
    public static String getVerb(String sentence) {
        ArrayList<String> allVerbs = new ArrayList<String>();
        allVerbs.add("go");
        allVerbs.add("make");
        allVerbs.add("see");
        allVerbs.add("want");
        allVerbs.add("call");
        allVerbs.add("ask");
        allVerbs.add("read");
        allVerbs.add("learn");
        allVerbs.add("went");
        allVerbs.add("made");
        allVerbs.add("saw");
        allVerbs.add("wanted");
        allVerbs.add("called");
        allVerbs.add("asked");
        allVerbs.add("learned");
        allVerbs.add("learnt");
        allVerbs.add("going");
        allVerbs.add("making");
        allVerbs.add("seeing");
        allVerbs.add("wanting");
        allVerbs.add("calling");
        allVerbs.add("asking");
        allVerbs.add("reading");
        allVerbs.add("learning");

        String[] splitSentence = sentence.split(" ");
        for (int i = 0; i < splitSentence.length; i++) {
            for (int j = 0; j < allVerbs.size(); j++) {
                if (splitSentence[i].equals(allVerbs.get(j))) {
                    return allVerbs.get(j);
                }
            }
        }
        return "INVALID";

    }
}
