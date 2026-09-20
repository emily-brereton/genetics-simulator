package emily.io;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class TraitPrompterTest {

    @Test 
    void generatePhenotypeTest(){

        HashSet<String> testSet = new HashSet<>();
        testSet.add("1");
        testSet.add("2");
        List<String> testList = List.of("black","brown","red");
        Scanner fakeInput = new Scanner("1\nblack\n");
        ConsolePrompter <String> prompter = new ConsolePrompter<String>(fakeInput);
        TraitPrompter traitPrompter = new TraitPrompter(prompter);

        // test
        String result = traitPrompter.generatePhenotype("his", "hair color", "black brown red", testList);

        assertEquals("black", result);

    }


    
}
