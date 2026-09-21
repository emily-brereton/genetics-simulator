package emily.io;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import emily.model.utils.Randomize;

public class ConsolePrompter <T>{
    private final Scanner input;

    public ConsolePrompter(Scanner input){
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


    public String askSet(String prompt, Set<String> options){
        String selection = "";
        while (!options.contains(selection)){
            System.out.println(prompt);
            selection = input.nextLine().toUpperCase();
        }
        return selection;
    }

    public String askArray(String prompt, String[] options){
        String selection = "";
        while (!Arrays.asList(options).contains(selection)){
            System.out.println(prompt);
            selection = input.nextLine().toUpperCase();
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
