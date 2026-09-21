package emily.io;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class ConsolePrompterTest <T>{

    @Test
    void askSetTest(){
        // set up
        HashSet<String> testSet = new HashSet<>();
        testSet.add("XX");
        testSet.add("XY");
        Scanner fakeInput = new Scanner("xY\n");
        ConsolePrompter <String> prompter = new ConsolePrompter<String>(fakeInput);

        // test
        String result = prompter.askSet("Please enter xx / xy r", testSet);

        assertEquals("XX", result);
    }

    @Test
    void selectOptionTest(){
        List<String> testList = List.of("black", "brown", "red");
        Scanner fakeInput = new Scanner("black\n");
        ConsolePrompter <String> prompter = new ConsolePrompter<String>(fakeInput);
        
        String result = prompter.selectOption("Please select black / brown / red", testList);

        assertEquals("brown", result);
    }

}