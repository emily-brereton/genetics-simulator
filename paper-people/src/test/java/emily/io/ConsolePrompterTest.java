package emily.io;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashSet;
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

}