package emily.io;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import emily.model.utils.Randomize;

public class TraitPrompter {

    private final ConsolePrompter <String> consolePrompter;
    private final HashSet<String> options = new HashSet<>(Set.of("1","2"));
    

    TraitPrompter(ConsolePrompter <String> consolePrompter){
        this.consolePrompter = consolePrompter;
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

    public String generatePhenotype(String pronoun, String traitType, String selectionMenu, List<String> phenoList){
        String phenotype = "";
        String answer = consolePrompter.askSet(traitSelectMenu(pronoun, traitType), options);
        if (answer.equals("1")) {
            phenotype = selectPhenotype(selectionMenu, phenoList);
        }
        else {
            phenotype = Randomize.random(phenoList);
        }
        return phenotype;
    }


    // not validated
    public String selectPhenotype(String selectionMenu, List<String> phenoList) {
        return consolePrompter.selectOption(selectionMenu, phenoList);
    }



    // // to randomize or not to randomize
    // public String getUserChoice(String pronoun, String traitType, String selectionMenu, List<String> phenoList) {
    //     String userChoice = null;
    //     System.out.println(traitSelectMenu(pronoun, traitType));
    //     String choice = input.nextLine();
    //     if (choice.equals("1")) {
    //         userChoice = selectPhenotype(selectionMenu, phenoList);
    //     }
    //     return userChoice;
    // }
}
