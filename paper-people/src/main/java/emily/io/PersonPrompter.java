package emily.io;

import java.util.Scanner;
import emily.model.people.Male;
import emily.model.people.Female;
import emily.model.people.PersonFactory;
import emily.model.traits.Eyes;
import emily.model.traits.Hair;
import emily.model.utils.Ancillary;
import emily.model.utils.Randomize;

public class PersonPrompter {
    private final TraitPrompter traitPrompter;

    public PersonPrompter(Scanner input) {
        this.traitPrompter = new TraitPrompter(input);
    }

    public Male createMan(String firstName, String lastName) {
        // Ancillary.pause(input, "Creating person...");

        Eyes eyesTemplate = new Eyes();
        Hair hairTemplate = new Hair();

        String eyesChoice = traitPrompter.getUserChoice("his", "eye color",
                eyesTemplate.getSelectionMenu(), eyesTemplate.getPhenotypes());
        String hairChoice = traitPrompter.getUserChoice("his", "hair color",
                hairTemplate.getSelectionMenu(), hairTemplate.getPhenotypes());

        return PersonFactory.createMale(firstName, lastName, eyesChoice, hairChoice);
    }

    public Female createWoman(String firstName, String lastName) {
        // Ancillary.pause(input, "Creating person...");

        Eyes eyesTemplate = new Eyes();
        Hair hairTemplate = new Hair();

        String eyesChoice = traitPrompter.getUserChoice("her", "eye color",
                eyesTemplate.getSelectionMenu(), eyesTemplate.getPhenotypes());
        String hairChoice = traitPrompter.getUserChoice("her", "hair color",
                hairTemplate.getSelectionMenu(), hairTemplate.getPhenotypes());

        return PersonFactory.createFemale(firstName, lastName, eyesChoice, hairChoice);
    }


    // only method needed for name?
    public String namePrompter(Scanner input, String[] names, String message){
        System.out.println(message);
        String name = input.nextLine();
        if (name.equalsIgnoreCase("R")) {
            name = Randomize.random(names);
        }
        name = Ancillary.formatName(name);
        return name;
    }


    // method to prompt user selection of sex
    public String isMalePrompter(Scanner input){
        String selection = "";
        while (!selection.equals("R") && !selection.equals("XX") && !selection.equals("XY")) {
            System.out.println(
                    "Is your person male (XY) or female (XX)? Type your answer or type \"R\" to randomize.");
            selection = input.nextLine().toUpperCase();
        }
        return selection;
        }

    // method to assign sex
    // probably should go in a different class
    public boolean isMale(String selection) {
        boolean isMale = true;
        switch (selection) {
            case "R" -> {
                isMale = Math.random() < 0.5;
                }
            case "XY" -> {
                isMale = true;
                }
            case "XX" -> {
                isMale = false;
                }
            default -> System.out.println("Invalid entry. Please try again.");
            }
        return isMale;
    }
}
