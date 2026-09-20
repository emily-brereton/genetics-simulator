package emily.io;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;


import emily.model.utils.Randomize;

public class ConsolePrompter <T>{

// selectThing(prompt, List<T> options) — generic, covers trait phenotypes, parent selection, menu selection.
// DID NOT DO YET askValidatedChoice(prompt, Set<String> validAnswers) — covers isMale (and honestly, probably the "manual or random" 1-vs-2 decision too, once you notice that's just a 2-item version of the same shape).
// askFreeTextOrRandom(prompt, List<String> randomPool) — covers name.

    private final Scanner input;

    ConsolePrompter(Scanner input){
        this.input = input;
    }

    // print list of things, prompt user to select one
    // does not validate choice
    public String selectOption(String prompt, List<T> options) {
        System.out.println(prompt);
        for (T item : options) {
            System.out.println(item);
        }
        String selection = input.nextLine();
        return selection;
    }

    // prompt user to input text, accept any text
    // if R, return randomized value
    public String askText(String prompt, List<String> options){
        System.out.println(prompt);
        String selection = input.nextLine();
        if (selection.equalsIgnoreCase("R")) {
            selection = Randomize.random(options);
        }
        return selection;
    }


    public String askSet(String prompt, HashSet<String> options){
        String selection = "";
        while (!options.contains(selection)){
            System.out.println(prompt);
            selection = input.nextLine();
        }
        return selection;
    }







    // public String askRandom(String prompt, String optionRandom){
    //     System.out.println(prompt);
    //     String selection = input.nextLine();
    //     if selection.equals(optionRandom){
            
    //     }
    // }

    // // method to prompt user selection of sex
    // public String isMalePrompter(Scanner input){
    //     String selection = "";
    //     while (!selection.equals("R") && !selection.equals("XX") && !selection.equals("XY")) {
    //         System.out.println(
    //                 "Is your person male (XY) or female (XX)? Type your answer or type \"R\" to randomize.");
    //         selection = input.nextLine().toUpperCase();
    //     }
    //     return selection;
    //     }




}
