package emily.io;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import emily.model.people.Male;
import emily.model.people.Person;
import emily.model.people.Female;
import emily.model.people.PersonFactory;
import emily.model.traits.Eyes;
import emily.model.traits.Hair;
import emily.model.utils.Ancillary;

public class PersonPrompter {
    private final TraitPrompter traitPrompter;

    public PersonPrompter(TraitPrompter traitPrompter) {
        this.traitPrompter = traitPrompter;
    }

    public Male createMan(String firstName, String lastName) {
        Eyes eyesTemplate = new Eyes();
        Hair hairTemplate = new Hair();

        String eyesChoice = traitPrompter.generatePhenotype("his", "eye color", eyesTemplate.getSelectionMenu(), eyesTemplate.getPhenotypes());
        String hairChoice = traitPrompter.generatePhenotype("his", "hair color", hairTemplate.getSelectionMenu(), hairTemplate.getPhenotypes());

        return PersonFactory.createMale(firstName, lastName, eyesChoice, hairChoice);
    }

    public Female createWoman(String firstName, String lastName) {
        Eyes eyesTemplate = new Eyes();
        Hair hairTemplate = new Hair();

        String eyesChoice = traitPrompter.generatePhenotype("her", "eye color", eyesTemplate.getSelectionMenu(), eyesTemplate.getPhenotypes());
        String hairChoice = traitPrompter.generatePhenotype("her", "hair color", hairTemplate.getSelectionMenu(), hairTemplate.getPhenotypes());

        return PersonFactory.createFemale(firstName, lastName, eyesChoice, hairChoice);
    }

    

    public Person createBaby(mom, dad)




    public Person selectParent(List<Person> potentialParents) {
        

    }

    public String selectOption(String prompt, List<T> options) {
        System.out.println(prompt);
        for (T item : options) {
            System.out.println(item);
        }
        String selection = input.nextLine();
        return selection;
    }

    // make this into enumerated version, combine selectOption and selectParent into one method
    public String selectOption(String prompt, List<T> options){
        System.out.println(prompt);
        int count = options.size();
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + options.get(i).toString());
        }

    }



    // choose a parent from population list
    public static Person selectParent(String type, List<? extends Person> parentList, Scanner input) {
        System.out.println("Select a " + type + " from the following list:");
        int count = parentList.size();
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + parentList.get(i).toString());
        }
        int parentIndex = input.nextInt() - 1;
        Person parent = parentList.get(parentIndex);
        System.out.println(
                "Great! You selected " + parent.getFirstName() + " " + parent.getLastName() + " as the " + type + " .");
        System.out.println("--------------------------------------------------------");
        input.nextLine();
        return parent;
    }



    public String name(String prompt, String[] options){
        String name = traitPrompter.consolePrompter.askArray(prompt, options);
        name = Ancillary.formatName(name);
        return name;
    }

    public boolean isMalePrompter(){
        boolean isMale = true;
        Set<String> sexOptions = Set.of("XX", "XY", "R");
        String selection = traitPrompter.consolePrompter.askSet(
            "Is your person male (XY) or female (XX)? Type your answer or type \"R\" to randomize.",
            sexOptions);
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
