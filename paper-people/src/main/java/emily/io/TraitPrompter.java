package emily.io;

import java.util.List;
import java.util.Scanner;

public class TraitPrompter {

    private final Scanner input;

    TraitPrompter(Scanner input){
        this.input = input;
    }

    private static String traitSelectMenu(String pronoun, String traitType) {
        return """

                --------------------------------------------------------
                How do you want to determine %s %s?

                --------------------------------------------------------

                    1. Choose %s %s manually
                    2. Randomize %s %s

                --------------------------------------------------------
                Please enter "1" or "2" to proceed

                """.formatted(
                pronoun,
                traitType,
                pronoun,
                traitType,
                pronoun,
                traitType);
    }

    // User selects phenotype from printed list
    private String selectPhenotype(String selectionMenu, List<String> phenoList) {
        System.out.println(selectionMenu);
        for (String pheno : phenoList) {
            System.out.println("- " + pheno);
        }
        String phenotype = input.nextLine();
        return phenotype;
    }

    // to randomize or not to randomize
    public String getUserChoice(String pronoun, String traitType, String selectionMenu, List<String> phenoList) {
        String userChoice = null;
        System.out.println(traitSelectMenu(pronoun, traitType));
        String choice = input.nextLine();
        if (choice.equals("1")) {
            userChoice = selectPhenotype(selectionMenu, phenoList);
        }
        return userChoice;
    }
}
