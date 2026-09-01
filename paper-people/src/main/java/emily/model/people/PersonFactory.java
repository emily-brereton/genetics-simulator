package emily.model.people;

import java.util.Scanner;
import emily.model.traits.Eyes;
import emily.model.traits.Hair;
import emily.model.traits.Trait;
import emily.model.utils.Ancillary;

import emily.io.TraitPrompter;

public class PersonFactory {

    public static Person createStarterPerson(
            //Scanner input,
            String firstName,
            String lastName,
            boolean isMale,
            String eyesUserChoice,
            String hairUserChoice) {

        //Ancillary.pause(input, "Creating person...");

        Male dad = new Male();
        Female mom = new Female();

        Person person = isMale ? new Male() : new Female();
        person.setDad(dad);
        person.setMom(mom);
        person.setFirstName(firstName);
        person.setLastName(lastName);

        //fix io stuff
        Eyes eyes = new Eyes();
        eyes = (Eyes) Trait.createTrait(eyesUserChoice, eyes, dad.eyes.getGenotype(), mom.eyes.getGenotype());
        System.out.println(firstName + " has " + eyes.getPhenotype() + " eyes (" + eyes.getGenotype() + ").");

        Hair hair = new Hair();
        hair = (Hair) Trait.createTrait(hairUserChoice, hair, dad.hair.getGenotype(), mom.hair.getGenotype());
        System.out.println(firstName + " has " + hair.getPhenotype() + " hair (" + hair.getGenotype() + ").");
        person.setEyes(eyes);
        person.setHair(hair);



        //eyes = (Eyes) Trait.createTrait(getUserChoice(isMale ? "his" : "her", "eye color", eyes.getSelectionMenu(),eyes.getPhenotypes())
        // dad.getEyes().getGenotype(),
        //         mom.getEyes().getGenotype());
        // System.out.println(firstName + " has " + eyes.getPhenotype() + " eyes (" + eyes.getGenotype() + ").");
        // Hair hair = new Hair();
        // hair = (Hair) Trait.createTrait(isMale ? "his" : "her", "hair color", input, hair, dad.getHair().getGenotype(),
        //         mom.getHair().getGenotype());
        // System.out.println(firstName + " has " + hair.getPhenotype() + " hair (" + hair.getGenotype() + ").");
        // person.setEyes(eyes);
        // person.setHair(hair);

        return person;
    }





    public static Person createBaby(
            Scanner input,
            Male dad,
            Female mom,
            String name,
            boolean isMale) {

        Person person = isMale ? new Male() : new Female();
        person.setDad(dad);
        person.setMom(mom);
        person.setFirstName(name);
        person.setLastName(dad.getLastName());

        Eyes eyes = new Eyes();
        eyes = (Eyes) Trait.recombinate(eyes, dad.getEyes().getGenotype(), mom.getEyes().getGenotype());
        System.out.println(name + " has " + eyes.getPhenotype() + " eyes (" + eyes.getGenotype() + ").");
        Hair hair = new Hair();
        hair = (Hair) Trait.recombinate(hair, dad.getHair().getGenotype(), mom.getHair().getGenotype());
        System.out.println(name + " has " + hair.getPhenotype() + " eyes (" + hair.getGenotype() + ").");
        person.setEyes(eyes);
        person.setHair(hair);

        return person;
    }

    public static Male createMan() {
        String eyesUserChoice = TraitPrompter.getUserChoice("him", "eye color", eyes.getSelectionMenu(), eyes.getPhenotypes());
        String hairUserChoice = TraitPrompter.getUserChoice("him", "hair color", Hair.getSelectionMenu(), Hair.getPhenotypes());
        return (Male) createStarterPerson("Adam", "Paper", true, eyesUserChoice, hairUserChoice);
    }

    public static Female createWoman(Scanner input) {
        return (Female) createStarterPerson("Eve", "Paper", false);
    }
}
