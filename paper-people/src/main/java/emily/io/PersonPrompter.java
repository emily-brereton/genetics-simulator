package emily.io;

import java.util.Scanner;
import emily.model.people.Male;
import emily.model.people.Female;
import emily.model.people.PersonFactory;
import emily.model.traits.Eyes;
import emily.model.traits.Hair;


public class PersonPrompter {
    private final TraitPrompter traitPrompter;

    public PersonPrompter(Scanner input) {
        this.traitPrompter = new TraitPrompter(input);
    }

    public Male createMan() {
        //Ancillary.pause(input, "Creating person...");

        Eyes eyesTemplate = new Eyes();
        Hair hairTemplate = new Hair();

        String eyesChoice = traitPrompter.getUserChoice("his", "eye color",
                eyesTemplate.getSelectionMenu(), eyesTemplate.getPhenotypes());
        String hairChoice = traitPrompter.getUserChoice("his", "hair color",
                hairTemplate.getSelectionMenu(), hairTemplate.getPhenotypes());

        return PersonFactory.createAdam(eyesChoice, hairChoice);
    }

    public Female createWoman() {
        //Ancillary.pause(input, "Creating person...");

        Eyes eyesTemplate = new Eyes();
        Hair hairTemplate = new Hair();

        String eyesChoice = traitPrompter.getUserChoice("her", "eye color",
                eyesTemplate.getSelectionMenu(), eyesTemplate.getPhenotypes());
        String hairChoice = traitPrompter.getUserChoice("her", "hair color",
                hairTemplate.getSelectionMenu(), hairTemplate.getPhenotypes());

        return PersonFactory.createEve(eyesChoice, hairChoice);
    }
}
